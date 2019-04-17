package abeille.cool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import abeille.cool.model.Actualite;
import abeille.cool.model.Administrateur;
import abeille.cool.model.Article;
import abeille.cool.model.ArticleCatArt;
import abeille.cool.model.Avis;
import abeille.cool.model.CatArt;
import abeille.cool.model.CatProd;
import abeille.cool.model.Client;
import abeille.cool.model.ClientEvenement;
import abeille.cool.model.CommandeClient;
import abeille.cool.model.CommandeFournisseur;
import abeille.cool.model.Coordonnee;
import abeille.cool.model.Evenement;
import abeille.cool.model.Facturation;
import abeille.cool.model.Fournisseur;
import abeille.cool.model.LigneCommande;
import abeille.cool.model.Produit;
import abeille.cool.model.ProduitCatProd;
import abeille.cool.model.Statut;
import abeille.cool.model.TypeHydromel;
import abeille.cool.model.TypeUtilisateur;
import abeille.cool.model.Unite;
import abeille.cool.model.Utilisateur;
import abeille.cool.repository.IActualiteRepository;
import abeille.cool.repository.IAdministrateurRepository;
import abeille.cool.repository.IArticleCatArtRepository;
import abeille.cool.repository.IArticleRepository;
import abeille.cool.repository.IAvisRepository;
import abeille.cool.repository.ICatArtRepository;
import abeille.cool.repository.ICatProdRepository;
import abeille.cool.repository.IClientEvenementRepository;
import abeille.cool.repository.IClientRepository;
import abeille.cool.repository.ICommandeClientRepository;
import abeille.cool.repository.ICommandeFournisseurRepository;
import abeille.cool.repository.ICoordonneeRepository;
import abeille.cool.repository.IEvenementRepository;
import abeille.cool.repository.IFacturationRepository;
import abeille.cool.repository.IFournisseurRepository;
import abeille.cool.repository.ILigneCommandeRepository;
import abeille.cool.repository.IProduitCatProdRepository;
import abeille.cool.repository.IProduitRepository;
import abeille.cool.repository.IUtilisateurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbeilleCoolBackApplicationTests {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	@Autowired
	private IClientRepository clientRepo;
	@Autowired
	private IClientEvenementRepository clientEventRepo;
	@Autowired
	private IEvenementRepository evenementRepo;
	@Autowired
	private ICoordonneeRepository coordonneeRepo;
	@Autowired
	private ICommandeClientRepository commandeClientRepo;
	@Autowired
	private IFacturationRepository facturationRepo;
	@Autowired
	private IAvisRepository avisRepo;
	@Autowired
	private ILigneCommandeRepository ligneCommandeRepo;
	@Autowired
	private IArticleRepository articleRepo;
	@Autowired
	private IArticleCatArtRepository articleCatArtRepo;
	@Autowired
	private ICatArtRepository catArtRepo;
	@Autowired
	private IProduitRepository produitRepo;
	@Autowired
	private ICatProdRepository catProdRepo;
	@Autowired
	private ICommandeFournisseurRepository commandeFournisseurRepo;
	@Autowired
	private IFournisseurRepository fournisseurRepo;	
	@Autowired
	private IAdministrateurRepository amdinistrateurRepo;
	@Autowired
	private IActualiteRepository actualiteRepo;
	@Autowired
	private IProduitCatProdRepository produitCaProdRepo;
	
	@Test
	public void contextLoads() throws ParseException {
	
		Utilisateur utilisateur = new Utilisateur("adri.chataigneau@gmail.com","123456",TypeUtilisateur.CLIENT);
		Client client = new Client ("Chataigneau","Adrien",true,5);
		ClientEvenement clievent = new ClientEvenement();
		Evenement evenement= new Evenement(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-18"),"Bordeaux","Dégustation","C:\\Users\\utilisateur\\Pictures\\Saved Pictures\\louis_burned.png");
		Coordonnee coordonnee= new Coordonnee("Mon Hydromel","Chataigneau","Adrien","0647134045","adri.chataigneau@gmail.com","71 Rue du Quai Bourgeois","33000","Bordeaux","France");
		CommandeClient commandeClient = new CommandeClient(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-16"),Statut.Commande);
		Facturation fact = new Facturation (new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-16"),"REF-45689");
		Avis avis = new Avis(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-16"),"C'est bien l'hydromel",2,true,true);
		LigneCommande ligneCommande = new LigneCommande(50);
		Article article= new Article("Hydromel de Pêche","Hydromel fabriqué avec de la pêche sauvage jaune",4.20f,10,"C:\\Users\\utilisateur\\Pictures\\Saved Pictures\\louis_burned.png",10.2f,1,"Miel d'Acacia",TypeHydromel.Melomel,false);
		ArticleCatArt articleCatArt = new ArticleCatArt();
		CatArt catArt = new CatArt(5);
		
		articleCatArt.setCatArt(catArt);
		articleCatArt.setArticle(article);;
		avis.setArticle(article);
		avis.setClient(client);
		ligneCommande.setArticle(article);
		ligneCommande.setCommandeClient(commandeClient);
		commandeClient.setFacturation(fact);
		commandeClient.setCoordonnee(coordonnee);
		commandeClient.setClient(client);
		coordonnee.setClient(client);
		clievent.setEvent(evenement);
		clievent.setClient(client);
		utilisateur.setClient(client);	
		
		catArt=catArtRepo.save(catArt);
		article=articleRepo.save(article);
		articleCatArt=articleCatArtRepo.save(articleCatArt);
		client=clientRepo.save(client);
		avis=avisRepo.save(avis);
		evenement=evenementRepo.save(evenement);
		clievent=clientEventRepo.save(clievent);
		coordonnee=coordonneeRepo.save(coordonnee);
		fact=facturationRepo.save(fact);
		commandeClient=commandeClientRepo.save(commandeClient);
		ligneCommande=ligneCommandeRepo.save(ligneCommande);
		utilisateur=utilisateurRepo.save(utilisateur);
		
		Produit produit1 = new Produit("miel", " le meilleur des miels", 100, (float) 10, Unite.kg);
		produit1 = produitRepo.save(produit1);
		produit1.setQte(200);
		Optional<Produit> optProduit = produitRepo.findById(produit1.getId());
		produit1 = optProduit.get();
		produitRepo.findAll();
		
		Produit produit2 = new Produit("bouteille", " une bouteuille de qualité", 1000, (float) 50, Unite.Unite);
		produit2 = produitRepo.save(produit2);
		
		CatProd catProd1 = new CatProd("materiel");
		catProd1 = catProdRepo.save(catProd1);
		catProd1.setNom("miel");
		Optional<CatProd> optCatProd = catProdRepo.findById(catProd1.getId());
		catProd1 = optCatProd.get();
		catProdRepo.findAll();
		
		CatProd catProd2 = new CatProd("levure");
		catProd2 = catProdRepo.save(catProd2);
				
		ProduitCatProd produitCatProd = new ProduitCatProd();
		produitCatProd = produitCaProdRepo.save(produitCatProd);
		
		CommandeFournisseur commandeF1 = new CommandeFournisseur(100, (float) 20, 20, new Date());
		commandeF1 = commandeFournisseurRepo.save(commandeF1);
		commandeF1.setPrixTotal((float) 63.25);
		Optional<CommandeFournisseur> optFournisseur = commandeFournisseurRepo.findById(commandeF1.getId());
		commandeF1 = optFournisseur.get();
		commandeFournisseurRepo.findAll();
				
		CommandeFournisseur commandeF2 = new CommandeFournisseur(10, (float) 10, 200, new Date());
		commandeF2 = commandeFournisseurRepo.save(commandeF2);
		
		Fournisseur fournisseur1 = new Fournisseur("Les gourmands", "123212A", "SA", "FR6545666");
		fournisseur1 = fournisseurRepo.save(fournisseur1);
		fournisseur1.setNumeroTva("FT26523");
		Optional<Fournisseur> optfournisseur = fournisseurRepo.findById(fournisseur1.getId());
		fournisseur1 = optfournisseur.get();
		fournisseurRepo.findAll();
		
		Fournisseur fournisseur2 = new Fournisseur("Les apiculteurs", "923212A", "SARL", "FR45666");
		fournisseur2 = fournisseurRepo.save(fournisseur2);
		
		Utilisateur utilisateur1 = new Utilisateur("jordi.sarpoulet@gmail.com", "motdepassetropdur", TypeUtilisateur.ADMINISTRATEUR);
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		utilisateur1.setMdp("0000");
		Optional<Utilisateur> optUtilisateur = utilisateurRepo.findById(utilisateur1.getId());
		utilisateur1 = optUtilisateur.get();
		utilisateurRepo.findAll();
		
		Utilisateur utilisateur2 = new Utilisateur("fournisseur.lambda@gmail.com", "1234", TypeUtilisateur.FOURNISSEUR);
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		
		Administrateur admin1 = new Administrateur("SARPOULET", "Jordi", "rue du miel", "33300","La Ruche", "France");
		admin1 = amdinistrateurRepo.save(admin1);
		admin1.setPays("Frelon");
		Optional<Administrateur> optAdmin = amdinistrateurRepo.findById(admin1.getId());
		admin1 = optAdmin.get();
		amdinistrateurRepo.findAll();
		
		Actualite actualite1 = new Actualite("l'hydromdel en folie !","Venez boire la meilleure hydromel de france chez Jordi Corporation", new Date(), "photo", true);
		actualite1 = actualiteRepo.save(actualite1);
		actualite1.setPhotoUrl("photo2");
		Optional<Actualite> optActualite = actualiteRepo.findById(actualite1.getId());
		actualite1 = optActualite.get();
		actualiteRepo.findAll();
		
		produitCatProd.setCatProd(catProd1);
		produitCatProd.setProduit(produit1);
		produitCatProd = produitCaProdRepo.save(produitCatProd);
		
		produit1.setFournisseur(fournisseur1);
		produit1 = produitRepo.save(produit1);
		
		commandeF1.setAdministrateur(admin1);
		commandeF1 = commandeFournisseurRepo.save(commandeF1);
		
		utilisateur1.setAdministrateur(admin1);
		utilisateur2.setFournisseur(fournisseur1);
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		produitRepo.delete(produit2);
	}
}
