/**
 * Pancake sorting
 * ---------------
 * Pancake sorting is a variation of the sorting problem in which the only allowed operation
 * is to reverse the elements of some prefix of the sequence. Unlike a traditional sorting algorithm,
 * which attempts to sort with the fewest comparisons possible, the goal is to sort the sequence
 * in as few reversals as possible. This operation can be visualized by thinking of a stack of pancakes
 * in which one is allowed to take the top k pancakes and flip them.
 *
 * http://en.wikipedia.org/wiki/Pancake_sorting
 *
 * Basic approach to the algorithm
 * 1) Find the index of the largest pancake
 * 2) Flip (reverse) the stack from the head to the largest pancake (inclusive)
 * 3) Now that the largest is at the head, separate the head from the tail and repeat with the tail (recursively)
 * 4) Finally, the entire sorted sequence will be large to small, so flip the entire stack from the bottom.
 */

class PancakeSort() {
    def sort(list: List[Int]) = {
        insertAndFlip(list).reverse
    }

    def insertAndFlip(list: List[Int]): List[Int] =  {
        if(list.isEmpty) return List()

        // Find the index of the largest item
        val index = list.indexOf(list.max)

        // Flip (reverse) the stack from the head to the largest item (inclusive)
        val flipped = list.slice(0, index + 1).reverse

        // Add the flipped portion back to the stack
        val patched = list.patch(0, flipped, index + 1)

        val (head, tail) = patched.splitAt(1)

        // Concatenate (recursively) the sorted heads to make up a complete list
        // .. this result needs to be reversed when we are all done
        head ++ insertAndFlip(tail)
    }

}
