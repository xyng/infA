/******************************  RekursiveBerechnungen.java  ******************/

import AlgoTools.IO;

/**
 * @version 14.11.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class RekursiveBerechnungen {
  /**
   * Berechnet die Ackermann-Funktion für die Zahlen <tt>n</tt> und <tt>m</tt>
   * @param n beliebige natürliche Zahl
   * @param m beliebige natürliche Zahl
   * @return Ergebnis der Ackermann-Funktion
   * @throws RuntimeException wenn beide Parameter Null
   * @throws RuntimeException wenn n > 3
   * @throws RuntimeException wenn m > 12
   */
   public static int ackermann(int n, int m) {
    // Werte != 0, begrenzung um Stackoverflow vorzubeugen.
    if (n == 0 && m == 0) {
      throw new RuntimeException("Es dürfen nicht beide Parameter 0 sein.");
    } else if(n > 3) {
      throw new RuntimeException("n ist zu groß und würde "
                                + "einen Stackoverflow verursachen");
    } else if(m > 12) {
      throw new RuntimeException("m ist zu groß und würde "
                                + "einen Stackoverflow verursachen");
    }
    return ackermannRek(n, m);
   }

  /**
   * Rekursive Ausführung der Ackermann-Funktion
   * @param n beliebige natürliche Zahl
   * @param m beliebige natürliche Zahl
   * @return Ergebnis der Ackermann-Funktion
   */
  private static int ackermannRek(int n, int m) {
    // Ackermann nach Skript
    if(n == 0) {
      return m + 1;
    } else if(m == 0) {
      return ackermannRek(n - 1, 1);
    } else {
      return ackermannRek(n - 1, ackermannRek(n, m - 1));
    }
  }

  /**
   * Rekursive überprüfung, ob ein Wort ein Palindrom ist
   * @param wort zu überprüfendes Wort
   * @throws RuntimeException wenn Wort nur ein Zeichen hat
   * @return Wahrheitswert, ob Palindrom oder nicht
   */
  public static boolean istPalindrom(char[] wort) {
    // Unter zwei Zeichen kann es kein Palindrom sein.
    if(wort.length < 2) {
      throw new RuntimeException("Wort muss mindestens zwei Zeichen haben!");
    }
    return istPalindromRek(wort, 0);
  }

  /**
   * Rekursive überprüfung, ob ein Wort ein Palindrom ist
   * @param wort zu überprüfendes Wort
   * @param index aktuelle Stelle
   * @return Wahrheitswert, ob Zeichen übereinstimmen
   */
  private static boolean istPalindromRek(char[] wort, int index) {
    // Spiegelwert identisch?
    boolean identisch = wort[index] == wort[wort.length - 1 - index];
    if(index < (wort.length - 1) / 2) {
      // Wenn identisch: weiter!
      if(identisch) {
        return istPalindromRek(wort, index + 1);
      } else { // sonst abbruch (Anker)
        return false;
      }
    } else {
      // Rekursions-Anker
      return identisch;
    }
  }

  /**
   * Berechnet beliebige Potenz einer Basis
   * @param basis beliebige Gleitkommazahl
   * @param exponent beliebige natürliche Zahl
   * @throws RuntimeException wenn exponent > 7938
   * @throws RuntimeException wenn exponent < -7938
   * @throws RuntimeException wenn basis 0 und exponent negativ
   * @return Die exponent-te Potenz der Basis
   */
  public static double potenz(double basis, int exponent) {
    if(exponent > 7938 || exponent < -7938) {
      throw new RuntimeException("Exponent ist zu groß oder zu klein!");
    }
    if(basis == 0 && exponent < 0) {
      throw new RuntimeException("Diese Potenz würde etwas durch 0 teilen!");
    }
    // für alle x gilt: 0^x = 0
    if(basis == 0) {
      return 0;
    }
    return potenzRek(1, basis, exponent);
  }

  /**
   * Berechnet rekursiv die Potenz
   * @param current aktuelles Zwischenergebnis
   * @param basis beliebige Gleitkommazahl
   * @param exponent beliebige natürliche Zahl
   * @return Den aktuellen Zwischenstand der Potenzierung & zuletzt den Endwert
   */
  private static double potenzRek(double current, double basis, int exponent) {
    // für alle x != 0 gilt: x^0 = 1
    if(exponent == 0) {
      return 1;
    } else if(exponent > 0) {
      // solange exponent > 1, um exponent == 0 zu verhindern
      if(exponent - 1 != 0) {
        return potenzRek(current * basis, basis, exponent - 1);
      } else {
        // wenn exponent 1 sind wir beim Rekursionsanker
        return current * basis;
      }
      // siehe oben nur für exponent steigend von negativer Zahl
    } else if (exponent < 0) {
      if(exponent + 1 != 0) {
        return potenzRek(current / basis, basis, exponent + 1);
      } else {
        return current / basis;
      }
    // für alle x gilt: x^1 = x
    } else {
      return current;
    }
  }

  /**
   * Berechnet die Determinante von ganzzahliger quadratischer Matrix
   * @param mat quadratische ganzzahlige Matrix
   * @return Determinante der Matrix
   * @throws RuntimeException wenn Matrix nicht quadratisch
   * @throws RuntimeException wenn Matrix größer als 10x10
   */
  public static int determinante(int[][] mat) {
    // Quadratische Matrix in Aufgabe gefordert
    if(mat.length != mat[0].length) {
      throw new RuntimeException("Die Matrix muss quadratisch sein!");
    }
    if(mat.length > 10) {
      throw new RuntimeException("Da Matrix darf nicht größer als 10x10 sein!");
    }
    return determinanteRek(mat);
  }

  /**
   * Rekursive Berechnung der Determinante einer quadratischen Matrix
   * @param mat quadratische ganzzahlige Matrix
   * @return Determinante der Matrix
   */
  private static int determinanteRek(int[][] mat) {
    // Rechnung nach Aufgabenstellung
    int determinante = 0;
    if(mat.length > 1) {
      int[][] nextMat = new int[mat.length - 1][mat.length - 1];
      // Summe über j bis n (arrays fangen bei 0 an, daher von 0 bis n - 1)
      for(int j = 0; j < mat.length; j++) {
        // schreiben der Werte für Matrix mit Unterdeterminanten
        // i-te Zeile (i immer = 1) weglassen => bei i=1 anfangen, 0te verfällt.
        for(int i = 1; i < mat.length; i++) {
          for(int k = 0; k < mat[i].length; k++) {
            // wenn Spaltenindex kleiner j: alles wie sonst
            if(k < j) {
              nextMat[i - 1][k] = mat[i][k];
            } else if(k > j) {
              // wenn Spaltenindex größer als j => ausgelassene Spalte vom
              // Index her ausgleichen (sonst: indexOutOfBounds)
              nextMat[i - 1][k - 1] = mat[i][k];
            }
          }
        }
        // Bestimmung der Determinante durch Rekursion mit Unterdeterminante(n)
        determinante += (int) potenz(-1, ((j + 1) + 1)) * mat[0][j]
                        * determinanteRek(nextMat);
      }
    } else {
      // Rekursionsanker (wenn dim der Determinante = 1, einfach das einzige
      //                  Element ausgeben)
      determinante = mat[0][0];
    }
    // Rekursionsanker / Rückgabe der finalen Determinante
    return determinante;
  }

  public static void main(String[] argv) {
    char action;
    // Aktionswert einlesen.
    // Mögliche Aktionen: A, P, p, D
    do {
      IO.println("Mögliche Aktionen: ");
      IO.println("A : Ackermann-Funktion berechnen");
      IO.println("P : Palindrom prüfen");
      IO.println("p : Potenz berechnen");
      IO.println("D : Determinante einer n x n Matrix berechnen");
      action = IO.readChar("Welche Aktion möchtest Du ausführen?" +
                           " (A, P, p, D) ");
      if(action != 'A' && action != 'P' && action != 'p' && action != 'D') {
        IO.println("Ungültiger Befehl!");
      }
    } while(action != 'A' && action != 'P' && action != 'p' && action != 'D');

    // Entsprechende Funktion, wie oben beschrieben, ausführen.
    switch(action) {
      case 'A': // Ackermann
      int n, m;
        do {
          n = IO.readInt("Bitte einen Wert für n: ");
          if(n > 2) {
            IO.println("n darf maximal 2 sein.");
          }
        } while (n > 2); // Grenzwert sodass keine Exception geworfen wird

        do {
          m = IO.readInt("Bitte einen Wert für m: ");
          if(m > 12) {
            IO.println("m darf maximal 13 sein.");
          }
        } while (m > 12); // Grenzwert sodass keine Exception geworfen wird

        IO.println(ackermann(n, m)); // Ausgabe des Wertes (nach Rekursion)
        break;
      case 'P': // Palindrom
        char[] wort;

        // Keine Längenprüfung nötig, längste mögliche Eingabe in readChars
        // führt nicht zu Fehler
        do {
          wort = IO.readChars("Bitte zu prüfendes Wort eingeben: ");
          if(wort.length < 2) {
            IO.println("Das Wort muss mindestens zwei Zeichen lang sein!");
          }
        } while(wort.length < 2);

        // Ausgabe des wahrheitswertes
        IO.println(istPalindrom(wort));
        break;
      case 'p': // Potenz
        double basis;
        int exponent;

        do {
          basis = IO.readFloat("Bitte gebe die zu potenzierende Basis ein: ");
          if(basis == 0) {
            IO.println("Basis darf nicht 0 sein!");
          }
        } while(basis == 0);

        do {
          exponent = IO.readInt("Bitte gebe den Exponenten ein: ");
          if(exponent > 7938 || exponent < -7938) {
            IO.println("Exponent darf nicht größer als 7938 "
                       + "oder kleiner als -7938 sein!");
          }
        } while(exponent > 7938 || exponent < -7938);
        IO.println(basis + " hoch " +  exponent
                   + " = " + potenz(basis,exponent));
        break;
      case 'D': // Determinante
        int size;
        int[][] mat;

        do {
          size = IO.readInt("Größe der Matrix: ");
          if(size <= 0) {
            IO.println("Größe der Matrix darf nicht kleiner gleich 0 sein!");
          } else if(size > 10) {
            IO.println("Matrix darf nicht größer als 10x10 sein");
          }
        } while(size <= 0 || size > 10); // Matrix mit Größe 0 ist keine Matrix

        mat = new int[size][size];

        for(int i = 0; i < size; i++) {
          do {
            mat[i] = IO.readInts("Daten für Zeile " + (i + 1) + ": ");
            if(mat[i].length != size) {
              IO.println("Anzahl der Daten passt nicht zu gewählter Größe!");
            }
          } while(mat[i].length != size);
        }

        // Determinante bestimmen und ausgeben
        IO.println("Determinate: " + determinante(mat));
        break;
    }
  }
}
