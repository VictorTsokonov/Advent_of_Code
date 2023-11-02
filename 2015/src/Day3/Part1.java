package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int x = 0;
        int y = 0;
        HashMap<String, Integer> places1 = new HashMap<>();
        places1.put("00" , 1);
        try{
            String directions = new Scanner(new File("./2015/src/Day3/input.txt")).next();
            for (int i = 0; i < directions.length(); i++) {
                switch (directions.charAt(i)){
                    case '<' -> x-=1;
                    case '>' -> x+=1;
                    case '^' -> y+=1;
                    case 'v' -> y-=1;
                }
                places1.put(x + "" + y, places1.getOrDefault(x + "" + y, 0) + 1);

            }
            System.out.println(places1.keySet().size());
        }catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
    }
}
