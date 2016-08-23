package banque.web;

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

import banque.dao.AgenceDao;
import banque.model.Agence;
import banque.model.AgenceId;
import banque.model.Client;

@RestController
public class AgenceRestController {

	@Autowired
	private AgenceDao agenceDao;

	@RequestMapping(value = "/agence/", method = RequestMethod.GET)
	public ResponseEntity<List<Agence>> listAll() {
		List<Agence> agences = agenceDao.findAll();
		if (agences == null) {
			return new ResponseEntity<List<Agence>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Agence>>(agences, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/agence/{numBanque}&{numAgence}", method = RequestMethod.GET)
	public ResponseEntity<Agence> get(@PathVariable("numBanque") String numBanque, @PathVariable("numAgence") String numAgence) {
		Agence agence = agenceDao.find(new AgenceId(numBanque, numAgence));
		if (agence == null) {
			return new ResponseEntity<Agence>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Agence>(agence, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/agence/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Agence agence, UriComponentsBuilder ucBuilder) {
		if (agence.getNumBanque() != null && agence.getNumAgence() != null && agenceDao.find(new AgenceId(agence.getNumBanque(), agence.getNumAgence())) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			agenceDao.create(agence);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/agence/{numBanque}&{numAgence}").buildAndExpand(agence.getNumBanque(), agence.getNumAgence()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/agence/{numBanque}&{numAgence}", method = RequestMethod.PUT)
	public ResponseEntity<Agence> update(@PathVariable("numBanque") String numBanque, @PathVariable("numAgence") String numAgence, @RequestBody Agence agence) {
		Agence currentAgence = agenceDao.find(new AgenceId(numBanque, numAgence));
		if (currentAgence == null) {
			return new ResponseEntity<Agence>(HttpStatus.NOT_FOUND);
		} else {
			currentAgence.setNumBanque(agence.getNumBanque());
			currentAgence.setNumAgence(agence.getNumAgence());
			currentAgence.setLibelle(agence.getLibelle());
			currentAgence.setHoraires(agence.getHoraires());
			currentAgence.setAdresse(agence.getAdresse());
			currentAgence = agenceDao.update(currentAgence);
			currentAgence = agenceDao.find(new AgenceId(currentAgence.getNumBanque(), currentAgence.getNumAgence()));
			return new ResponseEntity<Agence>(currentAgence, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/agence/{numBanque}&{numAgence}", method = RequestMethod.DELETE)
	public ResponseEntity<Agence> delete(@PathVariable("numBanque") String numBanque, @PathVariable("numAgence") String numAgence) {
		Agence agence = agenceDao.find(new AgenceId(numBanque, numAgence));
		if (agence == null) {
			return new ResponseEntity<Agence>(HttpStatus.NOT_FOUND);
		}
		agenceDao.delete(agence);
		return new ResponseEntity<Agence>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
