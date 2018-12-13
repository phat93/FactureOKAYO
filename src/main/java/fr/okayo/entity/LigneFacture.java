package fr.okayo.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ligneFacture")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Getter @Setter 
@NoArgsConstructor @ToString 

public class LigneFacture implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idLigFacture;
    private long quantite;
    private double reduction;
    
    
	public LigneFacture(long quantite, double reduction) {
		super();
		this.quantite = quantite;
		this.reduction = reduction;
	}

	//mapping entre lignFacture et facture @ManyToOne	
	@ManyToOne
	@JoinColumn(name="idFacture")
	private Facture facture;
	
	//mapping entre ligneFacture et catalogue
    @ManyToMany
	@JoinTable(name="LigneFacture_Catalogue",
	     joinColumns= {@JoinColumn(name="idLigFacture")} ,
	     inverseJoinColumns = {@JoinColumn(name="idOffre")})
	private List<Catalogue> ListCatalogue;
   
    //mapping entre ligneFacture et LigFactPrestation
    @OneToMany(mappedBy="ligneFacture",fetch=FetchType.LAZY)
   	private List<LigneFacturePrestation> listLigFactPrestation;
    
    public void addPrestation(Prestation prestation) {
    	//on ajoute une nouvelle ligne prestation avec la ligneFacture encours et le prsetation dans listLigFactPrestation
    	LigneFacturePrestation ligFactPrestation = new LigneFacturePrestation(this, prestation);
    	listLigFactPrestation.add(ligFactPrestation);
        prestation.getListLigFactPrestation().add(ligFactPrestation);
    }
   
}