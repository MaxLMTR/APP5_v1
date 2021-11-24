import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Exception_med_deja_existe extends Exception {
	public Exception_med_deja_existe() {
		JOptionPane avertissement;
		Color couleur = new Color(255,254,204);
		UIManager.put("OptionPane.background", couleur);
		UIManager.put("Panel.background", couleur);
		avertissement = new JOptionPane();
		avertissement.showMessageDialog(null, "Ce médicament existe déjà ! ", "Attention !", JOptionPane.WARNING_MESSAGE);		
	}
}
