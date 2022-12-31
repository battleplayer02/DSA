public class SubsetSum{
    public static void main(String... args) {
        int runs[] = new int[]{2,3,7,8,10};
        int sum = 17;
        print(runs);
        // boolean dp[][] = new boolean[runs.length+1][sum+1];
        // for(int reqSum = 0; reqSum<sum+1;reqSum++){
        //     for(int players = 0;players<runs.length+1;players++){
        //         if(players == 0 && reqSum==0){
        //             dp[players][reqSum] = true;
        //         }else if(players == 0){
        //             dp[players][reqSum] = false;
        //         }else if(reqSum == 0){
        //             dp[players][reqSum] = true;
        //         }else{
        //             boolean alone = runs[players-1] == reqSum;
        //             boolean play = reqSum-runs[players-1] >= 0 ? dp[players-1][reqSum-runs[players-1]]:false;
        //             boolean noplay = dp[players-1][reqSum];
        //             dp[players][reqSum] = alone || play || noplay;
        //          }
        //     }
        // }
        // System.out.println(dp[runs.length][sum]);

    }

    public boolean sol(int runs[],int target,int currentRuns,int curP){
        
    }




    public static void print(int arr[]){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}