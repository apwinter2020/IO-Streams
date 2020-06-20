package ObjectsPackage;

public class SampleChild extends SampleObject {
    public SampleChild(String name) {
        super(name);
    }

    public SampleChild() {
        this("Default name");
    }

    @Override
    public String toString() {
        return "(Child) My name is: " + name;
    }
}
