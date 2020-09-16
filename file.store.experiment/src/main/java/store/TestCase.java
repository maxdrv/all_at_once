package store;

import java.util.*;

public class TestCase {

    private final String id;
    private final String mnemonic;
    private final String name;
    private final String description;
    private final Map<String, Parameter> parameters;

    TestCase(String id, String mnemonic, String name, String description, Map<String, Parameter> parameters) {
        this.id = id;
        this.mnemonic = mnemonic;
        this.name = name;
        this.description = description;
        this.parameters = Collections.unmodifiableMap(parameters);
    }

    public Optional<String> getParameters(String key) {
        if (parameters.containsKey(key)) {
            return Optional.of(parameters.get(key).getContent());
        } else {
            return Optional.empty();
        }
    }

    public String getId() {
        return id;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
