package com.focess.pathfinder.goals.builder;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.PathfinderUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;

public class TextGoalsBuilder {
    public static void start() throws IOException, ClassNotFoundException {
        List<String> classes = getClassesFromPackage(NMSManager.PathfinderGoal.getPackage(), "PathfinderGoal");
        getClassesExtendsGoal(classes).forEach((Class c) -> {
            try {
                translation(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static class Reader {

        private int pointer;

        private final Class<?>[] classes;

        private Reader(Class<?>[] classes) {
            this.classes = classes;
            this.pointer = 0;
        }

        private boolean isEnd() {
            return this.pointer == classes.length;
        }

        public Class<?> next() {
            return this.classes[pointer++];
        }

        public int search(Class<?> n) {
            int start = this.pointer;
            while(this.classes[pointer].equals(n) && !isEnd())
                this.pointer++;
            return this.pointer - start + 1;
        }
    }


        private static String translation(Class<?> clazz) throws IOException {
        TextClassBuilder builder = new TextClassBuilder(clazz.getSimpleName().replace("PathfinderGoal","") + "GoalItem");
        Constructor<?> constructor = null;
        for (Constructor<?> c:clazz.getConstructors())
            if (constructor == null)
                constructor = c;
            else if (constructor.getParameterCount() < c.getParameterCount())
                constructor = c;
        // find the main constructor
        Reader reader = new Reader(constructor.getParameterTypes());
        while (!reader.isEnd()) {
            int pos = reader.pointer;
            Class<?> n = reader.next();
            int len = reader.search(n);
            if (len > 1) {
                TextFieldBuilder field = new TextFieldBuilder(TextClassBuilder.VarPool.var(PathfinderUtil.styleLowerClassName(n) + "Writer"),pos,len);
                builder.addField(field);
                builder.addMethod(new TextMethodBuilder(TextClassBuilder.VarPool.var("write" + PathfinderUtil.styleUpperClassName(n)),field));
            } else
                builder.addMethod(new TextMethodBuilder(TextClassBuilder.VarPool.var("write" + PathfinderUtil.styleUpperClassName(n)),n,pos));
        }
        return builder.build();
        // add methods
//        String filename = clazz.getName();
//        filename = filename.substring(filename.lastIndexOf(".") + 1);
//        filename = filename + "GoalItems.java";
//        File f = new File("C:\\Users\\dell\\Desktop\\GoalItems", filename);
//        if (!f.exists()) {
//            f.createNewFile();
//        }
//        filename = filename.replaceAll("GoalItems.java", "");
//
//        int parameters = 0;
//        Constructor constructor = null;
//        for (Constructor c : clazz.getConstructors()) {
//            if (c.getParameterCount() > parameters) {
//                parameters = c.getParameterCount();
//                constructor = c;
//            }
//        }
//        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
//        String strings = "package com.focess.pathfinder.goals;\n" +
//                "\n" +
//                "import com.focess.pathfinder.core.goal.NMSGoalItem;\n" +
//                "import com.focess.pathfinder.core.goal.util.NMSManager;\n" +
//                "import com.focess.pathfinder.wrapped.WrappedEntityCreature;\n" +
//                "\n" +
//                "import java.util.function.Predicate;\n" +
//                "\n" +
//                "public class AvoidTargetGoalItem extends NMSGoalItem {\n" +
//                "    public AvoidTargetGoalItem() {\n" +
//                "        super(NMSManager.getNMSClass(\"" + clazz.getName() + "\",true)," + parameters + "\n" +
//                "                ,NMSManager.getNMSClass(\"<>1\",true)\n" +
//                "                ,<>2,<>3,<>4,<>5,<>6,<>7,<>8,<>9);\n" +
//                "    }\n" +
//                "\n" +
//                "    public AvoidTargetGoalItem writeEntityCreature(WrappedEntityCreature entity){\n" +
//                "        write(0,entity);\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "\n" +
//                "    public AvoidTargetGoalItem writeClass(Class<?> clazz){\n" +
//                "        write(1,clazz);\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "\n" +
//                "    public AvoidTargetGoalItem writePredicate3(Predicate<?> predicate){\n" +
//                "        write(2,predicate);\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "\n" +
//                "    public AvoidTargetGoalItem writeFloat(float f){\n" +
//                "        write(3,f);\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "\n" +
//                "    PointerWriter doubleWriter = new PointerWriter(4,2);\n" +
//                "\n" +
//                "    public AvoidTargetGoalItem writeDouble(double d){\n" +
//                "        doubleWriter.write(d);\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "\n" +
//                "    public AvoidTargetGoalItem writePredicate7(Predicate<?> predicate){\n" +
//                "        write(6,predicate);\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "\n" +
//                "    @Override\n" +
//                "    public AvoidTargetGoalItem clear() {\n" +
//                "        doubleWriter.clear();\n" +
//                "        return this;\n" +
//                "    }\n" +
//                "}";
//        strings = strings.replaceAll("AvoidTargetGoalItem", filename + "GoalItems");
//        for (int i = 1; i <= parameters; i++) {
//            strings = strings.replaceAll("<>" + i, constructor.getParameterTypes()[i - 1].getName() + ".class");
//        }
//        for (int i = 1; i <= 9; i++) {
//            strings = strings.replaceAll(",<>" + i, "");
//        }
//        writer.write(strings);
//        writer.flush();
//        writer.close();
//        return f;
    }

    private static List<Class> getClassesExtendsGoal(List<String> classes) throws ClassNotFoundException {
        List<Class> classList = new ArrayList<>();
        for (String name : classes) {
            Class c = Class.forName(name);
            if (c.getSuperclass().getName().contains("PathfinderGoal")) {
                classList.add(c);
            }
        }
        return classList;
    }

    private static List<String> getClassesFromPackage(Package pack, String filter) throws IOException, ClassNotFoundException {
        List<String> classes = new ArrayList<>();
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(pack.getName().replace(".", "/"));
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String protocol = url.getProtocol();
            if (protocol.equalsIgnoreCase("file")) {
                String packagepath = url.getPath().trim();
                AddClass(classes, packagepath, pack.getName(), filter);
            } else if (protocol.equalsIgnoreCase("jar")) {
                JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                Enumeration<JarEntry> jarEntryEnumeration = jarURLConnection.getJarFile().entries();
                while (jarEntryEnumeration.hasMoreElements()) {
                    JarEntry entry = jarEntryEnumeration.nextElement();
                    String entryname = entry.getName();
                    if (entryname.endsWith(".class")) {
                        String classname = entryname.substring(0, entryname.indexOf("."));
                        if (classname.contains("$")) {
                            continue;
                        }
                        classname = classname.replace("/", ".");
                        if (classname.contains(filter)) {

                        } else {
                            continue;
                        }
                        classes.add(classname);
                    }
                }
            }
        }
        return classes;
    }

    private static void AddClass(List<String> list, String packpath, String packname, String filter) throws ClassNotFoundException {
        File f = new File(packpath);
        String name = f.getName().substring(0, f.getName().indexOf("."));
        String classname = packname + "." + name;
        if (classname.contains("$")) {
            return;
        }
        if (!classname.contains(filter))
        list.add(classname);
    }
}
