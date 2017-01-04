class DNA(val sequence: String) {

  val validBases = Set('A', 'C', 'G', 'T')
  val baseCounts = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)

  def baseOf(base: Char): Either[String, Char] =
    if (validBases.contains(base))
      Right(base)
    else
      Left("invalid nucleotide '" + base + "'")

// Crappy solution which totally fails to use Either's features.
  def count(base: Char): Either[String, Int] =
    sequence map(baseOf) find(_.isLeft) match {
      case Some(Left(msg)) => Left(msg)
      case None => 
        baseOf(base) match {
          case Right(_) => Right(sequence count (_ == base))
          case Left(msg) => Left(msg)
        }
    }

// Again, failing to figure out how to compose against Either
  def nucleotideCounts(): Either[String, Map[Char, Int]] =
    sequence map(baseOf) find(_.isLeft) match {
      case Some(Left(msg)) => Left(msg)
      case None =>
        Right(baseCounts ++ (sequence groupBy(identity) mapValues(_.length)))
    }
}