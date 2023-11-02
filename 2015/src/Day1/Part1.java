package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int floor = 0;
        try{
            File input = new File("./2015/src/Day1/input.txt");
            Scanner scanner = new Scanner(input);
            ArrayList<String> steps = new ArrayList<>(Arrays.asList(scanner.next().split("")));
            for (String s:
                 steps) {
                if(s.equals("(")){
                    floor++;
                }else {
                    floor--;
                }
            }
        System.out.println(floor);
        scanner.close();
        }catch (FileNotFoundException e){
            throw new FileNotFoundException();

        }
    }
}
