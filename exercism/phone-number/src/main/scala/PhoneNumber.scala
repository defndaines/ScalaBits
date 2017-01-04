class PhoneNumber(input: String) {

  val PhoneRegEx = """1?\(?(\p{Digit}{3})[). ]*(\p{Digit}{3})[-.]?(\p{Digit}{4})""".r

  def number(): Option[String] =
    input match {
      case PhoneRegEx(areaCode, prefix, lineNumber) => Some(areaCode + prefix + lineNumber)
      case _ => None
    }

  def areaCode(): Option[String] =
    input match {
      case PhoneRegEx(areaCode, prefix, lineNumber) => Some(areaCode)
      case _ => None
    }

  def prettyPrint(): Option[String] =
    input match {
      case PhoneRegEx(areaCode, prefix, lineNumber) => Some(s"($areaCode) $prefix-$lineNumber")
      case _ => None
    }
}
