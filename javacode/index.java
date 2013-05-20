import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class index {
	static Hashtable<String,Integer> returnhashtable1=new Hashtable<String, Integer>(100000,0.75f);
	static TreeMap<String,ArrayList<Double>> main = new TreeMap<String,ArrayList<Double>>();
	static String name;
	static int file_namyarrayme=0;
	static int file_name1=0;
	//print start
	public static void print(){
		  File file = new File("/home/santoshkosgi/Downloads/nlp/out4/"+Integer.toString(++file_name)+".txt");
		  File file1 = new File("/home/santoshkosgi/Downloads/nlp/out5/"+Integer.toString(++file_name1)+".txt");
	      try {
	    	  BufferedWriter outer = new BufferedWriter(new FileWriter(file));
	    	  BufferedWriter outer1 = new BufferedWriter(new FileWriter(file1));
		      String key;
		      for(Entry<String, ArrayList<Double>> entry : main.entrySet()) {
		    	  key=entry.getKey();
		          //out1.write();
		    	  double l = entry.getValue().get(0)+entry.getValue().get(1);
		          StringBuffer data = new StringBuffer(key+"|"+entry.getValue().get(0)+"@"+entry.getValue().get(1)+"\n");
		          StringBuffer data1 = new StringBuffer(key+"|"+l+"\n");
		          // write it to file 
		          outer.write(data.toString()); 
		          outer1.write(data1.toString());
		      }

	      outer.flush(); 
	      outer1.flush(); 
	      outer.close(); 
	      outer1.close(); 
	      main.clear();
	     
	      } catch (Exception e) { 
	      e.printStackTrace(); 
	      }
	  }
	//print end
	public static void main(String argv[]) {
 
    try {
 
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
		if (qName.equalsIgnoreCase("conversation")) {
			tokenizer t1 = new tokenizer();
			
			returnhashtable1 = t1.tokenize(content);
			//System.out.println(returnhashtable1.get("car"));
			ArrayList<Double> temp_secondary= new ArrayList<Double>();
			ArrayList<Double> temp_secondary1= new ArrayList<Double>();
			content = "";
			Set<String> set=new HashSet<String>();
			set.addAll(returnhashtable1.keySet());
			String[] title = name.split("[_.]");print();
			if(title[title.length-2].compareToIgnoreCase("MALE") ==0){
			for (String s: set){
					if(main.containsKey(s)){
						temp_secondary = main.get(s);
						temp_secondary1.add(temp_secondary.get(0)+((double)returnhashtable1.get(s)/(double)returnhashtable1.get("---")));
						temp_secondary1.add(temp_secondary.get(1));
						main.put(s, new ArrayList<Double>(temp_secondary1));
						temp_secondary1.clear();
						temp_secondary.clear();
					}
					else{
						temp_secondary1.add((double)returnhashtable1.get(s)/(double)returprint();nhashtable1.get("---"));
						temp_secondary1.add((double)0);
						main.put(s, new ArrayList<Double>(temp_secondary1));
						temp_secondary1.clear();
						temp_secondary.clear();
					}
				}
			}
				else{
					for (String s: set){
					if(main.containsKey(s)){
						temp_secondary = main.get(s);
						temp_secondary1.add(temp_secondary.get(0));
						temp_secondary1.add((double)temp_secondary.get(1)+((double)returnhashtable1.get(s)/(double)returnhashtable1.get("---")));
						main.put(s, new ArrayList<Double>(temp_secondary1));
						temp_secondary1.clear();
						temp_secondary.clear();
					}print();
					else{
						temp_secondary1.add((double)0);
						temp_secondary1.add((double)returnhashtable1.get(s)/(double)returnhashtable1.get("---"));
						main.put(s, new ArrayList<Double>(temp_secondary1));
						temp_secondary1.clear();
						temp_secondary.clear();
					}
				}
				
				
			}
			bconverse = false;print();
		}
 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException {
 
		if (bconverse) {
			content += new String(ch, start, length);print();
		}
 
	}
     };
     File directory = new File("/home/santoshkosgi/Downloads/pan_author_profiling_training_data/en/");      
     File[] myarray;  
     myarray=new File[10];
     myarray=directory.listFiles();
     for (int j = 1; j <= myarray.length; j++)
     {
    	 System.out.println(j);
            if(j%10000 == 0){
            	print();
            }
    	 	File path=myarray[j-1];
            name = path.getName();
            saxParser.parse(path, handler);
     }
     print();
     } catch (Exception e) {
       e.printStackTrace();
     }
   }
 
}