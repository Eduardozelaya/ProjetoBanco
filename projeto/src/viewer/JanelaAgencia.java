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

import model.Agencia;
import model.ModelException;

public class JanelaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JanelaContaCorrente janContaCorrente;
	private JButton btContaCorrente;
	private JTextField tfCodigo;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfUf;
	private JTextField tfInabilitado;

	/**
	 * Create the frame.
	 */
	public JanelaAgencia() {
		setTitle("Agência");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setBounds(33, 22, 68, 14);
		contentPane.add(lblNewLabel_1);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(104, 19, 140, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Bairro:");
		lblNewLabel_2.setBounds(33, 47, 68, 14);
		contentPane.add(lblNewLabel_2);

		tfBairro = new JTextField();
		tfBairro.setBounds(104, 44, 140, 20);
		contentPane.add(tfBairro);
		tfBairro.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = tfCodigo.getText();
				String bairro = tfBairro.getText();
				String cidade = tfCidade.getText();
				String uf = tfUf.getText();
				Agencia a;
				try {
					a = new Agencia(codigo, bairro, cidade, uf);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btOk, "ERRO: " + me.getMessage());
					return;
				}
				// Mostrando o objeto criado.
				JOptionPane.showMessageDialog(btOk, a);
				btContaCorrente.setEnabled(true);
				tfCodigo.setEnabled(false);
				tfBairro.setEnabled(false);
				tfCidade.setEnabled(false);
				tfUf.setEnabled(false);

			}
		});
		btOk.setBounds(33, 204, 89, 23);
		contentPane.add(btOk);

		btContaCorrente = new JButton("Conta Corrente");
		btContaCorrente.setEnabled(false);
		btContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janContaCorrente == null || !janContaCorrente.isVisible()) {
					janContaCorrente = new JanelaContaCorrente();
					janContaCorrente.setVisible(true);
				}
			}
		});
		btContaCorrente.setBounds(129, 150, 127, 53);
		contentPane.add(btContaCorrente);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(264, 204, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblNewLabel = new JLabel("Cidade:");
		lblNewLabel.setBounds(33, 72, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("UF:");
		lblNewLabel_3.setBounds(33, 97, 46, 14);
		contentPane.add(lblNewLabel_3);

		tfCidade = new JTextField();
		tfCidade.setBounds(104, 69, 140, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);

		tfUf = new JTextField();
		tfUf.setBounds(103, 95, 141, 20);
		contentPane.add(tfUf);
		tfUf.setColumns(10);
		
		tfInabilitado = new JTextField();
		tfInabilitado.setEnabled(false);
		tfInabilitado.setBounds(104, 126, 140, 20);
		contentPane.add(tfInabilitado);
		tfInabilitado.setColumns(10);
	}
}