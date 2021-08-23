package leetcode.normal.n789

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/escape-the-ghosts/
  * 789. 逃脱阻碍者
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
    val you = math.abs(target.head) + math.abs(target.last);
    !ghosts.toStream.map { ghost =>
      math.abs(ghost.head - target.head) + math.abs(ghost.last - target.last)
    }.exists(_ <= you)
  }
}
