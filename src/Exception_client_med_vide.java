import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Exception_client_med_vide extends Exception {
		public Exception_client_med_vide() {
			JOptionPane avertissement;
			Color couleur = new Color(255,254,204);
			UIManager.put("OptionPane.background", couleur);
			UIManager.put("Panel.background", couleur);
			avertissement = new JOptionPane();
			avertissement.showMessageDialog(null, "Il n'y a pas encore de clients et/ou de médicaments ", "Attention !", JOptionPane.WARNING_MESSAGE);		
		}
}
