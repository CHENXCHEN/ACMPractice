package hackerrank.Practice.InterviewPreparationKit.Arrays.NewYearChaos

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
import scala.util.control.Breaks

object Solution {

  var arr: Array[Int] = Array()
  var posHash: mutable.Map[Int, Int] = mutable.Map()
  var moveCnt: Array[Int] = Array()

  def moveLeft(pos: Int): Int = {
    var cnt = 0
    var check = true
    if (posHash(pos) > pos) {
      for (x <- posHash(pos) - 1 to pos by (-1)) {
        cnt += 1
        arr(x + 1) = arr(x)
        posHash(arr(x)) = x + 1
        moveCnt(arr(x)) += 1
        if (moveCnt(arr(x)) > 2) {
          check = false
          return -1
        }
      }
      arr(pos) = pos
      posHash(pos) = pos
    }
    if (check) cnt else -1
  }

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]): Unit = {
    arr = q.map(_ - 1)
    posHash = mutable.Map(arr.zipWithIndex: _ *)
    moveCnt = Array.fill(q.length){0}
    //    println(arr)
    //    println(posHash)
    var checkValid = true
    var cnt = 0
    val loop = Breaks
    loop.breakable(
      for (x <- arr.indices) {
        val tmpCnt1 = moveLeft(x)
        if (tmpCnt1 == -1) {
          checkValid = false
          loop.break
        }
        cnt += tmpCnt1
        //                println(arr)
        //                println(moveCnt)
      }
    )
    //    println(moveCnt)
    if (checkValid) println(cnt)
    else println("Too chaotic")
  }

  def main(args: Array[String]) {
    if (!sys.env.keySet.contains("OUTPUT_PATH")) {
      testData()
      return
    }
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val q = stdin.readLine.split(" ").map(_.trim.toInt)
      minimumBribes(q)
    }
  }

  def testData(): Unit = {
    minimumBribes(Array(2, 1, 5, 3, 4))
    minimumBribes(Array(2, 5, 1, 3, 4))
    minimumBribes(Array(1, 2, 5, 3, 7, 8, 6, 4))
    minimumBribes(Array(1, 2, 3, 4, 5))
    minimumBribes(Array(1))
    minimumBribes(Array(3, 1, 2))
    minimumBribes(Array(3, 2, 1))
    minimumBribes(Array(5, 4, 3, 2, 1))
    minimumBribes(Array(1, 2, 3, 4, 5))
  }
}

