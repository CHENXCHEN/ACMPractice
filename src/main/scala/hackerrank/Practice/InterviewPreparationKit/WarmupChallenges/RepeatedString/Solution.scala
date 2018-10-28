package hackerrank.Practice.InterviewPreparationKit.WarmupChallenges.RepeatedString

import java.io._

object Solution {
  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val aCnt = s.filter(_ == 'a').length
    var cnt = 0L
    cnt += s.substring(0, (n % s.length).toInt).filter(_ == 'a').length
    cnt += (n / s.length) * aCnt.toLong
    cnt
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    printWriter.println(result)

    printWriter.close()
  }

  def testData(): Unit = {
    println(repeatedString("aba", 10))
    println(repeatedString("a", 1000000000000L))
  }
}

