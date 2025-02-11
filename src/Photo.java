import java.util.ArrayList;

public class Photo implements Comparable<Photo>{

    enum Orientation {
        H, V;
    }

    public Orientation type;
    public int ID;
    public ArrayList<String> tags;

    public Photo(Orientation type, int ID,  ArrayList<String> tags) {
        this.ID = ID;
        this.type = type;
        this.tags = tags;
    }
    
    public int compareTo(Photo other)
    {
        return (other.tags.size() - this.tags.size());
    }
}


