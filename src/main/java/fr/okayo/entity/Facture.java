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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="facture")
@Getter @Setter 
@NoArgsConstructor @ToString 
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@NamedQuery(name="Facture.findByIdFacture", query="SELECT f FROM Facture f WHERE f.idFacture =?1")

public class Facture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture;
	private Date dateFacturation;
    private Date dateEcheance;
    //mapping entre Client et facture
    @XmlTransient
    @ManyToOne
	@JoinColumn(name="idClient")  
    private Client client;
    
    //mapping entre facture et ligne facture
    @OneToMany(mappedBy="facture",fetch=FetchType.LAZY)
  	private List<LigneFacture> listLigFactures;

	public Facture(Date dateFacturation, Date dateEcheance, Client client, List<LigneFacture> listLigFactures) {
		super();
		this.dateFacturation = dateFacturation;
		this.dateEcheance = dateEcheance;
		this.client = client;
	}

    
    




}