package fr.okayo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.okayo.dao.IFactureDao;
import fr.okayo.entity.Facture;

@Component
@Transactional
public class ServiceFacture implements IServiceFacture {
	
	@Autowired
	IFactureDao factureDao;
	
	@Override
	public List<Facture> findAllFacture() {
		return (List<Facture>) factureDao.findAll();
	}

	@Override
	public Facture getFactureByID(Long id) {
		return factureDao.findByIdFacture(id);
	}


	@Override
	public Facture ajouterFacture(Facture facture) {
		factureDao.save(facture); //avec auto_incr de b.id
		return facture;
	}

}
