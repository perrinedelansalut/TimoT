/**
 * 
 */
package vol.model.dao;

import vol.model.Adresse;

/**
 * @author ajc
 *
 */
public interface AdresseDao extends Dao<Adresse, Integer> {

	/**
	 * 
	 */
	public Adresse findById(Integer idAdd);
}
