package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        HashMap<String, Integer> places1 = new HashMap<>();
        places1.put("00" , 2);
        try{
            String directions = new Scanner(new File("./2015/src/Day3/input.txt")).next();
            for (int i = 0; i < directions.length(); i++) {
                switch (directions.charAt(i)){
                    case '<' -> {
                        if(i%2 == 0){
                            x-=1;
                            places1.put(x + "" + y, places1.getOrDefault(x + "" + y, 0) + 1);
                        }else {
                            x2-=1;
                            places1.put(x2 + "" + y2, places1.getOrDefault(x2 + "" + y2, 0) + 1);
                        };
                    }
                    case '>' -> {
                        if(i%2 == 0){
                            x+=1;
                            places1.put(x + "" + y, places1.getOrDefault(x + "" + y, 0) + 1);
                        }else {
                            x2+=1;
                            places1.put(x2 + "" + y2, places1.getOrDefault(x2 + "" + y2, 0) + 1);
                        };
                    }
                    case '^' -> {
                        if(i%2 == 0){
                            y+=1;
                            places1.put(x + "" + y, places1.getOrDefault(x + "" + y, 0) + 1);
                        }else {
                            y2+=1;
                            places1.put(x2 + "" + y2, places1.getOrDefault(x2 + "" + y2, 0) + 1);
                        };
                    }
                    case 'v' -> {
                        if(i%2 == 0){
                            y-=1;
                            places1.put(x + "" + y, places1.getOrDefault(x + "" + y, 0) + 1);
                        }else {
                            y2-=1;
                            places1.put(x2 + "" + y2, places1.getOrDefault(x2 + "" + y2, 0) + 1);
                        };
                    }
                }
//                places1.put(x + "" + y, places1.getOrDefault(x + "" + y, 0) + 1);
//                places1.put(x2 + "" + y2, places1.getOrDefault(x2 + "" + y2, 0) + 1);

            }

            System.out.println(places1.keySet().size());
        }catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
    }
    public static int hash(int x, int y) {
        final int prime = 31; // A prime number used for hashing
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
}
