class Bob {
  private def isShout(phrase: String): Boolean =
    phrase.toUpperCase == phrase && phrase.toLowerCase != phrase

  def hey(phrase: String): String =
    phrase match {
      case silent if silent.trim.isEmpty => "Fine. Be that way!"
      case shout if isShout(shout) => "Whoa, chill out!"
      case question if question.endsWith("?") => "Sure."
      case _ => "Whatever."
    }
}