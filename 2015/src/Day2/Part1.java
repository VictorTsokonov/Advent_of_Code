package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int paper = 0;
        try{
            File input = new File("./2015/src/Day2/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()){
                String[] dimensions = scanner.next().split("x");
                int l = Integer.parseInt(dimensions[0]);
                int w = Integer.parseInt(dimensions[1]);
                int h = Integer.parseInt(dimensions[2]);
                paper += 2*l*w + 2*w*h + 2*h*l + Math.min(l*w, Math.min(w*h,l*h));
            }
            System.out.println(paper);
        }catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
    }
}
