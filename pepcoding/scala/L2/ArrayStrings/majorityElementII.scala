object majorityElementII{
    /* Element who's count > n/3 
    */
    def majorityElement(nums: Array[Int]): List[Int] = {
        def majorityElement(list: List[Int], countMap: Map[Int, Int]): Int = {
            val current: Int = list.head
            val updatedCountMap: Map[Int, Int] = countMap + (current -> (countMap.getOrElse(current, 0) + 1))
            
            if (updatedCountMap(current) > nums.length / 3) current
            else majorityElement(list.tail, updatedCountMap)
        }
        majorityElement(nums.toList, Map.empty)
    }

    def majorityElementOptimized(nums: Array[Int]): List[Int] = nums.foldLeft(Array.ofDim[Int](4)) {
        // Using Array(cand1, cand2, cnt1, cnt2)
        case (cache, curr) if curr == cache(0) => cache.updated(2, cache(2) + 1)
        case (cache, curr) if curr == cache(1) => cache.updated(3, cache(3) + 1)
        case (cache, curr) if cache(2) == 0    => cache.updated(0, curr).updated(2, 1)
        case (cache, curr) if cache(3) == 0    => cache.updated(1, curr).updated(3, 1)
        case (cache, _)                        => cache.updated(2, cache(2) - 1).updated(3, cache(3) - 1)
      }.take(2)  // Ignoring counts
      .distinct // Ignoring duplicates
      .filter(n => nums.count(_ == n) > nums.length / 3)
      .toList
    
    def main(args: Array[String]): Unit = {
        var data = Array(3, 2, 3, 3)
        majorityElement(nums=data)
    }
}
