package abeille.cool.model;

public enum Unite {
	
Unite("Unite"), cL("Centilitre"), kg("Kilogramme"), g("Gramme");

private final String label;
private Unite(String label) {
this.label = label;	}

public String getLabel() {
return label;
		}

	}


