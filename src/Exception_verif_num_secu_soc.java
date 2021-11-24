import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Exception_verif_num_secu_soc extends Exception{
	public Exception_verif_num_secu_soc() {
		JOptionPane avertissement;
		Color couleur = new Color(255,254,204);
		UIManager.put("OptionPane.background", couleur);
		UIManager.put("Panel.background", couleur);
		avertissement = new JOptionPane();
		avertissement.showMessageDialog(null, "L'identifiant doit contenir au moins 13 caractères ! ", "Attention !", JOptionPane.WARNING_MESSAGE);		
	}
	

}

