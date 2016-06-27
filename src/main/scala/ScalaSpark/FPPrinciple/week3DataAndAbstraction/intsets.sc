
//tree:
//   1. tree for the EmptySEt and
//   2. a tree consisting of an integer and 2 sub-trees
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  //incl an element into IntSet
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."

}
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" + left + elem + right + "}"
}


val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4
t2.contains(1)
def error(msg: String ) = throw new Error(msg)




  /*
     persistent data structures
      Note: pure functional, so when we are calling incl,
         we are creating actually another Tree(see new ....)
   */
