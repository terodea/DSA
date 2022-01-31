import scala.collection.immutable.List as List

object bestMeetingPoint{

    def minTotalDistance(grid: Array[Array[Int]]): Int = {
        val xcord = new List()
        val ycord = new List()
        val n: Int = grid.size
        val m: Int = grid[0].size
        for(r <- 0 to n-1){
            for(c <- 0 to m-1){
                if(grid(r)(c) == 1) xcord.add(r)                
            }
        }
        
        for(c <- 0 to m-1){
            for(r <- 0 to n-1){
                if(grid(r)(c) == 1) ycord.add(c)
            }
        }
        
        val x: Int = xcord.get(xcord.size() / 2)
        val y: Int = ycord.get(ycord.size() / 2)
        
        val dist: Int = 0;
        
        for(r <- 0 to n-1){
            for(c <- 0 to m-1){
                if(grid(r)(c) == 1) dist+= (x-r).abs + (y-c).abs
                
            }
        }
        dist
    }

    def main(args: Array[String]): Unit ={
        val grid: Array[Array[Int]] = new Array(new Array(1,0,0,0,1), new Array(0,0,0,0,0), new Array(0,0,1,0,0))
        print(minTotalDistance(grid))
    }
}
