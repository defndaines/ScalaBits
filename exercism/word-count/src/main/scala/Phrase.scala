class Phrase(val phrase: String) {
  def wordCount(): Map[String, Int] =
    phrase.toLowerCase.split("[^\\p{Alnum}']+") groupBy(identity) mapValues(_.size)
}
