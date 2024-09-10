package x

trait A {
  def y(m: Map[Int, Int]) = m.mapValues(a => a)
}
