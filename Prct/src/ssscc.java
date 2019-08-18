

public class ssscc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String price1="1,234.00";
		   price1 = price1.indexOf(".") < 0 ? price1 : price1.replaceAll("0*$", "").replaceAll("\\.$", "");
		  // float price1_1 = Float.parseFloat(price1);
		   String newStr = price1.replaceAll(",", "");
		   int price1_1 = Integer.parseInt(newStr);	
		   System.out.println(price1_1);
	}

}
