object maxProductThreeNum {
    def maximumProduct(nums: Array[Int]): Int = {
        var highest = max(nums(0), nums(1))
        var lowest = min(nums(0), nums(1))
    
        var highestProductOf2 = nums(0) * nums(1)
        var lowestProductOf2 = nums(0) * nums(1)
    
        var highestProductOf3 = nums(0) * nums(1) * nums(2)
        
        for (i <- 2 until nums.length) {
            var current = nums(i)   
            highestProductOf3 = List( highestProductOf3, current * highestProductOf2, current * lowestProductOf2).max
            highestProductOf2 = List( highestProductOf2, current * highest, current * lowest).max
            lowestProductOf2 = List( lowestProductOf2, current * highest, current * lowest).min
            highest = max(highest, current)
            lowest = min(lowest, current)
        }
        highestProductOf3
    }

    def main(args: Array[String]): Unit = {
        var data = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        maximumProducts(nums=data)
    }
}
