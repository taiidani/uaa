class LatLong {

	public static void main(String[] args) {
		//Take a given latitude or longitude in decimal format
		double input = 61.190758;

		//Grab the degrees component by casting to an integer (truncation)
		int degrees = (int)input;

		//Use a temporary variable to grab the decimal component of the coordinate
		//Multiply by 60 to get the minutes
		double tmp = (input % 1) * 60;

		//Cast the minutes to an integer, truncating the decimal component
		//The decimal component will end up being the seconds
		int minutes = (int)tmp;

		//Use the temporary variable again to find the seconds using the same method as the minutes
		double seconds = (tmp % 1) * 60;

		//Print the results to the screen
		System.out.println(degrees + ", " + minutes + ", " + seconds);

		//Print out the result of converting back to decimal degrees.
		//Note the cast to double where two integers were being divided
		double decDegrees = degrees + (double)minutes / 60 + seconds / 3600;
		System.out.println(decDegrees);
	}
}