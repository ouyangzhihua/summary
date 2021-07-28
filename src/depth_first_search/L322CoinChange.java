package depth_first_search;

public class L322CoinChange {
	/*
	 * 322. 零钱兑换
	 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
	 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。你可以认为每种硬币的数量是无限的。
	 */
	
	/*
	int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0)
        {
            return -1;
        }
        
        backtrack(coins, amount, 0);
        if(res == Integer.MAX_VALUE)
        {
            return -1;
        }
        return res;
    }

    private void backtrack(int[] coins, int amount, int count)
    {
        if(amount < 0)
        {
            return;
        }
        if(amount == 0)
        {
            res = Math.min(res, count);
        }
        for(int coin : coins)
        {
            backtrack(coins, amount-coin, count+1);
            
        }
    }
	 */
	
public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0 )
        {
            return -1;
        }
        int[] dp = new int[amount];
        return backtrack(coins, amount, dp);
        
    }

    private int backtrack(int[] coins, int amount, int[] dp)
    {
        if(amount < 0)
        {
            return -1;
        }
        if(amount == 0)
        {
            return 0;
        }
        if(dp[amount-1] != 0)
        {
            return dp[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins)
        {
            int res = backtrack(coins, amount-coin, dp);  
            if(res >= 0 && res < min)
            {
                min = res + 1;
            }          
        }
        if(min == Integer.MAX_VALUE)
        {
            dp[amount-1] = -1;
        }
        else
        {
            dp[amount-1] = min;
        }
        return dp[amount-1];
    }
	
	
}
