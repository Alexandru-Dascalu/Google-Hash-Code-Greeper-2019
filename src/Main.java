import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Photo> photos = new ArrayList<>();

        // reader
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        in.nextLine();
        for (int i = 0; i < n; i++) {
            String readTags = in.nextLine();
            System.out.println(readTags);
            String[] split = readTags.split(" ");

            String orientation = split[0];

            // dont need the second one

            ArrayList<String> tags = new ArrayList<>();
            for (int j = 2; j < split.length; j++) {
                tags.add(split[j]);
            }

            photos.add(new Photo(orientation.equals("H") ? Photo.Orientation.H : Photo.Orientation.V,
                    i,
                    tags));
        }

        System.out.println();
        System.out.println("photooos");
        System.out.println();


        for(Photo p : photos){
            System.out.print(p.ID + " " + p.type + " ");
            for(String s : p.tags){
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
