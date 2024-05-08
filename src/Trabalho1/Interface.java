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

import exercicio2.ListaEstatica;

public class Interface {

	private JFrame frame;
	
	Validador validator = new Validador();
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

	private void montarTabela(ListaEstatica<Tag> dados, DefaultTableModel tableModel) {
		for (int j = 0; j <= dados.getTamanho() - 1; j++) {
			Tag ptag = dados.obterElemento(j);
			tableModel.addRow(new Object[] { ptag.getTag(), ptag.getCount() });
		}

	}

	private String lerArquivo(String path) {
		StringBuilder contentBuilder = new StringBuilder();
		if (path.length() == 0) {
			throw new RuntimeException("Nenhum caminho digitado");
		}

		try {

			BufferedReader in = new BufferedReader(new FileReader(path));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException error) {
			throw new RuntimeException(error.getMessage());
		}

		return contentBuilder.toString();
	}

	private void Validar(JButton btnAnalisar, JTextField textField, DefaultTableModel tableModel, JTextArea textArea) {
		btnAnalisar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String path = textField.getText();

				try {
					String conteudo = lerArquivo(path);
					ListaEstatica<Tag> tags = validator.validarTexto(conteudo);
					montarTabela(tags, tableModel);
					textArea.setText("O arquivo está bem formatado");

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
		textArea.setEditable(false);
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
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setRowHeight(20);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(table);
		table.setEnabled(false);

		panel_2.add(table.getTableHeader(), BorderLayout.NORTH);

		/* Listeners */

		Validar(btnAnalisar, textField, model, textArea);

	}
}
