object wiggleSort{
    def wiggleSort(arr: Array[Int]): Unit = {
        for(i <- 0 to arr.size - 1){
            if(i % 2 == 0){
                if(arr(i) > arr(i+1)){
                    swap(arr, i, i+1)
                }
            }
            else{
                if(arr(i) < arr(i+1)){
                    swap(arr, i, i+1)
                }
            }
        }
    }
    
    def swap(arr: Array[Int], i:Int, j:Int): Unit = {
        var temp = arr(i)
        arr(i) = arr(j)
        arr(j) = temp
    }

    def main(args: Array[String]): Unit={
        var arr = Array(3,5,2,1,6,4)
        print(wiggleSort(arr))
    }
}
