import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

	public class Exception_num_secu_soc_occupe extends Exception {
		public Exception_num_secu_soc_occupe() {
			JOptionPane avertissement;
			Color couleur = new Color(255,254,204);
			UIManager.put("OptionPane.background", couleur);
			UIManager.put("Panel.background", couleur);
			avertissement = new JOptionPane();
			avertissement.showMessageDialog(null, "Ce client existe d�j� ! ", "Attention !", JOptionPane.WARNING_MESSAGE);		
		}
}
