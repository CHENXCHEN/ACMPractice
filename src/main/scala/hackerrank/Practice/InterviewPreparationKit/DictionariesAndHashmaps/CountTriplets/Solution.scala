package hackerrank.Practice.InterviewPreparationKit.DictionariesAndHashmaps.CountTriplets

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._
import scala.collection.mutable


object Solution {

  /**
    * 统计数组中有多少3对数以r为系数的等比数列, arr[i] < arr[j] < arr[k], arr[i] * r = arr[j], arr[j] * r = arr[k]
    *
    * @param arr 给定的数组
    * @param r   等比系数
    * @return
    */
  // Complete the countTriplets function below.
  def countTriplets(arr: Array[Long], r: Long): Long = {
    var doHash = mutable.Map[Long, Boolean]()
    var hashCnt1 = mutable.Map[Long, Long]()
    var hashCnt2 = mutable.Map[Long, Long]()
    var hashCnt3 = mutable.Map[Long, Long]()
    var ans = 0L
    for (x <- arr.length - 1 to 0 by -1) {
      hashCnt2 += arr(x) -> (hashCnt2.getOrElse(arr(x), 0L) + hashCnt1.getOrElse(arr(x) * r, 0L))
      hashCnt3 += x.toLong -> hashCnt1.getOrElse(arr(x) * r, 0L)
      hashCnt1 += arr(x) -> (hashCnt1.getOrElse(arr(x), 0L) + 1L)
    }
    if(r > 1) {
      for ((x, pos) <- arr.zipWithIndex) {
        val y = x * r
        ans += hashCnt2.getOrElse(y, 0L)
        //        println(ans, y, hashCnt2.getOrElse(y, 0))
        if(hashCnt2.getOrElse(x, 0L) > 0L) {
          hashCnt2 += x -> (hashCnt2(x) - hashCnt3(pos))
        }
      }
    } else {
      for (x <- arr) {
        if(doHash.getOrElse(x, true)) {
          val n = hashCnt1(x)
          if(n >= 3) {
            ans += (n - 1) * (n - 2) * n / 6
          }
        }
        doHash += x -> false
      }
    }
    ans
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nr = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = nr(0).toInt

    val r = nr(1).toLong

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toLong)
    val ans = countTriplets(arr, r)

    printWriter.println(ans)

    printWriter.close()
  }

  def testData(): Unit = {
    val inputs = Array(
      Array("1 2 2 4", "2", "2"),
      Array("1 3 9 9 27 81", "3", "6"),
      Array("1 5 5 25 125", "5", "4"),
      Array("1 1 1 1", "1", "4"),
      Array("1 2 1 2 4", "2", "3"),
      Array("1 2 2 4 2", "2", "2"),
      Array("1 2 1 2 4 2 4", "2", "8")
    )
    inputs.foreach {
      x => {
        val res = countTriplets(x(0).split(" ").map(_.trim.toLong), x(1).toLong)
        println(res, res == x(2).toLong)
      }
    }
  }
}
