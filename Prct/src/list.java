import java.util.ArrayList;
import java.util.List;

public class list {
public static void main(String ag[])
{
	ArrayList <Integer> first = new ArrayList <Integer> ();
    ArrayList <Integer> second = new ArrayList <Integer> ();
    ArrayList <Integer> finalResult = new ArrayList <Integer> ();

    first.add(1);
    first.add(2);
    first.add(3);
    first.add(4);

    second.add(2);
    second.add(3);
    second.add(4);
    second.add(6);
    second.add(7);

    for (int i = 0; i < first.size(); i++){

        if (!second.contains(first.get(i))){

            finalResult.add(first.get(i));
        }
    }


    for (int j = 0; j < second.size(); j++){

        if (!first.contains(second.get(j))){

            finalResult.add(second.get(j));
        }

    }
    System.out.println(finalResult);
}
}
