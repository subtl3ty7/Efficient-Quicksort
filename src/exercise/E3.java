package exercise;

import java.util.Arrays;

public class E3 {
    static final boolean SELECT_IS_IMPLEMENTED = true;
    static final boolean SORT_SELECT_IS_IMPLEMENTED = true;


    static int select(Integer[] numbers, int k) {
        return quicksort(0,numbers.length-1,k,numbers);
    }
    static int quicksort(int lowerIndex, int higherIndex, int k, Integer[] numarray){

        if( lowerIndex<higherIndex){
            int pivot = divide(lowerIndex,higherIndex,numarray);

            if(k< pivot){

                quicksort(lowerIndex,pivot-1,k,numarray);
            }
            if(k > pivot){
                quicksort(pivot+1,higherIndex,k,numarray);
            }
            return numarray[k];
        }

        return numarray[k];

    }

    static int divide(int lowerIndex, int higherIndex, Integer[] numarray){

        int piv = numarray[higherIndex];
        int a = lowerIndex-1;

        for(int i = lowerIndex; i < higherIndex ; i++){

            if(numarray[i] <= piv){
                a++;
                int help = numarray[a];
                numarray[a] = numarray[i];
                numarray[i] = help;
            }
        }

        int help = numarray[a+1];
        numarray[a+1] = numarray[higherIndex];
        numarray[higherIndex] = help;
        return a+1;
    }

    static int sortSelect(Integer[] numbers, int k) {
        Arrays.sort(numbers);
        return numbers[k];
    }

}
