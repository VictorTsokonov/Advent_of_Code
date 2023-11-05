package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        int ans = 0;
        int[][] grid = new int[1000][1000];

        try {
            Scanner scanner = new Scanner(new File("./2015/src/Day6/input.txt"));
            while (scanner.hasNext()) {
                String[] msg = scanner.nextLine().split(" ");
                msg[0] = "";
                msg[msg.length - 2] = "";

                for (String s :
                        msg) {
                    if (s.trim().equals("")) continue;
                    if (s.trim().equals("off")) {
                        int x1 = Integer.parseInt(msg[msg.length - 3].split(",")[0]);
                        int y1 = Integer.parseInt(msg[msg.length - 3].split(",")[1]);
                        int x2 = Integer.parseInt(msg[msg.length - 1].split(",")[0]);
                        int y2 = Integer.parseInt(msg[msg.length - 1].split(",")[1]);
                        updateGridLights(grid, "off", x1, y1, x2, y2);
                        break;
                    }
                    if (s.trim().equals("on")) {
                        int x1 = Integer.parseInt(msg[msg.length - 3].split(",")[0]);
                        int y1 = Integer.parseInt(msg[msg.length - 3].split(",")[1]);
                        int x2 = Integer.parseInt(msg[msg.length - 1].split(",")[0]);
                        int y2 = Integer.parseInt(msg[msg.length - 1].split(",")[1]);
                        updateGridLights(grid, "on", x1, y1, x2, y2);
                        break;
                    } else{
                        int x1 = Integer.parseInt(s.split(",")[0]);
                        int y1 = Integer.parseInt(s.split(",")[1]);
                        int x2 = Integer.parseInt(msg[msg.length-1].split(",")[0]);
                        int y2 = Integer.parseInt(msg[msg.length-1].split(",")[1]);
                        updateGridLights(grid, "toggle", x1, y1, x2, y2);
                        break;
                    }
                }
            }

            for (int x = 0; x < 1000; x++) {
                for (int y = 0; y < 1000; y++) {
                    ans += grid[x][y];
                }
            }

            System.out.println(ans);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    static void updateGridLights(int[][] grid, String command, int x1, int y1, int x2, int y2){
        for(int x = x1; x <= x2; x++){
            for(int y = y1; y <= y2; y++){
                switch (command){
                    case "on" -> {
                        grid[x][y] += 1;
                    }
                    case "off" ->{
                        if((grid[x][y] - 1) >= 0)grid[x][y] -= 1;
                    }
                    case "toggle" -> {
                        grid[x][y] += 2;
                    }
                }
            }
        }
    }
}