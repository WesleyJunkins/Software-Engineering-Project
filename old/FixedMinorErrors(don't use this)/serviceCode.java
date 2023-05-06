package ChocAn;

public class serviceCode {
	
	int code;				// service code
	String serviceName;		// corresponding service name
	
	int getCode() {						// get code
		return code;
	}
	
	String getName() {					// get name
		return serviceName;
	}
	
	String checkCode(int inCode) {		// input code, if =serviceCode, return service name, else NULL
		if (inCode == code) {
			return serviceName;
		}
		else return null;
	}
	
}
