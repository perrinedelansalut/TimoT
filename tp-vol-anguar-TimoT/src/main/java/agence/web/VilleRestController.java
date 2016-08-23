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


import vol.model.Ville;
import vol.model.dao.VilleDao;

@RestController
public class VilleRestController {

	@Autowired
	private VilleDao villeDao;

	@RequestMapping(value = "/ville/", method = RequestMethod.GET)
	public ResponseEntity<List<Ville>> listAll() {
		List<Ville> villes = villeDao.findAll();
		if (villes == null) {
			return new ResponseEntity<List<Ville>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Ville>>(villes, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/ville/{idVil}", method = RequestMethod.GET)
	public ResponseEntity<Ville> get(@PathVariable("idVil") Integer idVil) {
		Ville ville = villeDao.find(idVil);
		if (ville == null) {
			return new ResponseEntity<Ville>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Ville>(ville, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/ville/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Ville ville, UriComponentsBuilder ucBuilder) {
		if (ville.getIdVil() != null && villeDao.find(ville.getIdVil()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			villeDao.create(ville);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/ville/{idVil}").buildAndExpand(ville.getIdVil()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/ville/{idVil}", method = RequestMethod.PUT)
	public ResponseEntity<Ville> update(@PathVariable("idVil") Integer idVil, @RequestBody Ville ville) {
		Ville currentVille = villeDao.find(idVil);
		if (currentVille == null) {
			return new ResponseEntity<Ville>(HttpStatus.NOT_FOUND);
		} else {
			currentVille.setNom(ville.getNom());
			currentVille = villeDao.update(currentVille);
			currentVille = villeDao.find (currentVille.getIdVil());
			return new ResponseEntity<Ville>(currentVille, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/ville/{idVil}", method = RequestMethod.DELETE)
	public ResponseEntity<Ville> delete(@PathVariable("idVil") Integer idVil) {
		Ville ville = villeDao.find(idVil);
		if (ville == null) {
			return new ResponseEntity<Ville>(HttpStatus.NOT_FOUND);
		}
		villeDao.delete(ville);
		return new ResponseEntity<Ville>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
