import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Algorithm {

    public static int interestScore(Slide s1, Slide s2) {

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
        for (String tag : allTags) {
            commonTags.add(tag);
        }


        for (Photo pic : s1.photos) {

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
