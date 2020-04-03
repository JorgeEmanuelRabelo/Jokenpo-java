package br.com.anhembi.utils;

import java.util.Arrays;

import javax.swing.JOptionPane;

import br.com.anhembi.game.User;

public class Messages {

	/*
	 * Método responsável por retornar a lista de opções do tipo de jogo.
	 */
	public static String informsTypeGame() {
		String[] msg = new String[4];
		msg[0] = "1: Quem vencer primeiro ganha o jogo.";
		msg[1] = "2: Melhor de 3 (Duas vitórias para ganhar o jogo).";
		msg[2] = "3: Informar o número de rodadas.";
		msg[3] = "4: Escolher quando acaba.\n";

		return toStringArray(msg);
	}

	/*
	 * Método responsável por retornar mensagem inicial para o usuário.
	 */
	public static String informsUser() {
		return "Para começar, digite seu nome!";
	}

	/*
	 * Método responsável por retornar tipos de jogadas.
	 */
	public static String informsActions() {
		String[] msg = new String[3];
		msg[0] = "1: Pedra ganha da tesoura (amassando-a ou quebrando-a).";
		msg[1] = "2: Tesoura ganha do papel (cortando-o).";
		msg[2] = "3: Papel ganha da pedra(embrulhando-a).";

		return toStringArray(msg);
	}

	/*
	 * Método responsável por formar mensagens.
	 */
	private static String toStringArray(String array[]) {
		return Arrays.toString(array).replace('[', ' ').replace(']', ' ').replace(',', '\n');
	}

	public static void resultGame(User[] users) {
		JOptionPane.showMessageDialog(null,
				Arrays.toString(users).replace('[', ' ').replace(']', ' ').replace(',', '\n'), "Resultado do jogo", 0,
				null);
		System.out.println(Messages.result(users));
	}

	/*
	 * Método responsável por retornar o quadro final de valores.
	 */
	public static String result(User users[]) {
		User pl1 = users[0];
		User pl2 = users[1];

		String[] msg = new String[3];
		msg[0] = "Player 1: " + pl1.getName() + " - Vitórias: " + pl1.getWonRounds();
		msg[1] = "Player 2: " + pl2.getName() + " - Vitórias: " + pl2.getWonRounds();
		msg[2] = "Empates: " + pl1.getTie();

		return toStringArray(msg);
	}
}
