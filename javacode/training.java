import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class training{
	public static void main(String[] args) throws IOException{
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> w = new ArrayList<Double>();
		ArrayList<Double> wp = new ArrayList<Double>();
		ArrayList<Double> wm = new ArrayList<Double>();
		ArrayList<String> words = new ArrayList<String>();
		InputStream    fis;
		BufferedReader br;
		fis = new FileInputStream("/home/santoshkosgi/Downloads/nlp/out4/max.txt");
		br = new BufferedReader(new InputStreamReader(fis));
		String line;
		while((line = br.readLine())!=null){
			words.add(line);
			x.add((double)0);
			w.add((double)0);
			wp.add((double)1);
			wm.add((double)-1);
		}
		
		
		br.close();
 		}
}



