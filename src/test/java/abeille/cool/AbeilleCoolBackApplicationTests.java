package abeille.cool;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import abeille.cool.model.Article;
import abeille.cool.model.ArticleCatArt;
import abeille.cool.model.Avis;
import abeille.cool.model.CatArt;
import abeille.cool.model.Client;
import abeille.cool.model.ClientEvenement;
import abeille.cool.model.CommandeClient;
import abeille.cool.model.Coordonnee;
import abeille.cool.model.Evenement;
import abeille.cool.model.Facturation;
import abeille.cool.model.LigneCommande;
import abeille.cool.model.Statut;
import abeille.cool.model.TypeHydromel;
import abeille.cool.model.TypeUtilisateur;
import abeille.cool.model.Utilisateur;
import abeille.cool.repository.IArticleCatArtRepository;
import abeille.cool.repository.IArticleRepository;
import abeille.cool.repository.IAvisRepository;
import abeille.cool.repository.ICatArtRepository;
import abeille.cool.repository.IClientEvenementRepository;
import abeille.cool.repository.IClientRepository;
import abeille.cool.repository.ICommandeClientRepository;
import abeille.cool.repository.ICoordonneeRepository;
import abeille.cool.repository.IEvenementRepository;
import abeille.cool.repository.IFacturationRepository;
import abeille.cool.repository.ILigneCommandeRepository;
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
	}
}
