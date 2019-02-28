import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<String> p1Tags = new ArrayList<>();
        p1Tags.add("Cat");
        p1Tags.add("Garden");
        p1Tags.add("Sun");
        p1Tags.add("Food");
        p1Tags.add("Google");
        p1Tags.add("Googlee");

        ArrayList<String> p2Tags = new ArrayList<>();

        p2Tags.add("Garden");
        p2Tags.add("Rats");
        p2Tags.add("Ratssss");
        p2Tags.add("Google");
        p2Tags.add("Googlee");


        int temp = Algorithm.interestScore(new Slide(new Photo(Photo.Orientation.H, 1, p1Tags)),
                new Slide(new Photo(Photo.Orientation.H, 1, p2Tags)));

        System.out.println(temp);

    }

}
