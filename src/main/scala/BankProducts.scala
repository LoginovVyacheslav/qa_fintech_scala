package BankProducts

trait MarketNamable { val marketName: String }
trait Balancable {
  var balance: Int
  def withdraw(amount:Int):Boolean = {
    if (amount >= 0) {
      if(balance > amount) { balance = balance - amount }
      // return false if not enough balance to withdraw
      // no overdraft
    }
    (balance < amount) && (amount >= 0)
  }
  def deposit(amount:Int):Boolean = {
    if(amount>=0)
      balance = balance + amount
    amount>=0
  }
}

abstract class BankProducts extends MarketNamable with Balancable

case class Debet(val marketName:String, var balance:Int) extends BankProducts {
  //Debet-specific logic will be defined here
}
case class DebetCard(val marketName:String, var balance:Int) extends BankProducts {
  //DebetCard-specific logic will be defined here
}
case class CreditCard(val marketName:String, var balance:Int) extends BankProducts {
  //CreditCard-specific logic will be defined here
}

