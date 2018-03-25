import org.scalatest.FlatSpec
import BankProducts._

class BankProductsSpec extends FlatSpec {

  val debet = Debet("Debet", 100)
  val creditCard = CreditCard("AllAirlines", 1000)
  val debetCard = DebetCard("Black", 200)

  "BankProducts" should "work correctly with an example from the task" in {
    val products: List[BankProducts] = List(debet, creditCard, debetCard)
    val sumBalance = products.map(_.balance).sum
    assert(sumBalance == 1300)
  }
}