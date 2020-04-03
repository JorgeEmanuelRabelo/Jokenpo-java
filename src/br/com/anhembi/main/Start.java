package br.com.anhembi.main;

import javax.swing.JOptionPane;

import br.com.anhembi.game.Game;
import br.com.anhembi.game.User;
import br.com.anhembi.utils.Messages;
import br.com.anhembi.utils.TypeGameEnum;

public class Start {

	private int numberRounds = 0;
	private int typeGame = 0;

	/**
	 * M�todo respons�vel por setar os usu�rios iniciais.
	 */
	public void init() {
		// Inicializa array de usu�rios.
		User users[] = new User[2];

		// Player 1 - Usu�rio
		String name = JOptionPane.showInputDialog(null, Messages.informsUser(), "Nome do usu�rio",
				JOptionPane.INFORMATION_MESSAGE);
		users[0] = new User(name.toUpperCase());

		// Player 2 - Computador
		users[1] = new User("COMPUTADOR");

		// Tipo de jogo
		typeGame = Integer.parseInt(JOptionPane.showInputDialog(null, Messages.informsTypeGame(), "Tipo de jogo",
				JOptionPane.INFORMATION_MESSAGE));

		if (typeGame > 4) {
			JOptionPane.showMessageDialog(null, "Escolha um op��o valida", "Alerta", JOptionPane.WARNING_MESSAGE);
			init();
		} else {

			// Verifica se o usu�rio escolher informar o n�mero de rodadas.
			if (typeGame == 3) {
				numberRounds = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o n�mero de rodadas",
						"Quantidade de rodadas", JOptionPane.INFORMATION_MESSAGE));
			}

			// Seta os valores iniciais do jogo.
			Game game = new Game(users, TypeGameEnum.getEnum(typeGame), numberRounds);
			game.run();
		}
	}
}
