package googleJapan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner io = new Scanner(new File(Task2.class.getResource("task2-test-input.txt").getPath()));
		PrintWriter writer = new PrintWriter("output2.txt", "UTF-8");

		int c = io.nextInt();
		for (int r = 1; r <= c; r++) {
			int count = 0;
			int h = io.nextInt();
			int w = io.nextInt();

			char[][] lab = new char[h][w];
			for (int i = 0; i < h; i++) {
				lab[i] = io.next().toCharArray();
			}

			boolean[][] visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (lab[i][j] != '.')
						visited[i][j] = true;
				}
			}

			count = getDeadEnds(lab, visited, h, w, 1, 1);

			writer.write("Case #" + r + ": " + count + "\n");
		}
		io.close();
		writer.close();
	}

	static int getDeadEnds(char[][] lab, boolean[][] visited, int h, int w, int i, int j) {
		if (visited[i][j])
			return 0;

		visited[i][j] = true;

		if (isDeadEnd(lab, visited, h, w, i, j))
			return 1;

		int deadEnds = getDeadEnds(lab, visited, h, w, i - 1, j) + getDeadEnds(lab, visited, h, w, i, j - 1)
				+ getDeadEnds(lab, visited, h, w, i, j + 1) + getDeadEnds(lab, visited, h, w, i + 1, j);

		return deadEnds;
	}

	static boolean isDeadEnd(char[][] lab, boolean[][] visited, int h, int w, int i, int j) {
		return visited[i - 1][j] && visited[i][j - 1] && visited[i][j + 1] && visited[i + 1][j];
	}

	static boolean isInBound(int h, int w, int i, int j) {
		return i >= 0 && i < h && j >= 0 && j < w;
	}
}