import scala.compiletime.ops.boolean
object firstMissingPositiveNum{
    
    def firstMissingPositiveNum(nums: Array[Int]): Int= {
        val hasOne = nums.indices.foldLeft(false)((hasOne, index) => {
            if (nums(index) < 1) {
                nums(index) = 1
                hasOne
            } else hasOne || nums(index) == 1
      })

      if (!hasOne) 1
      else {
        //second pass go thru and make item at corresponding index negative
        nums.indices.foreach(index => {
          val indexValueToUpdate: Int = Math.abs(nums(index))

          if (indexValueToUpdate - 1 < nums.length) {
            nums(indexValueToUpdate - 1) = -Math.abs(nums(indexValueToUpdate - 1))
          }
        })

        nums.indices.find(index => nums(index) > 0).map(_ + 1).getOrElse(nums.length + 1)
      }
    }
    }
    def firstMissingPositive(nums: Array[Int]): Int = {
        var one:Boolean = false
        var n: Int = nums.size
        
        for(i <- 0 to n-1){
            
            if(nums(i) == 1) one = true
            
            if(nums(i) < 1 || n < nums(i)) {
                nums(i) = 1
            }
        }
        
        if(one == false) 1
        else{
            var val = 0
            for(i <- 0 to n-1){
                var val = nums(i).abs
                var idx = val-1
                nums(idx) = -nums(idx).abs
                
            }
        
            for(int i=0; i<n; i++){
                if(nums(i) > 0){
                    i+1;
                }
            }
            n+1
        }    
    }

}
