package exercise;

import util.Algorithm;
import util.Exercise;
import util.Prompt;
import util.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SelectExercise extends Exercise {
    public SelectExercise(Path instancesBase_P, Path solutionsBase_P) {
        setInstancesBase(instancesBase_P);
        setSolutionsBase(solutionsBase_P);
    }

    @Override
    public String name() { return "Select"; }

    @Override
    public void run() throws IOException {
        SelectSolution sol = new SelectSolution();
        this.<SelectSolution>promptInstances(sol, instancesBase, solutionsBase, ".csv");

    }

    @Override
    protected void runWithFile(BufferedReader reader, Solution sol) throws IOException, Algorithm.AlgorithmErrorException {
        SelectSolution selectSol = (SelectSolution) sol;
        SelectSolution sortSol = (SelectSolution) sol;

        if(!E3.SELECT_IS_IMPLEMENTED)
            System.out.println("Warning: Select marked as not implemented!");

        if(!E3.SORT_SELECT_IS_IMPLEMENTED)
            System.out.println("Warning: Sort-Select marked as not implemented!");

        int numInstances = Integer.parseInt(reader.readLine());
        System.out.println("Searching... ");
        for(String line = reader.readLine(); line != null; line = reader.readLine()) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();

            String[] splitted = line.split(",");
            int id = Integer.parseInt(splitted[0]);
            String seqType = splitted[1];
            int target = Integer.parseInt(splitted[2]);
            for(String number : Arrays.copyOfRange(splitted, 3, splitted.length))
                numbers.add(Integer.parseInt(number));

            if(id % 1000 == 0)
                System.out.println("Searching in Sequence " + id + "/" + numInstances);

            if(E3.SELECT_IS_IMPLEMENTED) {
                if (!selectFromSequence(id, seqType, target, numbers, selectSol)) {
                    throw new Algorithm.AlgorithmErrorException(id, "select: " + selectSol.solutionToString(selectSol.numSolutions() - 1));
                }
            }

            if(E3.SORT_SELECT_IS_IMPLEMENTED) {
                if (!selectFromSortedSequence(id, seqType, target, numbers, sortSol)) {
                    throw new Algorithm.AlgorithmErrorException(id, "sortSelect: " + selectSol.solutionToString(selectSol.numSolutions() - 1));
                }
            }
        }

        if(E3.SELECT_IS_IMPLEMENTED || E3.SORT_SELECT_IS_IMPLEMENTED) {
            System.out.println(Prompt.getSuccessMessage("Search has been completed successfully!"));
            System.out.print("\n");
        }
        else {
            System.out.println(Prompt.getErrorMessage("Both Algorithms are not implemented! Empty Output occurred!"));
            System.out.print("\n");
        }

    }

    private boolean selectFromSortedSequence(int id, String seqType, int target, ArrayList<Integer> numbers, SelectSolution sol) {
        ArrayList<Integer> solution = new ArrayList<Integer>(numbers.size());
        for(Integer i : numbers)
            solution.add(new Integer(i));
        Collections.sort(solution);

        SortSelect sortSelect = new SortSelect();

        long[] timeResult = sortSelect.call(numbers, target);

        ArrayList<Integer> correctSolution = new ArrayList<Integer>();
        ArrayList<Integer> theirSolution = new ArrayList<Integer>();
        theirSolution.add(0, (int)timeResult[1]);
        correctSolution.add(0, solution.get(target));
        theirSolution.add(1, numbers.size());
        correctSolution.add(1, numbers.size());

        return sol.addSolution(id, sortSelect.name(), seqType, timeResult[0], theirSolution, correctSolution);
    }

    private boolean selectFromSequence(int id, String seqType, int target, ArrayList<Integer> numbers, SelectSolution sol) {
        ArrayList<Integer> solution = new ArrayList<Integer>(numbers.size());
        for(Integer i : numbers)
            solution.add(new Integer(i));
        Collections.sort(solution);

        Select select = new Select();

        long[] timeResult = select.call(numbers, target);

        ArrayList<Integer> correctSolution = new ArrayList<Integer>();
        ArrayList<Integer> theirSolution = new ArrayList<Integer>();
        theirSolution.add(0, (int)timeResult[1]);
        correctSolution.add(0, solution.get(target));
        theirSolution.add(1, numbers.size());
        correctSolution.add(1, numbers.size());

        return sol.addSolution(id, select.name(), seqType, timeResult[0], theirSolution, correctSolution);
    }
}
