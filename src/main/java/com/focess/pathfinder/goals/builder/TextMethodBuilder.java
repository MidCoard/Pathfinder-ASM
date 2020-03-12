package com.focess.pathfinder.goals.builder;

import java.lang.reflect.Type;

public class TextMethodBuilder {
    private final TextClassBuilder.VarName name;
    private final Type c;
    private int pos;
    private TextFieldBuilder field;

    public TextMethodBuilder(TextClassBuilder.VarName var, Type c, int pos) {
        this.name = var;
        this.c = c;
        this.pos = pos;
    }

    public TextMethodBuilder(TextClassBuilder.VarName var, Type c, TextFieldBuilder field) {
        this.name = var;
        this.field = field;
        this.c = c;
    }

    public String build(TextClassBuilder c) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildMethodClaim(c));
        sb.append(buildMethodStart());
        if (this.field != null)
            sb.append(buildFieldWrite());
        else
            sb.append(buildWrite());
        sb.append(buildReturn());
        sb.append(buildMethodEnd());
        return sb.toString();
    }

    private String buildFieldWrite() {
        return "%fieldName%.write(arg);".replace("%fieldName%",this.field.getName());
    }

    private String buildReturn() {
        return "return this;";
    }

    private String buildWrite() {
        return "this.write(" + this.pos + ", arg);";
    }

    private String buildMethodEnd() {
        return "}";
    }

    private String buildMethodStart() {
        return "{";
    }

    private String buildMethodClaim(TextClassBuilder c) {
        return "public %className% %methodName%(%fieldClassName% arg) "
                .replace("%className%",c.getSimpleName())
                .replace("%methodName%",name.getFinalName())
                .replace("%fieldClassName%",buildFieldClassName());
    }

    private String buildFieldClassName() {
        return getFieldClassName(this.c.getTypeName());
    }

    private String getFieldClassName(String name) {
        int pos;
        if ((pos = name.indexOf('<')) != -1) {
            String temp = name.substring(pos+1,name.length()-1);
            String head = name.substring(0,pos);
            if (name.startsWith("net.minecraft")) {
                String temps[] = head.split("\\.");
                return "com.focess.pathfinder.wrapped.Wrapped" + temps[temps.length - 1] + "<" + getFieldClassName(temp) + ">";
            }
            else
                return head + "<" + getFieldClassName(temp) + ">";
        }
        else if (name.startsWith("net.minecraft")) {
            String temp[] = name.split("\\.");
            return "com.focess.pathfinder.wrapped.Wrapped" + temp[temp.length - 1];
        }
        return name;
    }
}
