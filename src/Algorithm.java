import java.util.ArrayList;

public class Algorithm {

    public static int interestScore(Slide s1, Slide s2){

        ArrayList<String> allTags = new ArrayList<>();

        ArrayList<String> commonTags = new ArrayList<>();

        ArrayList<String> s1NOTs2 = new ArrayList<>();

        ArrayList<String> s2NOTs1 = new ArrayList<>();

        //Populating allTags
        for (Photo pic : s1.photos){
            allTags.addAll(pic.tags);
        }
        for (Photo pic : s2.photos){
            allTags.addAll(pic.tags);
        }

        //Populating commonTag
        for (String tag : allTags){
            commonTags.add(tag);
        }


        for (Photo pic : s1.photos){

        }


//        allTags.stream().filter(tag -> )

        return 0 ;
    }

}
