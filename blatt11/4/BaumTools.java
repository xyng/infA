/******************************  BaumTools.java  ******************************/

import AlgoTools.IO;

/**
 * Utility-Klasse mit einigen Algorithemn fuer Baeume
 */
public class BaumTools {

  /**
   * Druckt einen Baum auf der Konsole ebenenweise aus.
   * Nutzt baumTiefe(Baum), printEbene(Baum,int,int) und spaces(int).
   * @param b der zu druckende Baum
   */
  public static void printBaum(Baum b) {

    //Berechne die Tiefe des Baumes
    int resttiefe = baumTiefe(b);

    //Gehe die Ebenen des Baumes durch
    for(int i = 0; i < resttiefe; i++) {
      //Drucke die Ebene, beruecksichtige Anzahl der Leerzeichen
      //fuer korrekte Einrueckung
      printEbene(b, i, spaces(resttiefe - i));
      IO.println();
      IO.println();
    }

  }

  /**
   * Druckt eine Ebene eines Baumes aehnlich der Breitensuche
   * aus. 0 ist dabei die Wurzel. Vor und nach jedem Element
   * werden spaces Leerzeichen eingefuegt.
   * @param b der auszugebende Baum
   * @param ebene die gewuenschte Ebene beginnend bei 0
   * @param spaces Anzahl von Leerzeichen vor und nach jedem Element
   */
  public static void printEbene(Baum b, int ebene, int spaces) {

    //Wenn 0 erreicht, drucke Element mit Leerzeichen
    if(ebene == 0) {

      IO.print("", spaces);
      if(b != null) {
        IO.print(b.value());
      }
      else { //Wenn Nullzeiger uebergeben wurde, ein Leerzeichen drucken
        IO.print(" ");
      }
      IO.print(" ", spaces + 1);

    } else {

      //Steige rekursiv ab, betrachte Soehne als Teilbaeume und verringere
      //dabei die zu druckende Ebene. In endende Aeste wird mit dem Nullzeiger
      //gelaufen.
      if(b != null && !b.left().empty()) {
        printEbene(b.left(), ebene - 1, spaces);
      }
      else {
        printEbene(null, ebene - 1, spaces);
      }

      if(b != null && !b.right().empty()) {
        printEbene(b.right(), ebene - 1, spaces);
      }
      else {
        printEbene(null, ebene - 1, spaces);
      }

    }

  }

  /**
   * Berechnet die Anzahl an benoetigten Leerzeichen fuer
   * eine korrekte Einrueckung, also 0.5 * (2^(ebene) - 2).
   * @param ebene die Ebene, Blaetter sind Ebene 1, darueber aufsteigend
   * @return Anzahl der Leerzeichen zur Elementtrennung
   */
  private static int spaces(int ebene) {

    if(ebene == 1) {
      return 0;
    }
    else {
      //verdoppele die Leerzeichen gegenueber der Ebene darunter
      //und fuege ein weiteres Leerzeichen hinzu
      return 2 * spaces(ebene - 1) + 1;
    }

  }

  public static int baumTiefe(Baum b) {
    if(b.empty()) {
      return 0; // Rekursionsanker
    }

    int tiefe = 1;
    int tiefeL = baumTiefe(b.left());
    int tiefeR = baumTiefe(b.right());

    if(tiefeL < tiefeR) {
      tiefe += tiefeR;
    } else {
      tiefe += tiefeL;
    }

    return tiefe;

  }

  public static VerweisBaum inorderPostorderBau (int[] inorder,
                                                 int[] postorder) {
    if(inorder.length == 0) {
      return new VerweisBaum(); // anker
    }

    int rootVal = postorder[postorder.length - 1];
    int i;

    // Position von RootVal bestimmen
    for (i = 0; i < inorder.length && inorder[i] != rootVal; i++);
    // Neue Arrays mit Daten für linken und rechten Teilbaum erzeugen
    // Daten für Linken Teilbaum sind in beiden Arrays vor Position i.

    int[] inL = new int[i];
    int[] postL = new int[i];

    for (int j = 0; j < i; j++) {
      inL[j] = inorder[j];
      postL[j] = postorder[j];
    }

    // Menge der verbleibenden Elemente bestimmen
    int lengthR = postorder.length - i - 1;

    int[] inR = new int[lengthR];
    int[] postR = new int[lengthR];

    for (int j = 0; j < lengthR; j++) {
      // inorder fängt bei dem element nach Root an (=> i + 1)
      // damit wird auch das letzte Element aus inorder erreicht
      inR[j] = inorder[j + i + 1];
      // postorder startet bei i. Damit wird das letzte Element ausgelassen,
      // da immer j + i < postorder.length - 1 ist.
      postR[j] = postorder[j + i];
    }

    // neuen VerweisBaum mit durch rekursion erzeuge Teilbäumen erzeugen
    return new VerweisBaum(
      inorderPostorderBau(inL, postL),
      rootVal,
      inorderPostorderBau(inR, postR)
    );
  }

  public static int anzahlKnoten(Baum b) {
    if (b.empty()) {
      return 0;
    }

    return 1 + anzahlKnoten(b.left()) + anzahlKnoten(b.right());
  }

  public static boolean istVollstaendig(Baum b) {
    if (b.empty()) {
      return true;
    }

    return baumTiefe(b.left()) == baumTiefe(b.right());
  }

}
