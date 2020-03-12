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
        TextClassBuilder builder = new TextClassBuilder(clazz.getSimpleName().replace("PathfinderGoal","") + "GoalItem",clazz);
        Constructor<?> constructor = null;
        for (Constructor<?> c:clazz.getConstructors())
            if (constructor == null)
                constructor = c;
            else if (constructor.getParameterCount() < c.getParameterCount())
                constructor = c;
        // find the main constructor
        builder.setConstructor(constructor);
        Reader reader = new Reader(constructor.getParameterTypes());
        while (!reader.isEnd()) {
            int pos = reader.pointer;
            Class<?> n = reader.next();
            int len = reader.search(n);
            if (len > 1) {
                TextFieldBuilder field = new TextFieldBuilder(TextClassBuilder.VarPool.var(PathfinderUtil.styleLowerClassName(n) + "Writer"),pos,len);
                builder.addField(field);
                builder.addMethod(new TextMethodBuilder(TextClassBuilder.VarPool.var("write" + PathfinderUtil.styleUpperClassName(n)),n,field));
            } else
                builder.addMethod(new TextMethodBuilder(TextClassBuilder.VarPool.var("write" + PathfinderUtil.styleUpperClassName(n)),n,pos));
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
