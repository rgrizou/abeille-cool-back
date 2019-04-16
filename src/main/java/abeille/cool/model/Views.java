package abeille.cool.model;

public class Views {
	public static class ViewCommandeClient {}

	public static class ViewCommon {}
	
	public static class ViewClient{}
	
	public static class ViewAvis extends ViewCommon{}
	
	public static class ViewLigneCommande extends ViewCommon{}
	
	public static class ViewCoordonnee extends ViewCommon{}
	
	public static class ViewFournisseur{}
	
	public static class ViewCommandeFournisseur extends ViewCommon {}

	public static class ViewUtilisateur extends ViewCommon {}
	
	
	public static class ViewEvenement extends ViewCommon {}
}
