/******************************  Cube.java  ***********************************/

import AlgoTools.IO;

/**
 * @version 13.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class Cube extends Shape {
	private double width;	 // Die Kantenlänge des Cubes

	/**
	 * Erzeugt neues Cube-Objekt
	 *
	 * @param colour Farbe des Shape
	 * @param x Koordinate auf der X-Achse
	 * @param y Koordinate auf der Y-Achse
	 * @param z Koordinate auf der Z-Achse
	 * @param width Kantenlänge des Cube (>= 0)
	 *
	 */
	public Cube(String colour, double x, double y, double z, double width) {
		super(colour, x, y, z);

		if(width < 0) throw new RuntimeException("Width muss >= 0 sein");

		this.width = width;
	}

	/**
	 * Erzeugt neues Cube-Objekt mit Farbe schwarz in den Ursprungskoordinaten
	 * und mit Width 0.
	 */
	public Cube() {
		// Default-Constructor
		// Setzt Farbe schwarz und im Urpsrung
		// Width = 0

		this("schwarz", 0, 0, 0, 0);
	}

	/**
	 * Liefert die Kantenlänge dieses Sphere
	 *
	 * @return Kantenlänge des Sphere
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Überschreibt die Kantenlänge des Spheres mit dem gegebenen Wert
	 *
	 * @param width Neue Kantenlänge >= 0
	 */
	public void setWidth(double width) {
		if(width < 0) throw new RuntimeException("Width muss >= 0 sein");
		this.width = width;
	}

	/**
	 * Liefert Shape-Objekt das den Mittelpunkt des Cube darstellt
	 *
	 * @return Shape Mittelpunkt des Cube
	 */
	public Shape getMittelpunkt() {
		return new Shape(
			colour,
			x - (width / 2),
			y - (width / 2),
			z - (width / 2)
		);
	}

	/**
	 * Liefert das Volumen dieses Cube.
	 *
	 * @return Volumen
	 */
	public double getVolume() {
		// V = width^3
		return width * width * width;
	}

	/**
	 * Liefert die Fläche dieses Cube.
	 *
	 * @return Fläche
	 */
	public double getArea() {
		// O = width^2
		return width * width;
	}

	/**
	 * Liefert den Abstand zwischen den Mittelpunkten dieses Cube und einem
	 * anderen Cube other.
	 *
	 * @param other Cube zu dessen Mittelpunkt der Abstand bestimmt wird.
	 * @return Abstand
	 */
	public double getDistanceTo(Cube other) {
		// Neue Shapes mit den Mittelpunkten der Würfel erzeugen und
		// deren Abstand zurückgeben

		// Mittelpunkte zwischenspeichern um Methode nur ein Mal aufzurufen

		Shape mittelpunkt = this.getMittelpunkt();
		Shape otherMittelpunkt = other.getMittelpunkt();

		// Abstand der Mittelpunkte zurückgeben
		return mittelpunkt.getDistanceTo(otherMittelpunkt);
	}

	/**
	 * Liefert die Attribute dieses Cube als String formatiert
	 *
	 * @return Beschreibung dieses Cube
	 */
	public String toString() {
		/* Überschreibt toString-Methode des Default-Objektes
		 * diese liefert immer den Klassennamen und die Speicherposition
		 * (als Hexadezimalzahl codiert) zurück.
		 */
		return super.toString() + " Kantenlänge: " + width;
	}
}

