/****************************  VerweisBaum.java  ******************************/

/** Klasse VerweisBaum mit vier Konstruktoren und vier Methoden.
 * 
 *  Ein VerweisBaum enthaelt einen Verweis auf den Wurzelknoten, der auf weitere
 *  Knoten verweisen kann, die den linken und rechten Teilbaum repraesentieren. 
 */

public class VerweisBaum implements Baum {
	
  Knoten wurzel;                               // Wurzel des Baums
  
  public VerweisBaum() {                       // konstruiert einen leeren Baum
    wurzel = null;                             // Wurzel verweist auf nichts
  }

  public VerweisBaum(Object x) {               // konstruiert ein Blatt
    wurzel = new Knoten(x);                    // lege Knoten mit Inhalt x an
  }
  
  public VerweisBaum(VerweisBaum l, Object x, VerweisBaum r) { // konstr. Baum
    wurzel = new Knoten(x);                    // lege Knoten mit Inhalt x an
    if (l != null)                             // wenn l nicht null, setze
      wurzel.links = l.wurzel;                 // wurzel von l als linken Sohn
    if (r != null)                             // wenn r nicht null, setze
      wurzel.rechts = r.wurzel;                // wurzel von r als rechten Sohn
  }

  private VerweisBaum(Knoten k) {              // konstruiert einen Baum
    wurzel = k;                                // aus ubergebenem Knoten
  }                                            // (nur fuer internen Gebrauch)

  public boolean empty() {                     // liefert true,
    return wurzel == null;                     // falls Baum leer ist
  }

  public Object value() {                      // liefert Element in der Wurzel
    if (empty())
    	throw new RuntimeException(" Baum ist leer ");
    return wurzel.inhalt;
  }

  public Baum left() {                         // liefert linken Teilbaum
    if (empty())
    	throw new RuntimeException(" Baum ist leer ");
    return new VerweisBaum(wurzel.links);      // Erzeuge Baum, der linken Sohn
  }                                            // als Wurzelknoten enthaelt

  public Baum right() {                        // liefert rechten Teilbaum
    if (empty())
    	throw new RuntimeException(" Baum ist leer ");
    return new VerweisBaum(wurzel.rechts);     // Erzeuge Baum, der rechten Sohn
  }                                            // als Wurzelknoten enthaelt
}
