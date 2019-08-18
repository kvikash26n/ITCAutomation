/**
 * 
 */
package Test;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author 29265
 *
 */
public class BasicWebCrawler {

	static private HashSet<String> links;

	public BasicWebCrawler() {
		links = new HashSet<String>();
	}

	public void getPageLinks(String URL) {
		// 4. Check if you have already crawled the URLs
		// (we are intentionally not checking for duplicate content in this example)
		if (!links.contains(URL)) {
			try {
				// 4. (i) If not add it to the index
				if (links.add(URL)) {
					// System.out.println(URL);
				}
				// 2. Fetch the HTML code
				Document document = Jsoup.connect(URL).get();
				// 3. Parse the HTML to extract links to other URLs
				Elements linksOnPage = document.select("a[href]");
				// 5. For each extracted URL... go back to Step 4.
				for (Element page : linksOnPage) {
					String lurl = page.attr("abs:href");
					System.out.println(lurl); // facebook https blog.google mailto
					if (!lurl.contains("mailto") && !lurl.contains("apple.com") && !lurl.contains("blog.google")
							&& !lurl.contains("play") && !lurl.contains("google") && !lurl.contains("facebook")
							&& !lurl.contains("twitter") && !lurl.contains("youtube.com") && !lurl.contains("instagram")
							&& lurl.contains("https")) {
						getPageLinks(page.attr("abs:href"));
					}
				}
			} catch (IOException e) {
				System.err.println("For '" + URL + "': " + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// 1. Pick a URL from the frontier http://newtours.demoaut.com/
		// http://www.mkyong.com/
		new BasicWebCrawler().getPageLinks("https://www.spicejet.com/");
		System.out.println("Total URL is : "+links.size());
	}
}