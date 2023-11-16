package model;

public class Banco {
	//
	// ATRIBUTOS
	//
	private String cnpj;
	private String nome;
	private String codigo;

	//
	// MÉTODOS
	//
	public Banco(String c, String n, String co) throws ModelException {
		this.setCnpj(c);
		this.setNome(n);
		this.setCodigo(co);
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String c) throws ModelException {
		Banco.validarCnpj(c);
		this.cnpj = c;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String n) throws ModelException {
		Banco.validarNome(n);
		this.nome = n;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String co) throws ModelException {
		Banco.validarCodigo(co);
		this.codigo = co;
	}

	public static void validarCnpj(String cnpj) throws ModelException {
		// Verificando se o cnpj é nulo
		if (cnpj == null || cnpj.length() == 0)
			throw new ModelException("O cnpj não pode ser nulo!");
		// Verificando se o cnpj tem mais de 18 caracteres
		if (cnpj.length() != 18)
			throw new ModelException("O cnpj deve estar no formato 99.999.999/0001-99!");
		// Verificando se cada caracter do cnpj é válido
		for (int i = 0; i < cnpj.length(); i++) {
			char c = cnpj.charAt(i);
			switch (i) {
			case 2:
			case 6:
				if (c != '.')
					throw new ModelException("Na posição " + i + " do cnpj deve ter '.' !");
				break;
			case 10:
				if (c != '/')
					throw new ModelException("Na posição " + i + " do cnpj deve ter '/' !");
				break;
			case 11:
			case 12:
			case 13:
				if (c != '0')
					throw new ModelException("Na posição " + i + " do cnpj deve ter '0' !");
				break;
			case 14:
				if (c != '1' && c != '2')
					throw new ModelException("Na posição " + i + " do cnpj deve ter '1' ou '2' !");
				break;
			case 15:
				if (c != '-')
					throw new ModelException("Na posição " + i + " do cnpj deve ter '-' !");
				break;
			default:
				if (!Character.isDigit(c))
					throw new ModelException("Na posição " + i + " do cnpj deve ter dígito!");
				break;
			}
		}
	}

	public static void validarNome(String nome) throws ModelException {
		// Verificando se o nome é nulo
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome não pode ser nulo!");
		// Verificando se o nome tem mais de 20 caracteres
		if (nome.length() > 20)
			throw new ModelException("O nome não pode ter mais que 20 caracteres!");
		// Verificando se cada caracter do nome é válido
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("Na posição " + i + " do nome há um caracter inválido: " + c);
		}
	}

	public static void validarCodigo(String codigo) throws ModelException {
		// Verificando se o código é nulo
		if (codigo == null || codigo.length() == 0)
			throw new ModelException("O código não pode ser nulo!");
		// Verificando se o código tem 3 caracteres
		if (codigo.length() != 3)
			throw new ModelException("O código deve ter 3 caracteres!");
		// Verificando os três primeiros caracteres do código
		for (int i = 0; i < 3; i++) {
			char c = codigo.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("Caracter inválido na posição " + i + " do código (deve ser dígito)");
		}
	}

	public String toString() {
		return "O cnpj do banco é " + this.cnpj + " o nome do banco é " + this.nome + " e o codigo do banco é "
				+ this.codigo;
	}
}