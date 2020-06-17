import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

import java.io.IOException;

public class JsoupCrawler {  //main class
    public static void main(String[] args) throws IOException { //main class must throw checked exception
        final String url = "https://hamrobazaar.com"; //name of the site which we are scraping
        Document document = Jsoup.connect(url).get(); // Loading the webpage and storing it in a Document variable document
        String title = document.title(); //fetching the document title
        System.out.println("Title is "+title+"\n"); //Title of the web page is displayed here

        Elements links = document.select("a[href]"); //for displaying the links

        for (Element link: links){ //enhanced for loop
            System.out.println("\n Link "+ link.attr("href")); //prints the link
            System.out.println("text "+ link.text()+"\n"); //prints the text associated with the link
        }

        System.out.println("Categories");

        //Now creating ArrayList and adding the categories in ArrayList Creating the generic arraylist

        //Getting the categories from the site and storing it in a ArrayList
        for(Element table: document.select("#tab_cat1")){ //All the categories reside in this id
            Elements tds = table.getElementsByTag("b"); //Finding the elements by  tagName b because categories are stored in it
            ArrayList<String> items = new ArrayList<String>();   //Now creating ArrayList and adding the categories in ArrayList Creating the generic arraylist
            for(Element td : tds){ //for-each loop
                String s = td.text(); //in text, similar as toString()
                items.add(s); // adding items in a arraylist
            }

            for(int i = 0; i < items.size(); i++ ){ //for loop
                System.out.println(items.get(i)); //printing the items
            }
        }
        
    }
}
