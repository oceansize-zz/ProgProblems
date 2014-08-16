package problems;

import java.util.AbstractList;

/**
 * 
 * 
 *
 */
public class MyInsertionSort {

	/**
	 * 
	 * @param <T>
	 * @param values
	 */
	public static <T extends Comparable> void sort(AbstractList<T> values) {
		int size = values.size();
		T currValue = null;
		T prevValue = null;
		int comparisonResult = 0;
		for (int i = 0; i < size; i++) {
			currValue = values.get(i);
			for (int j = i - 1; j > -1; j--) {
				prevValue = values.get(j);
				comparisonResult = currValue.compareTo(prevValue);
				if(comparisonResult > 0) {
					values.remove(i);
					values.add(j + 1, currValue);
					break;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractList<Integer> values = MyUtils.getVectorData(args);

		MyInsertionSort.sort(values);
		System.out.println(values);
		System.exit(0);
	}

}
