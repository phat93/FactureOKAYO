package fr.okayo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.okayo.entity.Facture;
@Service
public interface IServiceFacture {
	List<Facture> findAllFacture();
	Facture getFactureByID(Long id);
	Facture ajouterFacture(Facture facture);
}
