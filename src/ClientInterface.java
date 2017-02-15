import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


/**
 *
 */
public class ClientInterface extends JFrame {

	private Label senderLabel = new Label("From:");
	private TextField sender = new TextField("", 20);
	private Label recipientLabel = new Label("To:"); 
	private TextField recipient = new TextField("", 20);
	private Label subjectLabel = new Label("Subject:");
	private TextField subject = new TextField("", 20);
	private Label messageLabel = new Label("Message:");
	private TextArea message = new TextArea(10, 40);

	private Button sendButton = new Button("Send");
	/**
	 * Create a new MailClient window with fields for entering all
	 * the relevant information (From, To, Subject, and message).
	 */
	public ClientInterface() {
		super("Java Mailclient");
		Panel mainPanel = new Panel();
		Panel fieldPanel = new Panel();
		Panel messagePanel = new Panel();
		GridLayout grid = new GridLayout(3,2);
		fieldPanel.setLayout(grid);
		fieldPanel.add(senderLabel);
		fieldPanel.add(sender);
		fieldPanel.add(recipientLabel);
		fieldPanel.add(recipient);
		fieldPanel.add(subjectLabel);
		fieldPanel.add(subject);
		messagePanel.add(messageLabel);
		messagePanel.add(message);
		mainPanel.add(sendButton);
		
		sendButton.addActionListener(new SendListener());
		
		add(fieldPanel, BorderLayout.NORTH);
		add(messagePanel, BorderLayout.CENTER);
		add(mainPanel,BorderLayout.SOUTH);
		pack();
		show();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class SendListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if((sender.getText()).equals("") || recipient.getText().equals("") || subject.getText().equals("")) {
				System.out.println("All fields must be filled out.");
				return;
			}
			
//			/* Create the message */
//			Message mailMessage = new Message(fromField.getText(), toField.getText(), subjectField.getText(), messageText.getText());
//
//			/* Check that the message is valid, i.e., sender and recipient addresses look ok. */
//			if(!mailMessage.isValid()) {
//				return;
//			}
//
//			/* Create the envelope, open the connection and try to send
//	       the message. */
//			try {
//				Envelope envelope = new Envelope(mailMessage, 
//						serverField.getText());
//			} catch (UnknownHostException e) {
//				/* If there is an error, do not go further */
//				return;
//			}
//			try {
//				SMTPConnection connection = new SMTPConnection(envelope);
//				connection.send(envelope);
//				connection.close();
//			} catch (IOException error) {
//				System.out.println("Sending failed: " + error);
//				return;
//			}
//			System.out.println("Mail sent successfully!");
		}
	}

	static public void main(String argv[]) {
		new ClientInterface();
	}

}