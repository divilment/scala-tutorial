package com.divilment

object MyModule {

  private def fib(n: Int) : Int = {
    @annotation.tailrec
    def fib_rec(n: Int, nm2: Int, nm1: Int): Int =
      if (n == 0) nm2
      else fib_rec(n - 1, nm1, nm2 + nm1)

    fib_rec(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fib(5))
  }

}
