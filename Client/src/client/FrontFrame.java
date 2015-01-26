package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public FrontFrame(Client user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 11, 313, 36);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSrch = new JButton("search");
		btnSrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSrch.setBounds(335, 11, 89, 36);
		contentPane.add(btnSrch);

		Vector<String> listV = new Vector<String>();
		listV.add("Parham");
		listV.add("Navid");

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Open friend's ChatFrame:
				// open=true;
			}
		});
		btnSelect.setBounds(335, 58, 89, 192);
		contentPane.add(btnSelect);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 313, 192);
		contentPane.add(scrollPane);

		JList list = new JList(listV);
		scrollPane.setViewportView(list);
	}
}
