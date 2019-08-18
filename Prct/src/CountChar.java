/**
 * 
 */

/**
 * @author 29265
 *
 */
public class CountChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counta=0;
		int countb=0;
		int countc=0;
		String aString="aabbccc";
		char [] am=aString.toCharArray();
		for(int i=0;i<am.length;i++) {
			//System.out.println(am[i]);
				if(am[i]=='a') {
					 counta=counta+1;
		}else if (am[i]=='b') {
			 countb=countb+1;
		}
				else if (am[i]=='c') {
					countc=countc+1;
				}
		

	}System.out.println("c:"+countc);System.out.println("b:"+countb);System.out.println("a:"+counta);
	

}
}
