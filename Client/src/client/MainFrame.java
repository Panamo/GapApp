package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4905802514617108935L;

	private JTextPane textPane;
	public JTextPane getTextPane() {
		return textPane;
	}
	private Vector listData;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame(final User user) {
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
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 129, 336, 121);
		contentPane.add(editorPane);

		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String text = editorPane.getText();
					user.sendToServer(text);
					//user.sendToServer("client1");
					textPane.setText(textPane.getText() + "sending " + text
							+ " to server\n");
					editorPane.setText("");
					String history;
					if ((history = textPane.getText()).split("\n").length>=7){
						textPane.setText("");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		sendButton.setBounds(356, 129, 68, 121);
		contentPane.add(sendButton);
		listData = new Vector();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Vector getListData() {
		return listData;
	}
}
