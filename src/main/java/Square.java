
import java.security.InvalidParameterException;

public class Square {

    private String name;

    public String getName() {
        return name;
    }

    public Square(String name) {

        if(name == null || name.equals(""))
        {
            throw new InvalidParameterException("Square name should not be null");
        }
        this.name = name;
    }
}
