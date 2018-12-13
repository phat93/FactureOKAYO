package fr.okayo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.okayo.entity.Facture;

public interface IFactureDao extends CrudRepository<Facture, Long> {
	Facture findByIdFacture(Long id);
	
}
