/*
 * class to store & organize service codes for provider access
 * written by Campbell Thompson
 */

package ChocAn;

import java.util.Vector;

public class ProviderDirectory {
	
	//variables
	Vector<Service> directory;
	
	//constructor
	public ProviderDirectory(Vector<Service> d) {
		directory = d;
	}
	
	//default
	public ProviderDirectory() {
		directory = new Vector<Service>();
	}
	
	//adder
	public void add(Service s) {
		directory.add(s);
	}
	
	//search functions
	public int searchByName(String serviceName) {
		for (Service s : directory) {
			if (s.getName().toLowerCase().equals(serviceName.toLowerCase()))
				return s.getCode();
		}
		//if name not found
		return -1;
	}
	
	//might not be needed, here just in case
	public String searchByCode(int code) {
		for (Service s : directory) {
			if (s.getCode() == code)
				return s.getName();
		}
		//if name not found
		return "";
	}
	
}