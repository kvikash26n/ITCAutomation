/**

 * 
 */
package Splash;

import org.apache.poi.ss.util.SSCellRange;

/**
 * @author 29265
 *
 */
public class javadoc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
splash splash1=new splash();
splash1.setVisible(true);
try {
	for(int i=0;i<30;i++) {
		Thread.sleep(40);
		//splash1.lblNewLabel.s
		home hh=new home();
		if(i==20) {
			splash1.dispose();
			hh.show();
		}
	}
}catch (Exception e) {
	// TODO: handle exception
}
	}

}
