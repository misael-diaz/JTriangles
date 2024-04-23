package com.midiaz.polygon;

import com.midiaz.util.Util;
import com.midiaz.polygon.Triangle;

public class IsoscelesTriangle extends Triangle
{
  // for preventing debugging code from executing
  private boolean verbose = false;
  // isosceles triangle sides (x, x, and y)
  private final double x;
  private final double y;
  // isosceles triangle area
  private final double area;
  // isosceles triangle interior angles (relationship of angles and lenghts are in info())
  private final double theta;
  private final double phi;

  // constructs an isosceles triangle with the given length if possible
  public IsoscelesTriangle (final double x0, final double y0, final double z0)
  {
    super(x0, y0, z0);

    if (invalid(x0, y0, z0)) {
      String errmsg = "IsoscelesTriangle: invalid supplied triangle lengths";
      throw new IllegalArgumentException(errmsg);
    }

    double x, y;
    if (x0 == y0) {
      x = x0;
      y = z0;
    } else if (x0 == z0) {
      x = x0;
      y = y0;
    } else {
      x = y0;
      y = x0;
    }

    this.x = x;
    this.y = y;
    // computes the interior angles by taking advantage of the geometric features
    this.phi = 2.0 * Math.asin((0.5 * this.y) / this.x);
    this.theta = 0.5 * (Math.PI - this.phi);
    // computes the area of the isosceles triangle
    this.area = (0.5 * this.y * Math.sqrt(this.x * this.x - 0.25 * this.y * this.y));
  }

  // displays the triangle info on the console
  @Override
  public void info ()
  {
    System.out.println();
    System.out.printf("kind: %s\n", this.kind());
    //System.out.printf("x: %f theta: %f\n", this.x, Util.rad2deg(this.theta));
    System.out.printf("area: %f\n", this.area);
    if (verbose) {
      if (this.hasConsistentArea()) {
	System.out.printf("area-test: ");
	System.out.println("PASS");
      } else {
	System.out.println("FAIL");
      }
      System.out.printf("a: %f alpha: %f\n", this.a, Util.rad2deg(this.alpha));
      System.out.printf("b: %f beta: %f\n", this.b, Util.rad2deg(this.beta));
      System.out.printf("c: %f gamma: %f\n", this.c, Util.rad2deg(this.gamma));
      System.out.printf("x: %f theta: %f\n", this.x, Util.rad2deg(this.theta));
      System.out.printf("y: %f phi: %f\n", this.y, Util.rad2deg(this.phi));
    } else {
      System.out.printf("x: %f theta: %f\n", this.x, Util.rad2deg(this.theta));
      System.out.printf("y: %f phi: %f\n", this.y, Util.rad2deg(this.phi));
    }
    System.out.println();
  }

  // returns true if the area differnce is less or equal to the tolerance, false otherwise
  private boolean hasConsistentArea ()
  {
    if (Math.abs(this.area() - this.area) > Util.TOL) {
      return false;
    } else {
      return true;
    }
  }

  // returns true if we don't have an isosceles triangle, false otherwise
  private boolean invalid (final double x0, final double y0, final double z0)
  {
    if (x0 == y0) {
      return false;
    } else if (x0 == z0) {
      return false;
    } else {
      if (y0 == z0) {
	return false;
      } else {
	return true;
      }
    }
  }

  public static void main (String args[])
  {
    IsoscelesTriangle t = new IsoscelesTriangle(1, 1, Math.sqrt(2));
    if (t.verbose) {
      if (!t.hasConsistentAttributes()) {
	System.out.println("FAIL");
      } else {
	System.out.println("PASS");
      }
    }
    t.info();

    t = new IsoscelesTriangle(1, Math.sqrt(2), 1);
    if (t.verbose) {
      if (!t.hasConsistentAttributes()) {
	System.out.println("FAIL");
      } else {
	System.out.println("PASS");
      }
    }
    t.info();

    t = new IsoscelesTriangle(Math.sqrt(2), 1, 1);
    if (t.verbose) {
      if (!t.hasConsistentAttributes()) {
	System.out.println("FAIL");
      } else {
	System.out.println("PASS");
      }
    }
    t.info();
  }
}

/*

JTriangle					April 18, 2024

source: IsoscelesTriangle.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/
