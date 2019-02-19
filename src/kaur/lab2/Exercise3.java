package kaur.lab2;
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Exercise3 {

	/** Returns true if there are no duplicate elements in the array. */
	public static boolean unique1(int[] data) {
		int n = data.length;
		System.out.println("Array Size in Unique 1: " + n);
		for (int j = 0; j < n - 1; j++)
			for (int k = j + 1; k < n; k++)
				if (data[j] == data[k]) {
					System.out.println("Item found:" + data[j]);
					return false;
				} // found duplicate pair
		return true; // if we reach this, elements are unique
	}

	/** Returns true if there are no duplicate elements in the array. */
	public static boolean unique2(int[] data) {
		int n = data.length;
		System.out.println("Array Size in Unique 2: " + n);
		int[] temp = Arrays.copyOf(data, n); // make copy of data
		Arrays.sort(temp); // and sort the copy
		for (int j = 0; j < n - 1; j++)
			if (temp[j] == temp[j + 1]) // check neighboring entries
				return false; // found duplicate pair
		return true; // if we reach this, elements are unique
	}

	public static void main(String args[]) {
		int min = 0;
		int max1 = 100000;// Maximum Size for Unique1
		int max2 = 10000000;// Maximum Size for Unique2
		int tLimit = 10000; // 1 second = 1000 millisecond
		int size1 = searchHighestSizeUnique1(min, max1, tLimit);
		int size2 = searchHighestSizeUnique2(min, max2, tLimit);
		System.out.println("Highest value of n for Unique1: " + size1);
		System.out.println("Highest value of n for Unique2: " + size2);
	}

	public static int searchHighestSizeUnique1(int min, int max, int tLimit) {

		int n = (min + max) / 2;
		int arr[] = generateArray(n);
		if (n < max && min != max) {

			long start, end;
			long elapsed;

			start = System.currentTimeMillis();
			unique1(arr);
			end = System.currentTimeMillis();
			elapsed = end - start;
			System.out.println("Array Size: n = " + n + "------Start Time: " + start + "    End Time: " + end
					+ "     Elapsed: " + elapsed);
			if (elapsed == tLimit) {
				return n;
			}
			if (elapsed < tLimit) {
				return searchHighestSizeUnique1(n + 1, max, tLimit);
			} else if (elapsed > tLimit) {
				return searchHighestSizeUnique1(min, n - 1, tLimit);
			}
		}
		return n;
	}

	public static int searchHighestSizeUnique2(int min, int max, int tLimit) {

		int n = (min + max) / 2;
		int arr[] = generateArray(n);
		if (n < max && min != max) {

			long start, end;
			long elapsed;

			start = System.currentTimeMillis();
			unique2(arr);
			end = System.currentTimeMillis();
			elapsed = end - start;
			System.out.println("Array Size: n = " + n + "------Start Time: " + start + "    End Time: " + end
					+ "     Elapsed: " + elapsed);
			if (elapsed == tLimit) {
				return n;
			}
			if (elapsed < tLimit) {
				return searchHighestSizeUnique2(n + 1, max, tLimit);
			} else if (elapsed > tLimit) {
				return searchHighestSizeUnique2(min, n - 1, tLimit);
			}
		}

		return n;
	}

	public static int[] generateArray(int n) {

		Set<Integer> arr = new HashSet<Integer>();

		while (arr.size() < n) {// create array
			Random random = new Random();
			arr.add(random.nextInt());
		}
		int arr1[] = arr.stream().mapToInt(i -> i).toArray();

		return arr1;
	}

}
