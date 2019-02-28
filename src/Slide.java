import java.util.ArrayList;

public class Slide {
    ArrayList<Photo> photos;

    public Slide(Photo p1) {
        photos = new ArrayList<>();
        photos.add(p1);
    }

    public Slide(Photo p1, Photo p2) {
        this(p1);
        photos.add(p2);
    }


}
