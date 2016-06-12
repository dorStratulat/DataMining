package ScalaSpark.FPPrinciple.week1


object Recursion extends App {
  /*

  sqrt(x)
  - start with an initial estimate y (let's pick y =1)
  - repeatedly improve the estimate by taking the mean of y and x/y
  Ex x = 2:

  Estimation      Quotient               Mean
  1               2 /1 = 2              1.5
  1.5             2 /1.5 = 1.333        1.4167
  1.4167          2 / 1.4167 = 1.4118   1.4142
  1.4142         ......                 ...

    Note: Recursive functions need an explicit return type in Scala

   */
  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      Math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)

  }

  println(sqrt(2))
  println(sqrt(4))

  def gcd(a: Int, b: Int): Int =
     if(b == 0) a else gcd(b, a % b)

  def factorial (n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
       if (n == 0) acc
       else loop (acc*n, n-1)

    loop(1, n)
  }


}
