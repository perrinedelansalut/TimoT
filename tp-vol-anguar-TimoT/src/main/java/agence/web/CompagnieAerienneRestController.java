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

import vol.model.CompagnieAerienne;
import vol.model.dao.CompagnieAerienneDao;

@RestController
public class CompagnieAerienneRestController {

	@Autowired
	private CompagnieAerienneDao compagnieAerienneDao;

	@RequestMapping(value = "/compagnieAerienne/", method = RequestMethod.GET)
	public ResponseEntity<List<CompagnieAerienne>> listAll() {
		List<CompagnieAerienne> compagnieAeriennes = compagnieAerienneDao.findAll();
		if (compagnieAeriennes == null) {
			return new ResponseEntity<List<CompagnieAerienne>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<CompagnieAerienne>>(compagnieAeriennes, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/compagnieAerienne/{id}", method = RequestMethod.GET)
	public ResponseEntity<CompagnieAerienne> get(@PathVariable("id") Integer id) {
		CompagnieAerienne compagnieAerienne = compagnieAerienneDao.find(id);
		if (compagnieAerienne == null) {
			return new ResponseEntity<CompagnieAerienne>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CompagnieAerienne>(compagnieAerienne, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/compagnieAerienne/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody CompagnieAerienne compagnieAerienne, UriComponentsBuilder ucBuilder) {
		if (compagnieAerienne.getId() != null && compagnieAerienneDao.find(compagnieAerienne.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			compagnieAerienneDao.create(compagnieAerienne);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/compagnieAerienne/{id}").buildAndExpand(compagnieAerienne.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/compagnieAerienne/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CompagnieAerienne> update(@PathVariable("id") Integer id, @RequestBody CompagnieAerienne compagnieAerienne) {
		CompagnieAerienne currentCompagnieAerienne = compagnieAerienneDao.find(id);
		if (currentCompagnieAerienne == null) {
			return new ResponseEntity<CompagnieAerienne>(HttpStatus.NOT_FOUND);
		} else {
			currentCompagnieAerienne.setNom(compagnieAerienne.getNom());
			currentCompagnieAerienne = compagnieAerienneDao.update(currentCompagnieAerienne);
			currentCompagnieAerienne = compagnieAerienneDao.find (currentCompagnieAerienne.getId());
			return new ResponseEntity<CompagnieAerienne>(currentCompagnieAerienne, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/compagnieAerienne/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CompagnieAerienne> delete(@PathVariable("id") Integer id) {
		CompagnieAerienne compagnieAerienne = compagnieAerienneDao.find(id);
		if (compagnieAerienne == null) {
			return new ResponseEntity<CompagnieAerienne>(HttpStatus.NOT_FOUND);
		}
		compagnieAerienneDao.delete(compagnieAerienne);
		return new ResponseEntity<CompagnieAerienne>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
