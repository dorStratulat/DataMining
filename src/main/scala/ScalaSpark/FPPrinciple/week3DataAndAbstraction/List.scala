package ScalaSpark.FPPrinciple.week3DataAndAbstraction


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

class Ex {
    def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
    singleton[Int](1)
    singleton[Boolean](true)
    singleton(2)
    singleton(true)
}

