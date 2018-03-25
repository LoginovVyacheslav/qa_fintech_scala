package personConvertor

import person.Person

object Convertor{
  def convert(inputMap: Map[Int, (String, Int, String)]): List[Person] = {
    inputMap.map { case (key, (name, age, phone)) =>
      key -> Person(name,age,phone)
    }.values.toList
  }
}

