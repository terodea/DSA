object gasStation{
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        var gasSum = 0
        var costSum = 0
        var n = gas.size

        for(i <- 0 to n-1){
            gasSum += gas(i)
            costSum += cost(i)
        }
        if(gasSum - costSum < 0 ) return -1

        var idx=0
        var prefixSum=0
        var min = Int.MaxValue

        for(i <- 0 to n-1){
            prefixSum += gas(i) - cost(i)
            if(prefixSum < min){
                min = prefixSum
                idx=i
            }
        }
        (idx+1) % n
    }

    def main(args:Array[String]): Unit = {
        var gas: Array[Int] = new Array(1,2,3,4,5)
        var cost: Array[Int] = new Array(3,4,5,1,2)
        print(canCompleteCircuit(gas = gas, cost = cost))
    }
}
