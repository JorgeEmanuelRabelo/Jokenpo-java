package br.com.anhembi.game;

import java.util.Random;

import javax.swing.JOptionPane;

import br.com.anhembi.main.Start;
import br.com.anhembi.utils.ActionEnum;
import br.com.anhembi.utils.Messages;
import br.com.anhembi.utils.TypeGameEnum;
import br.com.anhembi.utils.Utils;

public class Game {
	private User users[];
	private TypeGameEnum type;
	private Random rand = new Random();
	private int numberRounds = 0;
	private boolean endGame = true;

	// Construtor vazio.
	public Game() {
	}

	// Construtor responsável por setar valores iniciais do jogo.
	public Game(User[] users, TypeGameEnum type, int number_rounds) {
		super();
		this.users = users;
		this.type = type;
		this.numberRounds = number_rounds;
	}

	public void run() {

		User pl1 = users[0];
		User pl2 = users[1];

		switch (type) {
		case END_ROUND:
			while (endGame) {
				setActionPlayers(Messages.informsActionsEndGame(), 4);
				matchResult();
			}

			break;
		case NUMBER_ROUNDS:
			for (int i = 1; i <= numberRounds; i++) {
				setActionPlayers(Messages.informsActions(), 3);
				matchResult();
			}

			break;
		case TWO_ROUND:
			// Verifica se algum jogador teve duas vitórias.
			while (pl1.getWonRounds() < 2 && pl2.getWonRounds() < 2) {
				setActionPlayers(Messages.informsActions(), 3);
				matchResult();
			}
			break;

		default:
			setActionPlayers(Messages.informsActions(), 3);
			matchResult();
			break;
		}

		Messages.resultGame(users);
	}

	/*
	 * Inicializa as jogadas dos players
	 */
	private void setActionPlayers(String message, int count) {
		// Player 1
		int actionPlayer1 = Utils.validJOptionInteger(
				JOptionPane.showInputDialog(null, message, "Jogada", JOptionPane.INFORMATION_MESSAGE));

		if (actionPlayer1 > count) {
			JOptionPane.showMessageDialog(null, "Escolha um opção valida", "Alerta", JOptionPane.WARNING_MESSAGE);
			new Start().init();
		} else {

			if (actionPlayer1 == 4) {
				endGame = false;
				return;
			}

			users[0].setAction(actionPlayer1);

			// Player 2 - Random - Gera número entre 1 e 3
			users[1].setAction(rand.nextInt(3) + 1);
		}
	}

	/*
	 * Regras do jogo
	 */
	private void matchResult() {
		User pl1 = users[0];
		User pl2 = users[1];

		// Player 1: jogar pedra e Player 2: jogar tesoura, Player 1 venceu
		if (pl1.getAction() == ActionEnum.STONE.getValor() && pl2.getAction() == ActionEnum.SCISSORS.getValor()) {
			pl1.setWonRounds(pl1.getWonRounds() + 1);
			Messages.playerWin(pl1);

			// Player 1: jogar tesoura e Player 2 jogar papel, Player 1 venceu
		} else if (pl1.getAction() == ActionEnum.SCISSORS.getValor()
				&& pl2.getAction() == ActionEnum.PAPER.getValor()) {
			pl1.setWonRounds(pl1.getWonRounds() + 1);
			Messages.playerWin(pl1);

			// Player 1: jogar papel e Player 2 jogar pedra, Player 1 venceu
		} else if (pl1.getAction() == ActionEnum.PAPER.getValor() && pl2.getAction() == ActionEnum.STONE.getValor()) {
			pl1.setWonRounds(pl1.getWonRounds() + 1);
			Messages.playerWin(pl1);

			// Player 1: jogar pedra e Player 2: jogar papel, Player 2 venceu
		} else if (pl1.getAction() == ActionEnum.STONE.getValor() && pl2.getAction() == ActionEnum.PAPER.getValor()) {
			pl2.setWonRounds(pl2.getWonRounds() + 1);
			Messages.playerWin(pl2);

			// Player 1: jogar tesoura e Player 2 jogar pedra, Player 2 venceu
		} else if (pl1.getAction() == ActionEnum.SCISSORS.getValor()
				&& pl2.getAction() == ActionEnum.STONE.getValor()) {
			pl2.setWonRounds(pl2.getWonRounds() + 1);
			Messages.playerWin(pl2);

			// Player 1: jogar papel e Player 2 jogar tesoura, Player 2 venceu
		} else if (pl1.getAction() == ActionEnum.PAPER.getValor()
				&& pl2.getAction() == ActionEnum.SCISSORS.getValor()) {
			pl2.setWonRounds(pl2.getWonRounds() + 1);
			Messages.playerWin(pl2);

			// Player 1: jogar pedra e Player 2 jogar pedra, Player 2 empate
		} else if (pl1.getAction() == ActionEnum.STONE.getValor() && pl2.getAction() == ActionEnum.STONE.getValor()) {
			pl1.setTie(pl1.getTie() + 1);

			// Player 1: jogar tesoura e Player 2 jogar tesoura, Player 2 empate
		} else if (pl1.getAction() == ActionEnum.SCISSORS.getValor()
				&& pl2.getAction() == ActionEnum.SCISSORS.getValor()) {
			pl1.setTie(pl1.getTie() + 1);
			JOptionPane.showMessageDialog(null, "Empate", "Resultado da partida", JOptionPane.INFORMATION_MESSAGE);

			// Player 1: jogar papel e Player 2 jogar papel, Player 2 empate
		} else if (pl1.getAction() == ActionEnum.PAPER.getValor() && pl2.getAction() == ActionEnum.PAPER.getValor()) {
			pl1.setTie(pl1.getTie() + 1);
			JOptionPane.showMessageDialog(null, "Empate", "Resultado da partida", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
