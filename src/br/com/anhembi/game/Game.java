package br.com.anhembi.game;

import java.util.Random;

import javax.swing.JOptionPane;

import br.com.anhembi.utils.Messages;
import br.com.anhembi.utils.TypeGameEnum;

public class Game {
	private User users[];
	private TypeGameEnum type;
	private Random rand = new Random();

	// Construtor vazio.
	public Game() {
	}

	// Construtor responsável por setar valores iniciais do jogo.
	public Game(User[] users, TypeGameEnum type) {
		super();
		this.users = users;
		this.type = type;
	}

	public void run() {
		// Player 1
		users[0].setAction(Integer.parseInt(JOptionPane.showInputDialog(null, Messages.informsActions(), "Jogada",
				JOptionPane.INFORMATION_MESSAGE)));

		// Player 2
		// Random - Gera número entre 0 e 3
		users[1].setAction(rand.nextInt(4));

		switch (type) {
		case ONE_ROUND:

			break;
		case TWO_ROUND:

			break;
		case NUMBER_ROUNDS:

			break;
		case END_ROUND:

			break;
		default:
			break;
		}

		System.out.println(Messages.result(users));
	}

}
