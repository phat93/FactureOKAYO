// mapper la clé primaire composite qui appartient à la table de jointure intermédiaire.
// @Embeddabletype pour contenir l'identifiant d'entité composite
package fr.okayo.entiteComposite;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;
@NoArgsConstructor
@Embeddable

public class TvaPrestationID implements Serializable {

	private static final long serialVersionUID = 1L;
	private long IdPrestation;
	private long idTva;
	
		
	public TvaPrestationID(long idPrestation, long idTva) {
		super();
		this.IdPrestation = idPrestation;
		this.idTva = idTva;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	 
	        if (o == null || getClass() != o.getClass()) 
	            return false;
	 
	        TvaPrestationID that = (TvaPrestationID) o;
	        return Objects.equals(IdPrestation, that.IdPrestation) && 
	               Objects.equals(idTva, that.idTva);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(IdPrestation, idTva);
	    }
	 

}

