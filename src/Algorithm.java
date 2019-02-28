import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            } else if (s1.tags.contains(tag)) {
                s1NOTs2.add(tag);
            } else if (s2.tags.contains(tag)) {
                s2NOTs1.add(tag);
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

    public static List<Slide> mostSimilarTo(Slide slide, List<Slide> allSlides, int limit) {
        return allSlides.stream().filter(s -> haveCommonTags(s, slide))
                .sorted(Comparator.comparingLong(s2 -> numberOfCommonTags(slide, s2)))
                .limit(limit)
                .collect(Collectors.toList());
    }

    // Other has more different tags from me
    public static List<Slide> mostDifferentFromMe(Slide slide, List<Slide> allSlides, int limit) {
        return allSlides.stream().filter(s -> notHaveAnyCommonTags(s, slide))
                .sorted(Comparator.comparingLong(s2 -> numberOfCommonTags(s2, slide)))
                .limit(limit)
                .collect(Collectors.toList());
    }

    // I have more different tags than other
    public static List<Slide> imMostDifferentFrom(Slide slide, List<Slide> allSlides, int limit) {
        return allSlides.stream().filter(s -> notHaveAnyCommonTags(s, slide))
                .sorted(Comparator.comparingLong(s2 -> numberOfCommonTags(slide, s2)))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static void sortTags(Slide slide) {
        Collections.sort(slide.tags);
    }

    public static List<Slide> execute(Slide slide, List<Slide> allSlides, int limit) {
        System.out.println("Executing at " + System.currentTimeMillis() + " for Slide " + slide.id);
        List<Slide> mostSimilarToMe = mostSimilarTo(slide, allSlides, limit)
                .stream().limit(limit).collect(Collectors.toList());

        List<Slide> mostDifferentFromMe = mostDifferentFromMe(slide, allSlides, limit)
                .stream().limit(limit).collect(Collectors.toList());

        List<Slide> imMostDifferentFrom = imMostDifferentFrom(slide, allSlides, limit)
                .stream().limit(limit).collect(Collectors.toList());

        ArrayList<Slide> all = new ArrayList<>();
        all.addAll(mostSimilarToMe);
        all.addAll(mostDifferentFromMe);
        all.addAll(imMostDifferentFrom);


        System.out.println("Finished executing at " + System.currentTimeMillis() + " for Slide " + slide.id);
        return all.stream().sorted(Comparator.comparingInt(s -> interestScore(s, slide))).collect(Collectors.toList());
    }

    public static List<Slide> execute(Slide slide, List<Slide> allSlides) {
        return execute(slide, allSlides, 1);
    }

    public static Slide perfectSlide(Slide slide, List<Slide> allSlides) {
        return execute(slide, allSlides).get(0);
    }

    public static List<Slide> execute(List<Slide> allSlides) {
        return allSlides.stream()
                .map(slide -> perfectSlide(slide, allSlides)).collect(Collectors.toList());
    }

    //==============================PRIVATE============================================

    private static long numberOfCommonTags(Slide s1, Slide s2) {
        return s1.tags.stream()
                .filter(tag -> s1.tags.contains(tag) && s2.tags.contains(tag)).count();
    }

    // in S1 and not in S2
    private static long numberOfDifferentTags(Slide s1, Slide s2) {
        return s1.tags.stream()
                .filter(tag -> s1.tags.contains(tag) && !s2.tags.contains(tag)).count();
    }

    private static boolean notHaveAnyCommonTags(Slide s1, Slide s2) {
        return s1.tags.stream().noneMatch(tag -> s2.tags.contains(tag));
    }

    private static boolean haveCommonTags(Slide s1, Slide s2) {
        return s1.tags.stream().anyMatch(tag -> s2.tags.contains(tag));
    }

}
