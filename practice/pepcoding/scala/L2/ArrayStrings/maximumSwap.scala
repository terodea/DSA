import scala.util.control._

object maximumSwap {
    def swap(arr: Array[Char], left: Int, right:Int): Unit ={
        val temp = arr(left)
        arr(left) = arr(right)
        arr(right) = temp
    }
    def maximumSwap(num: Int): Int = {
        val arr: Array[Char] = num.toCharArray()
        val lastIndexOfDIgit: Array[Int] = new Array(10)
        n = arr.size-1

        for (i <- 0 to n) {
            lastIndexOfDIgit(arr(i)-'0') = i
        }

        for (i <- 0 to n) {
            val digit = arr(i) - '0';
            val idx = i;
            for (j <- (9 to digit).reverse()) {
                if (lastIndexOfDIgit(j) > i) {
                    idx = lastIndexOfDIgit(j)
                    break()
                }
            }

        if (idx != i) {
            swap(arr, i, idx);
            break;
        }
        }
    }

    def main(args: Array[String]): Unit = {
        print(maximumSwap("2798"))
    }
}
