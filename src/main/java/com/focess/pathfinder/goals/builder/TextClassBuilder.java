package com.focess.pathfinder.goals.builder;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TextClassBuilder {

    private final String simpleName;
    private final Class<?> c;

    private List<TextMethodBuilder> methods = Lists.newArrayList();
    private List<TextFieldBuilder> fields = Lists.newArrayList();
    private Constructor<?> constructor;

    public TextClassBuilder(String simpleName, Class<?> c) {
        this.simpleName = simpleName;
        this.c = c;
        VarPool.clear();
    }

    public void addMethod(TextMethodBuilder method) {
        methods.add(method);
    }

    public void addField(TextFieldBuilder field) {
        fields.add(field);
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(buildPackage());
        sb.append(buildImport());
        sb.append(buildClassClaim());
        sb.append(buildClassStart());
        sb.append(buildConstructor());
        for (TextFieldBuilder field : fields)
            sb.append(field.build());
        for (TextMethodBuilder method : methods)
            sb.append(method.build(this));
        sb.append(buildClear());
        sb.append(buildClassEnd());
        return sb.toString();
    }

    private String buildClear() {
        return new TextClearMethodBuilder().build();
    }

    private class TextClearMethodBuilder {

        public String build() {
            StringBuilder sb = new StringBuilder();
            sb.append(buildClearMethodClaim());
            sb.append(buildClearMethodStart());
            for (TextFieldBuilder field :fields)
                sb.append(buildFieldClear(field));
            sb.append(buildClearMethodReturn());
            sb.append(buildClearMethodEnd());
            return sb.toString();
        }

        private String buildFieldClear(TextFieldBuilder field) {
            return field.getName() + ".clear();";
        }

        private String buildClearMethodReturn() {
            return "return this;";
        }

        private String buildClearMethodEnd() {
            return "}";
        }

        private String buildClearMethodStart() {
            return "{";
        }

        private String buildClearMethodClaim() {
            return "@Override public " + simpleName + " clear()";
        }
    }

    private String buildConstructor() {
        return new TextConstructorBuilder().build();
    }

    public String getSimpleName() {
        return this.simpleName;
    }

    private class TextConstructorBuilder {

        public String build() {
            StringBuilder sb = new StringBuilder();
            sb.append(buildConstructorClaim());
            sb.append(buildConstructorStart());
            sb.append(buildSuper());
            sb.append(buildConstructorEnd());
            return sb.toString();
        }

        private String buildSuper() {
            StringBuilder sb = new StringBuilder();
            sb.append("super");
            sb.append("(");
            sb.append(buildNMSClassGetter(c.getSimpleName()));
            sb.append(",");
            sb.append(constructor.getParameterCount());
            for (Class<?> c : constructor.getParameterTypes())
                sb.append(",").append(buildNMSClassOrDefault(c));
            sb.append(");");
            return sb.toString();
        }

        private String buildNMSClassOrDefault(Class<?> c) {
            if (c.getName().startsWith("net.minecraft"))
                return buildNMSClassGetter(c.getSimpleName());
            return c.getName() + ".class";
        }

        private String buildNMSClassGetter(String className) {
            return "NMSManager.getNMSClass(\"%className%\", true)".replace("%className%", className);
        }

        private String buildConstructorStart() {
            return "{";
        }

        private String buildConstructorEnd() {
            return "}";
        }

        private String buildConstructorClaim() {
            return "protected " + simpleName + "()";
        }
    }

    private String buildClassEnd() {
        return "}";
    }

    private String buildClassStart() {
        return "{";
    }

    private String buildImport() {
        return "import com.focess.pathfinder.core.goal.NMSGoalItem;import com.focess.pathfinder.core.util.NMSManager;";
    }

    private String buildClassClaim() {
        return "public class " + this.simpleName + " extends NMSGoalItem";
    }

    private String buildPackage() {
        return "package com.focess.pathfinder.goals;";
    }

    public void setConstructor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public static class VarPool {

        private static Set<VarName> varNames = Sets.newHashSet();

        public static VarName var(String name) {
            VarName varName = new VarName(name);
            for (VarName v : varNames)
                if (v.equals(varName)) {
                    if (v.pos == -1)
                        v.pos = 0;
                    varName.pos = v.pos + 1;
                }
            return varName;
        }

        public static void clear() {
            varNames.clear();
        }
    }

    public static class VarName {
        private String name;
        private int pos = -1;

        public String getName() {
            return name;
        }

        public int getPos() {
            return pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VarName)) return false;
            VarName varName = (VarName) o;
            return Objects.equals(name, varName.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public VarName(String name) {
            this.name = name;
        }

        public String getFinalName() {
            if (this.getPos() == -1)
                return this.getName();
            return this.getName() + this.getPos();
        }
    }
}
