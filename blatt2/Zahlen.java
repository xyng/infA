/******************************  Zahlen.java  ******************************/

import AlgoTools.IO;

/**
 *  * @versiozahl 25.10.15
 *  *
 *  * @description Spricht eine Zahl zwischen 10 und 999 in englisch aus.
 *  * @author  dmelchior, coelker
 *  */

public class Zahlen {
  public static void main(String[] args) {
    int zahl;

    do {
      zahl = IO.readInt("Enter the number you want me to pronounce: ");
      if (zahl < 10 || zahl > 999) {
        IO.println("Sorry, I'm not aware of the existence of " + zahl);
      }
    } while(zahl < 10 || zahl > 999);

    switch (zahl / 100) { // Zahl durch Hundert => die anzahl der Hunderter
      case 1: IO.print("one"); break;
      case 2: IO.print("two"); break;
      case 3: IO.print("three"); break;
      case 4: IO.print("four"); break;
      case 5: IO.print("five"); break;
      case 6: IO.print("six"); break;
      case 7: IO.print("seven"); break;
      case 8: IO.print("eight"); break;
      case 9: IO.print("nine"); break;
    }

	// wenn Zahl größer Hundert: kommt noch mehr?
    if (zahl / 100 > 0) {
      IO.print(" hundred");

      if (zahl - ((zahl / 100) * 100) > 0) {
        IO.print(" and ");
      }
    }

	// zehner von Zahl durch abzug des Hunderters:
    switch ((zahl - ((zahl / 100) * 100)) / 10)  {
      case 0: break;
      case 1: break;
      case 2: IO.print("twenty"); break;
      case 3: IO.print("thirty"); break;
      case 4: IO.print("fourty"); break;
      case 5: IO.print("fifty"); break;
      case 6: IO.print("sixty"); break;
      case 7: IO.print("seventy"); break;
      case 8: IO.print("eighty"); break;
      case 9: IO.print("ninety"); break;
    }
	/* um die Zahlen von 10 bis 19 haben wir uns bereits gekümmert.
       * hier müssen die Einer nicht ausgegeben werden */
    if (((zahl - ((zahl / 100) * 100)) < 10 || (zahl - ((zahl / 100) * 100)) > 19)) {
	  // Bindestrich für Zahlen wie twenty-one setzen:
      if ((zahl - ((zahl / 100) * 100)) % 10 > 0) {
        IO.print("-");
      }

      switch (zahl % 10) { // zahl modulo 10 gibt uns die einer
        case 1: IO.print("one"); break;
        case 2: IO.print("two"); break;
        case 3: IO.print("three"); break;
        case 4: IO.print("four"); break;
        case 5: IO.print("five"); break;
        case 6: IO.print("six"); break;
        case 7: IO.print("seven"); break;
        case 8: IO.print("eight"); break;
        case 9: IO.print("nine"); break;
      }
    } else {
      switch (zahl - ((zahl / 100) * 100)) {
        /* letzten zwei Stellen von n.
         * (n/100) * 100 gibt immer den geraden Hunderter.
         * z.B: 112 -> 100 */
        case 10: IO.print("ten"); break;
        case 11: IO.print("eleven"); break;
        case 12: IO.print("twelve"); break;
        case 13: IO.print("thirteen"); break;
        case 14: IO.print("fourteen"); break;
        case 15: IO.print("fifteen"); break;
        case 16: IO.print("sixteen"); break;
        case 17: IO.print("seventeen"); break;
        case 18: IO.print("eighteen"); break;
        case 19: IO.print("nineteen"); break;
      }
    }

    IO.println();
  }
}
