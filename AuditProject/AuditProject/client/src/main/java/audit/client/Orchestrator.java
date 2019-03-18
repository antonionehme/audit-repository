package audit.client;

import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Orchestrator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		switchOptions();
	}

	 public static void switchOptions() throws Exception { Scanner scan=new Scanner(System.in);
	    System.out.println("0 to Add Address, 1 to VerifyServer, 2 to see last reported record on the audit server, 3 to Publish a message, 4 Send a message to another recipient, X to exit.");
	    	String option=scan.nextLine();
	    	while(option!="X") {
	        switch(option) { case "test2": {
	        	System.out.println("0 to Add Address, 1 to VerifyServer, 2 to see last reported record on the audit server, 3 to Publish a message, 4 Send a message to another recipient, 5 to Override Recipient Port, X to exit.");
	        	 RestTemplate restTemplate = new RestTemplate();
	        	//String http://localhost:8101/participant/call
	              /*restTemplate.postForLocation(url, request);
	               restTemplate.postForLocation("http://localhost:8101/participant/call", message);
	               */
	        	 
	        	 HttpHeaders headers = new HttpHeaders();
	        	 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	        	 MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
	        	 map.add("port", "8104");
	        	 map.add("first", "true");
	        	 

	        	 HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

	        	 ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8103/participant/call", request , String.class );
	        	option=scan.nextLine();
	        }break;
	        
	        default :{
	           System.out.println("Invalid Option");
	           option=scan.nextLine();}
	     }
	    	}
	
}
}
