package leetcode.normal.n208

object Solution {

}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
  * 208. 实现 Trie (前缀树)
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
class Trie() {

  /** Initialize your data structure here. */
  case class TNode(var child: Array[TNode] = null, var isEnd: Boolean = false)

  var root: TNode = TNode()

  /** Inserts a word into the trie. */
  def insert(word: String): Unit = {
    var head = root
    var i = 0
    while (i < word.length) {
      val pos = word(i) - 97
      if (head.child == null) head.child = Array.fill(26)(null)
      if (head.child(pos) == null) head.child(pos) = TNode()
      head = head.child(pos)
      i += 1
    }
    head.isEnd = true
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    var head = root
    var i = 0
    while (i < word.length) {
      val pos = word(i) - 97
      if (head.child == null || head.child(pos) == null) return false
      head = head.child(pos)
      i += 1
    }
    head.isEnd
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    var head = root
    var i = 0
    while (i < prefix.length) {
      val pos = prefix(i) - 97
      if (head.child == null || head.child(pos) == null) return false
      head = head.child(pos)
      i += 1
    }
    true
  }
}