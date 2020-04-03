package br.com.anhembi.main;

import javax.swing.JOptionPane;

import br.com.anhembi.game.Game;
import br.com.anhembi.game.User;
import br.com.anhembi.utils.Messages;
import br.com.anhembi.utils.TypeGameEnum;

public class Start {

	/**
	 * Método responsável por setar os usuários iniciais.
	 */
	public void init() {
		// Inicializa array de usuários.
		User users[] = new User[2];

		// Player 1 - Usuário
		String name = JOptionPane.showInputDialog(null, Messages.informsUser(), "Nome do usuário",
				JOptionPane.INFORMATION_MESSAGE);
		users[0] = new User(name.toUpperCase());

		// Player 2 - Computador
		users[1] = new User("COMPUTADOR");

		// Tipo de jogo
		int typeGame = Integer.parseInt(JOptionPane.showInputDialog(null, Messages.informsTypeGame(), "Tipo de jogo",
				JOptionPane.INFORMATION_MESSAGE));

		// Seta os valores iniciais do jogo.
		Game game = new Game(users, TypeGameEnum.getEnum(typeGame));
		game.run();
	}
}
