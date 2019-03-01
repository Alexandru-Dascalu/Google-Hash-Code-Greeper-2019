import java.util.ArrayList;
import java.util.HashSet;

public class Slide {
    public ArrayList<Photo> photos;
    public ArrayList<String> tags;
    public int id;
    public static int currentID = 0;
    public boolean alreadyUsed;

    public Slide(Photo p1) {
        photos = new ArrayList<>();
        photos.add(p1);

        tags = this.getTags();
        id = currentID;
        currentID++;
        alreadyUsed = false;
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
    
    public int getScore(Slide after)
    {
        int tags1 = this.tags.size();
        int tags2 = after.tags.size();
        
        HashSet<String> one = new HashSet<>();
        
        for(String s: this.tags)
        {
            one.add(s);
        }
        
        int common = 0;
        for(String s: after.tags)
        {
            if(one.contains(s))
            {
                common++;
            }
        }
        
        int firstWithout = tags1-common;
        int secondWithout = tags2-common;
        
        return Math.min(Math.min(firstWithout, secondWithout), common);
    }


}
