package codejam;
import java.util.*;

public class CodeJamQual1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();

		for (int t = 1; t <= testCases; t++) {
			int damageLimit = in.nextInt();
			char[] program = in.next().toCharArray();
			int hacks = 0;
			int progDamage = calcDamage(program);

			boolean impossible = false;
			while (progDamage > damageLimit && !impossible) {
				impossible = true;
				for (int i = program.length - 1; i >= 0; i--) {
					if (program[i] == 'S' && (i - 1) >= 0 && program[i - 1] == 'C') {
						char temp = program[i];
						program[i] = program[i-1];
						program[i-1] = temp;
						
						progDamage = calcDamage(program);
						hacks++;
						impossible = false;
						break;
					}
				}
			}
			if (impossible)
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + t + ": " + hacks);
		}

		in.close();
	}

	static int calcDamage(char[] program) {
		int currDamage = 1, progDamage = 0;

		for (int i = 0; i < program.length; i++) {
			if (program[i] == 'S')
				progDamage += currDamage;
			else
				currDamage *= 2;
		}

		return progDamage;
	}
}
