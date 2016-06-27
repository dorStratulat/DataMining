package ScalaSpark.FPPrinciple.week2HighOrderFunctions


object Main extends App {
  import FunSets._
  //import FunSets._
  singletonSet(1)
  println(contains(singletonSet(1), 1))
  val firstUnion = union(singletonSet(1), singletonSet(2))
  val secondUnion = union(firstUnion, singletonSet(3))
  val thirdUnion = union(secondUnion, singletonSet(-1))
  printSet(thirdUnion)
  printSet(filter(thirdUnion, (x:Int) => x > 0))

  println("*********************************************")
  singletonSet(1)
  println(contains(singletonSet(1), 1))
  val firstUnion1 = union(singletonSet(1), singletonSet(2))
  val secondUnion1 = union(firstUnion1, singletonSet(3))
  val thirdUnion1 = union(secondUnion1, singletonSet(-1))
  printSet(thirdUnion1)
  printSet(filter(thirdUnion1, (x:Int) => x > 0))
}
