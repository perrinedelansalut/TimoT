import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.List;

	import org.junit.Assert;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vol.model.Aeroport;
import vol.model.CompagnieAerienne;
import vol.model.Reservation;
import vol.model.Ville;
import vol.model.Vol;
import vol.model.dao.AeroportDao;
import vol.model.dao.CompagnieAerienneDao;
import vol.model.dao.ReservationDao;
import vol.model.dao.VilleDao;
import vol.model.dao.VolDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")	




public class TestAutres {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		@Autowired
		private AeroportDao aeroportDao;

		@Test
		public void aeroport() throws ParseException {
			Aeroport aeroport1 = new Aeroport();
			aeroport1.setNom("aeroport1");

			// INSERT
			aeroportDao.create(aeroport1);

			// SELECT
			aeroport1 = (Aeroport) aeroportDao.find(aeroport1.getIdAer());

			
			Assert.assertNotNull(aeroport1);

			Assert.assertEquals("aeroport1", aeroport1.getNom());
			
			

			aeroport1.setNom("aeroport11");
			

			// UPDATE
			aeroportDao.update(aeroport1);

			// SELECT
			aeroport1 = (Aeroport) aeroportDao.find(aeroport1.getIdAer());

			Assert.assertNotNull(aeroport1);

			Assert.assertEquals("aeroport11", aeroport1.getNom());
			

			List<Aeroport> aeroports = aeroportDao.findAll();

			Assert.assertEquals(1, aeroports.size());

			aeroportDao.delete(aeroport1);

			aeroport1 = (Aeroport) aeroportDao.find(aeroport1.getIdAer());

			Assert.assertNull(aeroport1);

		}

		@Autowired
		private VilleDao villeDao;
		
		@Test
		public void ville() throws ParseException {
			Ville ville1 = new Ville();
			ville1.setNom("ville1");

			// INSERT
			villeDao.create(ville1);

			// SELECT
			ville1 = (Ville) villeDao.find(ville1.getIdVil());

			// Assert.assertEquals(depot, depotFind);
			Assert.assertNotNull(ville1);

			Assert.assertEquals("ville1", ville1.getNom());

			

			ville1.setNom("ville1.0");


			// UPDATE
			villeDao.update(ville1);

			// SELECT
			ville1 = (Ville) villeDao.find(ville1.getIdVil());

			Assert.assertNotNull(ville1);

			Assert.assertEquals("ville1.0", ville1.getNom());


			List<Ville> villes = villeDao.findAll();

			Assert.assertEquals(1, villes.size());

			villeDao.delete(ville1);

			ville1 = (Ville) villeDao.find(ville1.getIdVil());

			Assert.assertNull(ville1);

		}
		
		@Autowired
		private CompagnieAerienneDao compagnieAerienneDao;
		
		@Test
		public void compagnieAerienne() throws ParseException {
			CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
			compagnieAerienne.setNom("Air France");
			

			// INSERT
			compagnieAerienneDao.create(compagnieAerienne);

			// SELECT
			compagnieAerienne = (CompagnieAerienne) compagnieAerienneDao.find(compagnieAerienne.getId());

			// Assert.assertEquals(depot, depotFind);
			Assert.assertNotNull(compagnieAerienne);

			Assert.assertEquals("Air France", compagnieAerienne.getNom());
			
			

			compagnieAerienne.setNom("Air-France");
			

			// UPDATE
			compagnieAerienneDao.update(compagnieAerienne);

			// SELECT
			compagnieAerienne = (CompagnieAerienne) compagnieAerienneDao.find(compagnieAerienne.getId());

			Assert.assertNotNull(compagnieAerienne);

			Assert.assertEquals("Air-France", compagnieAerienne.getNom());
			

			List<CompagnieAerienne> compagnies = compagnieAerienneDao.findAll();

			Assert.assertEquals(1, compagnies.size());

			compagnieAerienneDao.delete(compagnieAerienne);

			compagnieAerienne = (CompagnieAerienne) compagnieAerienneDao.find(compagnieAerienne.getId());

			Assert.assertNull(compagnieAerienne);

		}
		
		@Autowired
		private VolDao volDao;
		
		@Test
		public void vol() throws ParseException {
			
			
			
			Vol vol1 = new Vol();
			vol1.setDateDepart(sdf.parse("22/08/2016"));
			vol1.setDateArrivee(sdf.parse("24/08/2016"));

			

			// INSERT
			volDao.create(vol1);

			// SELECT
			vol1 = (Vol) volDao.find(vol1.getIdVol());

			// Assert.assertEquals(depot, depotFind);
			Assert.assertNotNull(vol1);


			Assert.assertEquals(sdf.parse("22/08/2016"), vol1.getDateDepart());
			Assert.assertEquals(sdf.parse("24/08/2016"), vol1.getDateArrivee());

			vol1.setDateDepart(sdf.parse("22/09/2016"));
			vol1.setDateArrivee(sdf.parse("23/09/2016"));

			// UPDATE
			volDao.update(vol1);

			// SELECT
			vol1 = (Vol) volDao.find(vol1.getIdVol());

			Assert.assertNotNull(vol1);


			Assert.assertEquals(sdf.parse("22/09/2016"), vol1.getDateDepart());
			Assert.assertEquals(sdf.parse("23/09/2016"), vol1.getDateArrivee());

			List<Vol> vols = volDao.findAll();

			Assert.assertEquals(1, vols.size());

			volDao.delete(vol1);

			vol1 = (Vol) volDao.find(vol1.getIdVol());

			Assert.assertNull(vol1);

		}
		
		@Autowired
		private ReservationDao reservationDao;
		
		@Test
		public void reservation() throws ParseException {
			
			
			
			Reservation resa = new Reservation();
			resa.setDate(sdf.parse("22/04/2016"));
			resa.setNumero("262518");

			

			// INSERT
			reservationDao.create(resa);

//			// SELECT
//			resa = (Reservation) reservationDao.find(resa.getIdRes());
//
//			// Assert.assertEquals(depot, depotFind);
//			Assert.assertNotNull(vol1);
//
//
//			Assert.assertEquals(sdf.parse("22/08/2016"), vol1.getDateDepart());
//			Assert.assertEquals(sdf.parse("24/08/2016"), vol1.getDateArrivee());
//
//			vol1.setDateDepart(sdf.parse("22/09/2016"));
//			vol1.setDateArrivee(sdf.parse("23/09/2016"));
//
//			// UPDATE
//			volDao.update(vol1);
//
//			// SELECT
//			vol1 = (Vol) volDao.find(vol1.getIdVol());
//
//			Assert.assertNotNull(vol1);
//
//
//			Assert.assertEquals(sdf.parse("22/09/2016"), vol1.getDateDepart());
//			Assert.assertEquals(sdf.parse("23/09/2016"), vol1.getDateArrivee());
//
//			List<Vol> vols = volDao.findAll();
//
//			Assert.assertEquals(1, vols.size());
//
//			volDao.delete(vol1);
//
//			vol1 = (Vol) volDao.find(vol1.getIdVol());
//
//			Assert.assertNull(vol1);

		}


}



