package hackerrank.Practice.InterviewPreparationKit.Arrays.ArrayManipulation

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

  // Complete the arrayManipulation function below.
  /**
    * 在一个长度为n的数组，做m次操作，每次操作将 a - b 之间的内容都加上k，最后求数组中的最大值
    * @param n 数组长度为n
    * @param queries 每次操作的内容
    * @return
    */
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    val qArr = Array.fill(n + 10){0L}
    queries.foreach(
      query => {
        qArr(query(0)) += query(2)
        qArr(query(1) + 1) -= query(2)
      }
    )
    var max = 0L
    var cnt = 0L
    qArr.foreach {
      x => {
        cnt += x
        max = Math.max(max, cnt)
      }
    }
    max
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val queries = Array.ofDim[Int](m, 3)

    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = arrayManipulation(n, queries)

    printWriter.println(result)

    printWriter.close()
  }

  def testData(): Unit = {
    val inputs = Array(
//      Array(2, 3, 4, 1, 5),
//      Array(4, 3, 1, 2),
//      Array(2, 1, 5, 3, 4),
//      Array(2, 5, 1, 3, 4),
//      Array(1, 2, 5, 3, 7, 8, 6, 4),
//      Array(1, 2, 3, 4, 5),
//      Array(1),
//      Array(3, 1, 2),
//      Array(3, 2, 1),
//      Array(5, 4, 3, 2, 1),
//      Array(1, 2, 3, 4, 5),
//      Array(7, 1, 3, 2, 4, 5, 6)
      /*
      */
    )
    /*
    inputs.foreach {
      input => println(arrayManipulation())
    }
    */
  }
}

