import org.scalatest.{FlatSpec, Matchers}
import permList.permList


class ListToAddressSpec extends FlatSpec with Matchers {

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

  "ListToAddress" should "work in usual case" in {
    val addr:Address = List("Ленина", 12, 32)
    addr.toString shouldBe "Ленина, 12, 32"
  }

  it should "work with Option apartment number" in {
    val addr:Address = List("Ленина", 12, Some(32))
    addr.toString shouldBe "Ленина, 12, 32"
  }


  it should "work without apartment number" in {
    val addr:Address = List("Ленина", 12)
    addr.toString shouldBe "Ленина, 12"
  }

  it should "work with random data after apartment number" in {
    val addr:Address = List("Ленина", 12, 11, "ASD","GGGGG")
    addr.toString shouldBe "Ленина, 12, 11"
  }

  it should "work when room number is not a number" in {
    val addr:Address = List("Ленина", 12, "!@#!@#!@#")
  }

  "an error" should "occur if house number is absent" in {
    intercept[Exception] {
      val addr:Address = List("Ленина")
    }
  }
}
