/**************************  Zusicherung.java  *******************************/
import AlgoTools.IO;

/**
 * Beweis der Korrektheit mit Hilfe der Zusicherungsmethode
 */

public class Zusicherung {

  public static void main(String[] args) {

    int i = 0, h = 1, z = 0, n;

    // i = 0, h = 1, z = 0, n = nicht initialisiert

    do {
      n = IO.readInt("n= ");
    } while (n < 0);

    // i = 0, h = 1, z = 0, n >= 0

    /* z = i * i und h = 2 * i + 1 und i < n ist Schleifeninvariante */

    while (i < n) {
	  // z = i * i und h = 2 * i + 1 und i < z

      z += h; // z(n) = z(a) + h

	  // z(n) - h = i * i und h = 2 * 1 + 1 und i < n

      h += 2; // h(n) = h(a) + 2 = 2 * i + 1 + 2 = 2 * i + 3

      // z - h(a) = i * i und h = 2 * i + 3 und i < n

      i++; // i(n) = i(a) + 1

      // Schleifeninvariante für nächste Iteration

	  // h = 2 * i(n) + 1:
	  // -------------------
      // h = 2 * i(a) + 3. Da i(a) == i(n) - 1 und i = i(n) gilt:
      // h = 2 * (i - 1) + 3 = 2 * i - 2 + 3 = 2 * i + 1.

      // z(n) = i(n) * i(n)
      // -------------------
      //z(n) = z(a) + h(a) = i(a) * i(a) = (i - 1) * (i - 1) = i * i - 2 * i + 1
    }

    // z = i * i und h = 2 * i + 1 und i == n
    // Da i = n und z = i * i ist z = n^2.
    // Da z ausgegeben wird, ist n^2 Ergebnis der Berechnung dieses Programms

    IO.println(z, 6);
  }
}

/**
 * Das Programm Terminiert für alle Werte >= 0, da i bei jedem Lauf inkremiert
 * und irgendwann gleich n ist. In diesem Fall terminiert die Schleife und nach
 * der Ausgabe von z auch das Programm.
 * Zusammen mit der partiellen Korrektheit folgt daraus die totale Korrektheit.
 *
 * Die Laufzeit der Schleife beträgt O(n), da von 0 bis n gelaufen wird und
 * bei jeder Iteration der Laufwert um 1 inkremiert wird --> linear.
 */
