package hackerrank.Practice.InterviewPreparationKit.Sorting.SortingBubbleSort

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {
  // Complete the countSwaps function below.
  def countSwaps(a: Array[Int]): Unit = {
    var cnt = 0
    for(i <- a.indices) {
      for (j <- i + 1 until a.length) {
        if(a(i) > a(j)) {
          val tmp = a(j)
          a(j) = a(i)
          a(i) = tmp
          cnt += 1
        }
      }
    }
    println(s"Array is sorted in $cnt swaps.")
    println(s"First Element: ${a.head}")
    println(s"Last Element: ${a.last}")
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    countSwaps(a)
  }

  def testData(): Unit = {
    val test = Array(
      Array(1, 2, 3),
      Array(3, 2, 1)
    )
    test.foreach {
      x => countSwaps(x)
    }
  }
}
