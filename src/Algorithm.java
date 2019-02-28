import java.util.ArrayList;
import java.util.stream.Collectors;

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
        for (Slide slide : slides) {
            for (Photo pic : slide.photos) {
                allTags.addAll(pic.tags);
            }
        }


//        for(int i =0; i< s1.getTags().size(); i++){
//            s2 contains the s1 tag
//            if(s2.getTags().indexOf(s1.getTags().get(i)) != -1){
//                s1
//            }
//        }

        commonTags.addAll(
                allTags.stream().filter(tag -> s1.getTags().contains(tag) && s2.getTags().contains(tag)
                ).collect(Collectors.toList()));

        s1NOTs2.addAll(
                allTags.stream().filter(tag -> s1.getTags().contains(tag) && !s2.getTags().contains(tag)
                ).collect(Collectors.toList()));

        s2NOTs1.addAll(allTags.stream().filter(tag -> !s1.getTags().contains(tag) && s2.getTags().contains(tag)
        ).collect(Collectors.toList()));

        //This is the algorithm
        return Math.min(Math.min(s2NOTs1.size(), s1NOTs2.size()), commonTags.size());
    }

}
