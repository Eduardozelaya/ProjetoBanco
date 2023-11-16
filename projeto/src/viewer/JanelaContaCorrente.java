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

import model.ContaCorrente;
import model.ModelException;

public class JanelaContaCorrente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNumero;
	private JTextField tfDiaAbertura;
	private JTextField tfNomeCorrentista;
	private JTextField tfSaldoInicial;
	private JTextField tfInabilitado;

	/**
	 * Create the frame.
	 */
	public JanelaContaCorrente() {
		setTitle("Conta Corrente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setBounds(32, 31, 74, 14);
		contentPane.add(lblNewLabel);

		tfNumero = new JTextField();
		tfNumero.setBounds(116, 28, 118, 20);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Dia Abertura:");
		lblNewLabel_2.setBounds(28, 62, 86, 14);
		contentPane.add(lblNewLabel_2);

		tfDiaAbertura = new JTextField();
		tfDiaAbertura.setBounds(116, 59, 118, 20);
		contentPane.add(tfDiaAbertura);
		tfDiaAbertura.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nome Correntista:");
		lblNewLabel_3.setBounds(10, 93, 106, 14);
		contentPane.add(lblNewLabel_3);

		tfNomeCorrentista = new JTextField();
		tfNomeCorrentista.setBounds(116, 90, 245, 20);
		contentPane.add(tfNomeCorrentista);
		tfNomeCorrentista.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = tfNumero.getText();
				String diaAbertura = tfDiaAbertura.getText();
				String nomeCorrentista = tfNomeCorrentista.getText();
				String aux = tfSaldoInicial.getText();
				int saldoInicial;
				try {
					saldoInicial = Integer.parseInt(aux);
				} catch (NumberFormatException qualquerNome) {
					JOptionPane.showMessageDialog(btOk, "O valor passado em 'Saldo Inicial' é inválido: " + aux);
					return;
				}
				ContaCorrente c;
				try {
					c = new ContaCorrente(numero, diaAbertura, nomeCorrentista, saldoInicial);
					JOptionPane.showMessageDialog(btOk, c);
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(btOk, "ERRO: " + e1.getMessage());
				}
			}
		});
		btOk.setBounds(73, 183, 89, 23);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(252, 183, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblNewLabel_1 = new JLabel("Saldo Inicial:");
		lblNewLabel_1.setBounds(28, 124, 86, 14);
		contentPane.add(lblNewLabel_1);

		tfSaldoInicial = new JTextField();
		tfSaldoInicial.setBounds(116, 121, 118, 20);
		contentPane.add(tfSaldoInicial);
		tfSaldoInicial.setColumns(10);

		tfInabilitado = new JTextField();
		tfInabilitado.setEnabled(false);
		tfInabilitado.setBounds(116, 152, 140, 20);
		contentPane.add(tfInabilitado);
		tfInabilitado.setColumns(10);
	}
}