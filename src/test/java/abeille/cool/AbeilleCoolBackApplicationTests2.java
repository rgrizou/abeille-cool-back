package abeille.cool;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import abeille.cool.model.Actualite;
import abeille.cool.model.Administrateur;
import abeille.cool.model.CatProd;
import abeille.cool.model.CommandeFournisseur;
import abeille.cool.model.Fournisseur;
import abeille.cool.model.Produit;
import abeille.cool.model.ProduitCatProd;
import abeille.cool.model.TypeUtilisateur;
import abeille.cool.model.Unite;
import abeille.cool.model.Utilisateur;
import abeille.cool.repository.IActualiteRepository;
import abeille.cool.repository.IAdministrateurRepository;
import abeille.cool.repository.ICatProdRepository;
import abeille.cool.repository.IClientRepository;
import abeille.cool.repository.ICommandeFournisseurRepository;
import abeille.cool.repository.IFournisseurRepository;
import abeille.cool.repository.IProduitCatProdRepository;
import abeille.cool.repository.IProduitRepository;
import abeille.cool.repository.IUtilisateurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbeilleCoolBackApplicationTests2 {
	
	@Autowired
	private IProduitRepository produitRepo;
	@Autowired
	private ICatProdRepository catProdRepo;
	@Autowired
	private ICommandeFournisseurRepository commandeFournisseurRepo;
	@Autowired
	private IFournisseurRepository fournisseurRepo;	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	@Autowired
	private IAdministrateurRepository amdinistrateurRepo;
	@Autowired
	private IActualiteRepository actualiteRepo;
	@Autowired
	private IProduitCatProdRepository produitCaProdRepo;
	
	@Test
	public void contextLoads() {
			
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
		utilisateur1.setFournisseur(fournisseur1);
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		
		
		produitRepo.delete(produit2);
	

	}

}
