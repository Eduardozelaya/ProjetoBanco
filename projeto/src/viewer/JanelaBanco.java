package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Banco;
import model.ModelException;

public class JanelaBanco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JanelaAgencia janAgencia;
	private JButton btAgencia;
	private JTextField tfNome;
	private JTextField tfCnpj;
	private JTextField tfCodigo;

	/**
	 * Create the frame.
	 */
	public JanelaBanco() {
		setTitle("Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(40, 79, 46, 14);
		contentPane.add(lblNewLabel);

		tfNome = new JTextField();
		tfNome.setBounds(89, 76, 186, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cnpj:");
		lblNewLabel_1.setBounds(40, 40, 46, 14);
		contentPane.add(lblNewLabel_1);

		tfCnpj = new JTextField();
		tfCnpj.setBounds(89, 37, 245, 20);
		contentPane.add(tfCnpj);
		tfCnpj.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Código:");
		lblNewLabel_2.setBounds(40, 117, 46, 14);
		contentPane.add(lblNewLabel_2);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(89, 114, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = tfCnpj.getText();
				String nome = tfNome.getText();
				String codigo = tfCodigo.getText();
				Banco b;
				try {
					b = new Banco(cnpj, nome, codigo);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btOk, "ERRO: " + me.getMessage());
					return;
				}
				// Mostrando o objeto criado.
				JOptionPane.showMessageDialog(btOk, b);
				btAgencia.setEnabled(true);
				tfCnpj.setEnabled(false);
				tfNome.setEnabled(false);
				tfCodigo.setEnabled(false);
			}
		});
		btOk.setBounds(40, 227, 89, 23);
		contentPane.add(btOk);

	    btAgencia = new JButton("Agência");
	    btAgencia.setEnabled(false);
		btAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janAgencia == null || !janAgencia.isVisible()) {
					janAgencia = new JanelaAgencia();
					janAgencia.setVisible(true);
				}
			}
		});
		btAgencia.setBounds(137, 159, 141, 53);
		contentPane.add(btAgencia);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(298, 227, 89, 23);
		contentPane.add(btCancelar);
	}
}