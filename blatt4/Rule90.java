/******************************  Rule90.java  **********************************/

import AlgoTools.IO;

/**
 *  * @version 07.11.15
 *  *
 *  * @author  dmelchior, coelker
 *  */

public class Rule90 {

  public static void main(String[] argv) {
    boolean[] row, rowTemp;
    int[] input;
    int iterations;
    boolean left, right;

    do {
      input = IO.readInts("Bitte eine Folge für Rule90 eingeben: ");
      if(input.length <= 0) {
        IO.println("Die Folge muss mindestens ein Zeichen haben");
      }
    } while(input.length <= 0);

    do {
      iterations = IO.readInt("Bitte die Anzahl der Iterationen: ");
      if(iterations <= 0) {
        IO.println("Es muss mindestens eine Iteration sein!");
      }
    } while(iterations <= 0);

    // line break damit nach der Eingabe nicht in der selben Zeile weitergemacht
    // wird
    IO.println();

    row = new boolean[input.length]; // wir erhalten gleichviele bools wie ints
    rowTemp = new boolean[input.length]; // und das ganze nochmal für den puffer

    // daten vom int array in boolean array übertragen
    // 0 => false; != 1 => true
    for(int j = 0; j < input.length; j++) {
      if(input[j] == 0) {
        row[j] = false;
      } else {
        row[j] = true;
      }
    }

    // für alle iterationen ab 0
    // iteration 0 ist die Eingabe
    for(int i = 0; i <= iterations; i++) {
      IO.print("Zeitpunkt " + i, 20);
      // zunächst aktuelle Daten ausgeben
      for(int j = 0; j < row.length; j++) {
        if(row[j]) {
          IO.print("@", 3);
        } else {
          IO.print(".", 3);
        }
      }
      // und jetzt werte aktualisieren
      for(int j = 0; j < row.length; j++) {
        // spezialfälle überschreiben
        if(j == 0) {
          // erstes Element. Der linke Nachbar ist das letzte Element
          left = row[row.length - 1];
        } else {
          left = row[j - 1];
        }

        if(j == row.length - 1) {
          // letztes Element. Der rechte Nachbar ist das erste Element
          right = row[0];
        } else {
          right = row[j + 1];
        }

        // neue Werte werden in temporären Array gespeichert, damit andere noch
        // nicht beeinflusst werden
        if(left ^ right) {
          // lebe!
          rowTemp[j] = true;
        } else {
          // stirb!
          rowTemp[j] = false;
        }
      }
      // row = rowTemp würde zu einer zu frühen Übertragung der Werte führen
      // daher hier dieser unschöne Workaround
      for(int j = 0; j < row.length; j++) {
        row[j] = rowTemp[j]; // puffer in die eigentliche Variable überführen.
      }
      IO.println();
    }

  }
}