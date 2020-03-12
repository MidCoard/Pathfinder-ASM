package com.focess.pathfinder.goals.builder;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.security.Provider;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TextClassBuilder {

    private final String simpleName;

    private List<TextMethodBuilder> methods = Lists.newArrayList();
    private List<TextFieldBuilder> fields = Lists.newArrayList();

    public TextClassBuilder(String simpleName) {
        this.simpleName = simpleName;
    }

    public void addMethod(TextMethodBuilder method) {
        methods.add(method);
    }

    public void addField(TextFieldBuilder field) {
        fields.add(field);
    }

    public String build() {
        return null;
    }

    public static class VarPool {

        private static Set<VarName> varNames = Sets.newHashSet();

        public static VarName var(String name) {
            VarName varName = new VarName(name);
            for (VarName v:varNames)
                if (v.equals(varName)){
                    if (v.pos == -1)
                        v.pos = 0;
                    varName.pos = v.pos + 1;
                }
            return varName;
        }
    }

    public static class VarName {
        private String name;
        int pos = -1;

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
    }
}
