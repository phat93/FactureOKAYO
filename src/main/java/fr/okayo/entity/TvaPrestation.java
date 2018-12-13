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
import fr.okayo.entiteComposite.TvaPrestationID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tvaPrestation")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Getter @Setter 
@NoArgsConstructor @ToString 

public class TvaPrestation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
    private TvaPrestationID id;
    private Date dateFacturation = new Date();
    
  //mapping entre prestatio et TvaPrestation
    @ManyToOne
	@MapsId("IdPrestation")
	@JoinColumn(name = "IdPrestation")
	private Prestation prestation;
    
    
    //mapping entre TvaPrestation et tva
    @ManyToOne
	@MapsId("idTva")
	@JoinColumn(name = "idTva")
	private TVA tva;


	/**
	 * @param prestation
	 * @param tva
	 */
	public TvaPrestation(Prestation prestation, TVA tva) {
		super();
		this.prestation = prestation;
		this.tva = tva;
		this.id = new  TvaPrestationID(prestation.getIdPrestation(), tva.getIdTva());
	}
	
}