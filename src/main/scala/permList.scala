package permList

object permList {
  //permList does not assume repeat elements
  def permList(l: List[Int]): List[List[Int]] = l match {
    case Nil => List(Nil)
    case List(ele) => List(List(ele))
    case xs => xs.indices.flatMap(i => permList(xs.slice(0, i) ++ xs.slice(i + 1, xs.length))
      .map(p => xs(i) :: p)).toList
  }

  //permListUnique support list with repeat elements
  def permListUnique(l: List[Int]): List[List[Int]] = {
    l.permutations.toList
  }
}