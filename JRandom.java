import java.util.Random;

// defines a pseudo-random number generator that yields pseudo-random numbers in a range
// suitable for producing triangles with arbitrary lengths
public class JRandom
{
  private Random r;
  private final double r_min = 1;
  private final double r_max = 16;

  JRandom(Random r)
  {
    this.r = r;
  }

  // fetches a pseudo-random number in the asymmetric range [r_min, r_max)
  public double fetch ()
  {
    return (this.r_min + (this.r_max - this.r_min) * this.r.nextDouble());
  }
}

/*

JTriangle					April 18, 2024

source: JRandom.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

References:
[0] https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html#nextDouble()

*/
