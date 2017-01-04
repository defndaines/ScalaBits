object Pangrams {
  val Alphabet = ('a' to 'z')

  def isPangram(phrase: String): Boolean =
    (Alphabet intersect phrase.toLowerCase) == Alphabet
}
