package dynamic_programming;

public class J60DicesProbability {
	public double[] dicesProbability(int n) {
        double[][] dp = new double[n+1][6*n+1];
        for(int i = 1; i <= 6; i++)
        {
            dp[1][i] = 1.0/6.0;
        }
        for(int i = 2; i <= n; i++)
        {
            for(int j = i-1; j <= 6*i-6; j++)
                for(int k = 1; k <= 6; k++)
                {
                    dp[i][j+k] += dp[i-1][j]/6.0;
                }            
        }
        double[] res = new double[5*n+1];
        for(int i = 0; i <= 5*n; i++)
        {
            res[i] = dp[n][i+n];
        }
        return res;
        
       //优化
       /*
       double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    	*/
    }
	
	
}
