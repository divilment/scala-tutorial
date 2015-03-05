package com.divilment

object MyModule {

  private def fib(n: Int) : Int = {
    @annotation.tailrec
    def fib_rec(n: Int, nm2: Int, nm1: Int): Int =
      if (n == 0) nm2
      else fib_rec(n - 1, nm1, nm2 + nm1)

    fib_rec(n, 0, 1)
  }

  private def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "%s(%d) = %d"
    val result = f(n)
    println(msg.format(name, n, result))
  }

  private def add(a: Int, b: Int): Int = {
    a + b
  }

  private def curry[A,B,C](f: (A, B) => C): A => B => C = {
    (a: A) => ((b: B) => f(a, b))
  }

  private def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def main(args: Array[String]): Unit = {
    formatResult("Fibonacci", 4, fib)
    val curry_add = curry(add)
    val add1 = curry_add(1)
    val result = add1(5)
    val add_basic = uncurry(curry_add)
    println(result)
    println(add_basic(3,4))
  }

}
