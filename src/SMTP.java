import java.io.*;
import java.net.*;

/**
 * This is an SMTP that utilizes TCP elements.
 * @author Sasha Jouravlev
 */
class SMTP {
	private Socket clientSocket;

	private BufferedReader inFromServer;
	private DataOutputStream outToServer;

	private static final int PORT = 778;
	private static final String carRet = "\r\n";

	//TODO: implement specialized errors at each stage of the process (out of scope for this HW)
	public SMTP(Email email)throws Exception{
		//Establish a TCP connection with the mail server.
		clientSocket = new Socket("172.16.223.21", PORT);
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		//Read greeting from the server.
		System.out.println(inFromServer.readLine());

		System.out.print("HELO" + carRet);
		//Send HELO command and get server response.
		outToServer.writeBytes("HELO" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("AUTH LOGIN" + carRet);
		//Send AUTH LOGIN command and get server response.
		outToServer.writeBytes("AUTH LOGIN" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("am91cmF2bGE=" + carRet);
		//Send encoded Username and get server response.
		outToServer.writeBytes("am91cmF2bGE=" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("c2FzaGFKMTI=" + carRet);
		//Send encoded password and get server response.
		outToServer.writeBytes("c2FzaGFKMTI=" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("MAIL FROM:<" + email.sender + ">" + carRet);
		//Send MAIL FROM command and get server response.
		outToServer.writeBytes("MAIL FROM:<" + email.sender + ">" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("RCPT TO:<" +email.recipient + ">" + carRet);
		//Send RCPT TO command and get server response. 
		outToServer.writeBytes("RCPT TO:<" +email.recipient + ">" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("DATA" + carRet);
		//Send DATA command and get server response. 
		outToServer.writeBytes("DATA" + carRet);
		System.out.println(inFromServer.readLine());

		System.out.print("SUBJECT:" + email.subject + carRet + "\n");
		//Send subject data (server will not respond to this) 
		outToServer.writeBytes("SUBJECT:" + email.subject + carRet + "\n");
		
		System.out.print(email.message + carRet);
		//Send subject data (server will not respond to this) 
		outToServer.writeBytes(email.message + carRet);
		
		System.out.print("." + carRet);
		//End with a line containing a single period and get server response.
		outToServer.writeBytes("." + carRet);
		System.out.println(inFromServer.readLine());
		
		System.out.print("QUIT" + carRet);
		//Send QUIT command and get server response.
		outToServer.writeBytes("QUIT" + carRet);
		System.out.println(inFromServer.readLine());
		
		outToServer.close();
		inFromServer.close();
		clientSocket.close();
	}
}