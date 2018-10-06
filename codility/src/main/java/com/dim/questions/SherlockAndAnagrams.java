package com.dim.questions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    public static int factorial(int num) {
        if (num == 1) return 1;
        return num * factorial(num - 1);
    }


    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        //first put all combinations to a hashMap
        char[] text =  s.toCharArray();
        Map<String, Integer> map = new HashMap();

        for(int i=1;i<s.length();i++){  //size of the subString
            for(int j=0;j<s.length()-(i-1) ; j++){ //index from which the subString is taken
                char[] subArray = new char[i];
                System.arraycopy(text, j, subArray, 0, i);
                Arrays.sort(subArray);
                String subString = new String(subArray);
                Integer count = map.putIfAbsent(subString  ,1);
                if(count!=null){
                    map.put(subString, count.intValue()+1);
                }
            }
        }
        //now go through the map and count the total
        return map.values().stream().mapToInt(i-> i==0?0 :factorial(i)/2).sum();
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
