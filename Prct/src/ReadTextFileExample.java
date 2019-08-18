import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple example program that reads a text file line by line using Files.readAllLines.
 */
public class ReadTextFileExample {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\29265\\Desktop\\fname.txt"));
        System.out.println(lines.size());
        System.out.println(lines.get(2));
        for (String line : lines) {
            System.out.println(line);
        }
        
        List<String> passinput=new ArrayList<>();

		for (int j = 0; j < 2; j++) {
			passinput.add(lines.get(j));
			
			
		}
		System.out.println(passinput);
		System.err.println(passinput);
	
}
}