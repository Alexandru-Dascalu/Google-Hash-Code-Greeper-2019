import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class Algorithm {

    public static int interestScore(Slide s1, Slide s2) {

        ArrayList<Slide> slides = new ArrayList<>();
        slides.add(s1);
        slides.add(s2);

        ArrayList<String> allTags = new ArrayList<>();

        ArrayList<String> commonTags = new ArrayList<>();

        ArrayList<String> s1NOTs2 = new ArrayList<>();

        ArrayList<String> s2NOTs1 = new ArrayList<>();

        //Populating allTags
        for (Photo pic : s1.photos) {
            allTags.addAll(pic.tags);
        }
        for (Photo pic : s2.photos) {
            allTags.addAll(pic.tags);
        }

        //Populating commonTag
        commonTags.addAll(allTags);

//        for(int i =0; i< s1.getTags().size(); i++){
//            s2 contains the s1 tag
//            if(s2.getTags().indexOf(s1.getTags().get(i)) != -1){
//                s1
//            }
//        }

        for (Slide slide : slides) {
            slide.getTags();
        }

        s1NOTs2.addAll(
                allTags.stream().filter(tag -> s1.getTags().contains(tag) && !s2.getTags().contains(tag)
                ).collect(Collectors.toList()));

        s2NOTs1.addAll(allTags.stream().filter(tag -> !s1.getTags().contains(tag) && s2.getTags().contains(tag)
        ).collect(Collectors.toList()));


//        allTags.stream().filter(tag -> )

        return 0;
    }

}
