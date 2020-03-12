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

    public String build() {
        return "private PointerWriter %fieldName% = new PointerWriter(%start%, %len%);"
                .replace("%fieldName%", name.getFinalName())
                .replace("%start%", this.start + "")
                .replace("%len%", this.len + "");
    }

    public String getName() {
        return this.name.getFinalName();
    }
}
