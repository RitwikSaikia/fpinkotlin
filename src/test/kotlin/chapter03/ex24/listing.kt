package chapter03.ex24

import chapter03.Branch
import chapter03.Leaf
import chapter03.Tree
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> size(tree: Tree<A>): Int = when (tree) {
  is Leaf -> 1
  is Branch -> 1 + size(tree.left) + size(tree.right)
}

class Exercise24 : WordSpec({
  "tree size" should {
    "determine the total size of a tree" {
      val tree =
        Branch(
          Branch(Leaf(1), Leaf(2)),
          Branch(Leaf(3), Leaf(4))
        )
      size(tree) shouldBe 7
    }
  }
})
