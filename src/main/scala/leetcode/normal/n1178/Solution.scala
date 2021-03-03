package leetcode.normal.n1178

/**
  * https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
  * 1178. 猜字谜
  *
  * 将一个字符串通过位运算压缩成一个 int，这样就可以用 & 直接对比两个字符串是否包含相同字符，
  * 并且对 26 个字母分别建个索引，用于过滤包含 puzzle 首字母的所有 word
  */
object Solution {
  def strToInt(str: String): Int = {
    var ret = 0
    str.foreach { ch => ret |= (1 << (ch.toInt - 'a'.toInt)) }
    ret
  }

  def calIntBit(vv: Int): Int = {
    var cnt = 0
    var cal = vv
    while (cal > 0) {
      cal = cal & (cal - 1)
      cnt += 1
    }
    cnt
  }

  def findNumOfValidWords(words: Array[String], puzzles: Array[String]): List[Int] = {
    val puzzlesParsed = puzzles.map {
      puzzle => (puzzle.head.toInt - 'a'.toInt, strToInt(puzzle))
    }
    val wordsCompress = words.map(strToInt)
    val letter2word = wordsCompress.flatMap {
      wordCompress =>
        (0 until 26).filter(i => (wordCompress >> i & 1) == 1).map(i => (i, wordCompress))
    }.groupBy(_._1).map {
      case (i, arr) => i -> arr.map(_._2).toArray
    }
    puzzlesParsed
      .map {
        case (pFirst, puzzleCompress) =>
          letter2word.getOrElse(pFirst, Array.empty).map {
            wordCompress =>
              if ((wordCompress & puzzleCompress) == wordCompress) 1 else 0
          }.sum
      }.toList
  }
}

/**
  * ["apple","pleas","please"]
  * ["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
  */
