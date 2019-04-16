package abeille.cool;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import abeille.cool.model.Client;
import abeille.cool.model.ClientEvenement;
import abeille.cool.model.CommandeClient;
import abeille.cool.model.Coordonnee;
import abeille.cool.model.Evenement;
import abeille.cool.model.Facturation;
import abeille.cool.model.Statut;
import abeille.cool.model.TypeUtilisateur;
import abeille.cool.model.Utilisateur;
import abeille.cool.repository.IClientEvenementRepository;
import abeille.cool.repository.IClientRepository;
import abeille.cool.repository.ICommandeClientRepository;
import abeille.cool.repository.ICoordonneeRepository;
import abeille.cool.repository.IEvenementRepository;
import abeille.cool.repository.IFacturationRepository;
import abeille.cool.repository.IUtilisateurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbeilleCoolBackApplicationTests {

	@Test
	public void contextLoads() throws ParseException {
		IUtilisateurRepository utilisateurRepo;
		IClientRepository clientRepo;
		IClientEvenementRepository clientEventRepo;
		IEvenementRepository evenementRepo;
		ICoordonneeRepository coordonneeRepo;
		ICommandeClientRepository commandeClientRepo;
		IFacturationRepository facturationRepo;
		
		Utilisateur utilisateur = new Utilisateur("adri.chataigneau@gmail.com","123456",TypeUtilisateur.CLIENT);
		Client client = new Client ("Chataigneau","Adrien",true,5);
		ClientEvenement clievent = new ClientEvenement();
		Evenement evenement= new Evenement(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-18"),"Bordeaux","Dégustation","C:\\Users\\utilisateur\\Pictures\\Saved Pictures\\louis_burned.png");
		Coordonnee coordonnee= new Coordonnee("Mon Hydromel","Chataigneau","Adrien","0647134045","adri.chataigneau@gmail.com","71 Rue du Quai Bourgeois","33000","Bordeaux","France");
		CommandeClient commandeClient = new CommandeClient(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-16"),Statut.Commande);
		Facturation fact = new Facturation (new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-16"),"REF-45689");
		
	}

}
