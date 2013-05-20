import java.util.*;
public class tokenizer {
  public Hashtable<String, Integer> tokenize(String str){ 
	  Hashtable<String, Integer> stems = new Hashtable<String, Integer>();
	  try {
		  Stemmer s = new Stemmer();
	  str = str.toLowerCase();
	  str = str.replaceAll("(?i)(<a .*?>)(.+?)(</a>)"," ");
	  str = str.replaceAll("(?i)(<br />)"," ");
	  str=str.replaceAll("[^a-zA-Z]", " ");
	  str = str.replaceAll("\\s+", " ");
	  str = str.replaceAll("[^\\x00-\\x7F]", "");
	  StringTokenizer st = new  StringTokenizer(str, " ");
	  ArrayList<String> tokens = new ArrayList<String>();
	  while(st.hasMoreTokens()) { 
		  String key = st.nextToken();  
		  s.add(key.toCharArray(),key.length());
		  s.stem();
		  if(s.toString().length()>1){
			  if(s.toString().compareToIgnoreCase("NULL")!=0){
				  tokens.add(s.toString());
			  }
		  }
		  }
	// System.out.println(tokens);
	 stems.put("---", tokens.size());
	 for(int i=0;i<tokens.size();i++){
		 int k;
		 if(!stems.containsKey(tokens.get(i))){
			//s.add(tokens.get(i).toCharArray(),tokens.get(i).length());
		//	s.stem();
			//System.out.println(s.toString());
			stems.put(tokens.get(i),1);
		}
		else {
			k = stems.get(tokens.get(i));
			stems.remove(tokens.get(i));
			stems.put(tokens.get(i), ++k);
		}
	 }
	 //System.out.println(stems);
	  }
	  catch (Exception e){
	  }
	  return stems;
	 
	   
    }
}