object rangeAddition{

    def getModifiedArrayOptimized(length: Int, queries: Array[Array[Int]]): Array[Int] = {
        var ans: Array[Int] = new Array(length);
        for(i <- 0 to queries.size - 1){
            val start = queries(i)(0);
            val end = queries(i)(1);
            val work = queries(i)(2);
            
            for(i <- start to end){
                ans(j) += work;
            }
        }    
        return ans;
    }

    def getModifiedArray(length: Int, queries: Array[Array[Int]]): Array[Int] = {
        var ans: Array[Int] = new Array(length);
        for(i <- 0 to queries.size - 1){
            val start = queries(i)(0)
            val end = queries(i)(1)
            val work = queries(i)(2)
            
            ans(start) += work
            if(end+1 < length){
                ans(end+1) += -work
            }
        }
        for(i <- 1 to ans.size - 1){
            ans(i) += ans(i-1)
        }
        return ans
    }

    def main(args: Array[String]): Unit = {
        val queries: Array[Array[Int]] = new Array(new Array(1,  3,  2), new Array(2,  4,  3), new Array(0,  2, -2))
        val ans: Array[Int] = getModifiedArray(5, queries)

        for(i <- 0 to ans.size-1){
            print(ans(i))
        }
    }
}
