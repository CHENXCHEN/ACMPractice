package leetcode.normal.n36

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/valid-sudoku/
  * 36. 有效的数独
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    def validRowOrCol(isRow: Boolean): Boolean = {
      (0 until 9).forall { i =>
        var rValid = 0
        var noError = true
        (0 until 9).foreach { j =>
          val ch = if (isRow) board(i)(j) else board(j)(i)
          if (ch != '.') {
            val num = ch - '0'.toInt
            if (((rValid >> num) & 1) == 1) {
              noError = false
            }
            rValid |= (1 << num)
          }
        }
        noError
      }
    }

    def validGrid: Boolean = {
      (0 until(9, 3)).forall { i =>
        (0 until(9, 3)).forall { j =>
          var valid = 0
          var noError = true
          (0 until 3).foreach { dx =>
            (0 until 3).foreach { dy =>
              val ch = board(i + dx)(j + dy)
              if (ch != '.') {
                val num = ch - '0'.toInt
                if (((valid >> num) & 1) == 1) {
                  noError = false
                }
                valid |= (1 << num)
              }
            }
          }
          noError
        }
      }
    }
    validRowOrCol(true) && validRowOrCol(false) && validGrid
  }
}
