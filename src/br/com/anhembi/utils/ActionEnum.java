package br.com.anhembi.utils;

public enum ActionEnum {
	STONE(1), SCISSORS(2), PAPER(3);

	private int valor;

	ActionEnum(int valor) {
		this.setValor(valor);
	}

	public static ActionEnum getEnum(int valor) {
		switch (valor) {
		case 1:
			return ActionEnum.STONE;
		case 2:
			return ActionEnum.SCISSORS;
		default:
			return ActionEnum.PAPER;
		}
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
