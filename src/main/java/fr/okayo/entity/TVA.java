package fr.okayo.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tva")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Getter @Setter 
@NoArgsConstructor @ToString 
public class TVA  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idTva;
	private double tauxTva;
	private Date dateDebut;
	private Date dateFin;

	//mapping entre TVA et TvaPrestation
	@OneToMany(mappedBy="tva",fetch=FetchType.LAZY)
  	private List<TvaPrestation> listTvaPrestation;


	public TVA(double tauxTva, Date dateDebut, Date dateFin) {
		super();
		this.tauxTva = tauxTva;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	
}