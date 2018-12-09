import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static  void  main(String[] args){

        int[] arr = {3,5,3,5,7,6,6,5,5,4,7,3,1,3,4,4,5,76,7,5,7,8,55,4,34,12,3,4,5,13,5,6,2,5,7,9,5-2,3,5,6,-56,5,8,6,4,3,5,6,3,4,5,6,7,8,8,8} ;

        int[] sortedArr = mergeSort(arr);

        for (int i : sortedArr) {
            System.out.print(i + ",");
        }

    }


    static int[] mergeSort(int[] numbers){

        if(numbers.length == 1){
            return numbers ;
        }

        if(numbers.length==2){
            if(numbers[0] <= numbers[1]){
                return numbers;
            }
            else{
                int temp = numbers[0];
                numbers[0] = numbers[1];
                numbers[1] = temp;
                return numbers;
            }
        }
        else{

            int mid = numbers.length/2;

           int[] left  =  mergeSort(Arrays.copyOfRange(numbers, 0 , mid+1));
           int[] right =  mergeSort(Arrays.copyOfRange(numbers, mid+1 , numbers.length));

            return  merge(left,right) ;
        }
    }


    //merge
    static int[] merge(int[] left, int [] right){

        int[] result = new int[left.length+right.length];

        int resultNextIndex = 0 ;
        int leftIndex = 0 ;
        int rightIndex = 0 ;

        //compare arrays and fill result
        while (leftIndex <= left.length-1 && rightIndex<= right.length-1){
            if(left[leftIndex] <= right[rightIndex]){
                result[resultNextIndex] =  left[leftIndex];
                resultNextIndex++;
                leftIndex++;
            }
            else{
                result[resultNextIndex] = right[rightIndex];
                resultNextIndex++;
                rightIndex++;
            }
        }
        //if left is not fully taken
        if(leftIndex<left.length){
            System.arraycopy(left, leftIndex  , result, resultNextIndex , result.length-resultNextIndex  );   //JNI (java native intrface)
        }
        else if(rightIndex<right.length){
            System.arraycopy(right, rightIndex  , result, resultNextIndex , result.length-resultNextIndex  );
        }
        return  result;
    }
}
