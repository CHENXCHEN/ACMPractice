package hackerrank.Practice.InterviewPreparationKit.WarmupChallenges.JumpingOnTheClouds

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

  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int]): Int = {
    var cnt = 0
    var pos = 0
    while(pos < c.size - 1) {
      pos += 2
      cnt += 1
      if(pos < c.size && c(pos) == 1) pos -= 1
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

    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    printWriter.println(result)

    printWriter.close()
  }

  def testData(): Unit = {
    println(jumpingOnClouds(Array(0, 0, 0, 0, 1, 0)))
    println(jumpingOnClouds(Array(0, 0, 1, 0, 0, 1, 0)))
    println(jumpingOnClouds(Array(0, 0)))
    println(jumpingOnClouds(Array(0, 1, 0)))
    println(jumpingOnClouds(Array(0, 1, 0, 0)))
  }
}

