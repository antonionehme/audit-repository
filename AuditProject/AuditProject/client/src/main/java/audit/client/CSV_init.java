package audit.client;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_init {
public static void main (String args[]) throws IOException {
	String file = "data.csv";
	String FILE_HEADER = "id,firstName"+"\n";
	FileWriter fileWriter = new FileWriter(file);
	 
    //Write the CSV file header
	fileWriter.append(FILE_HEADER.toString());
	fileWriter.append("1,Antonio"+"\n");
	
	fileWriter.flush();
    fileWriter.close();


}

}