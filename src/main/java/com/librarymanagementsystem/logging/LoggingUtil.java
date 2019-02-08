package com.librarymanagementsystem.logging;

import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * The LoggingUtil class provides the logger utility operations.
 * 
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 */

public class LoggingUtil {

	private static String fileName = "logging.properties";

	public static boolean configure() throws Exception {
		return configure(fileName);
	}

	public static boolean configure(String fileName) throws Exception {
		
		boolean configured = false;
		InputStream inputStream = null;
		
		try {
			inputStream = LoggingUtil.class.getClassLoader().getResourceAsStream(fileName);

			if (inputStream == null) {
				throw new Exception("LoggingUtil: Unable to configure logger");
			}
			
			LogManager.getLogManager().readConfiguration(inputStream);
			configured = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return configured;
	}
}
