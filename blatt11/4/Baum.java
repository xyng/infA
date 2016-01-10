/********************************  Baum.java  *********************************/

/** Interface Baum mit 4 Methoden. 
 */

public interface Baum { 

  public boolean empty();                  // liefert true, falls Baum leer ist

  public Baum left();                      // liefert linken Teilbaum

  public Baum right();                     // liefert rechten Teilbaum

  public Object value();                   // liefert Objekt in der Wurzel

}
