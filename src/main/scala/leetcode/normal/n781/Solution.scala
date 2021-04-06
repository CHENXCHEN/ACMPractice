package leetcode.normal.n781

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/rabbits-in-forest/
  * 781. 森林中的兔子
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numRabbits(answers: Array[Int]): Int = {
    val hashCnt = Array.fill[Int](1024)(0)
    answers.foreach(x => hashCnt(x) += 1)
    hashCnt.zipWithIndex.map {
      case (vv, i) if vv > 0 =>
        if (i == 0) {
          vv
        } else {
          (vv / (i + 1) + (vv % (i + 1) != 0).compare(false)) * (i + 1)
        }
      case _ =>
        0
    }.sum
  }
}
