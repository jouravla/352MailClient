
public class Email {
	public String sender;
	public String recipient;
	public String subject;
	public String message;
	
	public Email(String to, String from, String sub, String mes){
		//trim any problematic whitespace in the emails
		sender = to.trim();
		recipient = from.trim();
		subject = sub;
		message = mes;
	}
}
