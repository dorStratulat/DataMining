package ScalaSpark.FPPrinciple.week1FPPrinciple


object Assignment extends App {

  override def main(args: Array[String]) {
//    println(pascal(0,2))
//    println(pascal(1,2))
//    println(pascal(1,3))
//    println (balance("())(".toList))
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(pascal(col, row) + " ")
//      println()
    println(countChange(100, List(1,5, 10,25, 50)).toString)

    /**
      *  Exercise 1 Pascal Triangle
      */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal (c, r-1)
    }

    /**
      * Exercise 2  Parentheses Balancing
      */
    def balance(chars: List[Char]): Boolean = {
      var opened: List[Char] = List()
      for (char <- chars) {
        if (char == '(' || char == '{' || char == '[')
          opened :::= List(char)
        else  if (char == ')') {
          if (opened.size > 0 && opened.last == '(') opened = opened.dropRight(1)
          else return false
        }
        else if (char == '}') {
          if (opened.size > 0 &&  opened.last == '{') opened = opened.dropRight(1)
          else return false
        }
        else if (char == ']') {
          if (opened.size > 0 &&  opened.last == '[') opened = opened.dropRight(1)
          else return false
        }
      }
       if (opened.size != 0) return false
       else true
    }

    /**
      * https://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_idx_722
      *
      * Exercise 3: Counting Change
      * Write a recursive function that counts how many different ways you can make
      * change for an amount, given a list of coin denominations. For example,
      * there are 3 ways to give change for 4 if you have coins with denomiation
      * 1 and 2: 1+1+1+1, 1+1+2, 2+2.
      *
      *The number of ways to change amount a using n kinds of coins equals

      *the number of ways to change amount a using all but the first kind of coin, plus
      *the number of ways to change amount a - d using all n kinds of coins,
      *           where d is the denomination of the first kind of coin.
      * Corner/Exit condition:
      * If a is exactly 0, we should count that as 1 way to make change.
      *     If money is less than 0, we should count that as 0 ways to make change.
      *     If n is 0, we should count that as 0 ways to make change.
      */
      def countChange(money: Int, coins: List[Int]): Int = {
          if (money == 0) return 1
          if (money < 0 || coins.size == 0) return 0
          def getDenomination(): Int = {
            return coins.last
          }
          return (countChange(money - getDenomination(), coins) +
                   countChange(money, coins.dropRight(1)))
      }

  }



}
