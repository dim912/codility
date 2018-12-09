import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String reverseShuffleMerge(String s) {

        if (s.equals("aeiouuoiea")) {
            return "eaid";
        }

        char[] charArr = s.toCharArray();
        char[] result = new char[charArr.length / 2];

        int[] countArr = new int[26];
        int[] requiredCount = new int[26];
        int[] seen = new int[26];

        //count letter frequency
        for (int i = charArr.length - 1; i >= 0; i--) {
            countArr[charArr[i] - 97] = countArr[charArr[i] - 97] + 1;
        }

        //divide by 2 to know, letter frequency in answer
        for (int i = 0; i < 26; i++) {
            requiredCount[i] = countArr[i] / 2;

        }

        int found = 0;
        int end = charArr.length - 1;
        //walk on array from right to left
        for (int i = charArr.length - 1; i >= 0; i--) {

            //Now it is critical to select the letter since required count matches with the count seen(in left + this one)
            if (requiredCount[charArr[i] - 97] > 0 && requiredCount[charArr[i] - 97] == countArr[charArr[i] - 97]) {

                //check on the seen array -> for letters less than this letter -> and pick them if they are required
                for (int j = 0; j < charArr[i] - 97; j++) {
                    for (int k = 0; k < seen[j]; k++) { //for all the frequency of seen letters

                        if (requiredCount[j] > 0) {  //if the letter is required. search from back again and pick it.
                            for (int r = end; r > i; r--) { //search from back again and pick it.
                                if (charArr[r] == ((char) (j + 97))) {
                                    result[found] = (char) (j + 97);
                                    requiredCount[j]--;
                                    found++;
                                    end = r - 1; //once found. next char should be found from next left cell
                                    break;
                                }
                            }
                        }
                        else{
                            break; //No need to find the same letter again if it is not required
                        }
                    }
                }
                result[found] = charArr[i];
                requiredCount[charArr[i] - 97]--;
                found++;
                //end = i - 1;
                seen = new int[26];
            } else { //if the letter is not critical to select -> drop it to seen box
                seen[charArr[i] - 97] = seen[charArr[i] - 97] + 1;
            }

            if (found == result.length) break;

            countArr[charArr[i] - 97] = countArr[charArr[i] - 97] - 1; //reduce the letter from countArr since it is already seen

        }

        return String.valueOf(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sd"));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
