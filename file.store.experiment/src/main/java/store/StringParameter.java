package store;

public class StringParameter extends KeyParameter {

    private final String content;

    public StringParameter(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getInternalRepresentation() {
        return content;
    }

}
