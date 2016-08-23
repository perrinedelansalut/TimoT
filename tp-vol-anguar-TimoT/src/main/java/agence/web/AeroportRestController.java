package agence.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import vol.model.Aeroport;
import vol.model.dao.AeroportDao;


@RestController
public class AeroportRestController {

	@Autowired
	private AeroportDao aeroportDao;

	@RequestMapping(value = "/aeroport/", method = RequestMethod.GET)
	public ResponseEntity<List<Aeroport>> listAll() {
		List<Aeroport> aeroports = aeroportDao.findAll();
		if (aeroports == null) {
			return new ResponseEntity<List<Aeroport>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Aeroport>>(aeroports, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/aeroport/{idAer}", method = RequestMethod.GET)
	public ResponseEntity<Aeroport> get(@PathVariable("idAer") Integer idAer) {
		Aeroport aeroport = aeroportDao.find(idAer);
		if (aeroport == null) {
			return new ResponseEntity<Aeroport>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Aeroport>(aeroport, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/aeroport/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Aeroport aeroport, UriComponentsBuilder ucBuilder) {
		if (aeroport.getIdAer() != null && aeroportDao.find(aeroport.getIdAer()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			aeroportDao.create(aeroport);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/aeroport/{idAer}").buildAndExpand(aeroport.getIdAer()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/aeroport/{idAer}", method = RequestMethod.PUT)
	public ResponseEntity<Aeroport> update(@PathVariable("idAer") Integer idAer, @RequestBody Aeroport aeroport) {
		Aeroport currentAeroport = aeroportDao.find(idAer);
		if (currentAeroport == null) {
			return new ResponseEntity<Aeroport>(HttpStatus.NOT_FOUND);
		} else {
			currentAeroport.setIdAer(currentAeroport.getIdAer());
			currentAeroport.setNom(currentAeroport.getNom());
			currentAeroport = aeroportDao.update(currentAeroport);
			currentAeroport = aeroportDao.find (currentAeroport.getIdAer());
			return new ResponseEntity<Aeroport>(currentAeroport, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/aeroport/{idAer}", method = RequestMethod.DELETE)
	public ResponseEntity<Aeroport> delete(@PathVariable("idAer") Integer idAer) {
		Aeroport aeroport = aeroportDao.find(idAer);
		if (aeroport == null) {
			return new ResponseEntity<Aeroport>(HttpStatus.NOT_FOUND);
		}
		aeroportDao.delete(aeroport);
		return new ResponseEntity<Aeroport>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
