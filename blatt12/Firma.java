/******************************  Firma.java  **********************************/

import AlgoTools.IO;

/**
 * @version	17.01.16
 *
 * @author	dmelchior
 * @author	coelker
 */

public class Firma implements Comparable {
	private String name;
	private long annual, usid;

	/**
	 * Erstellt neue Firma
	 *
	 * @param name Name der Firma
	 * @param annual Jahresumsatz
	 * @param usid Umsatzsteueridentifikationsnummer
	 */
	Firma(String name, long annual, long usid) {
		setName(name);
		setAnnual(annual);
		setUSID(usid);
	}

	/**
	 * Namen der Firma ändern
	 * @param name Name der Firma
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Jahresumsatz der Firma ändern
	 * @param annual Jahresumsatz
	 */
	public void setAnnual(long annual) {
		this.annual = annual;
	}

	/**
	 * Umsatzsteueridentifikationsnummer der Firma ändern
	 * @param usid Umsatzsteueridentifikationsnummer
	 */
	public void setUSID(long usid) {
		this.usid = usid;
	}

	/**
	 * Gibt Namen der Firma zurück
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gibt Jahresumsatz der Firma zurück
	 * @return Jahresumsatz
	 */
	public long getAnnual() {
		return this.annual;
	}

	/**
	 * Gibt Umsatzsteueridentifikationsnummer der Firma zurück
	 * @return Umsatzsteueridentifikationsnummer
	 */
	public long getUSID() {
		return this.usid;
	}

	/**
	 * Gibt Daten als String zurück
	 * @return Daten der Firma
	 */
	public String toString() {
		return	"Frima: " + this.name +
				" Jahresumsatz: " + this.annual +
				" Umsatzsteueridentifikationsnummer: " + this.usid;
	}

	/**
	 * Erzeugt HashCode des Datensatzes
	 * @return HashCode
	 */
	public int hashCode() {
		// Long zu int machen
		return (int) this.usid;
	}

	/**
	 * Prüft gleichheit von zwei Firmen
	 * @param  x andere Firma
	 * @return   true falls identisch, false wenn nicht.
	 */
	public boolean equals(Object x) {
		if(x == null) {
			return false;
		}

		return this.usid == ((Firma) x).getUSID();
	}

	/**
	 * Vergleicht zwei Firmen
	 * @param  x andere Firma
	 * @return   < 0 falls x größer, > 0 falls x kleiner, 0 falls gleich.
	 *
	 * @throws  RuntimeException wenn null gegeben wird.
	 */
	public int compareTo(Object x) {
		if(x == null) {
			throw new RuntimeException("Null given.");
		}
		return (int) (this.usid - ((Firma) x).getUSID()) % Integer.MAX_VALUE;
	}
}

