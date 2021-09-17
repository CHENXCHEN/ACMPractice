package leetcode.normal.n212

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/word-search-ii/
  * 212. 单词搜索 II
  *
  * @author <a href='mailto:chenhuachaoxyz@gmail.com'>报时</a>
  */
object Solution {
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    val startPos = board.indices.flatMap { i =>
      board(i).indices.map { j =>
        board(i)(j) -> (i, j)
      }
    }.groupBy(_._1).mapValues(_.map(_._2).toSeq)
    val dx = Array(0, 0, 1, -1)
    val dy = Array(1, -1, 0, 0)
    val rows = board.length
    val cols = board.head.length

    def searchWord(word: String): Boolean = {
      startPos.getOrElse(word.head, Seq.empty).exists {
        case (x, y) =>
          val visit = Array.fill(rows, cols)(-1)
          visit(x)(y) = 1

          def checkWord(cx: Int, cy: Int, step: Int): Boolean = {
            if (step == word.length - 1) return true
            (0 until 4).exists { k =>
              val nextX = cx + dx(k)
              val nextY = cy + dy(k)
              if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && visit(nextX)(nextY) == -1 && board(nextX)(nextY) == word(step + 1)) {
                visit(nextX)(nextY) = 1
                val bool = checkWord(nextX, nextY, step + 1)
                visit(nextX)(nextY) = -1
                bool
              } else false
            }
          }

          checkWord(x, y, 0)
      }
    }

    words.filter(searchWord).toList
  }

  def main(args: Array[String]): Unit = {
    //    println(findWords(
    //      Array(Array('o', 'a', 'b', 'n'), Array('o', 't', 'a', 'e'), Array('a', 'h', 'k', 'r'), Array('a', 'f', 'l', 'v'))
    //      , Array("oaa")
    //    ))
    println(findWords(
      Array(Array('a', 'b', 'c'), Array('a', 'e', 'd'), Array('a', 'f', 'g'))
      , Array("eaabcdgfa")
    ))
  }
}

/**
  * [["a","b","c"],
  * ["a","e","d"],
  * ["a","f","g"]]
  * *
  * ["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]
  */