package abeille.cool.model;

public enum TypeUtilisateur {
	CLIENT("Client"), FOURNISSEUR("Fournisseur"), ADMINISTRATEUR("Administrateur");

	private final String label;

	private TypeUtilisateur(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}