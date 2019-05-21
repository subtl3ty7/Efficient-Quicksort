
import exercise.SelectExercise;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Test {

	public static void main(String[] args) {
		System.out.println("Efficient Quicksort");
		System.out.println("");

		Path instances = FileSystems.getDefault().getPath("instances/");
		Path solutions = FileSystems.getDefault().getPath("solutions/");

		SelectExercise exercise = new SelectExercise(instances, solutions);
		try {
			exercise.run();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
