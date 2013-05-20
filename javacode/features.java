import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class features {
	static Hashtable<String,Integer> returnhashtable1=new Hashtable<String, Integer>(100000,0.75f);
	static String name;
	static int file_name=0;
	static int file_name1=0;
	static ArrayList<String> words = new ArrayList<String>();
	static int filename=0;
	
	public static void print(String s) throws IOException{
		File file = new File("/home/santoshkosgi/Downloads/nlp/features/"+filename+++".csv");
		BufferedWriter outer1 = new BufferedWriter(new FileWriter(file));
		outer1.write(s);
		outer1.close();
	}

	public static void main(String argv[]) {
 
    try {
    	InputStream    fis;
		BufferedReader br;
		fis = new FileInputStream("/home/santoshkosgi/Downloads/nlp/out4/max.txt");
		br = new BufferedReader(new InputStreamReader(fis));
		String line;
		while((line = br.readLine())!=null){
			words.add(line);
		}
		
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
	
	DefaultHandler handler = new DefaultHandler() {
	boolean bconverse = false;
	String content;
	
	
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("conversation")) {
			bconverse = true;
		}
 
 
	}
 
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
		if (qName.equalsIgnoreCase("conversations")) {
			
			
		}
		if (qName.equalsIgnoreCase("conversation")) {
			bconverse = false;
		}
 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException {
 
		if (bconverse) {
			content = content+" "+new String(ch, start, length);
		}
 
	}
     };
     //File directory = new File("/home/santoshkosgi/Downloads/nlp/data/");
     File directory = new File("/home/santoshkosgi/Downloads/pan_author_profiling_training_data/en/");
     File[] myarray;  
     myarray=new File[10];
     myarray=directory.listFiles();
     for (int j = 1; j <= myarray.length; j++)
     {
    	 System.out.println(j);
	 	 File path=myarray[j-1];
         name = path.getName();
         saxParser.parse(path, handler);
     }
     
     br.close();
     } catch (Exception e) {
       e.printStackTrace();
     }
    
   }

}