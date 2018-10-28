package hackerrank.Practice.InterviewPreparationKit.WarmupChallenges.CountingValleys
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

  // Complete the countingValleys function below.
  def countingValleys(n: Int, s: String): Int = {
    var cnt = 0
    var level = 0
    s.foreach(
      x => {
        if (x == 'D' && level == 0) cnt += 1
        level += (if (x == 'D') -1 else 1)
      }
    )
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

    val s = stdin.readLine

    val result = countingValleys(n, s)

    printWriter.println(result)

    printWriter.close()
  }

  def testData(): Unit = {
    println(countingValleys(8, "UDDDUDUU".toString))
  }
}
