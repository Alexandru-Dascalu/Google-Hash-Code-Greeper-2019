import java.util.ArrayList;

public class Slide {
    ArrayList<Photo> slides;

    public Slide(Photo p1) {
        slides = new ArrayList<>();
        slides.add(p1);
    }

    public Slide(Photo p1, Photo p2) {
        this(p1);
        slides.add(p2);
    }


}
