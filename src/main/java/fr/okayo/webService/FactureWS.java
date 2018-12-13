package fr.okayo.webService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.okayo.entity.Facture;
import fr.okayo.service.IServiceFacture;

@RestController
@RequestMapping(value="/rest/facture" , headers="Accept=application/json")
public class FactureWS {

	@Autowired
	IServiceFacture serviceFacture;
	//web service pour afficher la liste des factures disponible
	//http://localhost:8080/FactureOKAYO/rest/facture
	@GetMapping("")
	public List<Facture> getAllFacture() {
		
		List<Facture> lf = serviceFacture.findAllFacture();	
		return lf;
	}
	
	//URL = /http://localhost:8080/FactureOKAYO/rest/facture/2
	@GetMapping("/{id}")
	public Facture getFactureById(@PathVariable("id")Long id) {
		return serviceFacture.getFactureByID(id);
		
	}
	
	//URL = http://localhost:8080/FactureOKAYO/rest/facture/add
		// avec { "titre" : "nouvelleBlague" , "texte" : "blague ..." }
	/*{"dateFacturation" : '2019-1-01 00:00:00',
		"dateEcheance : '2019-1-01 00:00:00',
		"client" : {idClient: 1}}*/
	@PostMapping("/add")
	public Facture postFacture(@RequestBody Facture facture) {
		serviceFacture.ajouterFacture(facture);
		return facture;
	}

}
