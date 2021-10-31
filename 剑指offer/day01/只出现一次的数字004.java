package day01;

/**
 * @author nuonuo
 * @create 2021-10-31 10:58
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *  
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 *
 *
 * 思路：因为是 O(n) + O（1）  所以只能考虑位运算
 *      没做出来，看了题解。  主要思路是看每一位的1或者0的个数加起来， 然后 % 3 ，如果是1的话  答案的这一位也就是1
 *
 *      方法2是将    用来计数的total   改成   tow one   因为最终结果只有   00  01  10 三种，具体看题解。
 *
 *
 */
public class 只出现一次的数字004 {
     public int singleNumber1(int[] nums) {
         int res = 0;
         for (int i = 0; i < 32; i++) {
             int total = 0;
             for (int num : nums) {
                 total += ((num >> i) & 1);
             }
             if ((total % 3) != 0) {
                 res |= (1 << i);
             }
         }
         return res;
     }
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
