package day05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 示例 1：
 输入：root = [1,2,3,null,null,4,5]
 输出：[1,2,3,null,null,4,5]


 思路 ： 我刚开始写的层序遍历，但因为把所有的null全部加进去队列导致 超时
    看了题解发现可以前中后序遍历   哎学傻了   下次重新写这道题！！！！

 */
public class 序列化与反序列化二叉树048 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "None,";
        }
        String s = root.val + ",";
        s += serialize(root.left);
        s += serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(nums));
        return rdeserialize(dataList);
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        head.left = rdeserialize(dataList);
        head.right = rdeserialize(dataList);
        return head;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
