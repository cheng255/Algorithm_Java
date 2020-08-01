package exer05;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer39题：二叉树的深度
 *
 * 分析：使用队列，层序遍历  每遍历一层k就++；
 * @author nuonuo
 * @create 2020-07-31 15:03
 */
class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;

    }

}
public class T39 {
    public static void main(String[] args) {

    }
    public int TreeDepth(TreeNode1 root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode1> queue = new LinkedList<>();
        int k = 0; //层数
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); //表示当前层的节点数
            while (size > 0) {
                TreeNode1 temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            k++; //层数加1
        }
        return k;
    }
}
