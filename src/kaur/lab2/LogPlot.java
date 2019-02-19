package kaur.lab2;

/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * ------------------
 * XYLogAxesDemo.java
 * ------------------
 * (C) Copyright 2002-2004, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   Clemens;
 *
 * $Id: XYLogAxesDemo.java,v 1.14 2004/04/26 19:12:04 taqua Exp $
 *
 * Changes
 * -------
 * 31-Jul-2002 : Version 1 (DG);
 * 11-Oct-2002 : Fixed issues reported by Checkstyle (DG);
 * 31-Jan-2003 : Replaced DefaultXYDataset with XYSeriesCollection (DG);
 *
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 * A demo showing the use of log axes.
 *
 */
public class LogPlot extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new demo.
	 *
	 * @param title
	 *            the frame title.
	 */
	public LogPlot(String title, int[] input, long output[]) {

		super(title);

		final XYSeries xy = new XYSeries("Prefix Analysis");
		xy.add(input[0], output[0]);
	    xy.add(input[1], output[1]);
	    xy.add(input[2], output[2]);
	    xy.add(input[3], output[3]);
	    xy.add(input[4], output[4]);
	    

		final XYSeriesCollection plot = new XYSeriesCollection(xy);
		final JFreeChart chart = ChartFactory.createXYLineChart("PrefixAverage", "X(input Size)", "Y(Time Consumed)",
				plot, PlotOrientation.VERTICAL, true, true, false);

		final ChartPanel cp = new ChartPanel(chart);
		cp.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(cp);

	}

}
