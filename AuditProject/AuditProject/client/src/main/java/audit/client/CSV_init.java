package audit.client;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_init {
public static void main (String args[]) throws IOException {
	String file_send = "data_send.csv";String file_recieve = "data_recieve.csv";
	String FILE_HEADER_send = "Participant,Time to Send"+"\n"; String FILE_HEADER_recieve = "Participant,Time to Recieve"+"\n";
	FileWriter fileWriter_send = new FileWriter(file_send); FileWriter fileWriter_recieve = new FileWriter(file_recieve);
	 
    //Write the CSV file header
	fileWriter_send.append(FILE_HEADER_send.toString()); fileWriter_recieve.append(FILE_HEADER_recieve.toString()); 
	//fileWriter.append("1,Antonio"+"\n");
	
	fileWriter_send.flush(); fileWriter_recieve.flush();
	fileWriter_send.flush(); fileWriter_recieve.close();


}

}