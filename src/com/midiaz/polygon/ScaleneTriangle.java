package com.midiaz.polygon;

import com.midiaz.util.Util;
import com.midiaz.polygon.Triangle;

public class ScaleneTriangle extends Triangle
{
  // for preventing debugging code from executing
  private boolean verbose = false;

  // constructs an scalene triangle with the given lengths if possible
  public ScaleneTriangle (final double x, final double y, final double z)
  {
    super(x, y, z);

    if (invalid(x, y, z)) {
      String errmsg = "ScaleneTriangle: invalid supplied triangle lengths";
      throw new IllegalArgumentException(errmsg);
    }
  }

  // returns true if we don't have an scalene triangle, false otherwise
  private boolean invalid (final double x0, final double y0, final double z0)
  {
    if (x0 == y0) {
      return true;
    } else if (x0 == z0) {
      return true;
    } else {
      if (y0 == z0) {
	return true;
      } else {
	return false;
      }
    }
  }

  public static void main (String args[])
  {
    ScaleneTriangle t = new ScaleneTriangle(3, 4, 5);
    if (t.verbose) {
      if (!t.hasConsistentAttributes()) {
	System.out.println("FAIL");
      } else {
	System.out.println("PASS");
      }
    }
    t.info();

    t = new ScaleneTriangle(4, 5, 3);
    if (t.verbose) {
      if (!t.hasConsistentAttributes()) {
	System.out.println("FAIL");
      } else {
	System.out.println("PASS");
      }
    }
    t.info();

    t = new ScaleneTriangle(5, 3, 4);
    if (t.verbose) {
      if (!t.hasConsistentAttributes()) {
	System.out.println("FAIL");
      } else {
	System.out.println("PASS");
      }
    }
    t.info();

    t = new ScaleneTriangle(6, 3, 4);
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

JTriangle					April 19, 2024

source: ScaleneTriangle.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/
