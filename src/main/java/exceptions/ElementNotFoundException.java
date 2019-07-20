package exceptions;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String element){
        super("Element with { " + element + " } not found");
    }
}
