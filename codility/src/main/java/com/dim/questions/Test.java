package com.dim.questions;

import java.util.ArrayList;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {

        //find minimum travel distances in order

        //Logic is : need to find i
        List<List<Integer>> output;
        int currentMinCost = Integer.MAX_VALUE ;
        for(int i=0 ;  i< forwardRouteList.size() ; i++ ){

            for(int j=0 ;  j< returnRouteList.size() ; j++ ){

                int distanceOfRoute =  forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1) ;

                if(currentMinCost == distanceOfRoute ){
                    List<Integer>  entry  = new ArrayList<>();
                    entry.add(i);
                    entry.add(j);
                }
                else if(distanceOfRoute < currentMinCost){
                     //output.clear();
                }

                currentMinCost = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1) ;

            }

        }



    }
    // METHOD SIGNATURE ENDS
}