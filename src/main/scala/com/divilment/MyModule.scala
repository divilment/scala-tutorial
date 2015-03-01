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

  def main(args: Array[String]): Unit = {
    formatResult("Fibonacci", 4, fib)
  }

}
