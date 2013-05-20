import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MergeFeatures{
	public static void main(String[] arg) throws IOException{
		InputStream    fis;
		BufferedReader br;
			File folder = new File("/home/santoshkosgi/Downloads/nlp/features/");
			File[] listOfFiles = folder.listFiles(); 
			//System.out.println(listOfFiles.length);
			Writer output;
			output = new BufferedWriter(new FileWriter("/home/santoshkosgi/Downloads/nlp/features/0.csv", true));
			output.append("\n");
			for (int i = 1; i <listOfFiles.length; i=i+1) {
				System.out.println(i);
				fis = new FileInputStream("/home/santoshkosgi/Downloads/nlp/features/"+i+".csv");
				br = new BufferedReader(new InputStreamReader(fis));
				output.append(br.readLine()+"\n");
				File f1=new File("/home/santoshkosgi/Downloads/nlp/features/"+i+".csv");
				f1.delete();
				br.close();
				fis.close();
			}
			output.close();
	}
}