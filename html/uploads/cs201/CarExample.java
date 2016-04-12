class CarExample {

	//This is a class-level variable
	public static int numOfParts;

	public static void main(String[] args) {
		//Method-level variables
		int year = 2004;
		char color = 'B';
		int miles = 250;
		int gallons = 15;

		//Calculation from multiple variables. Beware the / operator between two integers
		double mpg = miles / (double)gallons;

		System.out.println("This vehicle was made in the year " + year);
		System.out.println("The vehicle's color is " + color);
		System.out.println("The most recent miles per gallon estimate is " + (int)mpg + "mpg");

		//Road trip
		miles += 50;

		//Extra large gas tank
		gallons++;

		//Reassigning mpg with the new mileage
		mpg = miles / (double)gallons;

		//Rounding the miles per gallon to the nearest integer
		mpg = Math.round(mpg);

		System.out.println("Miles per gallon after a road trip (no gas stations): " + mpg);
	}
}