package search.binarysearchtree;

/**
 * @author: wjy
 * @date: 2020/2/22
 * @description: 实现二分搜索树结构
 */
public class TreeNode {
    
    public int key;
    public int value;
    public TreeNode left;
    public TreeNode right;
    
    TreeNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}