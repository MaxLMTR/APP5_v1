import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Exception_champ_vide extends Exception {
	public Exception_champ_vide() {
		JOptionPane avertissement;
		avertissement = new JOptionPane();
		Color couleur = new Color(255,254,204);
		UIManager.put("OptionPane.background", couleur);
		UIManager.put("Panel.background", couleur);
		avertissement.showMessageDialog(null, "Tous les champs ne sont pas remplis ! ", "Attention !", JOptionPane.WARNING_MESSAGE);	
	
		
	}
}