import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


        for (String tag : allTags) {
            if (s1.tags.contains(tag) && s2.tags.contains(tag)) {
                commonTags.add(tag);
                break;
            } else if (s1.tags.contains(tag)) {
                s1NOTs2.add(tag);
                break;
            } else if (s2.tags.contains(tag)) {
                s2NOTs1.add(tag);
                break;
            }
        }


       /* List<String> commonTags = allTags.stream().filter(tag -> s1.tags.contains(tag) && s2.tags.contains(tag)
        ).collect(Collectors.toList());

        List<String> s1NOTs2 = allTags.stream().filter(tag -> s1.tags.contains(tag) && !s2.tags.contains(tag)
        ).collect(Collectors.toList());

        List<String> s2NOTs1 = allTags.stream().filter(tag -> !s1.tags.contains(tag) && s2.tags.contains(tag)
        ).collect(Collectors.toList());*/

        //This is the algorithm
        return Math.min(Math.min(s2NOTs1.size(), s1NOTs2.size()), commonTags.size());
    }

    public static List<Slide> mostSimilarTo(Slide slide, List<Slide> allSlides) {


        return allSlides.stream().filter(s ->
                haveCommonTags(s, slide)
        ).collect(Collectors.toList());
    }

    private static boolean haveCommonTags(Slide s1, Slide s2) {
        return s1.tags.stream().anyMatch(tag -> s2.tags.contains(tag));
    }

    public static void sortTags(Slide slide) {
        Collections.sort(slide.tags);
    }

}
