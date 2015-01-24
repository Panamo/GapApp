package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ChatFrame extends JFrame {
	public boolean open = false;
	private JTextPane textPane;
	public JTextPane getTextPane() {
		return textPane;
	}
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ChatFrame(User user,Chat chat) {
		setTitle(chat.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 414, 107);
		contentPane.add(textPane);
//		JScrollPane jsp = new JScrollPane(textPane);
//		contentPane.add(jsp);
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 129, 336, 121);
		contentPane.add(editorPane);

		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//sending msg:
					String text = editorPane.getText();
					user.sendToServer("send",chat.getID(),text);
					textPane.setText(textPane.getText() + "Me: " + text + "\n");
					editorPane.setText("");
					//String history;
//					if ((history = textPane.getText()).split("\n").length>=7){
//						textPane.setText("");
//				}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		sendButton.setBounds(356, 129, 68, 121);
		contentPane.add(sendButton);
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
