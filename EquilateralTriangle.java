import java.util.Random;

public class EquilateralTriangle extends Triangle
{
  // for preventing debugging code from executing
  private boolean verbose = false;
  // equilateral triangle sides
  private double x = 0;
  // equilateral triangle interior angles
  private final double theta = Math.PI / 3;

  // constructs an equilateral triangle with the given length if possible
  public EquilateralTriangle (double x) {
    super(x, x, x);
    this.x = x;
    this.area();
    // although the constructor of the base class properly sets the kind we do so here
    this.kind = "equilateral";
  }

  // implements a radians-to-degrees utility method
  private double rad2deg (double theta)
  {
    return ((180.0 / Math.PI) * theta);
  }

  // computes the area of an equilateral triangle
  private void area ()
  {
    this.area = (0.25 * Math.sqrt(3) * this.x * this.x);
  }

  // displays the triangle info on the console
  public void info ()
  {
    System.out.println();
    System.out.printf("kind: %s\n", this.kind);
    System.out.printf("x: %f theta: %f\n", this.x, rad2deg(this.theta));
    System.out.printf("area: %f\n", this.area);
    if (verbose) {
      System.out.printf("a: %f alpha: %f\n", this.a, rad2deg(this.alpha));
      System.out.printf("b: %f beta: %f\n", this.b, rad2deg(this.beta));
      System.out.printf("c: %f gamma: %f\n", this.c, rad2deg(this.gamma));
    }
    System.out.println();
  }

  // tests that we get the same triangle area regardless of the used formula
  private boolean test ()
  {
    final double tol = 2.3283064365386963e-10;
    final double a0 = this.area;
    final double a1 = (0.5 * this.x * this.x * Math.sin(this.theta));
    if (Math.abs(a1 - a0) > tol) {
      return true;
    } else {
      return false;
    }
  }

  public static void main (String args[])
  {
    EquilateralTriangle t = new EquilateralTriangle(1);
    boolean final fail = t.test();
    if (!fail) {
      t.info();
    }
  }
}

/*

JTriangle					April 18, 2024

source: EquilateralTriangle.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

References:
[0] https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html#nextDouble()

*/