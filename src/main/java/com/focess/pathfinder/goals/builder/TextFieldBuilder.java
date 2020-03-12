package com.focess.pathfinder.goals.builder;

public class TextFieldBuilder {
    private final TextClassBuilder.VarName name;
    private final int start;
    private final int len;

    public TextFieldBuilder(TextClassBuilder.VarName var, int pos, int len) {
        this.name = var;
        this.start = pos;
        this.len = len;
    }
}
