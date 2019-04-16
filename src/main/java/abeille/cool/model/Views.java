package abeille.cool.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewActualite extends ViewCommon{}
	
	public static class ViewAdministrateur extends ViewCommon{}
	
	public static class ViewFacturation extends ViewCommon {}
	
	public static class ViewArticle extends ViewCommon {}
	
	public static class ViewArticleCatArt extends ViewCommon {}
	
	public static class ViewCatArt extends ViewCommon {}
	
	public static class ViewCommandeClient extends ViewCommon {}
	
	public static class ViewClient extends ViewCommon {}
	
	public static class ViewAvis extends ViewCommon {}
	
	public static class ViewLigneCommande extends ViewCommon {}
	
	public static class ViewCoordonnee extends ViewCommon {}
	
	public static class ViewFournisseur extends ViewCommon {}
	
	public static class ViewCommandeFournisseur extends ViewCommon {}

	public static class ViewUtilisateur extends ViewCommon {}
	
	public static class ViewEvenement extends ViewCommon {}
	
	public static class ViewClientEvenement extends ViewCommon {}
	
	public static class ViewProduit extends ViewCommon {}
	
	public static class ViewProduitCatProd extends ViewCommon {}
	
	public static class ViewCatProd extends ViewCommon {}
	
	public static class ViewFacturationWithCommandeCLient extends ViewCommandeClient {}
}
