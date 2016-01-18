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

	Firma(String name, long annual, long usid) {
		setName(name);
		setAnnual(annual);
		setUSID(usid);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAnnual(long annual) {
		this.annual = annual;
	}

	public void setUSID(long usid) {
		this.usid = usid;
	}

	public String getName() {
		return this.name;
	}

	public long getAnnual() {
		return this.annual;
	}

	public long getUSID() {
		return this.usid;
	}

	public String toString() {
		return	"Frima: " + this.name +
				" Jahresumsatz: " + this.annual +
				" Umsatzsteueridentifikationsnummer: " + this.usid;
	}

	public int hashCode() {
		return (int) this.usid;
	}

	public boolean equals(Object x) {
		if(x == null) {
			return false;
		}

		return this.usid == ((Firma) x).getUSID();
	}

	public int compareTo(Object x) {
		if(x == null) {
			throw new RuntimeException("Null given.");
		}
		return (int) (this.usid - ((Firma) x).getUSID()) % Integer.MAX_VALUE;
	}
}

