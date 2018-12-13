package fr.okayo.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="catalogue")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Getter @Setter 
@NoArgsConstructor @ToString 
public class Catalogue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idOffre;
    private String offre;
    
    //mapping entre catalogue et prestation
    @OneToMany(mappedBy="catalogue",fetch=FetchType.LAZY)
   	private List<Prestation> listPrestations;
    
    //mapping entre catalogue et ligneFacture
    @ManyToMany(mappedBy="ListCatalogue")
	private List<LigneFacture> ligneFactures;
	

	
	public Catalogue(String offre) {
		super();
		this.offre = offre;
	}
  
   





}