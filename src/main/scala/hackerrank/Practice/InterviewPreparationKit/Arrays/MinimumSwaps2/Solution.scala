package hackerrank.Practice.InterviewPreparationKit.Arrays.MinimumSwaps2

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable
import scala.util.control.Breaks

object Solution {

  // Complete the minimumSwaps function below.
  def minimumSwaps(arr: Array[Int]): Int = {
    val qArr = arr.map(_ - 1)
    var cnt = 0
//    println(qArr.toSeq)
    for (x <- qArr.indices) {
      while (qArr(x) != x && qArr(x) < qArr.length) {
        val pos1 = x
        val pos2 = qArr(x)
        val tmp1 = qArr(pos1)
        val tmp2 = qArr(pos2)
        qArr(pos1) = tmp2
        qArr(pos2) = tmp1
        cnt += 1
//        println(qArr.toSeq)
//        println(s"$pos1 $tmp1 $pos2 $tmp2")
      }
    }
    cnt
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val res = minimumSwaps(arr)

    printWriter.println(res)

    printWriter.close()
  }

  def testData(): Unit = {
    val inputs = Array(
      Array(2, 3, 4, 1, 5),
      Array(4, 3, 1, 2),
      Array(2, 1, 5, 3, 4),
      Array(2, 5, 1, 3, 4),
      Array(1, 2, 5, 3, 7, 8, 6, 4),
      Array(1, 2, 3, 4, 5),
      Array(1),
      Array(3, 1, 2),
      Array(3, 2, 1),
      Array(5, 4, 3, 2, 1),
      Array(1, 2, 3, 4, 5),
      Array(7, 1, 3, 2, 4, 5, 6)
      /*
      */
    )
    inputs.foreach {
      input => println(minimumSwaps(input))
    }
  }
}

