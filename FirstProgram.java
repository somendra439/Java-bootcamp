

/*
 1. Data Types
    char
	int
	float
	string
	Byte
	Short

 2. Variables
    
 */





public class FirstProgram
{
	@SuppressWarnings("unused")
	public static void main(String args[])
{
		System.out.println(" this is my first program ");
		String collegeName = "Suresh gyan vihar university";
		// alpha numeric
		String address = "123, jagatpura, jaipur, rajasthan";
		int age = 32;
		float perc = 98.79F;
		float f1 = 10;
		double value = 1.50;
		String productName = "motorola G85";
		double productPrice =16999;
		float productRating = 4.5F;
		double productMRP = 20999;
		System.out.println(" product name = "+productName); //static
        testVariableTypes();
}
public static void testVariableTypes()
{
	System.out.println(" inside test variable type method ");
            String productName = "iphone 16";
	System.out.println(" product name = "+productName); //local
}
public static void testConditionStatement()
{
	System.out.println(" inside test variable type method ");
	int a = 10;
	int b = 4;
	int c = 6;
	if (a <= 10) //condition/boolean
	{
		System.out.println("a is greater");
	}
	else if(b>c)
	{
		System.out.println("b is greater");
	}
	else
	{
		System.out.println("c is greater");
	}
}
}

