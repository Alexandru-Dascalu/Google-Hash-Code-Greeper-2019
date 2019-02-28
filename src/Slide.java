import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public ArrayList<String> getTags() {
        ArrayList<String> result = new ArrayList();
        for (Photo pic : photos){
            result.addAll(pic.tags);
        }
        return  result;
    }


}
