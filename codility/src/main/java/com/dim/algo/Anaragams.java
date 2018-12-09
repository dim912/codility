import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anaragams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> counts = new HashMap();

        //form the map of substrings
        for(int i=1 ; i < s.length() ; i++){ //size of the substring
            //startingcharacter
            for(int j=0 ; s.length() - j -i >= 0 ; j++){
                String subStr =  s.substring(j,j+i) ;
                char[] wordArr =  subStr.toCharArray() ;
                Arrays.sort(wordArr) ;
                subStr = String.valueOf(wordArr) ;
                Integer count = counts.get(subStr);

                if(count!=null){
                    counts.put(subStr, Integer.valueOf(count+1));
                }
                else{
                    counts.put(subStr,1);
                }
                System.out.println(subStr + " : " + count + ":" +   counts.get(subStr));

            }
        }

        //now calculate the number of Anagrams
        int total = 0;
        for(Map.Entry e : counts.entrySet()){

            Integer count = (Integer) e.getValue();
            total +=  ( count * (count-1) )/2;
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("asdf"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
