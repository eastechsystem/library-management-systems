package pk.com.telenorbank.librarymanagementsystem.util;

import org.omg.CORBA.portable.ApplicationException;

import com.librarymanagementsystem.logging.Level;
import com.librarymanagementsystem.logging.Logger;
import com.librarymanagementsystem.logging.LoggerImpl;

/**
 * This class provides the infrastructure layer services.
 * 
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 */
public final class Infrastructure {

	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(Infrastructure.class.getName());
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	/**
	 * Default private constructor.
	 */
	private Infrastructure() {

	}

	/**
	 * The getLogger() method returns the logger for a given name
	 * 
	 * @param name
	 *            specifies name of the logger
	 * @return the logger implementation
	 */
	public static Logger getLogger(String name) {
		return LoggerImpl.getLogger(name);
	}

	/**
	 * This method logs message at given level through given logger.
	 * 
	 * @param logger
	 *            Specifies logger object.
	 * @param level
	 *            Specifies level of log message.
	 * @param message
	 *            Specifies log message.
	 */
	public static void log(Logger logger, Level level, String message) {
		if (logger == null) {
			throw new RuntimeException("logger object cannot be null.");
		}

		logger.log(level, message);
	}

	/**
	 * This method logs message through given logger.
	 * 
	 * @param logger
	 *            Specifies logger object.
	 * @param message
	 *            Specifies log message.
	 */
	public static void log(Logger logger, String message) {
		if (logger == null) {
			throw new RuntimeException("logger object cannot be null.");
		}

		logger.log(message);
	}

	/**
	 * This method logs exception through given logger.
	 * 
	 * @param logger
	 *            Specifies logger object.
	 * @param exception
	 *            Specifies exception to be logged.
	 */
	public static void log(Logger logger, Exception exception) {
		if (logger == null) {
			throw new RuntimeException("logger object cannot be null.");
		}

		logger.log(exception);
	}
}
