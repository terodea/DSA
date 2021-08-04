import java.io.*;
import java.util.*;

public class buySellStockOTA{

    static Map<String, Integer> memoizeMap = new HashMap<>();

    public static void main(String[] args){
        int n = 9;
        int[] stockPrices = {11, 6, 7, 19, 4, 1, 6, 18, 4};
        System.out.println(helper(0, 0, true, stockPrices));
        System.out.println(memoizeMap);
    }

    public static int helper(int maxTransactions, int index, boolean isBuy, int[] prices) {

        if (index > prices.length - 1 || maxTransactions == 1) return 0;

        String key = index + "profit" + isBuy + "sum" + maxTransactions;
        System.out.println(key);
        if (memoizeMap.containsKey(key)) return memoizeMap.get(key);

        int maxProfit;

        if (isBuy) {

            int profitWhenBuy = helper(maxTransactions, index + 1, false, prices) - prices[index];
            int profitWhenDoNothing = helper(maxTransactions, index + 1, true, prices);

            maxProfit = Math.max(profitWhenBuy, profitWhenDoNothing);
        } else {

            int profitWhenSell = helper(maxTransactions + 1, index + 1, true, prices) + prices[index];
            int profitWhenDoNothing = helper(maxTransactions, index + 1, false, prices);

            maxProfit = Math.max(profitWhenDoNothing, profitWhenSell);
        }

        memoizeMap.put(key, maxProfit);
        return maxProfit;

    }
}
