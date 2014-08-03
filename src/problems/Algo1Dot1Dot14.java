package problems;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Vector;

/**
 * 
 *
 */
public class Algo1Dot1Dot14 {

	public static int lg(int n) {
		int x = 1;
		for (int i = 0; i < n; i++) {
			x = x * 2;
		}
		return x - 1;
	}

	/**
	 * 
	 * @param sortedValues
	 * @param m
	 * @return
	 */
	public static int[] histogram(AbstractList<Integer> values, int m) {
		int[] histogram = new int[m];
		int index = 0;
		int value = 0;
		int counter = 0;
		for (int i = 0; i < m; i++) {
			histogram[i] = i;
			value = i;
			counter = 0;
			index = MyBinarySearch.findIterative(i, values, 0, values.size());
			for (int j = index + 1; value == i && index >= 0; j++) {
				counter++;
				value = values.get(j);
			}

			for (int j = index - 1; value == i && index >= 0 && j > 0; j--) {
				counter++;
				value = values.get(j);
			}

			histogram[i] = counter;
		}

		return histogram;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(lg(4));

		int[] values = new In(args[0]).readAllInts();
		Arrays.sort(values);
		AbstractList<Integer> vectorValues = new Vector<Integer>();
		for (int i = 0; i < values.length; i++) {
			vectorValues.add(values[i]);
		}

		int[] histo = histogram(vectorValues, 100);
		for (int i = 0; i < histo.length; i++) {
			System.out.println(i + " " + histo[i]);
		}
		System.exit(0);
	}
}
