package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2 {
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
                ArrayList<Integer> sides = new ArrayList<>(Arrays.asList(l,w,h));
                Collections.sort(sides);
                paper += (sides.get(0) + sides.get(1))*2 + l*w*h;
            }
            System.out.println(paper);
        }catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
    }
}
