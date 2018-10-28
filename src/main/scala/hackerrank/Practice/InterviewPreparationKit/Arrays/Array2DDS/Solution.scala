package hackerrank.Practice.InterviewPreparationKit.Arrays.Array2DDS

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

  // Complete the hourglassSum function below.
  def hourglassSum(arr: Array[Array[Int]]): Int = {
    var maxSum = -10000
    for (x <- 0 until 4) {
      for (y <- 0 until 4) {
        val sum = arr(x).slice(y, y + 3).sum + arr(x + 1)(y + 1) + arr(x + 2).slice(y, y + 3).sum
        maxSum = math.max(sum, maxSum)
      }
    }
    maxSum
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }

  def testData(): Unit = {
    println(hourglassSum(Array(
      Array(1,1,1,0,0,0),
      Array(0,1,0,0,0,0),
      Array(1,1,1,0,0,0),
      Array(0,0,2,4,4,0),
      Array(0,0,0,2,0,0),
      Array(0,0,1,2,4,0)
    )))
    //    println(hourglassSum("aba", 10))
    //    println(repeatedString("a", 1000000000000L))
  }
}
