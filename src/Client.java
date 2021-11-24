import java.util.*;
public class Client {
	String nom, prenom, adresse, num_tel, num_securite_sociale;
	ArrayList<Medicament> liste_Achats = new ArrayList<Medicament>();
	
	public Client(String num_securite_sociale, String num_tel, String nom, String prenom, String adresse, ArrayList<Medicament> liste_Achats) {
		super();
		this.num_securite_sociale = num_securite_sociale;
		this.num_tel = num_tel;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.liste_Achats = liste_Achats;
		
	}

	public String getNum_securite_sociale() {
		return num_securite_sociale;
	}

	public void setNum_securite_sociale(String num_securite_sociale) {
		this.num_securite_sociale = num_securite_sociale;
	}

	public String getNum_tel() {
		return num_tel;
	}

	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Medicament> getListe_Achats() {
		return liste_Achats;
	}

	public void setListe_Achats(ArrayList<Medicament> liste_Achats) {
		this.liste_Achats = liste_Achats;
	}

	
}
