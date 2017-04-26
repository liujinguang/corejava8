package interfaces.classprocessor2;

public abstract class StringProcessor implements Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    
    public abstract String process(Object input);
}
