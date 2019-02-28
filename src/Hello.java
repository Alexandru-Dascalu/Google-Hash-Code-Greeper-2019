import java.util.ArrayList;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        ArrayList<Photo> photos = new ArrayList<>();

        // reader
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String readTags = in.nextLine();
            String[] split = readTags.split(" ");

            String orientation = split[0];

            // dont need the second one

            ArrayList<String> tags = new ArrayList<>();
            for (int j = 2; j < split.length - 2; j++) {
                tags.add(split[j]);
            }

            photos.add(new Photo(orientation == "H" ? Photo.Orientation.H : Photo.Orientation.V,
                    i,
                    tags));
        }

        for(Photo p : photos){
            System.out.println(p.ID + " " + p.type);
            for(String s : p.tags){
                System.out.print(s + " ");
            }
        }

    }
}
