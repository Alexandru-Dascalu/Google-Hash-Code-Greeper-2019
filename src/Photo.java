import java.util.ArrayList;

public class Photo {

    enum Orientation {
        H, V;
    }

    public Orientation type;
    ArrayList<String> tags;

    public Photo(Orientation type, ArrayList<String> tags) {
        this.type = type;
        this.tags = tags;
    }
}


