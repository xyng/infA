/******************************  ShapeTest.java  ******************************/

import AlgoTools.IO;

/**
 * @version 13.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class ShapeTest {

	private static void printSphereStuff(Sphere sphere, Sphere otherSphere,
										 Shape otherShape) {

		IO.println("Volumen: " + sphere.getVolume());
		IO.println("Fläche: " + sphere.getArea());
		IO.println("Euklidischer Abstand: " + sphere.getDistanceTo(otherSphere));
		IO.println("Euklidischer Abstand zu otherShape: "
			+ sphere.getDistanceTo(otherShape));
		IO.println("To String:");
		IO.println(sphere);

	}

	private static void printCubeStuff(Cube cube, Cube otherCube,
									   Shape otherShape) {
		IO.println("Volumen: " + cube.getVolume());
		IO.println("Fläche: " + cube.getArea());
		IO.println("Euklidischer Abstand: " + cube.getDistanceTo(otherCube));
		IO.println("Euklidischer Abstand zu otherShape: "
			+ cube.getDistanceTo(otherShape));
		IO.println("To String:");
		IO.println(cube);
	}

	private static void printShapeStuff(Shape shape, Shape otherShape) {
		IO.println("Volumen: " + shape.getVolume());
		IO.println("Fläche: " + shape.getArea());
		IO.println("Euklidischer Abstand: " + shape.getDistanceTo(otherShape));
		IO.println("To String:");
		IO.println(shape);
	}

	public static void main(String[] argv) {
		IO.println();
		IO.println("|--------------------------------------------------------");
		IO.println("| Shapes");
		IO.println("|--------------------------------------------------------");
		IO.println();
		// Default Shape erzeugen
		Shape defaultShape = new Shape();

		// Shape mit nicht-default Constructor erzeugen
		Shape otherShape = new Shape("Rosé", 10, 20, 30);

		IO.println("Shape mit Default-Constructor");
		printShapeStuff(defaultShape, otherShape);

		IO.println();

		IO.println("Move Default-Shape X, Y, Z by 5");
		defaultShape.move(5, 5, 5);
		printShapeStuff(defaultShape, otherShape);

		IO.println();

		IO.println("Shape mit Nicht-Default-Constructor");
		printShapeStuff(otherShape, defaultShape);

		IO.println();

		IO.println("Move Other-Shape X, Y, Z by 5");
		otherShape.move(5, 5, 5);
		printShapeStuff(otherShape, defaultShape);

		IO.println();
		IO.println("|--------------------------------------------------------");
		IO.println("| Spheres");
		IO.println("|--------------------------------------------------------");
		IO.println();

		// Default Shape erzeugen
		Sphere defaultSphere = new Sphere();

		// Shape mit nicht-default Constructor erzeugen
		Sphere otherSphere = new Sphere("Rosé", 10, 20, 30, 1);

		IO.println("Sphere mit Default-Constructor");
		printSphereStuff(defaultSphere, otherSphere, otherShape);

		IO.println();

		IO.println("Move Default-Sphere X, Y, Z by 5");
		defaultSphere.move(5, 5, 5);
		printSphereStuff(defaultSphere, otherSphere, otherShape);

		IO.println();

		IO.println("Set Radius of Default-Sphere to 5");
		defaultSphere.setRadius(5);
		IO.println("Radius of Default-Sphere is now: " + defaultSphere.getRadius());
		printSphereStuff(defaultSphere, otherSphere, otherShape);

		IO.println();

		IO.println("Sphere mit Nicht-Default-Constructor");
		printSphereStuff(otherSphere, defaultSphere, defaultShape);

		IO.println();

		IO.println("Move Other-Sphere X, Y, Z by 5");
		otherSphere.move(5, 5, 5);
		printSphereStuff(otherSphere, defaultSphere, defaultShape);

		IO.println();
		IO.println("|--------------------------------------------------------");
		IO.println("| Cubes");
		IO.println("|--------------------------------------------------------");
		IO.println();

		// Default Cube erzeugen
		Cube defaultCube = new Cube();

		// Cube mit nicht-default Constructor erzeugen
		Cube otherCube = new Cube("Rosé", 10, 20, 30, 10);

		IO.println("Cube mit Default-Constructor");
		printCubeStuff(defaultCube, otherCube, otherShape);

		IO.println();

		IO.println("Move Default-Cube X, Y, Z by 5");
		defaultCube.move(5, 5, 5);
		printCubeStuff(defaultCube, otherCube, otherShape);

		IO.println();

		IO.println("Set Width of Default-Cube to 5");
		defaultCube.setWidth(5);
		IO.println("Width of Default-Cube is now: " + defaultCube.getWidth());
		printCubeStuff(defaultCube, otherCube, otherShape);

		IO.println();

		IO.println("Cube mit Nicht-Default-Constructor");
		printCubeStuff(otherCube, defaultCube, defaultShape);

		IO.println();

		IO.println("Move Other-Cube X, Y, Z by 5");
		otherCube.move(5, 5, 5);
		printCubeStuff(otherCube, defaultCube, defaultShape);
	}
}
