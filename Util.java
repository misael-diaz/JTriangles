// provides needed utilities as static methods
public class Util
{
  // implements a radians-to-degrees utility method
  public static double rad2deg (double theta)
  {
    return ((180.0 / Math.PI) * theta);
  }

  // interior angle computation util based on the cosine law
  public static double[] angles (final double a, final double b, final double c)
  {
    final double cos_alpha = 0.5 * (((b * b) + (c * c) - (a * a)) / (b * c));
    final double cos_beta = 0.5 * (((a * a) + (c * c) - (b * b)) / (a * c));
    final double alpha = Math.acos(cos_alpha);
    final double beta = Math.acos(cos_beta);
    final double gamma = (Math.PI - alpha - beta);
    double[] angles = {alpha, beta, gamma};
    return angles;
  }

  // computes the triangle area
  public static double area (final double base, final double height)
  {
    return (0.5 * base * height);
  }

  // determines the kind of triangle based on the given lengths
  public static String kind (final double a, final double b, final double c)
  {
    String kind;
    if (a == b) {
      kind = (a == c)? "equilateral" : "isosceles";
    } else {
      kind = (a == c)? "isosceles" : "scalene";
    }
    return kind;
  }

  // returns true if the given lengths and angles consistently yield the same area
  public static boolean checkArea (final double a,
				   final double b,
				   final double c,
      				   final double alpha,
				   final double beta,
				   final double gamma)
  {
    final double tol = 2.3283064365386963e-10;
    final double a0 = (0.5 * a * b * Math.sin(gamma));
    final double a1 = (0.5 * a * c * Math.sin(beta));
    final double a2 = (0.5 * b * c * Math.sin(alpha));
    if (Math.abs(a1 - a0) > tol || Math.abs(a2 - a0) > tol || Math.abs(a2 - a1) > tol) {
      return false;
    } else {
      return true;
    }
  }

  // returns true if we can construct a triangle with the given lengths, false otherwise;
  // uses a geometric constraint test based on the fact that |cos(x)| <= 1
  public static boolean validate (final double a, final double b, final double c)
  {
    if (a <= 0 || b <= 0 || c <= 0) {
      return false;
    }
    return ((0.5 * Math.abs(((b * b) + (c * c) - (a * a)) / (b * c))) < 1.0);
  }
}

/*

JTriangle					April 19, 2024

source: Util.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/
