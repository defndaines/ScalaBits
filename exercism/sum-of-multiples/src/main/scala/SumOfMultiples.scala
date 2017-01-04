object SumOfMultiples {
  def sumOfMultiples(list: List[Int], n: Int): Int = {
    def isMultiple(x: Int): Boolean = list exists (x % _ == 0)
    (1 until n) filter isMultiple sum
  }
}
