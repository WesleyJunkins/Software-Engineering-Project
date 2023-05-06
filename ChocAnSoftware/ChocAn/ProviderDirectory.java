/**
 * class to store & organize service codes for provider access
 * @author Campbell Thompson
 */

package ChocAn;

import java.util.Vector;

public class ProviderDirectory {
	
	//variables
	Vector<Service> directory;
	
	/**
	 * constructor
	 * can intialize directory with a predetermined vector
	 */
	public ProviderDirectory(Vector<Service> d) {
		directory = d;
	}
	
	/**
	 * default constructor
	 * sets directory to empty vector
	 */
	public ProviderDirectory() {
		directory = new Vector<Service>();
	}
	
	/**
	 * adds Service to the directory
	 */
	public void add(Service s) {
		directory.add(s);
	}
	
	/**
	 * finds a service from a string name
	 * returns the int service code
	 */
	public int searchByName(String serviceName) {
		for (Service s : directory) {
			if (s.getName().toLowerCase().equals(serviceName.toLowerCase()))
				return s.getCode();
		}
		//if name not found
		return -1;
	}
	
	/**
	 * finds a service from an int service code
	 * returns the string service name
	 */
	public String searchByCode(int code) {
		for (Service s : directory) {
			if (s.getCode() == code)
				return s.getName();
		}
		//if name not found
		return "";
	}
	
	/**
	 * returns full service object from input service code
	 */
	public Service searchByCodeGetFullService(int code) {
		for (Service s : directory) {
			if (s.getCode() == code)
				return s;
		}
		//if name not found
		return null;
	}
	
	/**
	 * prints all stored service names & corresponding codes
	 */
	public void printProviderDirectory() {
		int i = 0;
		for (Service s : directory) {
			i++;
			System.out.println(i + ". " + s.getName() + " || " + s.getCode());
		}
	}
	
}