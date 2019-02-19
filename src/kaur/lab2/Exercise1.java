package kaur.lab2;

public class Exercise1 {
	/** Returns the sum of the integers in given array. */
	  public static int example1(int[] arr) {
	    int n = arr.length, total = 0;
	    for (int j=0; j < n; j++)       // loop from 0 to n-1
	      total += arr[j];
	    return total;
	  }
	  /* Big O notation of example1
	   * 	1+n
			F(n) <= cg(n)
			1+n <= c*n
			1 <= cn – n
			1 <= (c – 1)n
			1/(c-1) <= n
			C=2 for n˳ = 1
			Complexity =  O(n)

	   */

	  /** Returns the sum of the integers with even index in given array. */
	  public static int example2(int[] arr) {
	    int n = arr.length, total = 0;
	    for (int j=0; j < n; j += 2)    // note the increment of 2
	      total += arr[j];
	    return total;
	  }
	  /* Big O notation of example2
	   * 	1+ 1 + logn
			F(n) <= cg(n)
			2 + logn  ≤  cn
			clogn-logn ≥ 2
			logn(c-1) ≥ 2
			2/(c-1) <= logn
			c=3
			n˳ = 1
			Complexity= O(logn)

	   */
	

	  /** Returns the sum of the prefix sums of given array. */
	  public static int example3(int[] arr) {
	    int n = arr.length, total = 0;
	    for (int j=0; j < n; j++)       // loop from 0 to n-1
	      for (int k=0; k <= j; k++)    // loop from 0 to j
	        total += arr[j];
	    return total;
	  }
	  /* Big O notation of example3
	   * 	1 + n* n +1
			1+ n²+1
			2+n² ≤ cn²
			Cn² – n² ≥ 2
			n² (c-1) ≥ 2
			n² >= 2/(c-1)
			for c=3
			n˳ = 1
			Complexity = O(n²)

	   */

	  /** Returns the sum of the prefix sums of given array. */
	  public static int example4(int[] arr) {
	    int n = arr.length, prefix = 0, total = 0;
	    for (int j=0; j < n; j++) {     // loop from 0 to n-1
	      prefix += arr[j];
	      total += prefix;
	    }
	    return total;
	  }
	  /* Big O notation of example4
	   * 	1 + 1 + 1 + n * n * 1 * 1 * 1
			3 + n² <= cn²
			3 <= cn² - n²
			3/(c-1) <= n²
			C = 4 for n˳ = 0
			Complexity = O(n²)

	   */

	  /** Returns the number of times second array stores sum of prefix sums from first. */
	  public static int example5(int[] first, int[] second) { // assume equal-length arrays
	    int n = first.length, count = 0;
	    for (int i=0; i < n; i++) {     // loop from 0 to n-1
	      int total = 0;
	      for (int j=0; j < n; j++)     // loop from 0 to n-1
	        for (int k=0; k <= j; k++)  // loop from 0 to j
	          total += first[k];
	      if (second[i] == total) count++;
	    }
	    return count;
	  }
	  /* Big O notation of example5
	   * 	1 + 1 + n * 1 * n * n + n + 1
			n³ + n + 3  ≤  cn³
			n + 3 <= cn³ - n³
			n + 3 <= (c-1) n³
			(n + 3)/(c-1) <= n³
			C=4 for   n˳ = 0
			Complexity = O(n³)

	   */


}
