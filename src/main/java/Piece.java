public class Piece {
    private String name;
    private Square location;

    Piece(String name){
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
