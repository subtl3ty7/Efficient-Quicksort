package exercise;

import util.Solution;

import java.util.ArrayList;

public class SelectSolution extends Solution<ArrayList<Integer>> {

    @Override
    public boolean check(ArrayList<Integer> value, ArrayList<Integer> solution) {
        int theirs = value.get(0);
        int correct = solution.get(0);
        if(theirs != correct) {
            return false;
        }
        return true;
    }

    @Override
    public String header() {
        String head = super.header();
        head += delim + "elements";
        return head;
    }

    @Override
    public String line(Integer i) {
        String l = super.line(i);
        l += delim;
        l += solutions.get(i).get(1);

        return l;
    }

    @Override
    public String solutionToString(int id) {
        ArrayList<Integer> solution = solutions.get(id);
        return solution.get(0).toString();
    }
}
