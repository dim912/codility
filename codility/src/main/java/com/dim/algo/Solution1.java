import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

    // Complete the candies function below.

    //static long[][] mem ;

    static long candies(int n, int[] arr) {

        /*
        int max = 0;
        for(int i=0 ; i< arr.length ; i++){
            max = Math.max(max,arr[i]);
        }
        */

        // mem = new long[arr.length+1][arr.length+1];
        long result = candies(0, 0 , arr );
        return  result;
    }

    static long candies(int n, int givenToLast , int[] arr) {

        //if(mem[n][givenToLast] > 0){
        //    return  mem[n][givenToLast];
        // }

        if(n==0){
            int give = 0;
            while(true){
                give++;
                long suffix = candies(n+1, give, arr);
                if(suffix > 0){
                    //            mem[n][givenToLast] = suffix+give;
                    return suffix + give;
                }
            }
        }
        if(n==arr.length-1){
            if(arr[n] == arr[n-1]){
                //     mem[n][givenToLast] = 1;
                return 1;
            }
            if(arr[n] < arr[n-1]){
                if(givenToLast==1){
                    //       mem[n][givenToLast] = -1;
                    return -1;
                }
                //    mem[n][givenToLast] = givenToLast-1;
                return givenToLast-1;
            }
            if(arr[n] > arr[n-1]){
                //    mem[n][givenToLast] =  givenToLast+1;
                return givenToLast+1;
            }
        }
        else{
            if(arr[n] == arr[n-1]){
                int give = 0;
                while(true){
                    give++;
                    long suffix = candies(n+1, give, arr);
                    if(suffix > 0){
                        //          mem[n][givenToLast] = suffix + give;
                        return suffix + give;
                    }
                }
            }
            else if(arr[n] < arr[n-1]){
                for(int i= 1 ; i< givenToLast ; i++){
                    long suffix = candies(n+1, i, arr);
                    if(suffix > 0){
                        //        mem[n][givenToLast] = suffix +i ;
                        return suffix + i;
                    }
                }
                //   mem[n][givenToLast] = -1;
                return -1;
            }
            else if(arr[n] > arr[n-1]){
                int give = givenToLast;
                while(true){
                    give++;
                    long suffix = candies(n+1, give, arr);
                    if(suffix > 0){
                        //         mem[n][givenToLast] = suffix + give;
                        return suffix + give;
                    }
                }
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ads"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
