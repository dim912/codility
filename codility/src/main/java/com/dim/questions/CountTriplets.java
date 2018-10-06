package com.dim.questions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    public static int index(long num, long r){
        int numInt = Math.toIntExact(num);
        int rInt = Math.toIntExact(r);

        int index = 0;
        while(true){
            if(numInt%rInt==0){
                index++;
                numInt=numInt/rInt;
                if(numInt==1){
                    return index;
                }
            }
            else{ // num is not one of 'r's into the power
                return 0;
            }
        }
    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {


        if(r==1) {
            Map<Long, Integer> countMap_1 = new HashMap();
            for (int i = 0; i < arr.size(); i++) {
                Integer countInMap_1 = countMap_1.putIfAbsent(arr.get(i), 1);
                if (countInMap_1 != null) {
                    countMap_1.put(arr.get(i), countInMap_1 + 1);
                }
            }
            return countMap_1.values().stream().mapToLong(v -> {
                if (v >= 3) return v - 2;
                else return 0;
            }).sum();
        }

        int[] toPowerArray = arr.stream().mapToInt(val->index(val,r)).toArray();

        Map<Integer, Integer> countMap = new HashMap();
        for(int i=0 ;i < toPowerArray.length ; i++){
            Integer countInMap = countMap.putIfAbsent(toPowerArray[i],1);
            if(countInMap!=null){
                countMap.put(toPowerArray[i], countInMap +1 );
            }
        }

        Iterator<Integer> it = countMap.keySet().iterator() ;

        long total = 0;
        while(it.hasNext()){
            int indexVal = it.next() ;
            try{
                total+= countMap.get(indexVal) * countMap.get(indexVal+1) * countMap.get(indexVal+2);
            }
            catch (Exception e){}
        }

        return total;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
