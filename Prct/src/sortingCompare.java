import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class sortingCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Integer>sort=new ArrayList();
		sort.add(12);
		sort.add(13);
		sort.add(14);
		sort.add(15);
		System.out.println(sort);
		for(int i=0;i<sort.size();i++) {
			for (int j = i+1; j < sort.size(); j++) {
				sort.get(i).toString();
				if(sort.get(i)<sort.get(j)) {
					System.out.println("sorted");
				}else {
					System.out.println("error");
				}
			}
		}
		

	}

}
