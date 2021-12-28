package leetcode.normal.n472

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/concatenated-words/
  * 472. 连接词
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {

  case class TreeNode(child: Array[TreeNode] = Array.fill(26)(null), var isEnd: Boolean = false)

  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    val head = TreeNode()

    def insert(word: String): Unit = {
      var next = head
      word.foreach { ch =>
        val pos = ch - 'a'
        if (next.child(pos) == null) {
          next.child(pos) = TreeNode()
        }
        next = next.child(pos)
      }
      next.isEnd = true
    }

    def query(word: String, start: Int): Boolean = {
      if (start == word.length) return true
      var next = head
      // 可以对 start 判断，做一层记忆化搜索的优化
      (start until word.length).foreach { i =>
        val pos = word(i) - 'a'
        next = next.child(pos)
        if (next == null) return false
        if (next.isEnd) {
          if (query(word, i + 1)) return true
        }
      }
      false
    }

    val sortWords = words.sortWith((w1, w2) => w1.length < w2.length)

    sortWords.filter { word =>
      if (word.length == 0) false
      else if (query(word, 0)) true
      else {
        insert(word)
        false
      }
    }.toList
  }

  def main(args: Array[String]): Unit = {
    println(findAllConcatenatedWordsInADict(Array("cat", "dog", "catdog")))
    println(findAllConcatenatedWordsInADict(Array("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat")))
  }
}
