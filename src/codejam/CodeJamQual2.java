package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeJamQual2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(bf.readLine());

		for (int t = 1; t <= testCases; t++) {
			int n = Integer.parseInt(bf.readLine());

			String arrAsString = bf.readLine();

			String[] arrAsStrings = arrAsString.split("\\s");
			int[] evenArr = new int[(n + 1) / 2];
			int[] oddArr = new int[n / 2];

			for (int i = 0; i < n; i++) {
				if (i % 2 == 0)
					evenArr[i / 2] = Integer.parseInt(arrAsStrings[i]);
				else
					oddArr[i / 2] = Integer.parseInt(arrAsStrings[i]);
			}

			Arrays.sort(evenArr);
			Arrays.sort(oddArr);

			int[] arr = new int[n];
			
			for (int i = 0; i < evenArr.length; i++) {
				arr[i * 2] = evenArr[i];
			}
			for (int i = 0; i < oddArr.length; i++) {
				arr[i * 2 + 1] = oddArr[i];
			}
			
			int errorIndex = -1;

			for (int i = 0; i < n - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					errorIndex = i;
					break;
				}
			}
			
			if (errorIndex == -1)
				System.out.println("Case #" + t + ": OK");
			else
				System.out.println("Case #" + t + ": " + errorIndex);
		}

		bf.close();
	}
}
