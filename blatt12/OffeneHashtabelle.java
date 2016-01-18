/******************************  OffeneHashtabelle.java  **********************/

import AlgoTools.IO;

/**
 * @version	17.01.16
 *
 * @author	dmelchior
 * @author	coelker
 */

public class OffeneHashtabelle implements Menge {
	private Liste[] lists;

	OffeneHashtabelle() {
		lists = new Liste[7];

		for (int i = 0; i < 7; i++) {
			lists[i] = new VerweisListe();
		}
	}

	public boolean empty() {
		for (int i = 0; i < 7; i++) {
			if (!lists[i].empty()) {
				return false;
			}
		}

		return true;
	}

	public Comparable lookup(Comparable x) {
		Liste list = lists[((Firma) x).hashCode() % 7];
		if(!list.empty()) {
			list.reset();
			while(!list.endpos()) {
				Comparable cur = (Comparable) list.elem();
				if (cur.compareTo(x) == 0) {
					return cur;
				}
				list.advance();
			}
		}

		return null;
	}

	public boolean insert(Comparable x) {
		if(lookup(x) != null) {
			return false;
		}

		lists[((Firma) x).hashCode() % 7].insert(x);
		return true;
	}

	public boolean delete(Comparable x) {
		if(lookup(x) != null) {
			lists[((Firma) x).hashCode() % 7].delete();
			return true;
		}
		return false;
	}
}

