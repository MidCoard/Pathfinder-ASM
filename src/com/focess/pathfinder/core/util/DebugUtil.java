package com.focess.pathfinder.core.util;

public class DebugUtil {
	private static boolean debug=true;
	
	public static void log(Object obj) {
		if(debug)
			System.out.println(obj);
	}

}
