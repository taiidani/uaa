package stringreversal;

public class StringReversal {

    public static void main(String args) {
	
	String str = "Hello World";
	String reversed = "";
	
	//The iterative approach
	for(int cnt = str.length() - 1; cnt >= 0; cnt--) {
	    reversed += str.charAt(cnt);
	}
	
	System.out.println(reversed);
	
	//The recursive approach
	reversed = stringReverse(str);
	
	
	
    }
    
    public static String stringReverse(String str) {
	return stringReverse(str, 0);
    }
    
    public static String stringReverse(String str, int position) {
	if(position == str.length()) {
	    return "";
	}
	
	return stringReverse(str, position + 1) + str.charAt(position);
    }
}
