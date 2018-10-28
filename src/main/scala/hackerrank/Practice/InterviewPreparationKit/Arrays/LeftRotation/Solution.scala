package hackerrank.Practice.InterviewPreparationKit.Arrays.LeftRotation
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

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    a.slice(d, a.length) ++ a.slice(0, d)
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nd = stdin.readLine.split(" ")

    val n = nd(0).trim.toInt

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
  def testData(): Unit = {
    println(rotLeft(Array(1,2,3,4,5), 4).toSeq)
  }
}
