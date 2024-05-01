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

import exercicio5.Pilha;

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

	private void montarTabela(Pilha<String> dados, DefaultTableModel tableModel) {

		System.out.print(dados.toString());

		while (!dados.estaVazia()) {
			tableModel.addRow(new Object[] { dados.pop(), 1 });
		}

	
		

	}

	private String lerArquivo(String path) {
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

		return contentBuilder.toString();
	}

	private void Validar(JButton btnAnalisar, JTextField textField, DefaultTableModel tableModel) {
		btnAnalisar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String path = textField.getText();

				String conteudo = lerArquivo(path);

				Validador validator = new Validador();

				try {
					Pilha<String> tags = validator.validarTexto(conteudo);
					montarTabela(tags, tableModel);

				} catch (Exception error) {
					JOptionPane.showMessageDialog(frame, error.getMessage());
				}

			}
		});

	}

	private void initialize() {
		JTextField textField;
		JTable table;

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

		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"Tag", "N\u00FAmero de ocorr\u00EAncias"
				});

		table = new JTable(model);

		table.setRowHeight(20);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(table);

		panel_2.add(table.getTableHeader(), BorderLayout.NORTH);

		/* Listeners */

		Validar(btnAnalisar, textField, model);

	}
}
