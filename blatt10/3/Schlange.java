/******************************  Schlange.java  *******************************/

/** Interface zum ADT Schlange          
 */

public interface Schlange {
    
  public boolean empty();                 // Testet, ob Schlange leer ist

  public void enq(Object x);              // Fuegt x hinten ein

  public Object front();                  // Liefert vorderstes Element

  public void deq();                      // Entfernt vorderstes Element

}
