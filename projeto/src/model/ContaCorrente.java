package model;

public class ContaCorrente implements Serializable{
	//
	// ATRIBUTOS
	//
	private String numero;
	private String diaAbertura;
	private String nomeCorrentista;
	private int saldoInicial;

	//
	// MÉTODOS
	//
	public ContaCorrente(String n, String d, String nc, int s) throws ModelException {
		this.setNumero(n);
		this.setDiaAbertura(d);
		this.setNomeCorrentista(nc);
		this.setSaldoInicial(s);
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String n) throws ModelException {
		ContaCorrente.validarNumero(n);
		this.numero = n;
	}

	public String getDiaAbertura() {
		return this.diaAbertura;
	}

	public void setDiaAbertura(String d) throws ModelException {
		ContaCorrente.validarDiaAbertura(d);
		this.diaAbertura = d;
	}

	public String getNomeCorrentista() {
		return this.nomeCorrentista;
	}

	public void setNomeCorrentista(String nc) throws ModelException {
		ContaCorrente.validarNomeCorrentista(nc);
		this.nomeCorrentista = nc;
	}

	public int getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(int s) throws ModelException {
		ContaCorrente.validarSaldoInicial(s);
		this.saldoInicial = s;
	}

	public static void validarNumero(String numero) throws ModelException {
		// Verificando se o numero é nulo
		if (numero == null || numero.length() == 0)
			throw new ModelException("O código não pode ser nulo!");
		// Verificando se o numero tem 7 caracteres
		if (numero.length() != 7)
			throw new ModelException("O código deve ter 7 caracteres!");
		for (int i = 0; i < numero.length(); i++) {
			char c = numero.charAt(i);
			switch (i) {
			case 5:
				if (c != '-')
					throw new ModelException("Na posição " + i + " do numero deve ter '-' !");
				break;
			default:
				if (!Character.isDigit(c))
					throw new ModelException("Na posição " + i + " do numero deve ter dígito!");
				break;
			}
		}
	}

	public static void validarDiaAbertura(String diaAbertura) throws ModelException {
		if (diaAbertura == null || diaAbertura.length() == 0)
			throw new ModelException("O diaAbertura não pode ser nulo!");
		if (diaAbertura.length() != 10)
			throw new ModelException("O diaAbertura deve ter 10 caracteres!");
		for (int i = 0; i < diaAbertura.length(); i++) {
			char c = diaAbertura.charAt(i);
			switch (i) {
			case 0:
			case 1:
				if (c < 1 && c > 31)
					throw new ModelException("Na posição " + i + " deve ter um número de um dia de 1 á 31 !");
				break;
			case 2:
				if (c != '/')
					throw new ModelException("Na posição " + i + " deve ter '\' ");
				break;
			case 3:
			case 4:
				if (c < 0 && c > 9)
					throw new ModelException("Na posição " + i + " deve ter um número de um mês de 1 á 12 !");
				break;
			case 5:
				if (c != '/')
					throw new ModelException("Na posição " + i + " deve ter '\' ");
				break;
			case 6:
				if (c < 2)
					throw new ModelException("Na posição " + i + " deve ter um número maior ou igual a 2!");
				break;
			case 8:
				if (c < 2)
					throw new ModelException("Na posição " + i + " deve ter um número maior ou igual a 2!");
			default:
				if (!Character.isDigit(c))
					throw new ModelException("Na posição " + i + " deve ter dígito!");
				break;
			}
		}
	}

	public static void validarNomeCorrentista(String nomeCorrentista) throws ModelException {
		// Verificando se o nomeCorrentista é nulo
		if (nomeCorrentista == null || nomeCorrentista.length() == 0)
			throw new ModelException("O nomeCorrentista não pode ser nulo!");
		// Verificando se o nomeCorrentista tem mais de 40 caracteres
		if (nomeCorrentista.length() > 40)
			throw new ModelException("O nomeCorrentista não pode ter mais que 40 caracteres!");
		// Verificando se cada caracter do nomeCorrentista é válido
		for (int i = 0; i < nomeCorrentista.length(); i++) {
			char c = nomeCorrentista.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("Na posição " + i + " do nomeCorrentista há um caracter inválido: " + c);
		}
	}

	public static void validarSaldoInicial(int saldoInicial) throws ModelException {
		if (saldoInicial < 0)
			throw new ModelException("Saldo Inicial inválido!");
	}

	public String toString() {
		return "O número da conta corrente é " + this.numero + " o dia de abertura da mesma é " + this.diaAbertura
				+ " o nome do correntista é " + this.nomeCorrentista + " e o saldo inicial é " + this.saldoInicial
				+ ".\nEu estou na posição #" + Integer.toHexString(this.hashCode()) + "\n";
	}

}