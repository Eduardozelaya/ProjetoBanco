package model;

public class Agencia implements Serializable{
	//
	// ATRIBUTOS
	//
	private String codigo;
	private String bairro;
	private String cidade;
	private String uf;

	//
	// MÉTODOS
	//
	public Agencia(String c, String b, String ci, String u) throws ModelException {
		this.setCodigo(c);
		this.setBairro(b);
		this.setCidade(ci);
		this.setUf(u);
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String c) throws ModelException {
		Agencia.validarCodigo(c);
		this.codigo = c;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String b) throws ModelException {
		Agencia.validarBairro(b);
		this.bairro = b;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String ci) throws ModelException {
		Agencia.validarCidade(ci);
		this.cidade = ci;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String u) throws ModelException {
		Agencia.validarUf(u);
		this.uf = u;
	}

	public static void validarCodigo(String codigo) throws ModelException {
		// Verificando se o código é nulo
		if (codigo == null || codigo.length() == 0)
			throw new ModelException("O código não pode ser nulo!");
		// Verificando se o código tem 6 caracteres
		if (codigo.length() != 6)
			throw new ModelException("O código deve ter 6 caracteres!");
		for (int i = 0; i < codigo.length(); i++) {
			char c = codigo.charAt(i);
			switch (i) {
			case 4:
				if (c != '-')
					throw new ModelException("Na posição " + i + " do codigo deve ter '-' !");
				break;
			default:
				if (!Character.isDigit(c))
					throw new ModelException("Na posição " + i + " do codigo deve ter dígito!");
				break;
			}
		}
	}

	public static void validarBairro(String bairro) throws ModelException {
		// Verificando se o bairro é nulo
		if (bairro == null || bairro.length() == 0)
			throw new ModelException("O bairro não pode ser nulo!");
		// Verificando se o bairro tem mais de 15 caracteres
		if (bairro.length() > 15)
			throw new ModelException("O bairro não pode ter mais que 15 caracteres!");
		// Verificando se cada caracter do bairro é válido
		for (int i = 0; i < bairro.length(); i++) {
			char c = bairro.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("Na posição " + i + " do bairro há um caracter inválido: " + c);
		}
	}

	public static void validarCidade(String cidade) throws ModelException {
		// Verificando se o cidade é nulo
		if (cidade == null || cidade.length() == 0)
			throw new ModelException("O cidade não pode ser nulo!");
		// Verificando se o cidade tem mais de 20 caracteres
		if (cidade.length() > 20)
			throw new ModelException("O cidade não pode ter mais que 20 caracteres!");
		// Verificando se cada caracter do cidade é válido
		for (int i = 0; i < cidade.length(); i++) {
			char c = cidade.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("Na posição " + i + " do cidade há um caracter inválido: " + c);
		}
	}

	public static void validarUf(String uf) throws ModelException {
		// Verificando se o uf é nulo
		if (uf == null || uf.length() == 0)
			throw new ModelException("O uf não pode ser nulo!");
		// Verificando se o uf tem mais de 2 caracteres
		if (uf.length() > 2)
			throw new ModelException("O uf não pode ter mais que 2 caracteres!");
		// Verificando se cada caracter do uf é válido
		for (int i = 0; i < uf.length(); i++) {
			char c = uf.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isUpperCase(c))
				throw new ModelException("Na posição " + i + " do uf há um caracter inválido: " + c);
		}
	}

	public String toString() {
		return "O código do banco é " + this.codigo + " o bairro onde está localizado a agência do banco é "
				+ this.bairro + " e a cidade é " + this.cidade + "que está na UF de " + this.uf + "\n";
	}
}