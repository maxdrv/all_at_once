package store.model.file;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "test")
public class TestCaseXml {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "mnemonic")
    private String mnemonic;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "desc")
    private String description;

    @XmlElementWrapper(name = "parameters")
    @XmlElement(name = "parameter")
    private List<ParameterXml> parameters = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ParameterXml> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterXml> parameters) {
        this.parameters = parameters;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
}
