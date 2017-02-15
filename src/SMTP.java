import java.io.*;
import java.net.*;

/**
 * Code based off of TCPClient.java found on the course Moodle.
 * @author Sasha Jouravlev
 */
class SMTP {
	private Socket clientSocket;

	private BufferedReader inFromServer;
	private DataOutputStream outToServer;

	private static final int PORT = 778;

	public SMTP(Email email)throws Exception{
		clientSocket = new Socket("172.16.223.21", PORT);
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


		outToServer.writeBytes("telnet exmail.dickinson.edu " + PORT);
		
		//inFromUser will be the lines of the Email
		if(inFromServer.readLine().contains("220")){
			System.out.println("worked");
		}
		else{
			System.out.println("nope");
		}

		//outToServer.writeBytes(sentence + "\n");

		//modifiedSentence = inFromServer.readLine();
	}
}