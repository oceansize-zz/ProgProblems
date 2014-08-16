package problems;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Vector;

public class MyUtils {
	public static <T extends Comparable> AbstractList getVectorData(String[] args) {
		// TODO Auto-generated method stub
		int[] values = new In(args[0]).readAllInts();
		Arrays.sort(values);
		AbstractList<Integer> vectorValues = new Vector<Integer>();
		for (int i = 0; i < values.length; i++) {
			vectorValues.add(values[i]);
		}
		return vectorValues;
	}
}
