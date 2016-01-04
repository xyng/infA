/******************************  Sphere.java  *********************************/

import AlgoTools.IO;

/**
 * @version 13.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class Sphere extends Shape {
	private double radius;   // Radius der Kugel

	/**
	 * Erzeugt neues Sphere-Objekt
	 *
	 * @param colour Farbe des Shape
	 * @param x Koordinate auf der X-Achse
	 * @param y Koordinate auf der Y-Achse
	 * @param z Koordinate auf der Z-Achse
	 * @param radius Radius des Sphere (>= 0)
	 *
	 */
	public Sphere(String colour, double x, double y, double z, double radius) {
		super(colour, x, y, z);

		if(radius < 0 ) throw new RuntimeException("Radius muss >= 0 sein!");

		this.radius = radius;
	}

	/**
	 * Erzeugt neues Sphere-Objekt mit Farbe schwarz in den Ursprungskoordinaten
	 * und mit Radius 0.
	 */
	public Sphere() {
		// Default-Constructor
		// Setzt Farbe schwarz und im Urpsrung, Radius auf 0.

		this("schwarz", 0, 0, 0, 0);
	}

	/**
	 * Liefert den Radius dieses Sphere
	 *
	 * @return Radius des Sphere
	 */
	public double getRadius() {        // liefert den Radius der Kugel
		return radius;
	}

	/**
	 * Überschreibt den Radius des Spheres mit dem gegebenen Wert
	 *
	 * @param r Neuer Radius >= 0
	 */
	public void setRadius(double r) {  // setzt den Radius der Kugel
		if(r < 0) throw new RuntimeException("Radius muss >= 0 sein!");

		this.radius = r;
	}

	/**
	 * Liefert das Volumen dieses Sphere.
	 *
	 * @return Volumen
	 */
	public double getVolume() {
		// V = 4/3 * π * r^3
		return (4/3) * Math.PI * (radius * radius * radius);
	}

	/**
	 * Liefert die Fläche dieses Sphere.
	 *
	 * @return Fläche
	 */
	public double getArea() {
		// O = 4 * π * r^2
		return 4 * Math.PI * (radius * radius);
	}

	/**
	 * Liefert den absoluten Abstand zwischen diesem Sphere und einem anderen
	 * Sphere other. (=> Abstand zwischen den nähesten Punkten der Oberflächen)
	 *
	 * @param other Sphere zu dem der absolute Abstand bestimmt werden soll.
	 * @return Abstand
	 */
	public double getDistanceTo(Sphere other) {
		double distance = getDistanceTo((Shape) other);

		// Es müssen die Radien abgezogen werden
		// um den absoluten Abstand zu bestimmen
		distance -= this.radius + other.radius;

		// Wenn Abstand negativ schneiden sich die Spheres -> Abstand 0.0
		if (distance < 0) {
			return 0.0;
		}

		return distance;
	}

	/**
	 * Liefert die Attribute dieses Sphere als String formatiert
	 *
	 * @return Beschreibung dieses Sphere
	 */
	public String toString() {
		/* Überschreibt toString-Methode des Default-Objektes
		 * diese liefert immer den Klassennamen und die Speicherposition
		 * (als Hexadezimalzahl codiert) zurück.
		 */
		return super.toString() +  " Radius: " + radius;
	}
}
