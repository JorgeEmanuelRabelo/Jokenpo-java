package br.com.anhembi.utils;

public enum TypeGameEnum {
	ONE_ROUND(1), TWO_ROUND(2), NUMBER_ROUNDS(3), END_ROUND(4);

	private int valor;

	TypeGameEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	/*
	 * Método responsável por retornar o tipo de enum usado inteiro como
	 * parâmetro.
	 */
	public static TypeGameEnum getEnum(int valor) {
		switch (valor) {
		case 1:
			return TypeGameEnum.ONE_ROUND;
		case 2:
			return TypeGameEnum.TWO_ROUND;
		case 3:
			return TypeGameEnum.NUMBER_ROUNDS;
		default:
			return TypeGameEnum.END_ROUND;
		}
	}
}
