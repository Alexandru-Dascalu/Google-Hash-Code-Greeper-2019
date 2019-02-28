import java.util.ArrayList;

public class Slide {
    public ArrayList<Photo> photos;
    public ArrayList<String> tags;

    public Slide(Photo p1) {
        photos = new ArrayList<>();
        photos.add(p1);

        tags = this.getTags();
    }

    public Slide(Photo p1, Photo p2) {
        this(p1);
        photos.add(p2);
    }

    private ArrayList<String> getTags() {
        ArrayList<String> result = new ArrayList();
        for (Photo pic : photos){
            result.addAll(pic.tags);
        }
        return  result;
    }


}
