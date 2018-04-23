
public class StringReverse {
	
	// Method - 1
	public void ReverseWithIteration(String str) {
		for(int i = str.length();i>0;i--) {
			System.out.print((str.charAt(i-1)));
		}
	}
	
	
	// Method - 2
	public String ReverseWithRecurssion(String str) {
		
		if(str == null || str.length() == 1 ) return str;
		else return ReverseWithRecurssion(str.substring(1))+str.charAt(0);
	}
	
	// Method - 3 is with use of StringBuffer
	
	public static void main(String[] args) {
		
		StringReverse a = new StringReverse();
		a.ReverseWithIteration("Manoj");
		System.out.println(a.ReverseWithRecurssion("Manoj"));
		 
		
	}

}
