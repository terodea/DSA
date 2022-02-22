import scala.runtime.Arrays
object wiggleSortII{
    def wiggleSort(nums: Array[Int]): Unit = {
        val n = nums.size
        var arr: Array[Int] = new Array(n)

        for(i <- 0 to n-1){
            arr(i) = nums(i)
        }
        scala.util.Sorting.quickSort(arr)
        var j = n-1
        var i = 1

        while(i < n){
            nums(i) = arr(j)
            j -= 1
            i += 2
        }
        i=0

        while( i < n){
            nums(i) = arr(j)
            j -= 1
            i += 2
        }
        
    }
    
    def wiggleSortII(nums: Array[Int]): Unit = {
        val sorted = nums.sorted
        
        var refRight = sorted.size - 1
        var refLeft = (sorted.size - 1) / 2
        
        var inputLeft = 0
        
        var dir = -1
        while (inputLeft < nums.size) {
            if (dir < 0) {
                nums(inputLeft) = sorted(refLeft)
                inputLeft += 1
                refLeft -= 1
                dir = 1
            } else {
                nums(inputLeft) = sorted(refRight)
                inputLeft += 1
                refRight -= 1
                dir = -1
            }
        }
    }

    def main(args: Array[String]): Unit = {
        var nums: Array[Int] = new Array(1,5,1,1,6,4)
        wiggleSort(nums)
    }
}
