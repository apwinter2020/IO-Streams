package ObjectsPackage;

import java.io.Serializable;

public class SampleObject implements Serializable {
    protected String name;

    public SampleObject(String name) {
        this.name = name;
    }

    private String privateToString() {
        return toString();
    }

    @Override
    public String toString() {
        return "My name is: " + name;
    }
}
