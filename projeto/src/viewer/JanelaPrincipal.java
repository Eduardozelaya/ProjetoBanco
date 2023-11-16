package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JanelaBanco janBanco;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		this.janBanco = null;
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btBanco = new JButton("Incluir Banco");
		btBanco.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		btBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janBanco == null || !janBanco.isVisible()) {
					janBanco = new JanelaBanco();
					janBanco.setVisible(true);
				}
			}
		});
		btBanco.setBounds(73, 31, 264, 117);
		contentPane.add(btBanco);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setBounds(54, 209, 334, 41);
		contentPane.add(btSair);
	}
}