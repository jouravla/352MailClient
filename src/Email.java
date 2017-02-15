
public class Email {
	public String sender;
	public String recipient;
	public String subject;
	public String message;
	
	public Email(String to, String from, String sub, String mes){
		sender = to;
		recipient = from;
		subject = sub;
		message = mes;
	}
	
	//have to check if sender/recipient is valid
	//need to screen message for escapes
}
