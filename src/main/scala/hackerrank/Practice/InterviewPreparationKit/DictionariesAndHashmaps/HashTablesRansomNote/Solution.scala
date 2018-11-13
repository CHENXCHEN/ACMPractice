package hackerrank.Practice.InterviewPreparationKit.DictionariesAndHashmaps

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

object Solution {

  /**
    * 判断magazine数组中的字符串是否能组成note数组
    * @param magazine 杂志数组
    * @param note   笔记数组
    */
  // Complete the checkMagazine function below.
  def checkMagazine(magazine: Array[String], note: Array[String]): Unit = {
    val mMap = magazine.zipWithIndex.groupBy(_._1).map {
      case (key, arrVal) => key -> arrVal.length
    }
    val nMap = note.zipWithIndex.groupBy(_._1).map {
      case (key, arrVal) => key -> arrVal.length
    }
    var check = true
    nMap.foreach {
      case (key, cnt) => check &= mMap.getOrElse(key, 0) >= cnt
    }
    if(check) println("Yes")
    else println("No")
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val mn = stdin.readLine.split(" ")

    val m = mn(0).trim.toInt

    val n = mn(1).trim.toInt

    val magazine = stdin.readLine.split(" ")

    val note = stdin.readLine.split(" ")
    checkMagazine(magazine, note)
  }

  def testData(): Unit = {
    val inputs = Array(
      Array(
        "give me one grand today night",
        "give one grand today"
      ),
      Array(
        "two times three is not four",
        "two times two is four"
      ),
      Array(
        "ive got a lovely bunch of coconuts",
        "ive got some coconuts"
      )
    )
    inputs.foreach {
      x => checkMagazine(x(0).split(" "), x(1).split(" "))
    }
  }
}

