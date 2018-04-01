import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

import permList.permList

/**
  * Created by a.a.perfilyev on 22.03.2018.
  */
object PermListScalaCheckSpec extends Properties("MyGen") {

  def genBoundedList(maxSize: Int, g: Gen[Int] = Gen.chooseNum(Int.MinValue, Int.MaxValue)): Gen[List[Int]] = {
    Gen.choose(0, maxSize) flatMap { sz => Gen.listOfN(sz, g) }
  }

  def compare(actual: List[List[Int]], expected: List[Int]): Boolean = {
    actual.diff(expected.permutations.toList).isEmpty && expected.permutations.toList.diff(actual).isEmpty
  }

  property("PermListUnique") = forAll(genBoundedList(5)) { (xs: List[Int]) =>
    compare(permList.permListUnique(xs),xs)
  }

  property("PermList") = forAll(genBoundedList(5)) { (xs: List[Int]) =>
    compare(permList.permList(xs),xs)
  }
}