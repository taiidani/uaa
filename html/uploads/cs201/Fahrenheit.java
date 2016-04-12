class Fahrenheit {
	
	public static void main(String[] args) {
		int fahrenheit = 32;
		int celcius = (fahrenheit - 32) * 5 / 9;
		System.out.println("Incorrect result: " + celcius);

		int fah = 32;
		double cel = ((double)fah - 32) * 5 / 9;

		System.out.println("Correct Result: " + cel);
	}
}