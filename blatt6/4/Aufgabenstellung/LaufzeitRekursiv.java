/*************************  LaufzeitRekursiv.java  ***************************/

import AlgoTools.IO;

/**
 *
 * @author Nicolas Neubauer (nineubau@uos.de)
 * @author Sebastian Buescher (sbuesche@uos.de)
 * @author Jana Lehnfeld (jlehnfel@uos.de)
 * @author Nils Haldenwang (nhaldenw@uos.de)
 *
 */
public class LaufzeitRekursiv {

  public static void rek(int n) {
    if(n < 2) {
      IO.print(":-");
    } else {
      rek(n-1);
	  IO.println(n);
      for(int i = 0; i < 2*n - 1; i++){
        IO.print(")");
      }
    }

  }

  public static void main(String[] args) {
    int zahl;

    do {
      zahl = IO.readInt("Bitte ein int.");
    } while(zahl < 0);

    rek(zahl);
  }

}
