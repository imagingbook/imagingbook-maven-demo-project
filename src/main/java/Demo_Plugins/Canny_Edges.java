/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 *  image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2020 Wilhelm Burger, Mark J. Burge. All rights reserved. 
 * Visit http://imagingbook.com for additional details.
 *******************************************************************************/
package Demo_Plugins;


import static imagingbook.common.ij.DialogUtils.addToDialog;
import static imagingbook.common.ij.DialogUtils.getFromDialog;

import java.util.List;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import imagingbook.common.edges.CannyEdgeDetector;
import imagingbook.common.edges.EdgeTrace;

/**
 * This plugin implements the Canny edge detector for all types of images.
 * This is a renamed duplicate of {@link Color_Edges.Color_Edges_Canny}.
 * @author W. Burger
 * @version 2021/11/26
 * @version 2022/03/22 revised dialog
 */
public class Canny_Edges implements PlugInFilter {
	
	static boolean showEdgeMagnitude = true;
	static boolean showEdgeOrientation = true;
	static boolean showBinaryEdges = true;
	static boolean listEdgeTraces = false;
	
	ImagePlus imp = null;
	
	public int setup(String arg0, ImagePlus imp) {
		this.imp = imp;
		return DOES_ALL + NO_CHANGES;
	}

	public void run(ImageProcessor ip) {
		
		CannyEdgeDetector.Parameters params = new CannyEdgeDetector.Parameters();
		if (!runDialog(params)) return;
		
		CannyEdgeDetector detector = new CannyEdgeDetector(ip, params);
		
		if (showEdgeMagnitude) {
			ImageProcessor eMag = detector.getEdgeMagnitude();
			(new ImagePlus("Canny Edge Magnitude sigma=" + params.gSigma, eMag)).show();
		}
		
		if (showEdgeOrientation) {
			ImageProcessor eOrt = detector.getEdgeOrientation();
			(new ImagePlus("Canny Edge Orientation sigma=" + params.gSigma, eOrt)).show();
		}
		
		if (showBinaryEdges) {
			ImageProcessor eBin = detector.getEdgeBinary();
			(new ImagePlus("Canny Binary Edges sigma=" + params.gSigma, eBin)).show();
		}
		
		if(listEdgeTraces) {
			List<EdgeTrace> edgeTraces = detector.getEdgeTraces();
			IJ.log("number of edge traces: " + edgeTraces.size());
			int i = 0;
			for (EdgeTrace et : edgeTraces) {
				IJ.log(i + ". " + et.toString());
				i++;
			}
		}
	}

	private boolean runDialog(CannyEdgeDetector.Parameters params) {
		GenericDialog gd = new GenericDialog(this.getClass().getSimpleName());
		// Canny parameters:
		addToDialog(params, gd);
		// plugin parameters:
		gd.addMessage("Plugin parameters:");
		gd.addCheckbox("Show edge magnitude", showEdgeMagnitude);
		gd.addCheckbox("Show edge orientation", showEdgeOrientation); 
		gd.addCheckbox("Show binary edges", showBinaryEdges);
		gd.addCheckbox("List edge traces", listEdgeTraces);
		// display dialog
		gd.showDialog();
		if (gd.wasCanceled()) {
			return false;
		}	
		// update Canny parameters:
		getFromDialog(params, gd);
		if (params.gSigma < 0.5f) params.gSigma = 0.5f;
		if (params.gSigma > 20) params.gSigma = 20;
		
		// update plugin parameters:
		showEdgeMagnitude = gd.getNextBoolean();
		showEdgeOrientation = gd.getNextBoolean();
		showBinaryEdges = gd.getNextBoolean();
		listEdgeTraces = gd.getNextBoolean();
		return true;
	}
	
}
