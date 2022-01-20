object maxChunksToMakeArraySorted{

    def maxChunksToSorted(arr: Array[Int]): Int = {
        val s = arr.scanLeft(0)((a, b) => a + (1<<b))
        val p = (0 to arr.size-1).scanLeft(0)((a, b) => a + (1<<b))
        (s zip p).map(a => a._1 == a._2).count(_ == true)-1
    }
    
    def main(args: Array[String]): Unit{
        var data = Array(4,3,2,1,0)
        maxChunksToMakeArraySorted(arr=data)
    }
}
