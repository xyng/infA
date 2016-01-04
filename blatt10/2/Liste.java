/*****************************  Liste.java  ***********************************/

/** Interface fuer den ADT Liste                                              
 */
    
public interface Liste {

    public boolean empty();        // true, wenn Liste leer, false sonst

    public boolean endpos();       // true, wenn Liste am Ende, false sonst

    public void reset();           // rueckt an den Anfang der Liste
    
    public void advance();         // rueckt in Liste eine Position weiter

    public Object elem();          // liefert Inhalt des aktuellen Elements 

    public void insert(Object x);  // fuegt x vor das aktuelle Element ein
                                   // und macht x zum aktuellen Element

    public void delete();          // entfernt aktuelles Element und macht
                                   // seinen Nachfolger zum aktuellen Element
}
