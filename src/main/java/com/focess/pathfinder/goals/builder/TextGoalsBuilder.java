package com.focess.pathfinder.goals.builder;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.PathfinderUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
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
                FileWriter writer = new FileWriter(new File("plugins/" + c.getSimpleName().replace("PathfinderGoal", "") + "GoalItem.java"));
                writer.write(translation(c));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static String translation(Class<?> clazz) throws IOException {
        TextClassBuilder builder = new TextClassBuilder(clazz.getSimpleName().replace("PathfinderGoal", "") + "GoalItem", clazz);
        Constructor<?> constructor = null;
        for (Constructor<?> c : clazz.getConstructors())
            if (constructor == null)
                constructor = c;
            else if (constructor.getParameterCount() < c.getParameterCount())
                constructor = c;
        // find the main constructor
        builder.setConstructor(constructor);
        Reader reader = new Reader(constructor.getParameterTypes(), constructor.getGenericParameterTypes());
        while (!reader.isEnd()) {
            int pos = reader.pointer;
            Class<?> n = reader.next();
            Type type = reader.getType();
            int len = reader.search(n);
            if (len > 1) {
                TextFieldBuilder field = new TextFieldBuilder(TextClassBuilder.VarPool.var(PathfinderUtil.styleLowerClassName(n) + "Writer"), pos, len);
                builder.addField(field);
                builder.addMethod(new TextMethodBuilder(TextClassBuilder.VarPool.var("write" + PathfinderUtil.styleUpperClassName(n)), type, field));
            } else
                builder.addMethod(new TextMethodBuilder(TextClassBuilder.VarPool.var("write" + PathfinderUtil.styleUpperClassName(n)), type, pos));
        }
        return builder.build();
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
                addClass(classes, packagepath, pack.getName(), filter);
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
                        if (classname.contains(filter))
                            classes.add(classname);
                    }
                }
            }
        }
        return classes;
    }

    private static void addClass(List<String> list, String packpath, String packname, String filter) throws ClassNotFoundException {
        File f = new File(packpath);
        String name = f.getName().substring(0, f.getName().indexOf("."));
        String classname = packname + "." + name;
        if (!classname.contains("$")) {
            if (!classname.contains(filter))
                list.add(classname);
        }
    }

    private static class Reader {

        private final Type[] types;
        private final Class<?>[] classes;
        private int pointer;

        private Reader(Class<?>[] classes, Type[] types) {
            this.classes = classes;
            this.types = types;
            this.pointer = 0;
        }

        private boolean isEnd() {
            return this.pointer == classes.length;
        }

        public Class<?> next() {
            return this.classes[pointer++];
        }

        public int search(Type n) {
            int start = this.pointer;
            while (!isEnd() && this.classes[pointer].equals(n))
                this.pointer++;
            return this.pointer - start + 1;
        }

        public Type getType() {
            return this.types[this.pointer - 1];
        }
    }
}
