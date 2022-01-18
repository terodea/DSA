object majorityElementI {
    /* Element who's count > n/2 
    */
    def majorityElement(nums: Array[Int]): Int = {
        def majorityElement(list: List[Int], countMap: Map[Int, Int]): Int = {
            val current: Int = list.head
            val updatedCountMap: Map[Int, Int] = countMap + (current -> (countMap.getOrElse(current, 0) + 1))
            
            if (updatedCountMap(current) > nums.length / 2) current
            else majorityElement(list.tail, updatedCountMap)
        }
    majorityElement(nums.toList, Map.empty)
    }
    def main(args: Array[String]): Unit = {
        var data = Array(3, 2, 3)
        majorityElement(nums=data)
    }
}
