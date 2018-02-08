package neurocat

import cats.arrow.Category


trait MonoidalCat[F[_, _]] extends Category[F] {
  def product[A, B, C, D](lhs: F[A, B], rhs: F[C, D]): F[(A, C), (B, D)]
}


trait SymmetricMonoidalCat[F[_, _]] extends MonoidalCat[F] {
  def braiding[A, B, C, D](l: F[(A, C), (B, D)]): F[(C, A), (D, B)]
}


trait Comonoid[M] {
  def split(m: M): (M, M)
  def destroy(m: M): Unit
}

object Comonoid {
  def apply[M](implicit M: Comonoid[M]): Comonoid[M] = M
}