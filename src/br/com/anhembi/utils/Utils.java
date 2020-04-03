package br.com.anhembi.utils;

import javax.swing.JOptionPane;

import br.com.anhembi.main.Start;

public class Utils {

	public static String validJOption(String txt) {
		if (txt == null)
			System.exit(0);

		if (txt.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe um valor", "Alerta", JOptionPane.WARNING_MESSAGE);
			new Start().init();
		}
		return txt;
	}

	public static int validJOptionInteger(String txt) {
		if (txt == null)
			System.exit(0);

		if (txt.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe um valor", "Alerta", JOptionPane.WARNING_MESSAGE);
			new Start().init();
		}

		return Integer.parseInt(txt);
	}
}
