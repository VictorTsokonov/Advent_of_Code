package Day5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// pattern "(\\w{2}).*\\1"
// pattern "^(.).\\1$"
public class Part2 {
    public static void main(String[] args) {
        int res = 0;
        try {
            Scanner scanner = new Scanner(new File("./2015/src/Day5/input.txt"));
            Pattern patternPairAppearsTwice = Pattern.compile("(\\w{2})(?=.*\\1)");
            Pattern patternLetterRepeatsWithOneBetween = Pattern.compile("(\\w).\\1");
            while (scanner.hasNext()) {
                String word = scanner.next();
                Matcher matcherPair = patternPairAppearsTwice.matcher(word);
                Matcher matcherRepeat = patternLetterRepeatsWithOneBetween.matcher(word);
                if (matcherPair.find() && matcherRepeat.find()) {
                    res++;
                }
            }
            System.out.println(res);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
