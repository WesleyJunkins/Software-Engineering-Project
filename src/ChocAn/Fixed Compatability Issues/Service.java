//Nicholas Seidl
package ChocAn;

/**
 * The Service Class. This class stores the name and a code for a single service.
 * @author Nicholas Seidl
 *
 */

public class Service 
{
	/**
	 * Contains the name of the service
	 */
	private String name;
	/**
	 * Contains the code number for the service
	 */
	private int codeNum; 
	
	/**
	 * Constructor for the service class
	 * @param newName the name of the service
	 * @param newNum the code number of the service
	 */
	public Service(String newName, int newNum)
	{
		name = newName;
		codeNum = newNum;
	}
	
	/**
	 * Returns the name of the service
	 * @return the name of the service
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the code number of the service
	 * @return the code number of the service
	 */
	public int getCode()
	{
		return codeNum;
	}
}
