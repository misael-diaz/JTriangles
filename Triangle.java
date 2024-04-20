import java.util.Random;

public class Triangle
{
  // triangle sides
  protected final double a;
  protected final double b;
  protected final double c;

  // triangle interior angles
  protected final double alpha;
  protected final double beta;
  protected final double gamma;

  // triangle area
  protected final double area;

  // triangle kind: equilateral, isosceles, or scalene
  private final String kind;

  // constructs a triangle with the given lengths if possible
  public Triangle (double a, double b, double c) {
    if (!Util.validate(a, b, c)) {
      String errmsg = "Triangle: impossible to construct triangle with given lenghts";
      throw new IllegalArgumentException(errmsg);
    }
    this.a = a;
    this.b = b;
    this.c = c;
    final double[] angles = Util.angles(this.a, this.b, this.c);
    this.alpha = angles[0];
    this.beta = angles[1];
    this.gamma = angles[2];
    final double base = this.b;
    final double height = this.a * Math.sin(gamma);
    this.area = Util.area(base, height);
    this.kind = Util.kind(this.a, this.b, this.c);
  }

  // gets triangle area
  public double area ()
  {
    return this.area;
  }

  // gets the triangle kind
  public String kind ()
  {
    return this.kind;
  }

  // displays the triangle info on the console
  public void info ()
  {
    System.out.println();
    System.out.printf("kind: %s\n", this.kind);
    System.out.printf("a: %f alpha: %f\n", a, Util.rad2deg(this.alpha));
    System.out.printf("b: %f beta: %f\n", b, Util.rad2deg(this.beta));
    System.out.printf("c: %f gamma: %f\n", c, Util.rad2deg(this.gamma));
    System.out.printf("area: %f\n", this.area);
    System.out.println();
  }

  // tests that the triangle lenghts and interior angles are consistent: yield same area
  protected boolean hasConsistentAttributes ()
  {
    final boolean test1 = Util.checkArea(this.a,
				         this.b,
				         this.c,
				         this.alpha,
				         this.beta,
				         this.gamma);
    final boolean test2 = Util.checkLenghts(this.a,
				            this.b,
				            this.c,
					    this.alpha,
				            this.beta,
				            this.gamma);
    if (!test1 || !test2) {
      return false;
    } else {
      return true;
    }
  }

  public static void main (String args[])
  {
    tarea();
    Triangle t = new Triangle(1, 1, 1);
    t.info();
    t = new Triangle(1, 1, 1.75);
    t.info();
    t = new Triangle(3, 4, 5);
    t.info();
    t = new Triangle(3, 4, 6);
    t.info();
  }

  // conduct areas tests with random triangles
  private static void tarea ()
  {
    boolean fail = true;
    final double r_min = 1;
    final double r_max = 16;
    final int num_tests = 65536;
    JRandom r = new JRandom(new Random());
    for (int i = 0; i != num_tests; ++i) {
      double a, b, c;
      do {
	a = r.fetch();
	b = r.fetch();
	c = r.fetch();
      } while (!Util.validate(a, b, c));
      Triangle t = new Triangle(a, b, c);
      fail = (!t.hasConsistentAttributes())? true : false;
      if (fail) {
	break;
      }
    }

    System.out.printf("area-test: ");
    if (fail) {
      System.out.printf("FAIL\n");
    } else {
      System.out.printf("PASS\n");
    }
  }
}

/*

JTriangle					April 18, 2024

source: Triangle.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

References:
[0] https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html

*/
