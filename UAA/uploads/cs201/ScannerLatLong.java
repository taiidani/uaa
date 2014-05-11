import java.util.Scanner;

class ScannerLatLong {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Take a given latitude or longitude in decimal format
		System.out.print("Please enter a coordinate: ");
		double input = input.nextDouble();

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
		System.out.printf("Degrees: %d, Minutes: %d, Seconds: %6.2f", degrees, minutes, seconds);
	}
}