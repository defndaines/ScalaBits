class Anagram(val word: String) {
  val lower = word.toLowerCase
  val letters = lower.sorted

  def matches(ws: Seq[String]): Seq[String] =
    ws filter(w => w.toLowerCase != lower && w.toLowerCase.sorted == letters)
}
