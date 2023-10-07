package com.learning.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/*
There are N people standing in a circle waiting to be executed.
The counting out begins at some point in the circle and proceeds
around the circle in a fixed direction. In each step, a certain
number of people are skipped and the next person is executed.
The elimination proceeds around the circle (which is becoming smaller
and smaller as the executed people are removed), until only the last person remains, who is given freedom.

Given the total number of persons N and a number k which indicates that k-1 persons are skipped
and the kth person is killed in a circle. The task is to choose the person in the initial circle that survives.

Solution: Recursive way

Josephus( list , start , k){
   if list.size = 1
       return list[0]
   start = (start + k) % list.size
   list.remove( start )
   return Josephus( list, start, k)
}

 */
public class JosephusExample {

    public static void main(String[] args) {
        int numberOfPerson = 10;
        int personToDie = 3;
        int index=0;

        List<Integer> totalNumerOfPerson = new ArrayList<>();
        for(int i=1; i<=numberOfPerson; i++){
            totalNumerOfPerson.add(i);
        }

        int skippedPerson = personToDie-1;

        int escapedPerson = josephus(totalNumerOfPerson, skippedPerson, index);

        System.out.println("Escapted person " + escapedPerson);


    }

    private static int josephus(List<Integer> totalNumerOfPerson, int skippedPerson, int index) {

        // Base case , when only one person is left
        if(totalNumerOfPerson.size() == 1){
            return totalNumerOfPerson.get(0);
        }

        // find the index of first person which will die
        index = (skippedPerson+index) % totalNumerOfPerson.size();
        // remove the first person which is going to be killed
        totalNumerOfPerson.remove(index);

        // recursive call for n-1 persons
        return josephus(totalNumerOfPerson, skippedPerson, index);
    }
}
