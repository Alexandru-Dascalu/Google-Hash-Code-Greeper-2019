import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] inputFiles = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt"};
        String[] outputFiles = {"a_out.txt", "b_out.txt", "c_out.txt", "d_out.txt", "e_out.txt"};

        for (int k = 0; k < 5; k++) {
            ArrayList<Photo> photos = new ArrayList<>();
            // reader
            Scanner in = new Scanner(new File(inputFiles[k]));

            System.out.println(inputFiles[k]);
            int n = in.nextInt();

            in.nextLine();
            for (int i = 0; i < n; i++) {
                String readTags = in.nextLine();
                String[] split = readTags.split(" ");

                String orientation = split[0];

                // dont need the second one

                ArrayList<String> tags = new ArrayList<>();
                for (int j = 2; j < split.length; j++) {
                    tags.add(split[j]);
                }

                photos.add(new Photo(orientation.equals("H") ? Photo.Orientation.H : Photo.Orientation.V,
                        i, tags));
            }


            // get slides hopefully
            // write algorithm here
            photos.sort(null);
            ArrayList<Slide> slides = getSlides(photos);

            List<Slide> answer = Algorithm.execute(slides);

            PrintWriter pw = new PrintWriter(outputFiles[k]);

            pw.println(answer.size());
            for(Slide s : answer){
                for(Photo p : s.photos){
                    pw.print(p.ID + " ");
                }
                pw.println();
            }

            pw.close();

        }
    }

    public static ArrayList<Slide> getSlides(ArrayList<Photo> photos) {
        ArrayList<Slide> slides = new ArrayList<>();

        for (int i = 0; i < photos.size(); i++) {
            if (photos.get(i).type == Photo.Orientation.H) {
                slides.add(new Slide(photos.get(i)));
            } else {
                Slide newSlide = PhotoChooser.bestVPhotoPair(photos.get(i), photos.subList(i + 1, photos.size()));
                if (newSlide != null) {
                    slides.add(newSlide);
                }
            }
        }

        return slides;
    }

    public static ArrayList<Slide> algorithm1(ArrayList<Slide> slides) {
        ArrayList<Slide> answer = new ArrayList<>();

        Slide currentSlide = slides.get(0);
        int maxtags = slides.get(0).tags.size();

        // get the slide with most tags to be first
        for (int i = 1; i < slides.size(); i++) {
            if (slides.get(i).tags.size() > maxtags) {
                maxtags = slides.get(i).tags.size();
                currentSlide = slides.get(i);
            }
        }

        answer.add(currentSlide);
        slides.remove(currentSlide);


        int numSlides = slides.size();

        while (slides.size() > 0) {
            if(slides.size() % 10000 == 0){
                System.out.println(slides.size());
            }

            Slide bestNext = null;
            int nextPoints = -1;

            for (Slide s : slides) {
                if (Algorithm.interestScore(currentSlide, s) > nextPoints) {
                    bestNext = s;
                    nextPoints = Algorithm.interestScore(currentSlide, s);
                }
            }

            answer.add(bestNext);
            currentSlide = bestNext;
            slides.remove(bestNext);

        }

        return answer;
    }

    public static ArrayList<Slide> algorithm2(ArrayList<Slide> slides) {
        ArrayList<Slide> answer = new ArrayList<>();

        answer.add(slides.get(0));
        slides.get(0).alreadyUsed = true;
        Slide currentSlide = answer.get(0);
        int slideIndex = 0;
        int CHECK_NEXT_NUMBER = 100;

        while (true) {

            if(answer.size() % 1000 == 0) {
                System.out.println(answer.size());
            }

            int bestScore = -1;
            Slide next = null;
            boolean found = false;

            for(int i=slideIndex; i< Math.min(slides.size(), slideIndex+CHECK_NEXT_NUMBER); i++) {
                if(!slides.get(i).alreadyUsed && Algorithm.interestScore(currentSlide, slides.get(i)) > bestScore) {
                    next = slides.get(i);
                    found = true;
                    slideIndex = i;
                    bestScore =  Algorithm.interestScore(currentSlide, slides.get(i));
                }
            }



            if (!found) {
                for(Slide s : slides){
                    if(!s.alreadyUsed){
                        next = s;
                        break;
                    }
                }
            }
            if(next == null) break;

            answer.add(next);
            next.alreadyUsed = true;
            currentSlide = next;
            //slides.remove(next);

        }

        return answer;
    }

    public static ArrayList<Slide> algorithm3(ArrayList<Slide> slides) {
       return slides;
    }

}
