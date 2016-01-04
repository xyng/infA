/******************************  Shape.java  **********************************/

import AlgoTools.IO;

/**
 * @version 13.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class Shape {
	public String colour;    // Enthaelt die Farbe der Form
	public double x, y, z;   // Die Koordinate der Form im Raum

	/**
	 * Erzeugt neues Shape-Objekt
	 *
	 * @param colour Farbe des Shape
	 * @param x Koordinate auf der X-Achse
	 * @param y Koordinate auf der Y-Achse
	 * @param z Koordinate auf der Z-Achse
	 *
	 */
	public Shape(String colour, double x, double y, double z) {
		// Setzt Werte auf Eingabe
		this.colour = colour;

		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Erzeugt neues Shape-Objekt mit Farbe schwarz in den Ursprungskoordinaten
	 */
	public Shape() {
		// Default-Constructor
		// Setzt Farbe schwarz und im Urpsrung

		this("schwarz", 0, 0, 0);
	}

	/**
	 * Verschiebt das Shape im Raum um dX in x-Richtung, um dY in y-Richtung
	 * und um dZ in z-Richtung.
	 *
	 * @param dX Änderung der X-Koordinate
	 * @param dY Änderung der Y-Koordinate
	 * @param dZ Änderung der Z-Koordinate
	 *
	 */
	public void move(double dX, double dY, double dZ) {
		x = x + dX;
		y = y + dY;
		z = z + dZ;
	}

	/**
	 * Liefert das Volumen dieses Shape. Da bei einer allgemeinen Form nicht
	 * klar ist, wie groß das Volumen ist, wird 0.0 geliefert.
	 *
	 * @return Volumen
	 */
	public double getVolume() {
		// Nicht def. da allgemeiner Körper
		return 0.0;
	}

	/**
	 * Liefert die Fläche dieses Shape. Da bei einer allgemeinen Form nicht
	 * klar ist, wie groß die Fläche ist, wird 0.0 geliefert.
	 *
	 * @return Fläche
	 */
	public double getArea() {
		// Nicht def. da allgemeiner Körper
		return 0.0;
	}

	/**
	 * Liefert den Abstand zwischen den Positionen dieses Shape und dem
	 * Shape other in euklidischer Metrik
	 *
	 * @param other Shape zu dem der Abstand bestimmt werden soll
	 * @return Abstand
	 */
	public double getDistanceTo(Shape other) {
		// Der Lesbarkeit halber die einzelnen Summenteile vorher berechnen
		double valueX = (x - other.x) * (x - other.x);
		double valueY = (y - other.y) * (y - other.y);
		double valueZ = (z - other.z) * (z - other.z);

		// Wurzel der Summe zurückgeben => Euklidischer Abstand
		return Math.sqrt(valueX + valueY + valueZ);
	}

	/**
	 * Liefert die Attribute dieses Shape als String formatiert
	 *
	 * @return Beschreibung dieses Shape
	 */
	public String toString() {
		/* Überschreibt toString-Methode des Default-Objektes
		 * diese liefert immer den Klassennamen und die Speicherposition
		 * (als Hexadezimalzahl codiert) zurück.
		 */
		return "Farbe: " + colour + " X: " + x + " Y: " + y + " Z: " + z;
	}
}

