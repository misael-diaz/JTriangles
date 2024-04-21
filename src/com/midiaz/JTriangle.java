package com.midiaz;

import com.midiaz.util.Tag;
import com.midiaz.util.Util;
import com.midiaz.polygon.Triangle;
import com.midiaz.polygon.EquilateralTriangle;
import com.midiaz.polygon.IsoscelesTriangle;
import com.midiaz.polygon.ScaleneTriangle;

import java.util.Scanner;

// this is the main class
public class JTriangle
{
  public static void main (String args[])
  {
    System.out.println("JTriangle App");
    Scanner sc = new Scanner(System.in);
    System.out.printf("input the lenghts of a triangle: ");
    final double a = sc.nextDouble();
    final double b = sc.nextDouble();
    final double c = sc.nextDouble();
    final Tag tag = Util.tag(a, b, c);
    Triangle t;
    switch (tag) {
      case EQUILATERAL:
	t = new EquilateralTriangle(a);
	break;
      case ISOSCELES:
	t = new IsoscelesTriangle(a, b, c);
	break;
      default:
	t = new ScaleneTriangle(a, b, c);
    }
    // IMPORTANT:
    // we show the relevant info according to the triangle kind, for example it is not
    // necessary to show all the lengths of an equilateral triangle because all of them
    // are the same, so it suffices to show one. The same logic was applied to isosceles
    // triangles.
    t.info();
  }
}

/*

JTriangle					April 18, 2024

source: JTriangle.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

References:
[0] https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html

*/
