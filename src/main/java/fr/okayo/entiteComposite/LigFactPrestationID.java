// mapper la clé primaire composite qui appartient à la table de jointure intermédiaire.
// @Embeddabletype pour contenir l'identifiant d'entité composite
package fr.okayo.entiteComposite;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;
@NoArgsConstructor
@Embeddable

public class LigFactPrestationID implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idLigFacture;
	private long IdPrestation;
	
	public LigFactPrestationID(long idLigFacture, long idOffre) {
		super();
		this.idLigFacture = idLigFacture;
		this.IdPrestation = idOffre;
	}
	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	 
	        if (o == null || getClass() != o.getClass()) 
	            return false;
	 
	        LigFactPrestationID that = (LigFactPrestationID) o;
	        return Objects.equals(idLigFacture, that.idLigFacture) && 
	               Objects.equals(IdPrestation, that.IdPrestation);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(idLigFacture, IdPrestation);
	    }
	 
	 
	 
}
