package arrays;

import java.util.ArrayList;

public class HipHipArray {

	private HipHipArray() {
	}

	public static int[] makeHistogram(double[] data, int numBins, double min, double max) {
		double sizeBin = (max - min) / numBins;

		int histogram[] = new int[numBins];

		for (int i = 0; i < histogram.length; i++)

			histogram[i] = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i] >= min && data[i] < max)

			{

				int binIndex = (int) ((data[i] - min) / sizeBin);

				histogram[binIndex]++;

			}

		}

		return histogram;
	}

	public static int[] longestRun(int[] arr) {
		int index = 0, maximIndex = 0, length = 0, maximLength = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (i == 0) {
				index = 0;
				length = 1;
			} else {
				if (arr[i] >= arr[i - 1]) {
					length++;
				} else {
					if (length > maximLength) {
						maximIndex = index;
						maximLength = length;
					}
					length = 1;
					index = i;
				}
			}
		}
		if (length > maximLength) {
			maximIndex = index;
			maximLength = length;
		}
		int[] result = new int[maximLength];
		for (int i = 0; i < maximLength; ++i) {
			result[i] = arr[maximIndex + i];
		}
		return result;
	}

	public static boolean isPermutation(int[] arr) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		for (int j = 0; j < list.size(); j++) {
			for (int k = 0; k < arr.length; k++) {
				if (!list.contains(k)) {
					return false;
				}
			}
		}

		return true;

	}

	public static int[] createPalindrome(int[] arr) {
		if (arr.length == 0)
			return new int[0];

		int[] palin = new int[2 * arr.length - 1];
		int ind = 1;
		for (int i = 0; i < palin.length; ++i) {
			if (i < arr.length) {
				palin[i] = arr[i];
			} else {
				palin[i] = arr[arr.length - ind - 1];
				ind++;
			}
		}
		return palin;
	}

	public static void rotate(int[] arr, int amount) {

		int[] rotate = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			rotate[i] = arr[i];
		}
		amount %= arr.length;
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = rotate[(i - amount + arr.length) % arr.length];
		}
	}

	public static java.lang.String[] removeDups(java.lang.String[] arr) {
		int counter = 0;
		boolean dupe;
		for (int i = 0; i < arr.length; ++i) {
			dupe = false;
			for (int j = 0; j < i; ++j) {
				if (arr[i].equals(arr[j])) {
					dupe = true;
				}
			}
			if (!dupe) {
				++counter;
			}
		}
		java.lang.String[] result = new java.lang.String[counter];
		int index = 0;
		for (int i = 0; i < arr.length; ++i) {
			dupe = false;
			for (int j = 0; j < i; ++j) {
				if (arr[i].equals(arr[j])) {
					dupe = true;
				}
			}
			if (!dupe) {
				result[index++] = arr[i];
			}
		}
		return result;
	}

	public static boolean[] makeSieve(int size, int[] divisors) {
		boolean arr[] = new boolean[size];

		for (int i = 1; i < size; i++)

			arr[i] = true;

		for (int k = 0; k < divisors.length; k++) {

			for (int p = 2; p * divisors[k] < size; p++) {

				arr[divisors[k] * p] = false;

			}

		}

		return arr;
	}

	public static void shift(int[] arr, int amount) {
		if (amount > 0) {
			if (amount >= arr.length) {
				for (int i = 0; i < arr.length; i++) {
					arr[i] = 0;
				}
			} else {
				int k = 0;
				for (int i = amount; i < arr.length; i++) {
					arr[i] = arr[k++];
				}
				for (int i = 0; i < amount; i++) {
					arr[i] = 0;
				}
			}
		} else {
			amount = amount * -1;
			if (amount >= arr.length) {
				for (int i = 1; i < arr.length; i++) {
					arr[i] = 0;
				}
			} else {
				int k = 0;
				for (int i = amount; i < arr.length; i++) {
					arr[k++] = arr[i];
				}
				for (int i = k; i < arr.length; i++) {
					arr[i] = 0;
				}
			}
		}

	}

}
