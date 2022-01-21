object Solution {
    def maxChunksToSorted(arr: Array[Int]): Int = {
        var count=0;
        var rightMin:Array[Int] = new Array[Int](arr.size+1)
        var n = arr.size
        rightMin(n) = Int.MaxValue
        for (i <- (1 to n-1).reverse){
            rightMin(i) = Math.min(rightMin(i+1), arr(i))
        }
        
        var leftMax = -1
        
        for(i <- 0 to n-1){
            leftMax = (arr(i)).max(leftMax)
            if(leftMax <= rightMin(i+1)){
                count = count + 1;
            }
        }
        count
    }

    def main(args: Array[String]): Int{
        var data: Array[Int] = Array(4, 3, 2, 1, 0)
        maxChunksToSorted(arr=data)
    }
}