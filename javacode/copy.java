import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class copy {

	public static void main(String[] argv) throws IOException {
		File folder = new File("en/");
		File f[]=folder.listFiles();
		File afile=folder.listFiles()[0];
		for(int i = 0; i<200000;i++){
			System.out.println(i);
			afile= f[i];
			String bfile="ens/"+afile.getName();
			FileInputStream inStream = new FileInputStream(afile);
			FileOutputStream outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			//copy the file content in bytes 
			while ((length = inStream.read(buffer)) > 0){

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();
		}
	}
}
