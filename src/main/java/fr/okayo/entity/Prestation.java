package fr.okayo.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="prestation")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Getter @Setter 
@NoArgsConstructor @ToString 

public class Prestation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long IdPrestation;
    private String intitule;
    
	public Prestation(String intitule, double prix) {
		super();
		this.intitule = intitule;
		this.prix = prix;
	}
	
    private double prix;
    @ManyToOne
	@JoinColumn(name="idOffre")
    private Catalogue catalogue;
    
    //mapping entre prestation et LigFactPrestation
    @OneToMany(mappedBy="prestation",fetch=FetchType.LAZY)
   	private List<LigneFacturePrestation> listLigFactPrestation;
    
    
    //mapping entre Prestation et TvaPrestation
    @OneToMany(mappedBy="prestation",fetch=FetchType.LAZY)
   	private List<TvaPrestation> listTvaPrestation;

    public void addTVA(TVA tva) {
    	//on ajoute une nouvelle ligne tva et prestation encours dans tvaPrsetation
        TvaPrestation tvaPrestation = new TvaPrestation(this, tva);
        listTvaPrestation.add(tvaPrestation);
        tva.getListTvaPrestation().add(tvaPrestation);
    }
    
    
    
}