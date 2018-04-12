package googleJapan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner io = new Scanner(new File(Task2.class.getResource("task1-test-input.txt").getPath()));
		PrintWriter writer = new PrintWriter("output1.txt", "UTF-8");

		final String onePush = "ADGJMPTW";
		final String twoPushs = "BEHKNQUX";
		final String threePushs = "CFILORVY";

		int c = io.nextInt();
		for (int r = 1; r <= c; r++) {
			int count = 0;

			String word = io.next();

			for (int i = 0; i < word.length(); i++) {
				String letter = word.substring(i, i + 1);

				if (onePush.contains(letter)) {
					count += 1;
				} else if (twoPushs.contains(letter)) {
					count += 2;
				} else if (threePushs.contains(letter)) {
					count += 3;
				} else {
					count += 4;
				}
			}

			writer.write("Case #" + r + ": " + count + "\n");
		}
		io.close();
		writer.close();
	}
}