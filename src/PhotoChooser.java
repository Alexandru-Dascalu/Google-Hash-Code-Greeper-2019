import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class PhotoChooser 
{
//    public static void main(String args[])
//    {
//        ArrayList<String> mata = new ArrayList<>();
//        mata.add("cat");
//        mata.add("beach");
//        mata.add("sun");
//        Photo vPhoto = new Photo(Photo.Orientation.V, 0, mata);
//
//        ArrayList<Photo> photos = new ArrayList<>();
//        mata = new ArrayList<>();
//        mata.add("dog");
//        mata.add("shaorma");
//        mata.add("Romania");
//        photos.add(new Photo(Photo.Orientation.V, 1, mata));
//
//        mata = new ArrayList<>();
//        mata.add("cat");
//        mata.add("lalala");
//        mata.add("unguri");
//        photos.add(new Photo(Photo.Orientation.V, 2, mata));
//
//        Slide newSlide = bestVPhotoPair(vPhoto, photos);
//
//        for(Photo p: newSlide.photos)
//        {
//            for(String s: p.tags)
//            {
//                System.out.print(s+" ");
//            }
//            System.out.println();
//        }
//    }
    
    public static Slide bestVPhotoPair(Photo vPhoto, List<Photo> photos)
    {
        Photo bestPick = null;
        int max = Integer.MIN_VALUE;
        
        if(vPhoto.type == Photo.Orientation.H)
        {
            return null;
        }
        
        for(Photo p: photos)
        {
            if(!p.equals(vPhoto) && p.type == Photo.Orientation.V)
            {
                int tagUnion = tagUnion(vPhoto, p);
                if(max < tagUnion)
                {
                    max = tagUnion;
                    bestPick = p;
                }
            }
        }
        
        if(bestPick == null)
        {
            return null;
        }
        photos.remove(bestPick);
        
        Slide newSlide = new Slide(vPhoto, bestPick);
        return newSlide;
    }

    private static int tagUnion(Photo photo1, Photo photo2)
    {
        int unionSize = 0;
        
        HashSet<String> union = new HashSet<>();
        
        for(String tag: photo1.tags)
        {
            if(!union.contains(tag))
            {
                unionSize++;
                union.add(tag);
            }
        }
        
        for(String tag: photo2.tags)
        {
            if(!union.contains(tag))
            {
                unionSize++;
                union.add(tag);
            }
        }
        
        return unionSize;
    }
}
