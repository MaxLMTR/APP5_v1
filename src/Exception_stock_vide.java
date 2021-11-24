import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Exception_stock_vide extends Exception {
	public Exception_stock_vide() {
		JOptionPane avertissement;
		Color couleur = new Color(255,254,204);
		UIManager.put("OptionPane.background", couleur);
		UIManager.put("Panel.background", couleur);
		avertissement = new JOptionPane();
		avertissement.showMessageDialog(null, "Il n'y a pas assez de stock ! ", "Attention !", JOptionPane.WARNING_MESSAGE);		
	}
}
