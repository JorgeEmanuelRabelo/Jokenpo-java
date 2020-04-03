package br.com.anhembi.game;

import java.util.Random;

import javax.swing.JOptionPane;

import br.com.anhembi.utils.ActionEnum;
import br.com.anhembi.utils.Messages;
import br.com.anhembi.utils.TypeGameEnum;

public class Game {
	private User users[];
	private TypeGameEnum type;
	private Random rand = new Random();

	// Construtor vazio.
	public Game() {
	}

	public TypeGameEnum getType() {
		return type;
	}

	public void setType(TypeGameEnum type) {
		this.type = type;
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

		// Player 2 - Random - Gera número entre 0 e 3
		users[1].setAction(rand.nextInt(4));

		matchResult();
	}

	private void matchResult() {
		User pl1 = users[0];
		User pl2 = users[1];

		// Player 1: jogar pedra e Player 2: jogar tesoura, Player 1 venceu
		if (pl1.getAction() == ActionEnum.STONE.getValor() && pl2.getAction() == ActionEnum.SCISSORS.getValor())
			pl1.setWonRounds(pl1.getWonRounds() + 1);

		// Player 1: jogar tesoura e Player 2 jogar papel, Player 1 venceu
		else if (pl1.getAction() == ActionEnum.SCISSORS.getValor() && pl2.getAction() == ActionEnum.PAPER.getValor())
			pl1.setWonRounds(pl1.getWonRounds() + 1);

		// Player 1: jogar papel e Player 2 jogar pedra, Player 1 venceu
		else if (pl1.getAction() == ActionEnum.PAPER.getValor() && pl2.getAction() == ActionEnum.STONE.getValor())
			pl1.setWonRounds(pl1.getWonRounds() + 1);

		// Player 1: jogar pedra e Player 2: jogar papel, Player 2 venceu
		else if (pl1.getAction() == ActionEnum.STONE.getValor() && pl2.getAction() == ActionEnum.PAPER.getValor())
			pl2.setWonRounds(pl2.getWonRounds() + 1);

		// Player 1: jogar tesoura e Player 2 jogar pedra, Player 2 venceu
		else if (pl1.getAction() == ActionEnum.SCISSORS.getValor() && pl2.getAction() == ActionEnum.STONE.getValor())
			pl2.setWonRounds(pl2.getWonRounds() + 1);

		// Player 1: jogar papel e Player 2 jogar tesoura, Player 2 venceu
		else if (pl1.getAction() == ActionEnum.PAPER.getValor() && pl2.getAction() == ActionEnum.SCISSORS.getValor())
			pl2.setWonRounds(pl2.getWonRounds() + 1);

		// Player 1: jogar pedra e Player 2 jogar pedra, Player 2 empate
		else if (pl1.getAction() == ActionEnum.STONE.getValor() && pl2.getAction() == ActionEnum.STONE.getValor())
			pl1.setTie(pl1.getTie() + 1);

		// Player 1: jogar tesoura e Player 2 jogar tesoura, Player 2 empate
		else if (pl1.getAction() == ActionEnum.SCISSORS.getValor() && pl2.getAction() == ActionEnum.SCISSORS.getValor())
			pl1.setTie(pl1.getTie() + 1);

		// Player 1: jogar papel e Player 2 jogar papel, Player 2 empate
		else if (pl1.getAction() == ActionEnum.PAPER.getValor() && pl2.getAction() == ActionEnum.PAPER.getValor())
			pl1.setTie(pl1.getTie() + 1);

		Messages.resultGame(users);
	}

}
