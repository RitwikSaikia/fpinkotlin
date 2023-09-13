package chapter03.ex25

import chapter03.Branch
import chapter03.Leaf
import chapter03.Tree
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun maximum(tree: Tree<Int>): Int = when (tree) {
  is Leaf -> tree.value
  is Branch -> maxOf(maximum(tree.left), maximum(tree.right))
}

class Exercise25 : WordSpec({
  "tree maximum" should {
    "determine the maximum value held in a tree" {
      val tree = Branch(
        Branch(Leaf(1), Leaf(9)),
        Branch(Leaf(3), Leaf(4))
      )
      maximum(tree) shouldBe 9
    }
  }
})
