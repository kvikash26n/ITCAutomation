package Test;

import java.util.ArrayList;
import java.util.List;

public class addstring {
	public static void main(String ag[])
	{
		List list=new ArrayList();
		list.add(1);
		list.add("abcd");
		//list.addAll();
		//System.err.println(list);
	System.out.println(list);
		
		if (list != null)
		{
		    String listString = list.toString();
		    listString = listString.substring(1, listString.length() - 1);
		    System.out.println(listString);
		}
		
		List ll=new ArrayList();
		List ll2=new ArrayList();
		ll.add(23);
		ll.add(23);
		ll.add(24);
		ll.add(24);
		ll.add(25);
	int orisize=	ll.size();
		for(int i =0;i<ll.size();i++) {
			int temp=(int) ll.get(i);
			ll2.add(temp);
			for(int j=0;j<ll.size();j++) {
				int val=(int)ll.get(j);
				if(temp!=val)
				{
					ll2.add(val);
				}
			}
			int size=ll2.size();
			
			
		}
		
		
		
	}

}
