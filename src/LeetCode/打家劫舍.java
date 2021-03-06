package LeetCode;

/**
 * @ClassName LeetCode.打家劫舍
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。  给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。  示例 1:  输入: [1,2,3,1] 输出: 4 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。      偷窃到的最高金额 = 1 + 3 = 4 。 示例 2:  输入: [2,7,9,3,1] 输出: 12 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @Author ChongqingWangYu
 * @DateTime 2019/2/23 15:00
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        int[] s = {2, 1, 1, 2,2, 1, 1, 2,2, 1, 1, 2};
        System.out.println(rob(s));
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int n=nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] arr = new int[n];
        /*使用动态规划*/
        //对于第一家：->偷这一家/不偷->偷肯定是大于不偷的  {2, 1, 1, 2}
        arr[0]=nums[0];
        //对于第二家：->偷这一家，不偷第一家/不偷这一家，偷前一家->max（第一家收益，第二家收益）
        arr[1]=Math.max(nums[0],nums[1]);
        //从第三家开始：->偷这一家+上上家最大收益/不偷这家，最大收益等于上一家最大收益->max（xxx，yyy）
        for (int i = 2; i < n; i++) {
            arr[i]=Math.max(nums[i]+arr[i-2],arr[i-1]);
        }
        //返回这个动态规划数组的最后一项
        return arr[n-1];
    }
}
