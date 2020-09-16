package store;

import store.model.file.ParameterXml;
import store.model.file.TestCaseXml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCaseFactory {

    public static TestCase from(TestCaseXml xml) {
        check(xml);
        Map<String, Parameter> parameters = new HashMap<>();
        for (ParameterXml parameterXml : xml.getParameters()) {
            Parameter parameter;
            if ("base".equalsIgnoreCase(parameterXml.getType())) {
                parameter = new Base64Parameter(parameterXml.getValue());
            } else {
                parameter = new StringParameter(parameterXml.getValue());
            }
            parameters.put(parameterXml.getKey(), parameter);
        }
        return new TestCase(xml.getId(), xml.getMnemonic(), xml.getName(), xml.getDescription(), parameters);
    }

    private static void check(TestCaseXml xml) {
        if (xml != null) {
            List<String> errors = new ArrayList<>();
            if (isEmptyOrNull(xml.getId())) {
                errors.add("test id can not be null or empty");
            }
            if (isEmptyOrNull(xml.getName())) {
                errors.add("test name can not be null or empty");
            }
            if (isEmptyOrNull(xml.getMnemonic())) {
                errors.add("test mnemonic can not be null or empty");
            }
            if (xml.getParameters() == null || xml.getParameters().size() == 0) {
                errors.add("test must have parameters");
            }
            if (errors.size() != 0) {
                String errMsg = "Errors: " + String.join("\n", errors);
                throw new IllegalArgumentException(errMsg);
            }
        } else {
            throw new IllegalArgumentException("TestCaseXml must not be null");
        }
    }

    private static boolean isEmptyOrNull(String source) {
        return source == null || source.trim().length() == 0;
    }

}
