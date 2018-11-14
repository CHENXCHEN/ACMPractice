package hackerrank.Practice.InterviewPreparationKit.DictionariesAndHashmaps.SherlockAndAnagrams

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable.Vector

object Solution {

  /**
    * 判断字符串s中有多少对子串打乱之后可以重组成功
    * @param s 给定的字符串
    * @return
    */
  // Complete the sherlockAndAnagrams function below.
  def sherlockAndAnagrams(s: String): Int = {
    var allSubList: Vector[String] = Vector.empty[String]
    for(start <- 0 until s.length) {
      for(end <- start + 1 to s.length) {
        allSubList :+= s.substring(start, end).sorted
      }
    }
//    println(allSubList)
    allSubList.zipWithIndex.groupBy(_._1).map {
      case (subStr, list) => {
        val cnt = list.length
        if(cnt > 1) (1 + cnt - 1) * (cnt - 1) / 2
        else 0
      }
    }.sum
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
      val s = stdin.readLine

      val result = sherlockAndAnagrams(s)

      printWriter.println(result)
    }

    printWriter.close()
  }

  def testData(): Unit = {
    val inputs = Array(
      "abba",
      "abcd",
      "ifailuhkqq",
      "kkkk",
      "cdcd"
    )
    inputs.foreach {
      x => println(sherlockAndAnagrams(x))
    }
  }
}

