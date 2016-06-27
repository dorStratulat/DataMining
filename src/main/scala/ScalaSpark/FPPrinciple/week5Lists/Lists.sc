//import ScalaSpark.FPPrinciple.week3DataAndAbstraction.{Cons, Nil}
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

}
class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}
class Nil[T] extends List[T] {
  def isEmpty: Boolean = true;
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
object nth {
  def nth[T] (n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    if (n == 0) xs.head
    else nth(n-1, xs.tail)
  }



}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth.nth(2, list)
nth.nth(4, list)




