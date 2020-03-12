package com.focess.pathfinder.goals.builder;

public class TextMethodBuilder {
    private final TextClassBuilder.VarName name;
    private Class<?> c;
    private int pos;
    private TextFieldBuilder field;

    public TextMethodBuilder(TextClassBuilder.VarName var, Class<?> c, int pos) {
        this.name = var;
        this.c = c;
        this.pos = pos;
    }

    public TextMethodBuilder(TextClassBuilder.VarName var, TextFieldBuilder field) {
        this.name = var;
        this.field = field;
    }
}
