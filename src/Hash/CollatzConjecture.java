package Hash;

import java.util.HashSet;
import java.util.Set;

public class CollatzConjecture {

	public static boolean testCollatzConjecture(int n) {
		Set<Long> verifiedSet = new HashSet<>();
		for (int i = 3; i <= n; i += 2) {
			Set<Long> sequence = new HashSet<>();
			long testI = i;
			while (testI >= i) {
				if (sequence.add(testI)) {
					return false; // previously encountered testI so it has falledn into a loop.
				}

				if (testI % 2 != 0) {
					if (verifiedSet.contains(testI)) {
						break;
					}
					long nextTestI = 3 * testI + 1;
					if (nextTestI <= testI)
						throw new ArithmeticException("Collatz sequence overflow for " + i);

					testI = nextTestI;
				} else {
					testI /= 2;
				}
			}
		}
		return true;
	}
}
