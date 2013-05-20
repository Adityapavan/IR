import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MaxOccurence{
	public static void main(String[] argv) throws IOException{
		InputStream    fis;
		BufferedReader br;
		fis = new FileInputStream("/home/santoshkosgi/Downloads/nlp/out4/1.txt");
		br = new BufferedReader(new InputStreamReader(fis));
		Writer output;
		output = new BufferedWriter(new FileWriter("/home/santoshkosgi/Downloads/nlp/out4/max.txt", true));
		String line;
		while((line = br.readLine())!=null){
			double y = Double.parseDouble(line.split("\\|")[1].split("@")[0])+Double.parseDouble(line.split("\\|")[1].split("@")[1]);;
			//double y = Double.parseDouble(line.split("\\|")[1]);
			if(y>(double)1){
				output.write(line.split("\\|")[0]+"\n");
			}
		}
		br.close();
		output.close();
	}
}