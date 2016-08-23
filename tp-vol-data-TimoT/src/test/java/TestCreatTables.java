import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.model.Adresse;
import vol.model.Aeroport;
import vol.model.AeroportVille;
import vol.model.ClientEI;
import vol.model.ClientMoral;
import vol.model.ClientPhysique;
import vol.model.CompagnieAerienne;
import vol.model.CompagnieAerienneVol;
import vol.model.Escale;
import vol.model.EtatReservation;
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

public class TestCreatTables {
	public static void main(String[] args) throws ParseException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AeroportDao aeroportDao = (AeroportDao) context.getBean("aeroportDaoJpa");
		AeroportVilleDao aeroportVilleDao = (AeroportVilleDao) context.getBean("aeroportVilleDaoJpa");
		ClientDao clientDao = (ClientDao) context.getBean("clientDaoJpa");
		CompagnieAerienneDao compagnieAerienneDao = (CompagnieAerienneDao) context.getBean("compagnieAerienneDaoJpa");
		CompagnieAerienneVolDao compagnieAerienneVolDao = (CompagnieAerienneVolDao) context.getBean("compagnieAerienneVolDaoJpa");
		EscaleDao escaleDao = (EscaleDao) context.getBean("escaleDaoJpa");
		PassagerDao passagerDao = (PassagerDao) context.getBean("passagerDaoJpa");
		ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDaoJpa");
		VilleDao villeDao = (VilleDao) context.getBean("villeDaoJpa");
		VolDao volDao = (VolDao) context.getBean("volDaoJpa");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
//		Ville ville1 = new Ville();
//		ville1.setIdVil(1000);
//		ville1.setNom("ville1");
//		
//		Ville ville2 = new Ville();
//		ville2.setIdVil(2000);
//		ville2.setNom("ville2");
//		
//		villeDao.create(ville1);
//		villeDao.create(ville2);
//
////-------------------------------------------------------------------------------
//		
//		Aeroport aeroport1 = new Aeroport();
//		aeroport1.setIdAer(11111);
//		aeroport1.setNom("aeroport1");
//		
//		Aeroport aeroport2 = new Aeroport();
//		aeroport2.setIdAer(22222);
//		aeroport2.setNom("aeroport2");
//		
//		aeroportDao.create(aeroport1);
//		aeroportDao.create(aeroport2);
//		
////-------------------------------------------------------------------------------
//
//		Vol vol1 = new Vol();
//		Vol vol2 = new Vol();
//		vol1.setDateDepart(sdf.parse("22/08/2016"));
//		vol1.setDateArrivee(sdf.parse("24/08/2016"));
//		vol1.setAeroportDepart(aeroport1);
//		vol1.setAeroportArrivee(aeroport2);
//		vol2.setDateDepart(sdf.parse("22/08/2017"));
//		vol2.setDateArrivee(sdf.parse("23/08/2017"));
//		vol2.setAeroportDepart(aeroport2);
//		vol2.setAeroportArrivee(aeroport1);
//		volDao.create(vol1);
//		volDao.create(vol2);
//		
//		Escale escale1 = new Escale();
//
//		escale1.setDateDepart(sdf.parse("22/08/2016"));
//		escale1.setDateArrivee(sdf.parse("23/08/2016"));
//		escale1.setId(vol1, aeroport1);
//		
//		escaleDao.create(escale1);
//		
////-----------------------------------------------------------------------------------
//
//		ClientPhysique clientP = new ClientPhysique();
//		clientP.setEmail("un_email_qui_marche");
//		clientP.setLog("Pseudo", "motdepasse", false);
//		clientP.setNom("Roux");
//		clientP.setPrenom("Henry");
//		clientDao.create(clientP);
//		
//		ClientMoral clientM = new ClientMoral();
//		clientM.setEmail("un_autre_email_qui_marche");
//		clientM.setLog("NonExistant", "password", true);
//		clientM.setNom("Johny");
//		clientM.setSiret(4558);
//		clientM.setAdresse(new Adresse("12 rue de la soif", "12345", "Bordeaux", "France"));
//		clientM.setNumeroFax("123456789");
//		clientM.setNumeroTel("456789123");
//		clientM.setTitre(Titre.M);
//		clientDao.create(clientM);
//		
//		ClientEI clientEI = new ClientEI();
//		clientEI.setEmail("j'ai_plus_d'idée");
//		clientEI.setLog("Salut", "56qioerjg^q", false);
//		clientEI.setNom("John");
//		clientEI.setPrenom("Preston");
//		clientEI.setAdresse(new Adresse("15 boulevard truden", "45678", "Clermont", "France"));
//		clientEI.setNumeroFax("45678913");
//		clientEI.setNumeroTel("987456312");
//		clientDao.create(clientEI);
//		
//		clientEI.setNom("UnBeauNomARalonge");
//		clientEI = (ClientEI) clientDao.update(clientEI);
//		
//		
//		clientDao.delete(clientP);
//		
////-------------------------------------------------------------------------------
//		
//		Passager passager1 = new Passager();
//		
//		passager1.setNom("nomPassager1");
//		passager1.setPrenom("prenomPassager1");
//		
//		Adresse adresse1 = new Adresse();
//		
//		adresse1.setAdresse("rue");
//		adresse1.setCodePostal("11111");
//		adresse1.setVille("Paris");
//		adresse1.setPays("france");
//		
//		passager1.setAdresse(adresse1);
//		
//		passagerDao.create(passager1);
//		
//		Passager passager2 = new Passager();
//		
//		passager2.setNom("nomPassager2");
//		passager2.setPrenom("prenomPassager2");
//		
//		Adresse adresse2 = new Adresse();
//		
//		adresse2.setAdresse("rue2");
//		adresse2.setCodePostal("222222");
//		adresse2.setVille("Paris");
//		adresse2.setPays("france");
//		
//		passager2.setAdresse(adresse2);
//		
//		passagerDao.create(passager2);
////-------------------------------------------------------------------------------
//		
//		AeroportVille aeroportVille1 = new AeroportVille();
//		AeroportVille aeroportVille2 = new AeroportVille();
//		aeroportVille1.setAeroport(aeroport1);
//		aeroportVille2.setAeroport(aeroport2);
//		aeroportVille1.setVille(ville1);
//		aeroportVille2.setVille(ville2);
//		
//		aeroportVilleDao.create(aeroportVille1);
//		aeroportVilleDao.create(aeroportVille2);
//		
////-------------------------------------------------------------------------------		
//		
//
//		
//
//		
//
//		
//		
//		
//		
//
//
////-------------------------------------------------------------------------------		
//		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
//		compagnieAerienne.setNom("Air France");
//		
//		compagnieAerienneDao.create(compagnieAerienne);
//		
//		CompagnieAerienneVol compagnieAerienneVol = new CompagnieAerienneVol(compagnieAerienne, vol1);
//		compagnieAerienneVol.setNumero("123456789");
//		compagnieAerienneVol.setOuvert(true);
//		
//		compagnieAerienneVolDao.create(compagnieAerienneVol);
//
//		
//
//
////----------------------------------------------------------------------------
		
		Reservation reservation = new Reservation();
		reservation.setDate(sdf.parse("03/08/2016"));
		reservation.setNumero("13456798");
		//reservation.setClient(clientEI);
		//reservation.setPassager(passager1);
		//reservation.setVol(vol1);
		reservation.setEtatReservation(EtatReservation.ouvert);
		
		reservationDao.create(reservation);
		
		
		context.close();

	}

}
