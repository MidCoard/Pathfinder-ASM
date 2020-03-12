package com.focess.pathfinder.goals.builder;

public class TextMethodBuilder {
    private final TextClassBuilder.VarName name;
    private final Class<?> c;
    private int pos;
    private TextFieldBuilder field;

    public TextMethodBuilder(TextClassBuilder.VarName var, Class<?> c, int pos) {
        this.name = var;
        this.c = c;
        this.pos = pos;
    }

    public TextMethodBuilder(TextClassBuilder.VarName var, Class<?> c, TextFieldBuilder field) {
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
                .replace("%fieldClassName%",this.c.getName());
    }
}
