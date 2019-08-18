package frameworkform;

public class removechar {

	public static void main(String[] args) {
		String yourString="2300 INR";
		yourString=yourString.replace("INR", "");
		//String result = yourString.replaceAll("[-+.^:,]","");
		System.out.println(yourString);
	}

}
