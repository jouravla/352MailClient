import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


/**
 * This is a simple GUI for the user to input their information
 * @author Sasha Jouravlev
 *
 */
public class ClientInterface extends JFrame {
	//the appropriate parts of the GUI
	private Label senderLabel = new Label("From:");
	private TextField sender = new TextField("", 20);
	private Label recipientLabel = new Label("To:"); 
	private TextField recipient = new TextField("", 20);
	private Label subjectLabel = new Label("Subject:");
	private TextField subject = new TextField("", 20);
	private Label messageLabel = new Label("Message:");
	private TextArea message = new TextArea(10, 40);

	private Button sendButton = new Button("Send");
	
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

	//the listener for the send click
	class SendListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if((sender.getText()).equals("") || recipient.getText().equals("") || subject.getText().equals("")) {
				System.out.println("All fields must be filled out.");
				return;
			}

			Email email = new Email(sender.getText(), recipient.getText(), subject.getText(), message.getText());
			
			//surrounded by a try catch in case specialized errors wanted to be implemented
			try {
				SMTP blah = new SMTP(email);
			} catch (Exception error) {
				System.out.println("Sending failed: " + error);
			}
		}
	}
	
	static public void main(String argv[]) {
		new ClientInterface();
	}
}