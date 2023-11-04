package Day4;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        int ans = 0;
        Scanner scanner = new Scanner(new File("./2015/src/Day4/input.txt"));
        MessageDigest md =  MessageDigest.getInstance("MD5");
        String message = scanner.next();
        while(true){
            String input = message + ans;
            md.update(input.getBytes());
            byte[] digest = md.digest();
            char[] hash = Hex.encodeHex(digest);


            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Append a leading zero if the hex string is only one character
                }
                hexString.append(hex);
            }
            if(hexString.toString().startsWith("00000")){
                System.out.println(hash);
                System.out.println(message + " " + ans);
                break;
            }
            System.out.println(hash);
            System.out.println(message + " " + ans);
            ans++;
        }


    }
}
