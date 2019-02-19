package kaur.lab2;

import java.util.Random;

import org.jfree.ui.RefineryUtilities;

class Exercise2 {

	public static double[] prefixAverage1(double[] x) {
		int n = x.length;
		double[] a = new double[n]; // filled with zeros by default
		for (int j = 0; j < n; j++) {
			double total = 0; // begin computing x[0] + ... + x[j]
			for (int i = 0; i <= j; i++)
				total += x[i];
			a[j] = total / (j + 1); // record the average
		}
		return a;
	}

	public static double[] prefixAverage2(double[] x) {
		int n = x.length;
		double[] a = new double[n]; // filled with zeros by default
		double total = 0; // compute prefix sum as x[0] + x[1] + ...
		for (int j = 0; j < n; j++) {
			total += x[j]; // update prefix sum to include x[j]
			a[j] = total / (j + 1); // compute average based on current sum
		}
		return a;
	}

	public static void main(String arg[]) {

		Random rand = new Random();
		double aa[] = null;
		int inp[] = new int[6];
		long out[] = new long[6];
		int inp2[] = new int[6];
		long out2[] = new long[6];

		// Experimental Analysis of PreAverage2
		for (int k = 0; k <= 5; k++) {
			inp[k] = rand.nextInt(34500);
			aa = new double[inp[k]];
			for (int i = 0; i < aa.length; i++) {
				aa[i] = rand.nextDouble();
			}

			long start = System.currentTimeMillis();
			prefixAverage2(aa);
			long end = System.currentTimeMillis();
			System.out.println("Prefix 2 input size and output time consumed");
			out[k] = end - start;
			System.out.println("Input " + k + " :" + inp[k] + " Start time: " + start + " End Time: "
					+ end + " Output " + k + " Total Time: " + out[k]);

		}

		// Experimental Analysis of PreAverage2
		for (int h = 0; h <= 5; h++) {
			inp2[h] = rand.nextInt(34500);
			aa = new double[inp2[h]];
			for (int q = 0; q < aa.length; q++) {
				aa[q] = rand.nextDouble();
			}

			long startTime2 = System.currentTimeMillis();
			prefixAverage1(aa);
			long endTime2 = System.currentTimeMillis();
			System.out.println("Prefix 1 input size and output time consumed");
			out2[h] = endTime2 - startTime2;
			System.out.println("Input " + h + " :" + inp2[h] + " Start time: " + startTime2 + " End Time: "
					+ endTime2 + " Output " + h + " Total Time: " + out2[h]);

		}

		final LogPlot logPlot = new LogPlot("Average 2", inp, out);
		logPlot.pack();
		RefineryUtilities.centerFrameOnScreen(logPlot);
		logPlot.setVisible(true);

		final LogPlot logPlot1 = new LogPlot("Average 1", inp2, out2);
		logPlot1.pack();
		RefineryUtilities.centerFrameOnScreen(logPlot1);
		logPlot1.setVisible(true);
	}
}
