package store;

import org.junit.jupiter.api.Test;
import store.model.file.TestCaseXml;
import store.util.JaxB;

import javax.xml.bind.JAXBException;
import java.io.File;

class TestCaseFactoryDemo {

    @Test
    void demo() throws JAXBException {
        File file = new File("D:\\Java\\study_books\\allatonce\\file.store.experiment\\examples\\parameters.xml");

        TestCaseXml xml = new JaxB().unMarshalFromFile(TestCaseXml.class, file);
        TestCase testCase = TestCaseFactory.from(xml);

        System.out.println(testCase.getParameters("base64").get());

    }

}
