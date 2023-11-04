package Day5;


//        It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
//        It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
//        It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.

/*
For example:

            ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
            aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
            jchzalrnumimnmhp is naughty because it has no double letter.
            haegwjzuvuyypxyu is naughty because it contains the string xy.
            dvszwmarrgswjxmb is naughty because it contains only one vowel.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        int res = 0;
        try {
            Scanner scanner = new Scanner(new File("./2015/src/Day5/input.txt"));
            while (scanner.hasNext()){

                String word = scanner.next();
                boolean hasDouble = false;
                int numOfvowels = 0;
                HashMap<Character, Integer> hashMap = new HashMap();
                hashMap.put(word.charAt(0), hashMap.getOrDefault(word.charAt(0), 0) + 1);

                for (int i = 1; i < word.length() ; i++) {
                    if(word.contains("ab") || word.contains("cd") || word.contains("pq") || word.contains("xy"))break;
                    if(word.charAt(i-1) == word.charAt(i))hasDouble = true;
                    hashMap.put(word.charAt(i), hashMap.getOrDefault(word.charAt(i), 0) + 1);
                }

                for(Character c: hashMap.keySet()){
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        numOfvowels += hashMap.get(c);
                    }
                }

                if(numOfvowels >= 3 && hasDouble)res++;
            }
            System.out.println(res);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
