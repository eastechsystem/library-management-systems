package pk.com.telenorbank.librarymanagementsystem.util;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import org.springframework.http.HttpStatus;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
final public class ResourcesUtil {

	private ResourcesUtil() {
	}

	/**
	 * @param status
	 * @return
	 */
	public static String getPopulatedResponseMessage(HttpStatus status) {
		JsonObjectBuilder responseJsonBuilder = Json.createObjectBuilder();
		
		responseJsonBuilder.add("statusCode", status.value());
		if (HttpStatus.CREATED.equals(status)) {
			responseJsonBuilder.add("status", Constant.SUCCESS);
			responseJsonBuilder.add("responseMessage", Constant.RECORD_CREATED_RESPONSE_SUCCESS_MESSAGE);
		} else if (HttpStatus.CONFLICT.equals(status)) {
			responseJsonBuilder.add("status", Constant.FAILURE);
			responseJsonBuilder.add("responseMessage", Constant.RECORD_CREATED_RESPONSE_SUCCESS_MESSAGE);
		} else if (HttpStatus.NOT_FOUND.equals(status)) {
			responseJsonBuilder.add("status", Constant.FAILURE);
			responseJsonBuilder.add("responseMessage", Constant.RECORD_NOT_CREATED_RESPONSE_FAILURE_MESSAGE);
		} else if (HttpStatus.OK.equals(status)){
			responseJsonBuilder.add("status", Constant.SUCCESS);
			responseJsonBuilder.add("responseMessage", Constant.RECORD_DELETED_RESPONSE_SUCCESS_MESSAGE);
		}

		return responseJsonBuilder.build().toString();
	}
}
