public class gasStation{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        
        for(int i=0; i<gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        
        if(gasSum - costSum < 0) return -1;
        
        int idx = 0;
        int prefixSum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<gas.length; i++){
            
            prefixSum += gas[i] - cost[i];
            
            if(prefixSum < min){
                min = prefixSum;
                idx = i;
            }
        }
        
        return (idx + 1) % gas.length;
    }

    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost))
    }
}
