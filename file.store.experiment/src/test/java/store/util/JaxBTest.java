package store.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import store.model.file.ParameterXml;
import store.model.file.TestCaseXml;

import javax.xml.bind.JAXBException;
import java.util.Collections;

class JaxBTest {

    @Test
    void testMarshaling() throws JAXBException {
        ParameterXml parameter = new ParameterXml();
        parameter.setKey("XYZ");
        parameter.setValue("value of this parameter");
        JaxB jaxB = new JaxB();
        String result = jaxB.marshalToString(ParameterXml.class, parameter);
        Assertions.assertEquals("<parameter>\n" +
                "    <key>XYZ</key>\n" +
                "    <value>value of this parameter</value>\n" +
                "</parameter>", result);
    }

    @Test
    void testUnMarshaling() throws JAXBException {
        String objectAsString = "<parameter>\n" +
                "    <key>XYZ</key>\n" +
                "    <value>value of this parameter</value>\n" +
                "</parameter>";
        ParameterXml parameter = new JaxB().unMarshalFromString(ParameterXml.class, objectAsString);
        Assertions.assertAll(
                () -> Assertions.assertEquals("XYZ", parameter.getKey()),
                () -> Assertions.assertEquals("value of this parameter", parameter.getValue()),
                () -> Assertions.assertNull(parameter.getType())
        );
    }

    @Test
    void testMarshalingTestCase() throws JAXBException {
        ParameterXml parameter = new ParameterXml();
        parameter.setKey("request");
        parameter.setValue("request template");

        TestCaseXml test = new TestCaseXml();
        test.setId("0001");
        test.setName("some test");
        test.setDescription("some useful explanation");
        test.setParameters(Collections.singletonList(parameter));

        JaxB jaxB = new JaxB();
        String result = jaxB.marshalToString(TestCaseXml.class, test);
        Assertions.assertEquals("<test>\n" +
                "    <id>0001</id>\n" +
                "    <name>some test</name>\n" +
                "    <desc>some useful explanation</desc>\n" +
                "    <parameters>\n" +
                "        <parameter>\n" +
                "            <key>request</key>\n" +
                "            <value>request template</value>\n" +
                "        </parameter>\n" +
                "    </parameters>\n" +
                "</test>", result);
    }

}
