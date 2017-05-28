package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import DBOperation.PhoneNumberOperations;

import entity.CustomerPhoneNumber;

public class MyPanel extends JPanel {
	private String message;
	private JTextArea messageTextArea;
	private JButton sendButton;
	private JButton sendMyPageLinkButton;

	private JPanel messagePanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPanel;
	private JTable resultTable;

	private DefaultTableModel dtm;

	private String[] tableTitles = { "ID", "Phone Number" };

	public MyPanel() {

		dtm = new DefaultTableModel(null, tableTitles);
		messageTextArea = new JTextArea();
		sendButton = new JButton("Send Message");
		sendMyPageLinkButton = new JButton("Send Link");

		resultTable = new JTable(dtm) {
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			}

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		fillJTable(PhoneNumberOperations.retriveAllNumbers(), dtm,
				tableTitles.length);

		scrollPanel = new JScrollPane(resultTable);
		buttonPanel = new JPanel();
		messagePanel = new JPanel();
		buttonPanel.add(sendButton);
		buttonPanel.add(sendMyPageLinkButton);
		this.setLayout(new BorderLayout());
		this.add(messageTextArea, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		sendMyPageLinkButton.addActionListener(new SendLinksButtonActionListener());

	}

	private class SendLinksButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<String> toPhoneNumbers = new ArrayList<String>();
			for (int i = 0; i < resultTable.getSelectedRowCount(); i++) {
				toPhoneNumbers.add((String) resultTable.getModel().getValueAt(
						resultTable.getSelectedRows()[i], 1));
			}
			
			PhoneNumberOperations.sendLinks(toPhoneNumbers);
		}

	}

	private void fillJTable(List<CustomerPhoneNumber> list, DefaultTableModel dtm,
			int numberOfColumns) {
		for (CustomerPhoneNumber p : list) {

			String[] rowData = new String[numberOfColumns];

			rowData[0] = String.valueOf(p.getID());
			rowData[1] = String.valueOf(p.getPhoneNumber());

			System.out.println(p.getID() + "\t" + p.getPhoneNumber());
			dtm.addRow(rowData);
		}

		if (dtm.getRowCount() == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "no result .",
					"Inane error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
