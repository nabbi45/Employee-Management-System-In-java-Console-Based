import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Scanner;
class Employee
{
	String firstName;
	String lastName;
	String post;
	int joiningYear;
	String department;
	String uniqueID;	
	long mobile;
	String email;
	static int id = 000;	//Static id so it will remain same and we can generate on the basis of this
	
	
	
	void addEmp()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee's first name");
		this.firstName = sc.nextLine();
		
		System.out.println("Enter employee's last name");
		this.lastName = sc.nextLine();
		
		try{
		System.out.println("Enter employee's year of joining");
		this.joiningYear = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Enter year only in numeric format");
			e.printStackTrace();
		}
		sc.nextLine();
		
		System.out.println("Enter employee's post ");
		this.post = sc.nextLine();
		
		System.out.println("Enter employee's Department ");
		this.department = sc.nextLine();
		
		try{
		System.out.println("Enter employee's Mobile number ");
		this.mobile = sc.nextLong();
		
		}
		catch(Exception e)
		{
			System.out.println("You have to Enter mobile in proper format");
			e.printStackTrace();
		}
		sc.nextLine();
		System.out.println("Enter employee's Email id ");
		this.email = sc.nextLine();
		
		File myObj = new File("./emp.txt");
		
		try 
		{
			
      		FileWriter myWriter = new FileWriter("emp.txt",true);
			myWriter.write(firstName+" "+lastName+","+post+","+joiningYear+","+department+
			","+uniqueID+","+mobile+","+email);
			/*myWriter.write(lastName);
			myWriter.write(post);
			myWriter.write(Integer.toString(joiningYear));
			myWriter.write(department);
			//myWriter.write(uniqueID);
			myWriter.write(Long.toString(mobile));
			myWriter.write(email);*/
      		myWriter.close();
      		
    	} 
		catch (IOException e) 
		{
     		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
		
	}

	void setEmployeeID()	//Generate Id = joiningYear+id
	{
		id++;
		this.uniqueID = joiningYear+""+id;	//"" will consider entire line as string
	}
	
	String showInfo()
	{
		return "Name : "+firstName+""+lastName+
						"\nUID : "+uniqueID+
						"\nYear Of Joining : "+joiningYear+
						"\nDepartment : "+department+
						"\nPost : "+post+
						"\nMobile : "+mobile+
						"\nEmail : "+email;
	}
	
	public static void main(String st[])
	{	Scanner sc = new Scanner(System.in);
		System.out.println("*******Employee Management System*******");
		System.out.println("Press 1 to Add Employee\nPress 2 to show employees \nPress 3 to delete\nPress 4 to exit\n");
		int c = sc.nextInt();
		
		switch(c)
		{
			case 1:
		
			System.out.println("Enter the number of emplloyee you want to add. ");

			int numOfEmployee = sc.nextInt();
			Employee[] employees = new Employee[numOfEmployee];	//Array of objects
		
			for(int n=0; n < numOfEmployee; n++)
			{
				employees[n] = new Employee();
				employees[n].addEmp();
				employees[n].setEmployeeID();
			
			}
			for(int n=0; n < numOfEmployee; n++)
			{
				System.out.println(employees[n].showInfo());
			}
			System.out.println("Above Employees added succesfully");
			break;
		
		
		/*System.out.println("Enter the number of emplloyee you want to add ");
		int numOfEmployee = sc.nextInt();
		Employee[] employees = new Employee[numOfEmployee];	//Array of objects
		
		for(int n=0; n < numOfEmployee; n++)
		{
			employees[n] = new Employee();
			employees[n].addEmp();
			employees[n].setEmployeeID();
			
		}*/
			case 2:
			{
				//for(int n=0; n < numOfEmployee; n++)
				
					try
					{
						File myObj = new File("./emp.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine())
						{
        					String data = myReader.nextLine();
        					System.out.println(data);
							//myReader.close();
      					}
					}
					catch (FileNotFoundException e)
					{
      					System.out.println("Please add employee data first. No employee found");
      					e.printStackTrace();
				
					}
					break;
			}
			case 3:
			{
				
    			File myObj = new File("./emp.txt"); 
    			if (myObj.delete()) 
      			{
					System.out.println("Succesfully Deleted");
				}
   				else
				{
      				System.out.println("Failed to delete the file.");
    			} 
				break;
  
			}
			case 4:
			{
				System.exit(0);
				break;
			}
			case 5:
			{
				System.out.println("Enter a valid choice");

			}
		}
	}
}