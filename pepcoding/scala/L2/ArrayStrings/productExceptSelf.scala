object productExceptSelf{
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        var n = nums.size
        var res: Array[Int] = new Array(n)
        for(i <- 1 to n-1){
            res(i) = res(i-1) * nums(i-1)
        }
        var right=1
        for(i <- (0 to n-1).reverse){
            res(i) *= right
            right *= nums(i)
        }
        res
    }

    def productExceptSelf2(nums: Array[Int]): Array[Int] = {
        var n = nums.size
        var leftProduct: Array[Int] = new Array(n)
        var rightProduct: Array[Int] = new Array(n)
        var res: Array[Int] = new Array(n)

        for(i <- 0 to n-1){
            if (i == 0){
                leftProduct(i) = nums(i)
            }
            else{
                leftProduct(i) = leftProduct(i-1) * arr(i)
            }
        }

        for(i <- (0 to n-1).reverse){
            if (i == n-1){
                rightProduct(i) = arr(i)
            }
            else{
                rightProduct(i) = rightProduct(i+1) * arr(i)
            }
        }

        for(i <- 0 to n-1){
            if(i==0){
                res(i) = rightProduct(1)
            }
            else if(i==n-1){
                res(i) = leftProduct(n-2)
            }
            res(i) = leftProduct(i-1) * rightProduct(i+1)
        }
        res 
    }

    def main(args: Array[String]): Unit = {
        var nums: Array[Int] = new Array(1,2,3,4)
        print(productExceptSelf(nums))
    }
}
