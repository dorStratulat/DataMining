package ScalaSpark.FPPrinciple.week1

object Lecture extends App {

  //x>= 0 - is a predicat
  def abs(x: Int) = if (x>= 0) x else -x

  /* Reduction rules for boolean expresion
  !true ------> false
  !false -----> true
  true && e -----> e
  false && e ----> false
  true || e -----> true
  false || e -----> e
  */

  def loop: Boolean = loop

  //is ok
  def x = loop
  //this will fail
  //val y = loop

  //rewrite this
  def and(x: Boolean, y:Boolean) = x && y

  //not great, because it will failled
  def and2(x: Boolean, y: Boolean) = if(x) y else false

  //ex when and2 failled, interupt execution, we pass the second arg as "by-value"
  // and2(false, loop)

  //the second param impl is call "by-name"
  def and3(x: Boolean, y: => Boolean) = if (x) y else false
  and3(false, loop)

  println(2)

}
