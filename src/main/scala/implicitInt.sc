implicit class OptionIntImplicit(n: Option[Int]){
  def default = { n.getOrElse(0) }
}

Some(10).default // => 10

Option.empty[Int].default // => 0