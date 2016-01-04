/************************  Laufzeiten.java  *************************/

import AlgoTools.IO;

/**
 * Komplexitaet von Methoden in der O-Notation
 */

public class Laufzeiten {

  // höchste Zweierpotenz kleiner n in O(log_2(n))
  public static int a(int n) {
    int z = 0;

    while (n > 1) {
      n /= 2;
      z++;
    }
    return z;
  }

  // berechnet Quadrat von n in O(n)
  public static int b(int n) {
    int i = 0;
    int b = 1;

    while (++i < n) {
      b = b + 2 * i + 1;
    }
    return b;
  }

  // berechnet einen Näherungswert der Wurzel von n in O(Wurzel(n))
  // => ggf. aufgerundet
  public static int c(int n) {
    int t = 1, z = 0;

    while (n > 0) {
      n -= t;
      t += 2;
      z++;
    }
    return z;
  }


/**
 * Angenommen die Methoden u, v, und w haben die folgenden Laufzeiten:
 *
 * u(n) berechnet n^2 in n Schritten -> O(n)
 * v(n) berechnet Wurzel(n) in Wurzel(n) Schritten -> O(Wurzel(n))
 * w(v) berechnet log_2(n) in log_2(n) Schritten -> O(log_2(n)
 *
 * Welche Lauzeiten haben in diesem Fall die folgenden Methoden?


  // Wurzel(n) + Wurzel(n) --> O(Wurzel(n))
  public static int d(int n) {
    return u(v(n));
  }

  // log_2(n) + Wurzel(log_2(n)) < 2 * log_2(n) --> O(log_2(n))
  public static int e(int n) {
    return v(w(n));
  }

  // n + Wurzel(n) --> O(n)
  public static int f(int n) {
    return v(u(n));
  }

  // 2 * (Wurzel(n) * Wurzel(n)) --> O(n)
  public static int g(int n) {
    int z = 0;

    for (int i = 1; i <= v(n); i++)
      z += v(n);

    return z;
  }

  // (2 * Wurzel(n)) * Wurzel(n) --> O(n)
  public static int h(int n) {
    int z = 0;
    int y = v(n);

    for (int i = 1; i <= y; i++)
      z += v(n);

    return z;
  }

  // Wurzel(n) + log_2(n) --> O(Wurzel(n))
  public static int i(int n) {
    return v(n) + w(n);
  }

  // n * n --> n^2
  public static int j(int n) {
    return u(u(n));
  }
*/


  /** Hauptprogramm */
  // Berechnet a(n), b(n), c(n) in O(log_2(n)) + O(n) + O(n) --> O(n)
  public static void main(String argv[]) {
    int n;

    do {
      n = IO.readInt("Eingabe von n: ");
    } while (n < 1);

    IO.print("a(" + n + ") =");
    IO.println(a(n), 8);

    IO.print("b(" + n + ") =");
    IO.println(b(n), 8);

    IO.print("c(" + n + ") =");
    IO.println(c(n), 8);
  }
}
