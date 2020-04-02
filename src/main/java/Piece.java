import java.security.InvalidParameterException;

public class Piece {
    private String name;
    private Square location;

    Piece(String name){

        if(name == null || name.equals(""))
            throw new InvalidParameterException("Piece name should not be null");

        this.name = name;
        location = new Square("Go");
    }

    public String getName() {
        return name;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
}
