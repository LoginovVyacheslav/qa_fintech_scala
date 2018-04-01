import org.scalatest.{FlatSpec, Matchers}
import permList.permList


class PermListSpec extends FlatSpec with Matchers {
  val testedFunc: List[Int] => List[List[Int]] = permList.permList

  "PermList (empty list)" should "equal list(Nil)" in {
    val xs = List.empty[Int]
    testedFunc(xs) shouldBe List(xs)
  }

  "PermList (list)" should "not equal to input list" in {
    val xs = List(1,2,3)
    testedFunc(xs) should not equal xs
  }

  it should "have correct number of elements" in {
    val xs = List(1, 2, 3, 4, 5)
    val permutatedList = permList.permList(xs)
    permutatedList should have size 2*3*4*5


    val xs2 = List(1, 1, 1, 2, 1)
    val permutatedList2 = permList.permList(xs2)
    permutatedList2 should have size 5

    val xs3 = List(1, 1, 1, 1, 1)
    val permutatedList3 = permList.permList(xs3)
    permutatedList3 should have size 1
  }

  it should "have unique elements" in {
    val xs = List(1,2,3,4,5)
    val permutatedList = permList.permList(xs)
    for(element <- permutatedList){
      permutatedList.filter(x => x != element) should have size (permutatedList.size - 1)
    }
  }

  it should "have all permutations" in {
    val xs = List(1,2,3,4,5)
    def compare(actual: List[List[Int]], expected: List[Int]): Boolean = {
      actual.diff(expected.permutations.toList).isEmpty && expected.permutations.toList.diff(actual).isEmpty
    }

    assert(compare(permList.permList(xs),xs))
  }

  val testedFunc2: List[Int] => List[List[Int]] = permList.permListUnique

  "PermListUnique (empty list)" should "equal list(Nil)" in {
    val xs = List.empty[Int]
    testedFunc2(xs) shouldBe List(xs)
  }

  "PermListUnique (list)" should "not equal to input list" in {
    val xs = List(1,2,3)
    testedFunc2(xs) should not equal xs
  }

  it should "have correct number of elements" in {
    val xs = List(1, 2, 3, 4, 5)
    val permutatedList = testedFunc2(xs)
    permutatedList should have size 2*3*4*5


    val xs2 = List(1, 1, 1, 2, 1)
    val permutatedList2 = testedFunc2(xs2)
    permutatedList2 should have size 5

    val xs3 = List(1, 1, 1, 1, 1)
    val permutatedList3 = testedFunc2(xs3)
    permutatedList3 should have size 1
  }

  it should "have unique elements" in {
    val xs = List(1,2,3,4,5)
    val permutatedList = testedFunc2(xs)
    for(element <- permutatedList){
      permutatedList.filter(x => x != element) should have size (permutatedList.size - 1)
    }
  }

  it should "have all permutations" in {
    val xs = List(1,2,3,4,5)
    def compare(actual: List[List[Int]], expected: List[Int]): Boolean = {
      actual.diff(expected.permutations.toList).isEmpty && expected.permutations.toList.diff(actual).isEmpty
    }

    assert(compare(testedFunc2(xs),xs))
  }
}
