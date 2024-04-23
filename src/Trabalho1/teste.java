package Trabalho1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class teste extends JFrame{
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	public teste() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Arquivo:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(35);
		
		JButton btnNewButton = new JButton("Analisar");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(lblNewLabel);
		panel.add(textField);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("Button.border"));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Button.border"));
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Tag", "N\u00FAmero de ocorr\u00EAncias"
			}
		));
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(77);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(table_1);
	
	}
}
