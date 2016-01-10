/***************************  Traverse.java  **********************************/

import AlgoTools.IO;

/** Klasse Traverse  
 *  bestehend aus vier statischen Methoden
 *  zum Traversieren von Baeumen
 */

public class Traverse {

  public static void inorder(Baum b) {        // Inorder-Traversierung
    if (!b.empty()) {                         // falls Baum nicht leer,
        inorder (b.left());                   // steige links ab
        IO.print(b.value());                  // gib Knoteninhalt aus
        inorder (b.right());                  // steige rechts ab
    }
  }

  public static void preorder(Baum b) {       // Preorder-Traversierung
    if (!b.empty()) {                         // falls Baum nicht leer,
        IO.print(b.value());                  // gib Knoteninhalt aus
        preorder(b.left());                   // steige links ab
        preorder(b.right());                  // steige rechts ab
    }
  }

  public static void postorder(Baum b) {      // Postorder-Traversierung
    if (!b.empty()) {                         // falls Baum nicht leer,
        postorder(b.left());                  // steige links ab
        postorder(b.right());                 // steige rechts ab
        IO.print (b.value());                 // gib Knoteninhalt aus
    }
  }

  public static void klammerinorder(Baum b) { // Klammerinorder-Traversierung
    if (!b.empty()) {                         // falls Baum nicht leer
      if (!b.left().empty()) IO.print("(");   // "("
      klammerinorder(b.left());               // linker Sohn
      IO.print(b.value());                    // Wurzel von b
      klammerinorder(b.right());              // rechter Sohn
      if (!b.right().empty()) IO.print(")");  // ")"
    }
  }
}
