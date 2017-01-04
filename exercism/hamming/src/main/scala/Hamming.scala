object Hamming {
  def compute(left: String, right: String): Option[Int] =
    if (left.length == right.length)
      Some(left.zip(right) count(p => p._1 != p._2))
    else
      None
}
