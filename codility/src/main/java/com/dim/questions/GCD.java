package com.dim.questions;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class GCD
{
    public static void main(String[] args){
        generalizedGCD();
    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int generalizedGCD()
    {

        int num = 5 ;
        int[] arr = new int[] {2,3,4,5,6};


        // WRITE YOUR CODE HERE
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i < arr.length ; i++){

            if(arr[i] < min && arr[i]!=0) min = arr[i] ;

        }

        int gdc = 1;
        outerloop:
        for(int i=1 ; i <= min ; i++ ){
            for(int j=0 ; i< arr.length; j++){
                if(arr[j]%i != 0) { continue outerloop; }

            }
            gdc = i;
        }
        System.out.println(gdc);
        return gdc;

    }
    // METHOD SIGNATURE ENDS
}