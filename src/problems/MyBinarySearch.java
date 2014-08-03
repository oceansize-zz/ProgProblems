package problems;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Vector;

public class MyBinarySearch {

	/**
	 * Since we are using zero based array we should begin with startIndex = 0
	 * and endIndex n - 1 where n is the length of the array.
	 * 
	 * 
	 * @param valueToFind
	 * @param sortedValues
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static <T extends Comparable> int findRecursive(T valueToFind,
			AbstractList<T> sortedValues, int startIndex, int endIndex) {
		CheckAsserts(valueToFind, sortedValues, startIndex, endIndex);

		int middlePoint = GetMidPoint(startIndex, endIndex);
		int comparisonResult = 0;

		comparisonResult = doCompare(sortedValues.get(middlePoint), valueToFind);

		if (comparisonResult != 0
				&& (middlePoint == 0 || middlePoint == endIndex)) {
			return -1;
		}

		System.out.println("middlePoint: " + middlePoint + " startIndex: "
				+ startIndex + " endIndex: " + endIndex + " comparisonResult: "
				+ comparisonResult);

		if (comparisonResult == 0) {
			return middlePoint;
		} else if (comparisonResult > 0) {
			return MyBinarySearch.findRecursive(valueToFind, sortedValues,
					startIndex, middlePoint - 1);
		} else if (comparisonResult < 1) {
			return MyBinarySearch.findRecursive(valueToFind, sortedValues,
					middlePoint + 1, endIndex);
		}

		return -1;
	}

	/**
	 * s
	 * 
	 * @param valueToFind
	 * @param sortedValues
	 * @param startIndex
	 * @param endIndex
	 */
	public static <T> void CheckAsserts(T valueToFind,
			AbstractList<T> sortedValues, int startIndex, int endIndex) {
		assert (valueToFind instanceof Comparable) : "valueToFind is not an instance of Comparable";
		assert (sortedValues != null) : "list is null";
		assert (sortedValues.size() > 0) : "list is empty";
		assert (endIndex >= startIndex) : "endIndex cannot be less than startIndex";
	}

	/**
	 * 
	 * @param valueToFind
	 * @param sortedValues
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static <T extends Comparable> int findIterative(T valueToFind,
			AbstractList<T> sortedValues, int startIndex, int endIndex) {
		CheckAsserts(valueToFind, sortedValues, startIndex, endIndex);
		int middlePoint = 0;
		int comparisonResult = 0;
		int index = -1;
		int counter = 0;

		while (endIndex >= startIndex) {
			middlePoint = GetMidPoint(startIndex, endIndex);
			comparisonResult = doCompare(sortedValues.get(middlePoint),
					valueToFind);
			counter++;

			if (comparisonResult == 0) {
				index = middlePoint;
				break;
			} else if (comparisonResult > 0) {
				// lower half of list
				endIndex = middlePoint - 1;
			} else if (comparisonResult < 0) {
				// upper half of list
				startIndex = middlePoint + 1;
			}
		}
		//System.out.println("iter count: " + counter);
		return index;
	}

	/**
	 * 
	 * @param val1
	 * @param val2
	 * @return
	 */
	private static <T extends Comparable> int doCompare(T val1, T val2) {
		return val1.compareTo(val2);
	}

	/**
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int GetMidPoint(int startIndex, int endIndex) {
		return startIndex + ((endIndex - startIndex) / 2);
	}

	public static void main(String[] args) throws Exception, AssertionError {

		/*
		 * AbstractList<Integer> values = new Vector<Integer>(); values.add(3);
		 * values.add(5); values.add(7); values.add(9); values.add(11); int size
		 * = values.size();
		 */
		int[] values = new In(args[0]).readAllInts();
		Arrays.sort(values);
		AbstractList<Integer> vectorValues = new Vector<Integer>();
		for (int i = 0; i < values.length; i++) {
			vectorValues.add(values[i]);
		}

		System.out.println("length: " + vectorValues.size());

		System.out.println("Answer: "
				+ MyBinarySearch.findRecursive(982455, vectorValues, 0,
						vectorValues.size() - 1));

		System.out.println("Answer: "
				+ MyBinarySearch.findIterative(982455, vectorValues, 0,
						vectorValues.size() - 1));

		System.exit(0);
	}
}
