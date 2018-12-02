package hackerrank.Practice.InterviewPreparationKit.Sorting.MarkandToys

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

  // Complete the maximumToys function below.
  /**
    * 给定N件商品的价格，如果有k的钱，最多可以卖多少件商品(个数)
    *
    * @param prices 每件商品的价格
    * @param k      一共拥有的钱
    * @return
    */
  def maximumToys(prices: Array[Int], k: Int): Int = {
    val sortedPrices = prices.sorted
    var allPrice = 0L
    var cnt = 0
    println(sortedPrices.toList)
    sortedPrices.foreach {
      x =>
        allPrice += x.toLong
        if (allPrice <= k.toLong) cnt += 1
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

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    printWriter.println(result)

    printWriter.close()
  }

  def testData(): Unit = {
    val test = Array(
      Pair(Array(1, 12, 5, 111, 200, 1000, 10), 50)
    )
    test.foreach {
      x => {
        println(maximumToys(x._1, x._2))
      }
    }
  }
}


