import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Photo> photos = new ArrayList<>();
        String[] inputFiles = {"a.txt","b.txt","c.txt","d.txt","e.txt"};
        String[] outputFiles = {"a_out.txt","b_out.txt","c_out.txt","d_out.txt","e_out.txt"};
        
        for (int k = 0; k < 5; k++) {
            // reader
            Scanner in = new Scanner(new File(inputFiles[k]));

            System.out.println(inputFiles[k]);
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

                photos
                    .add(new Photo(orientation.equals("H") ? Photo.Orientation.H
                            : Photo.Orientation.V,
                        i, tags));
            }

            System.out.println();
            System.out.println("photooos");
            System.out.println();

            for (Photo p : photos) {
                System.out.print(p.ID + " " + p.type + " ");
                for (String s : p.tags) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

        }
    }
        
}
