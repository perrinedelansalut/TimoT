

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vol.model.Adresse;
import vol.model.Aeroport;
import vol.model.AeroportVille;
import vol.model.Client;
import vol.model.ClientEI;
import vol.model.ClientMoral;
import vol.model.ClientPhysique;
import vol.model.CompagnieAerienne;
import vol.model.CompagnieAerienneVol;
import vol.model.Escale;
import vol.model.Login;
import vol.model.Passager;
import vol.model.Reservation;
import vol.model.Titre;
import vol.model.Ville;
import vol.model.Vol;
import vol.model.dao.AeroportDao;
import vol.model.dao.AeroportVilleDao;
import vol.model.dao.ClientDao;
import vol.model.dao.CompagnieAerienneDao;
import vol.model.dao.CompagnieAerienneVolDao;
import vol.model.dao.EscaleDao;
import vol.model.dao.PassagerDao;
import vol.model.dao.ReservationDao;
import vol.model.dao.VilleDao;
import vol.model.dao.VolDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestClient {
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private AeroportDao aeroportDao;
	@Autowired
	private AeroportVilleDao aeroportVilleDao;
	@Autowired
	private PassagerDao passagerDao;
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private VilleDao villeDao;
	@Autowired
	private VolDao volDao;
	
	@Test
	public void lien() throws ParseException{
		ClientEI client1 = new ClientEI();
		ClientPhysique clientP1 = new ClientPhysique();
		ClientMoral clientM1 = new ClientMoral();
		clientDao.create(client1);
		clientDao.create(clientP1);
		clientDao.create(clientM1);
		Aeroport aeroport1 = new Aeroport();
		Aeroport aeroport2 = new Aeroport();
		aeroportDao.create(aeroport1);
		aeroportDao.create(aeroport2);
		AeroportVille aeroportVille1 = new AeroportVille();
		

		Passager p1 = new Passager();
		Passager p2 = new Passager();
		passagerDao.create(p1);
		passagerDao.create(p2);
		Reservation resa1 = new Reservation();
		
		Ville ville1 = new Ville();
		Ville ville2 = new Ville();
		villeDao.create(ville1);
		villeDao.create(ville2);
		Vol vol1 = new Vol();
		Vol vol2 = new Vol();
		volDao.create(vol1);
		volDao.create(vol2);
		
		//reservation
		resa1.setClient(client1);
		resa1.setPassager(p1);
		resa1.setVol(vol1);
		
		//Insert
		reservationDao.create(resa1);
		
		
		//Select
		resa1 = reservationDao.find(resa1.getIdRes());
		
		Assert.assertNotNull(resa1);
		Assert.assertEquals(client1.getIdCli(), resa1.getClient().getIdCli());
		Assert.assertEquals(p1.getIdPas(), resa1.getPassager().getIdPas());
		Assert.assertEquals(vol1.getIdVol(), resa1.getVol().getIdVol());
		
		resa1.setClient(clientP1);
		resa1.setPassager(p2);
		resa1.setVol(vol2);
		
		//Update
		reservationDao.update(resa1);
		
		//Select
		resa1 = reservationDao.find(resa1.getIdRes());
		
		Assert.assertNotNull(resa1);
		Assert.assertEquals(clientP1.getIdCli(), resa1.getClient().getIdCli());
		Assert.assertEquals(p2.getIdPas(), resa1.getPassager().getIdPas());
		Assert.assertEquals(vol2.getIdVol(), resa1.getVol().getIdVol());
		
	
		
		resa1.setClient(clientM1);
		resa1.setPassager(p2);
		resa1.setVol(vol2);
		
		//Update
		resa1 = reservationDao.update(resa1);
		
		Assert.assertNotNull(resa1);
		Assert.assertEquals(clientM1.getIdCli(), resa1.getClient().getIdCli());
		Assert.assertEquals(p2.getIdPas(), resa1.getPassager().getIdPas());
		Assert.assertEquals(vol2.getIdVol(), resa1.getVol().getIdVol());
		
		List<Reservation> reservations = reservationDao.findAll();
		
		Assert.assertEquals(1, reservations.size());
		
//		reservationDao.update(resa1);
		reservationDao.delete(resa1);
		
		resa1 = reservationDao.find(resa1.getIdRes());
		
		Assert.assertNull(resa1);
		
		//aeroport ville
		aeroportVille1.setAeroport(aeroport1);
		aeroportVille1.setVille(ville1);
		
		//insert
		aeroportVilleDao.create(aeroportVille1);
		
		//select
		aeroportVille1 = aeroportVilleDao.find(aeroportVille1.getId());
		Assert.assertNotNull(aeroportVille1);
		Assert.assertEquals(aeroport1.getIdAer(), aeroportVille1.getAeroport().getIdAer());
		Assert.assertEquals(ville1.getIdVil(), aeroportVille1.getVille().getIdVil());
		
		//update
		aeroportVille1.setAeroport(aeroport2);
		aeroportVille1.setVille(ville2);
		
		aeroportVilleDao.update(aeroportVille1);
		
		aeroportVille1 = aeroportVilleDao.find(aeroportVille1.getId());
		Assert.assertNotNull(aeroportVille1);
		Assert.assertEquals(aeroport2.getIdAer(), aeroportVille1.getAeroport().getIdAer());
		Assert.assertEquals(ville2.getIdVil(), aeroportVille1.getVille().getIdVil());
		
		List<AeroportVille> aeroportVilles = aeroportVilleDao.findAll();
		Assert.assertEquals(1, aeroportVilles.size());
		
		aeroportVilleDao.delete(aeroportVille1);
		aeroportVille1 = aeroportVilleDao.find(aeroportVille1.getId());
		Assert.assertNull(aeroportVille1);
	
		
		
		
		
		clientDao.delete(client1);
		clientDao.delete(clientM1);
		clientDao.delete(clientP1);
		
		passagerDao.delete(p1);
		passagerDao.delete(p2);
		
		volDao.delete(vol1);
		volDao.delete(vol2);
		
		
		villeDao.delete(ville1);
		villeDao.delete(ville2);
		aeroportDao.delete(aeroport2);
		aeroportDao.delete(aeroport1);
		
	}

	@Test
	public void client() throws ParseException {
		
		//client EI
		ClientEI clientEI = new ClientEI();
		clientEI.setAdresse(new Adresse("12 boulevard truden", "15456", "Toulouse", "France"));
		clientEI.setEmail("darksatan666@hotmail.com");
		clientEI.setLog("login", "motdepasse", false);
		clientEI.setNom("Nom");
		clientEI.setNumeroFax("123456789");
		clientEI.setNumeroTel("456123");
		clientEI.setPrenom("Prenom");
		clientEI.setTitre(Titre.M);

		// INSERT
		clientDao.create(clientEI);

		// SELECT
		clientEI = (ClientEI) clientDao.find(clientEI.getIdCli());

		// Assert.assertEquals(depot, depotFind);
		Assert.assertNotNull(clientEI);

		Assert.assertEquals(new  Adresse("12 boulevard truden", "15456", "Toulouse", "France"), clientEI.getAdresse());
		Assert.assertEquals("darksatan666@hotmail.com", clientEI.getEmail());
		Assert.assertEquals(new Login("login", "motdepasse", false), clientEI.getLog());
		Assert.assertEquals("Nom", clientEI.getNom());
		Assert.assertEquals("123456789", clientEI.getNumeroFax());
		Assert.assertEquals("456123", clientEI.getNumeroTel());
		Assert.assertEquals("Prenom", clientEI.getPrenom());
		Assert.assertEquals("Monsieur", clientEI.getTitre().getLabel());
		
		
		
		clientEI.setAdresse(new Adresse("12 boulevard truden1", "154561", "Toulouse1", "France1"));
		clientEI.setEmail("darksatan666@hotmail.com1");
		clientEI.setLog("login1", "motdepasse1", true);
		clientEI.setNom("Nom1");
		clientEI.setNumeroFax("1234567891");
		clientEI.setNumeroTel("4561231");
		clientEI.setPrenom("Prenom1");
		clientEI.setTitre(Titre.MME);
		

		// UPDATE
		clientDao.update(clientEI);

		// SELECT
		clientEI = (ClientEI) clientDao.find(clientEI.getIdCli());

		Assert.assertNotNull(clientEI);

		Assert.assertEquals(new  Adresse("12 boulevard truden1", "154561", "Toulouse1", "France1"), clientEI.getAdresse());
		Assert.assertEquals("darksatan666@hotmail.com1", clientEI.getEmail());
		Assert.assertEquals(new Login("login1", "motdepasse1", true), clientEI.getLog());
		Assert.assertEquals("Nom1", clientEI.getNom());
		Assert.assertEquals("1234567891", clientEI.getNumeroFax());
		Assert.assertEquals("4561231", clientEI.getNumeroTel());
		Assert.assertEquals("Prenom1", clientEI.getPrenom());
		Assert.assertEquals("Madame", clientEI.getTitre().getLabel());

		List<Client> clients = clientDao.findAll();

		Assert.assertEquals(1, clients.size());

		clientDao.delete(clientEI);

		clientEI = (ClientEI) clientDao.find(clientEI.getIdCli());

		Assert.assertNull(clientEI);
		
		//client Physique
		ClientPhysique clientP = new ClientPhysique();
		clientP.setAdresse(new Adresse("12 boulevard truden", "15456", "Toulouse", "France"));
		clientP.setEmail("darksatan666@hotmail.com");
		clientP.setLog("login", "motdepasse", false);
		clientP.setNom("Nom");
		clientP.setNumeroFax("123456789");
		clientP.setNumeroTel("456123");
		clientP.setPrenom("Prenom");
		clientP.setTitre(Titre.M);

		// INSERT
		clientDao.create(clientP);

		// SELECT
		clientP = (ClientPhysique) clientDao.find(clientP.getIdCli());

		// Assert.assertEquals(depot, depotFind);
		Assert.assertNotNull(clientP);

		Assert.assertEquals(new  Adresse("12 boulevard truden", "15456", "Toulouse", "France"), clientP.getAdresse());
		Assert.assertEquals("darksatan666@hotmail.com", clientP.getEmail());
		Assert.assertEquals(new Login("login", "motdepasse", false), clientP.getLog());
		Assert.assertEquals("Nom", clientP.getNom());
		Assert.assertEquals("123456789", clientP.getNumeroFax());
		Assert.assertEquals("456123", clientP.getNumeroTel());
		Assert.assertEquals("Prenom", clientP.getPrenom());
		Assert.assertEquals("Monsieur", clientP.getTitre().getLabel());
		
		
		
		clientP.setAdresse(new Adresse("12 boulevard truden1", "154561", "Toulouse1", "France1"));
		clientP.setEmail("darksatan666@hotmail.com1");
		clientP.setLog("login1", "motdepasse1", true);
		clientP.setNom("Nom1");
		clientP.setNumeroFax("1234567891");
		clientP.setNumeroTel("4561231");
		clientP.setPrenom("Prenom1");
		clientP.setTitre(Titre.MME);
		

		// UPDATE
		clientDao.update(clientP);

		// SELECT
		clientP = (ClientPhysique) clientDao.find(clientP.getIdCli());

		Assert.assertNotNull(clientP);

		Assert.assertEquals(new  Adresse("12 boulevard truden1", "154561", "Toulouse1", "France1"), clientP.getAdresse());
		Assert.assertEquals("darksatan666@hotmail.com1", clientP.getEmail());
		Assert.assertEquals(new Login("login1", "motdepasse1", true), clientP.getLog());
		Assert.assertEquals("Nom1", clientP.getNom());
		Assert.assertEquals("1234567891", clientP.getNumeroFax());
		Assert.assertEquals("4561231", clientP.getNumeroTel());
		Assert.assertEquals("Prenom1", clientP.getPrenom());
		Assert.assertEquals("Madame", clientP.getTitre().getLabel());

		List<Client> clientPs = clientDao.findAll();

		Assert.assertEquals(1, clientPs.size());

		clientDao.delete(clientP);

		clientP = (ClientPhysique) clientDao.find(clientP.getIdCli());

		Assert.assertNull(clientP);
		
		//client moral
		ClientMoral clientM = new ClientMoral();
		clientM.setAdresse(new Adresse("12 boulevard truden", "15456", "Toulouse", "France"));
		clientM.setEmail("darksatan666@hotmail.com");
		clientM.setLog("login", "motdepasse", false);
		clientM.setNom("Nom");
		clientM.setNumeroFax("123456789");
		clientM.setNumeroTel("456123");
		clientM.setSiret(123456);
		clientM.setTitre(Titre.M);

		// INSERT
		clientDao.create(clientM);

		// SELECT
		clientM = (ClientMoral) clientDao.find(clientM.getIdCli());

		// Assert.assertEquals(depot, depotFind);
		Assert.assertNotNull(clientM);

		Assert.assertEquals(new  Adresse("12 boulevard truden", "15456", "Toulouse", "France"), clientM.getAdresse());
		Assert.assertEquals("darksatan666@hotmail.com", clientM.getEmail());
		Assert.assertEquals(new Login("login", "motdepasse", false), clientM.getLog());
		Assert.assertEquals("Nom", clientM.getNom());
		Assert.assertEquals("123456789", clientM.getNumeroFax());
		Assert.assertEquals("456123", clientM.getNumeroTel());
		Assert.assertEquals((Integer) 123456, (Integer) clientM.getSiret());
		Assert.assertEquals("Monsieur", clientM.getTitre().getLabel());
		
		
		
		clientM.setAdresse(new Adresse("12 boulevard truden1", "154561", "Toulouse1", "France1"));
		clientM.setEmail("darksatan666@hotmail.com1");
		clientM.setLog("login1", "motdepasse1", true);
		clientM.setNom("Nom1");
		clientM.setNumeroFax("1234567891");
		clientM.setNumeroTel("4561231");
		clientM.setSiret(1234561);
		clientM.setTitre(Titre.MME);
		

		// UPDATE
		clientDao.update(clientM);

		// SELECT
		clientM = (ClientMoral) clientDao.find(clientM.getIdCli());

		Assert.assertNotNull(clientM);

		Assert.assertEquals(new  Adresse("12 boulevard truden1", "154561", "Toulouse1", "France1"), clientM.getAdresse());
		Assert.assertEquals("darksatan666@hotmail.com1", clientM.getEmail());
		Assert.assertEquals(new Login("login1", "motdepasse1", true), clientM.getLog());
		Assert.assertEquals("Nom1", clientM.getNom());
		Assert.assertEquals("1234567891", clientM.getNumeroFax());
		Assert.assertEquals("4561231", clientM.getNumeroTel());
		Assert.assertEquals((Integer) 1234561, (Integer) clientM.getSiret());
		Assert.assertEquals("Madame", clientM.getTitre().getLabel());

		List<Client> clientMs = clientDao.findAll();

		Assert.assertEquals(1, clientMs.size());

		clientDao.delete(clientM);

		clientM = (ClientMoral) clientDao.find(clientM.getIdCli());

		Assert.assertNull(clientM);

	}
	
	
}
