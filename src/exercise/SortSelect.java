package exercise;

import util.Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class SortSelect extends Algorithm {

    @Override
    protected String name() { return "SortSelect"; }

    public long[] call(ArrayList<Integer> numbers, int target) {
        Integer[] arr = new Integer[numbers.size()];
        arr = numbers.toArray(arr);

        //TIMING START
        long startTime = System.nanoTime();

        int res = E3.sortSelect(arr, target);

        long elapsedTime = System.nanoTime() - startTime;
        //TIMING END

        numbers.clear();
        Collections.addAll(numbers, arr);
        long[] result = {elapsedTime, res};
        return result;
    }
}
