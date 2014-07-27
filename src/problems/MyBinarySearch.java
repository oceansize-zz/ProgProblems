package problems;

import java.util.AbstractList;
import java.util.Vector;

public class MyBinarySearch {

	public static <T extends Comparable> int find(T valueToFind,
			AbstractList<T> sortedValues, int startIndex, int endIndex) {
		assert (valueToFind instanceof Comparable) : "valueToFind is not an instance of Comparable";
		assert (sortedValues != null) : "list is null";
		assert (sortedValues.size() > 0) : "list is empty";	
		assert (endIndex >= startIndex) : "endIndex cannot be less than startIndex";

		int middlePoint = GetMidPoint(startIndex, endIndex);
		int comparisonResult = 0;

		comparisonResult = ((Comparable<T>) sortedValues.get(middlePoint))
				.compareTo(valueToFind);

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
			return MyBinarySearch.find(valueToFind, sortedValues, 0,
					middlePoint - 1);
		} else if (comparisonResult < 1) {
			return MyBinarySearch.find(valueToFind, sortedValues,
					middlePoint + 1, endIndex);
		}

		return -1;
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
		// TODO Auto-generated method stub
		AbstractList<Integer> values = new Vector<Integer>();
		values.add(3);
		values.add(5);
		values.add(7);
		values.add(9);
		values.add(11);
		int size = values.size();

		System.out
				.println(MyBinarySearch.find(7, values, 0, size - 1));
	}

}
