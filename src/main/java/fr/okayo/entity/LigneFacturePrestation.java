package fr.okayo.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import fr.okayo.entiteComposite.LigFactPrestationID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="LigneFacturePrestation")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Getter @Setter 
@NoArgsConstructor @ToString 
 
public class LigneFacturePrestation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private LigFactPrestationID id;
	
    private Date dateFacturation= new Date();
    
    //mapping entre ligFacture; lignFactPrestation 
    @ManyToOne
	@MapsId("idLigFacture")
	@JoinColumn(name = "idLigFacture")
	private LigneFacture ligneFacture;
    
    
    //mapping entre lignFactPrestation et prestation
    @ManyToOne
	@MapsId("IdPrestation")
	@JoinColumn(name = "IdPrestation")
	private Prestation prestation;

	public LigneFacturePrestation(LigneFacture ligneFacture, Prestation prestation) {
		super();
		this.ligneFacture = ligneFacture;
		this.prestation = prestation;
		this.id = new  LigFactPrestationID(ligneFacture.getIdLigFacture(), prestation.getIdPrestation());
	}
	
	
    
}