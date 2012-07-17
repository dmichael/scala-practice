import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfterAll

class PancakeSortSpec extends FunSpec with BeforeAndAfterAll {

    describe("PancakeSort") {

        it("should sort the pancakes"){
            val sorter = new PancakeSort()
            val sorted = sorter.sort(List(5,3,4,9,10,8,1))

            assert(sorted == List(1,3,4,5,8,9,10))

        }

        it("should sort the pancakes, even if sorted"){
            val sorter = new PancakeSort()
            val sorted = sorter.sort(List(1,3,4,5,8,9,10))

            assert(sorted == List(1,3,4,5,8,9,10))
        }

        it("should sort the pancakes, even if just 1"){
            val sorter = new PancakeSort()
            val sorted = sorter.sort(List(1))

            assert(sorted == List(1))
        }
    }

}