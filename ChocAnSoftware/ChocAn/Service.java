package ChocAn;

public class Service 
{
	private String name; // Name of the service
	private int codeNum;  // Code associated with the service
	
	/*Constructor for the Service class
	 * newName initializes the name value
	 * codeNum initializes the codeNum value
	 * */
	public Service(String newName, int newNum)
	{
		name = newName;
		codeNum = newNum;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCode()
	{
		return codeNum;
	}
}
