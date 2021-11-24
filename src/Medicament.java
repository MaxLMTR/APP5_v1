
public class Medicament {
	String reference, libelle, description;
	double prix;
	int quantite, stock;
	
	public Medicament(String reference, String libelle, String description, double prix, int quantite, int stock) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.stock = stock;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDesription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
