package leetcode.normal.n794

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/valid-tic-tac-toe-state/
  * 794. 有效的井字游戏
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def validTicTacToe(board: Array[String]): Boolean = {
    val cnt1 = board.map { row =>
      row.filter(_ == 'X').length
    }.sum
    val cnt2 = board.map { row =>
      row.filter(_ == 'O').length
    }.sum

    def isWin(ch: Char): Boolean = {
      board.exists(_.forall(_ == ch)) || {
        (0 until 3).exists { i =>
          (0 until 3).forall { j => board(j)(i) == ch }
        }
      } || {
        board(0)(0) == ch && board(0)(0) == board(1)(1) && board(1)(1) == board(2)(2)
      } || {
        board(0)(2) == ch && board(0)(2) == board(1)(1) && board(1)(1) == board(2)(0)
      }
    }

    val isP1Win = isWin('X')
    val isP2Win = isWin('O')
    if (isP1Win && isP2Win) {
      false
    } else if (isP1Win) {
      cnt1 == cnt2 + 1
    } else if (isP2Win) {
      cnt1 == cnt2
    } else cnt1 == cnt2 || cnt1 == cnt2 + 1
  }
}
