package manish;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Solving https://code.google.com/codejam/contest/6224486/dashboard.
 * Passed small/large inputs.
 * 
 * @author mmaheshwari
 */
public class StandingOvation {
	final static String PROBLEM_NAME = "StandingOvation";
	final static String WORK_DIR = "/Users/mmaheshwari/Desktop/CodeJam2015/"
			+ PROBLEM_NAME + "/";
	final static String INPUT_FILE_NAME = "input.txt";
	final static String OUTPUT_FILE_NAME = "output.txt";

	int solve(Scanner sc, PrintWriter pw) {
		int maxShyness = sc.nextInt();
		String shynessValues = sc.next().trim();
		int[] people = new int[maxShyness + 1];
		for (int i = 0; i < people.length; i++) {
			people[i] = Integer.parseInt(shynessValues.charAt(i) + "");
		}
		// System.out.println(Arrays.toString(people));
		int aggregate = 0;
		int count = 0;
		for (int i = 0; i < people.length; i++) {
			aggregate = aggregate + people[i];
			if (aggregate > i) {
				continue;
			} else {
				int diff = i - aggregate;
				count = count + diff + 1;
				aggregate = aggregate + diff + 1;
//				System.out.format("i %s, diff %s, newCount %s, newAgg %s%n", i,
//						diff, count, aggregate);
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
				+ OUTPUT_FILE_NAME));
		int caseCnt = sc.nextInt();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			int answer = new StandingOvation().solve(sc, pw);
			pw.print(answer + "\n");
		}
		pw.flush();
		pw.close();
		sc.close();
		System.out.println("Complete.");
	}
}