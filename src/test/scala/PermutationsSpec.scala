import org.scalatest.FlatSpec
import listPermutation.ListPermutator


class PermutationsSpec extends FlatSpec {

  val testedFunc: List[Int] => List[List[Int]] = ListPermutator.doPermutation

  def compare(actual: List[List[Int]], expected: List[Int]): Boolean = {
    actual.diff(expected.permutations.toList).isEmpty && expected.permutations.toList.diff(actual).isEmpty
  }

  "My permutation func" should "work right for empty list" in {
    val xs = List.empty[Int]
    assert(compare(testedFunc(xs), xs))
  }

  "My permutation func" should "work correctly with an example from the task" in {
    val xs = List(1,2,3)
    assert(compare(testedFunc(xs), xs))
  }

}
