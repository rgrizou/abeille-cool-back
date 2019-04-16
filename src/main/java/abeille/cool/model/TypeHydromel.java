package abeille.cool.model;

public enum TypeHydromel {
	Rhodomel("Rhodomel"), Melomel("Melomel"), Braggot("Braggot"), Oxymel("Oxymel"), Oenomel("Oenomel"),
		Classique("Classique");

	private final String typeHydromel;

	private TypeHydromel(String typeHydromel) {
		this.typeHydromel = typeHydromel;
	}

	public String getTypeHydromel() {
		return typeHydromel;
	}
	
}
