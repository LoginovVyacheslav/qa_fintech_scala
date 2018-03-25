package listPermutation

object ListPermutator {
  def doPermutation(inputList: List[Int]): List[List[Int]] = {
    inputList.permutations.toList
    //mutation test:
    //List(inputList)
  }
}

