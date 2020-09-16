package store;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Parameter extends KeyParameter {

    private String internalRepresentation;

    public Base64Parameter(String internalRepresentation) {
        this.internalRepresentation = internalRepresentation;
    }

    @Override
    public String getContent() {
        return fromBase();
    }

    @Override
    public String getInternalRepresentation() {
        return internalRepresentation;
    }

    private String fromBase() {
        return new String(Base64.getDecoder().decode(internalRepresentation), StandardCharsets.UTF_8);
    }

}
