public class QuickSort {


    public static void main(String[] args) {

        int[] arr = {3, 5, 3, 5, 7, 6, 6, 5, 5, 4, 7, 3, 1, 3, 4, 4, 5, 76, 7, 5, 7, 8, 55, 4, 34, 12, 3, 4, 5, 13, 5, 6, 2, 5, 7, 9, 5 - 2, 3, 5, 6, -56, 5, 8, 6, 4, 3, 5, 6, 3, 4, 5, 6, 7, 8, 8, 8};

        //int[] arr = {2, 5, 6, 7, 4, 3, 2, 8, 9, 0};

        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    static void quickSort(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {

        /*marginal conditions to avoid corner cases*/
        if (start < 0 || end < 0 || start > arr.length - 1 || end > arr.length - 1 || start >= end) {
            return;
        }
        if (end - start == 1) {
            if (arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            return;
        }

        //when the array is larger than 2
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        //go will left pass right
        while (left <= right) {
            while (left <= end && arr[left] <= pivot) {
                left++;
            }
            while (right >= start && arr[right] > pivot) {
                right--;
            }
            //exchange values right <-> left. Do not exchange the last values.
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        //exchange right with pivot
        arr[start] = arr[right];
        arr[right] = pivot;
        //call sorting for both size
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);

    }
}
