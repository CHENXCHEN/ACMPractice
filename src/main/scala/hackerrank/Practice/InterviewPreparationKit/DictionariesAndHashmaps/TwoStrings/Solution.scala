package hackerrank.Practice.InterviewPreparationKit.DictionariesAndHashmaps.TwoStrings

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

  /**
    * 判断两个字符串中是否存在公共子串
    * @param s1 一个字符串
    * @param s2 另一个字符串
    * @return 是否存在公共字串，Yes为是，No为否
    */
  // Complete the twoStrings function below.
  def twoStrings(s1: String, s2: String): String = {
    val s1Set = s1.toSet
    val s2Set = s2.toSet
    val sInter = s1Set.intersect(s2Set)
    if(sInter.nonEmpty) "YES"
    else "NO"
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s1 = stdin.readLine

      val s2 = stdin.readLine

      val result = twoStrings(s1, s2)

      printWriter.println(result)
    }

    printWriter.close()
  }

  def testData(): Unit = {
    val inputs = Array(
      Array(
        "hello",
        "world"
      ),
      Array(
        "hi",
        "world"
      )
    )
    inputs.foreach {
      x => println(twoStrings(x(0), x(1)))
    }
  }
}

