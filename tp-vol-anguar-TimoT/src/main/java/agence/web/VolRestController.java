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

import vol.model.Vol;
import vol.model.dao.VolDao;

@RestController
public class VolRestController {

	@Autowired
	private VolDao volDao;

	@RequestMapping(value = "/vol/", method = RequestMethod.GET)
	public ResponseEntity<List<Vol>> listAll() {
		List<Vol> vols = volDao.findAll();
		if (vols == null) {
			return new ResponseEntity<List<Vol>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Vol>>(vols, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/vol/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vol> get(@PathVariable("id") Integer idVol) {
		Vol vol = volDao.find(idVol);
		if (vol == null) {
			return new ResponseEntity<Vol>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Vol>(vol, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/vol/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Vol vol, UriComponentsBuilder ucBuilder) {
		if (vol.getIdVol() != null && volDao.find(vol.getIdVol()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			volDao.create(vol);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/vol/{idVol}").buildAndExpand(vol.getIdVol()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/vol/{idVol}", method = RequestMethod.PUT)
	public ResponseEntity<Vol> update(@PathVariable("idVol") Integer idVol, @RequestBody Vol vol) {
		Vol currentVol = volDao.find(idVol);
		if (currentVol == null) {
			return new ResponseEntity<Vol>(HttpStatus.NOT_FOUND);
		} else {
			currentVol.setDateDepart(vol.getDateDepart());
			currentVol.setDateArrivee(vol.getDateArrivee());
			currentVol.setHeureDepart(vol.getHeureDepart());
			currentVol.setHeureArrivee(vol.getHeureArrivee());
			currentVol = volDao.update(currentVol);
			currentVol = volDao.find(currentVol.getIdVol());
			return new ResponseEntity<Vol>(currentVol, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/vol/{idVol}", method = RequestMethod.DELETE)
	public ResponseEntity<Vol> delete(@PathVariable("idVol") Integer idVol) {
		Vol vol = volDao.find(idVol);
		if (vol == null) {
			return new ResponseEntity<Vol>(HttpStatus.NOT_FOUND);
		}
		volDao.delete(vol);
		return new ResponseEntity<Vol>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
