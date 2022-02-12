object sortByParity{

    def sortArrayByParity(nums: Array[Int]): Array[Int] = {
        var even = 0
        var odd = nums.length - 1

        while (even < odd)
            if (nums(even) % 2 == 0)
                even = even + 1
            else {
                val temp = nums(odd)
                nums(odd) = nums(even)
                nums(even) = temp
                odd = odd - 1
            }
        nums
    }

    def main(args: Array[String]): Unit = {
        print(sortArrayByParity(Array(3,1,2,4)))
    }
}
