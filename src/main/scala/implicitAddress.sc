case class Address(street: String, house: Int, apartment: Option[Int]) {
  override def toString: String = {
    s"$street, $house${apartment.fold("")(", " + _)}"
  }
}

implicit def listToAddress(xs: List[Any]): Address = {
  xs match {
    case List(x: String, y: Int, z: Int, _*) => Address(x, y, Option[Int](z))
    case List(x: String, y: Int, z: Option[Int], _*) => Address(x, y, z)
    case List(x: String, y: Int, _*) => Address(x, y, None)
    case x => throw new Exception(s"Can't construct Address from $x")
  }
}

def printAddress(address: Address): Unit = {
  print(address)
}

printAddress(List("Ленина", 12, Some(11)))
printAddress(List("Ленина", 12, 11))
printAddress(List("Ленина", 12))
printAddress(List("Ленина", 12, 11, "ASD","GGGGG"))
printAddress(List("Ленина", 12, "!@#!@#!@#"))
printAddress(List("Ленина"))