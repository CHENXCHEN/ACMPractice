package hackerrank.Practice.InterviewPreparationKit.DictionariesAndHashmaps.FrequencyQueries

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
import scala.collection.immutable.Vector

object Solution {

  // Complete the freqQuery function below.
  /**
    * 给定一组操作，操作类型有三种 1.添加x，2.删除x，3.是否存在出现次数为x(1 -> 有, 0 -> 没有).
    *
    * @param queries 一组操作
    * @return
    */
  def freqQuery(queries: Array[Array[Int]]): Array[Int] = {
    var cntMap = mutable.Map[Long, Long]()
    var cntArr = mutable.Map[Long, Long]()
    var ans = Vector.empty[Int]
    queries.foreach {
      rr => {
//        print("operation: ", rr.toList)
        rr(0) match {
          case 1 =>
            val _cnt = cntArr.getOrElse(rr(1).toLong, 0L)
            cntArr += rr(1).toLong -> (_cnt.toLong + 1L)
            cntMap += _cnt -> (cntMap.getOrElse(_cnt, 1L) - 1L)
            cntMap += (_cnt + 1) -> (cntMap.getOrElse(_cnt + 1L, 0L) + 1L)
//            println(cntArr, cntMap)
          case 2 =>
            val _cnt = cntArr.getOrElse(rr(1).toLong, 0L)
            val _rcnt = if (_cnt > 0) _cnt - 1L else 0L
            cntArr += rr(1).toLong -> _rcnt
            var cntMapCnt = cntMap.getOrElse(_cnt, 1L)
            if(cntMapCnt <= 0)  cntMapCnt = 0
            else cntMapCnt -= 1
            cntMap += _cnt -> cntMapCnt
            if(_cnt > 1) {
              cntMap += (_cnt - 1) -> (cntMap.getOrElse(_cnt - 1, 0L) + 1)
            }
//            println(cntArr, cntMap)
          case 3 =>
            val _cnt = cntMap.getOrElse(rr(1).toLong, 0L)
            if (rr(1) == 0) {
              ans :+= 1
            } else if (_cnt > 0L) {
              ans :+= 1
            } else {
              ans :+= 0
            }
        }
      }
    }
    ans.toArray
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = StdIn.readLine.trim.toInt

    val queries = Array.ofDim[Int](q, 2)

    for (i <- 0 until q) {
      queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val ans = freqQuery(queries)

    printWriter.println(ans.mkString("\n"))

    printWriter.close()
  }

  def testData(): Unit = {
    var test = Array(
      Array(
        "1 5",
        "1 6",
        "3 2",
        "1 10",
        "1 10",
        "1 6",
        "2 5",
        "3 2"
      ),
      Array(
        "1 5",
        "1 6",
        "3 2",
        "2 10",
        "2 10",
        "2 6",
        "2 5",
        "3 2"
      ),
      Array(
        "2 10",
        "2 10",
        "2 6",
        "2 5",
        "3 2"
      )
    )
    test.foreach {
      x => {
        val queries: Array[Array[Int]] = x.map(_.split(" ").map(_.toInt))
        println(freqQuery(queries).toList)
      }
    }
  }
}

