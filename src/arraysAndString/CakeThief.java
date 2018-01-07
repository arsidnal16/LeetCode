package arraysAndString;

/**
 * You are a renowned thief who has recently switched from stealing precious
 * metals to stealing cakes because of the insane profit margins. You end up
 * hitting the jackpot, breaking into the world's largest privately owned stock
 * of cakes—the vault of the Queen of England. While Queen Elizabeth has a
 * limited number of types of cake, she has an unlimited supply of each type.
 *
 * Each type of cake has a weight and a value, stored in tuples with two
 * positions:
 *
 * An integer representing the weight of the cake in kilograms An integer
 * representing the monetary value of the cake in British pounds
 *
 * For example:
 *
 * # weighs 7 kilograms and has a value of 160 pounds (7, 160)
 *
 * # weighs 3 kilograms and has a value of 90 pounds (3, 90)
 *
 * You brought a duffel bag that can hold limited weight, and you want to make
 * off with the most valuable haul possible.
 *
 * Write a function max_duffel_bag_value() that takes an array of cake tuples
 * and a weight capacity, and returns the maximum monetary value the duffel bag
 * can hold.
 *
 * For example:
 *
 * cake_tuples = [(7, 160), (3, 90), (2, 15)] capacity = 20
 *
 * max_duffel_bag_value(cake_tuples, capacity) # returns 555 (6 of the middle
 * type of cake and 1 of the last type of cake)
 *
 * Weights and values may be any non-negative integer. Yes, it's weird to think
 * about cakes that weigh nothing or duffel bags that can't hold anything. But
 * we're not just super mastermind criminals—we're also meticulous about keeping
 * our algorithms flexible and comprehensive.
 * 
 */
public class CakeThief {

	public static int maxDuffelBagValue(final Cake[] cakes, final int capacity) {
		final int[] maxValueAtCapacity = new int[capacity + 1];

		for (int i = 0; i <= capacity; i++) {
			int currentMaxValue = 0;

			for (int j = 0; j < cakes.length; j++) {
				final Cake cake = cakes[j];
				if (cake.weight <= i) {
					// should we use the cake or not?
					// if we use the cake, the most kilograms we can include in addition to the cake
					// we're adding is the current capacity minus the cake's weight. we find the max
					// value at that integer capacity in our array max_values_at_capacities
					int maxValueUsingCake = cake.worth + maxValueAtCapacity[i - cake.weight];

					// now we see if it's worth taking the cake. how does the
					// value with the cake compare to the current_max_value?
					currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
				}
			}

			maxValueAtCapacity[i] = currentMaxValue;
		}

		return maxValueAtCapacity[capacity];
	}

	public static class Cake {
		private final int weight;
		private final int worth;

		public Cake(final int weight, final int worth) {
			this.weight = weight;
			this.worth = worth;
		}
	}
}