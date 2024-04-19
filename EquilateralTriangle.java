public class EquilateralTriangle extends Triangle
{
  // for preventing debugging code from executing
  private boolean verbose = false;
  // equilateral triangle sides
  private final double x;
  // equilateral triangle area
  private final double area;
  // equilateral triangle interior angles
  private final double theta = Math.PI / 3;

  // constructs an equilateral triangle with the given length if possible
  public EquilateralTriangle (double x) {
    super(x, x, x);
    this.x = x;
    // computes the area of an equilateral triangle
    this.area = (0.25 * Math.sqrt(3) * this.x * this.x);
  }

  // displays the triangle info on the console
  public void info ()
  {
    System.out.println();
    System.out.printf("kind: %s\n", this.kind());
    System.out.printf("x: %f theta: %f\n", this.x, Util.rad2deg(this.theta));
    System.out.printf("area: %f\n", this.area);
    if (verbose) {
      System.out.printf("a: %f alpha: %f\n", this.a, Util.rad2deg(this.alpha));
      System.out.printf("b: %f beta: %f\n", this.b, Util.rad2deg(this.beta));
      System.out.printf("c: %f gamma: %f\n", this.c, Util.rad2deg(this.gamma));
    }
    System.out.println();
  }

  public static void main (String args[])
  {
    EquilateralTriangle t = new EquilateralTriangle(1);
    final boolean fail = t.hasConsistentAttributes();
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

*/
