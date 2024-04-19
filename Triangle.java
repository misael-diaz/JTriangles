import java.util.Random;

public class Triangle
{
  // triangle sides
  private double a = 0;
  private double b = 0;
  private double c = 0;

  // triangle interior angles
  private double alpha = 0;
  private double beta = 0;
  private double gamma = 0;

  // triangle area
  private double area = 0;

  // triangle kind: equilateral, isosceles, or scalene
  private String kind = "";

  // constructs a triangle with the given lengths if possible
  public Triangle (double a, double b, double c) {
    if (invalid(a, b, c)) {
      String errmsg = "Triangle: impossible to construct triangle with given lenghts";
      throw new IllegalArgumentException(errmsg);
    }
    this.a = a;
    this.b = b;
    this.c = c;
    this.angles();
    this.area();
    this.kind();
  }

  // implements a radians-to-degrees utility method
  private double rad2deg (double theta)
  {
    return ((180.0 / Math.PI) * theta);
  }

  // applies the cosine law to obtain the interior angles
  private void angles ()
  {
    final double cos_alpha = 0.5 * (((b * b) + (c * c) - (a * a)) / (b * c));
    final double cos_beta = 0.5 * (((a * a) + (c * c) - (b * b)) / (a * c));
    final double alpha = Math.acos(cos_alpha);
    final double beta = Math.acos(cos_beta);
    final double gamma = (Math.PI - alpha - beta);
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
  }

  // computes the triangle area
  private void area ()
  {
    final double base = this.b;
    final double height = this.a * Math.sin(gamma);
    this.area = (0.5 * base * height);
  }

  // determines the kind of triangle based on the given lengths
  private void kind ()
  {
    if (this.a == this.b) {
      this.kind = (this.a == this.c)? "equilateral" : "isosceles";
    } else {
      this.kind = (this.a == this.c)? "isosceles" : "scalene";
    }
  }

  // displays the triangle info on the console
  public void info ()
  {
    System.out.println();
    System.out.printf("kind: %s\n", this.kind);
    System.out.printf("a: %f alpha: %f\n", a, rad2deg(this.alpha));
    System.out.printf("b: %f beta: %f\n", b, rad2deg(this.beta));
    System.out.printf("c: %f gamma: %f\n", c, rad2deg(this.gamma));
    System.out.printf("area: %f\n", this.area);
    System.out.println();
  }

  // tests that we get the same triangle area regardless of the used formula
  private boolean test ()
  {
    final double tol = 2.3283064365386963e-10;
    final double a0 = (0.5 * a * b * Math.sin(gamma));
    final double a1 = (0.5 * a * c * Math.sin(beta));
    final double a2 = (0.5 * b * c * Math.sin(alpha));
    if (Math.abs(a1 - a0) > tol || Math.abs(a2 - a0) > tol || Math.abs(a2 - a1) > tol) {
      return true;
    } else {
      return false;
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

  // returns true if it is not possible to construct a triangle with the given lengths
  private static boolean invalid (final double a, final double b, final double c)
  {
    if (a <= 0 || b <= 0 || c <= 0) {
      return true;
    }
    // performs a geometric constraint test based on the fact that |cos(x)| <= 1
    return ((0.5 * Math.abs(((b * b) + (c * c) - (a * a)) / (b * c))) >= 1.0);
  }

  // conduct areas tests with random triangles
  private static void tarea ()
  {
    boolean fail = true;
    final double r_min = 1;
    final double r_max = 16;
    final int num_tests = 65536;
    Random r = new Random();
    for (int i = 0; i != num_tests; ++i) {
      double a, b, c;
      do {
	a = r_min + r.nextDouble() * (r_max - r_min);
	b = r_min + r.nextDouble() * (r_max - r_min);
	c = r_min + r.nextDouble() * (r_max - r_min);
      } while (invalid(a, b, c));
      Triangle t = new Triangle(a, b, c);
      fail = (t.test())? true : false;
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
[0] https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html#nextDouble()

*/
