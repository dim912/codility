public class BinarySearch {


    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 11, 25, 67, 89, 100, 101, 103, 107, 150, 167};
        System.out.println(findRecurssive(arr, 150));
        System.out.println(findIterative(arr, 150));
    }


    static int findIterative(int[] numbers, int num){

        int result = -1 ;
        int left = 0 ;
        int right = numbers.length ;
        int middleIndex ;
        int midValue;

        while (left<=right){
            middleIndex = (left+right)/2;
            midValue = numbers[middleIndex];

            if(numbers[middleIndex] ==  num) {
                return middleIndex;
            }
            else if(num<midValue){
                right = middleIndex-1;
            }
            else{
                left = middleIndex+1 ;
            }
        }

        return result;
    }




    static int findRecurssive(int[] numbers, int num) {

        return findRecurssive(numbers, num, 0, numbers.length - 1);
    }
    // recursive solution
    static int findRecurssive(int[] numbers, int num, int start, int end) {

        int middle = (start + end) / 2;

        if (numbers[middle] == num) {
            return middle;
        } else if (start == end) {  //the number is not found
            return -1;
        }
        if (num < numbers[middle]) {

            return findRecurssive(numbers, num, start, middle - 1);
        } else {

            return findRecurssive(numbers, num, middle + 1, end);
        }
    }
}
