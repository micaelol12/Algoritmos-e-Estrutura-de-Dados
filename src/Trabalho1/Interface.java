package Trabalho1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.xml.validation.Validator;

public class Interface {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() {
		frame = new JFrame();
		frame.setTitle("Validador HTML");
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(600, 600));
		frame.setVisible(true);
	}

	private void Validar(JButton btnAnalisar, JTextField textField) {
		btnAnalisar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String path = textField.getText();
				System.out.println(path);

				StringBuilder contentBuilder = new StringBuilder();

				try {
					BufferedReader in = new BufferedReader(new FileReader(path));
					String str;
					while ((str = in.readLine()) != null) {
						contentBuilder.append(str);
					}
					in.close();
				} catch (IOException error) {
					System.out.print(error);
					JOptionPane.showMessageDialog(frame, error.getMessage());
				}

				String content = contentBuilder.toString();
				
				Validador validator = new Validador();

				try {
					validator.validarTexto(content);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(frame, error.getMessage());
				}

				System.out.print(content);

			}
		});

	}

	private void initialize() {
		JTextField textField;
		JTable table_1;

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Arquivo:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(35);

		JButton btnAnalisar = new JButton("Analisar");
		btnAnalisar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel.add(lblNewLabel);
		panel.add(textField);
		panel.add(btnAnalisar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("Button.border"));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Button.border"));
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);

		table_1 = new JTable(new DefaultTableModel(
				new Object[][] {
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
						{ null, null },
				},
				new String[] {
						"Tag", "N\u00FAmero de ocorr\u00EAncias"
				}));

		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(77);

		table_1.setRowHeight(20);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(table_1);

		panel_2.add(table_1.getTableHeader(), BorderLayout.NORTH);

		/* Listeners */

		Validar(btnAnalisar, textField);

	}
}
