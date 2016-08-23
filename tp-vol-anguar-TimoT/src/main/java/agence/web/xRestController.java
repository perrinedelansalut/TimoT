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

import banque.dao.ClientDao;
import banque.model.Client;

@RestController
public class xRestController {

	@Autowired
	private ClientDao clientDao;

	@RequestMapping(value = "/client/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAll() {
		List<Client> clients = clientDao.findAll();
		if (clients == null) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> get(@PathVariable("id") Long id) {
		Client client = clientDao.find(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/client/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
		if (client.getId() != null && clientDao.find(client.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			clientDao.create(client);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client client) {
		Client currentClient = clientDao.find(id);
		if (currentClient == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			currentClient.setCivilite(client.getCivilite());
			currentClient.setNom(client.getNom());
			currentClient.setPrenom(client.getPrenom());
			currentClient.setDtNaissance(client.getDtNaissance());
			currentClient.setEmail(client.getEmail());
			currentClient.setTelephone(client.getTelephone());
			currentClient.setProfessionnel(client.getProfessionnel());
			currentClient.setAdresse(client.getAdresse());
			currentClient = clientDao.update(currentClient);
			currentClient = clientDao.find (currentClient.getId());
			return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> delete(@PathVariable("id") Long id) {
		Client client = clientDao.find(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		clientDao.delete(client);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
