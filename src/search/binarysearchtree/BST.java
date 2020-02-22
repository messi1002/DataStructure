package search.binarysearchtree;

/**
 * @author: wjy
 * @date: 2020/2/22
 * @description: 二分搜索树
 */
public class BST {
    
    private TreeNode root;
    private int count;
    
    public BST() {
        this.root = null;
        this.count = 0;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * 功能描述: 插入key-value
     *
     * @param: [key, value]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/22 17:55
     */
    public void insert(int key, int value) {
        root = insert(root, key, value);
    }
    
    /**
     * 功能描述: 判断是否包含key
     *
     * @param: [key]
     * @return: boolean
     * @auther: wjy
     * @date: 2020/2/22 17:55
     */
    public boolean contain(int key) {
        return contain(root, key);
    }
    
    /**
     * 功能描述: 搜索key对应的value
     *
     * @param: [key]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/22 17:55
     */
    public int search(int key) {
        if (contain(key)) {
            return search(root, key);
        } else {
            System.out.println("key不存在");
            return -1;
        }
    }
    
    /**
     * 功能描述: 寻找最小的键值
     *
     * @param: []
     * @return: int
     * @auther: wjy
     * @date: 2020/2/22 17:55
     */
    public int minKey() {
        if (isEmpty()) {
            System.out.println("没有最小值");
            return -1;
        }
        return minKey(root).key;
    }
    
    /**
     * 功能描述: 寻找最大的键值
     *
     * @param: []
     * @return: int
     * @auther: wjy
     * @date: 2020/2/22 17:55
     */
    public int maxKey() {
        if (isEmpty()) {
            System.out.println("没有最大值");
            return -1;
        }
        return maxKey(root).key;
    }
    
    /**
     * 功能描述: 从二叉树中删除最小值所在节点
     *
     * @param: []
     * @return: void
     * @auther: wjy
     * @date: 2020/2/22 17:55
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
        System.out.println(root.key);
    }
    
    /**
     * 功能描述: 从二叉树中删除最大值所在节点
     *
     * @param: []
     * @return: void
     * @auther: wjy
     * @date: 2020/2/22 17:56
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
        System.out.println(root.key);
    }
    
    /**
     * 功能描述: 从二叉树中删除键值为key的节点
     * 将其后继节点作为代替节点
     *
     * @param: [key]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/22 18:16
     */
    public void remove1(int key) {
        if (root != null) {
            root = remove1(root, key);
        }
    }
    
    /**
     * 功能描述: 从二叉树中删除键值为key的节点
     * 将其前驱节点作为代替节点
     *
     * @param: [key]
     * @return: void
     * @auther: wjy
     * @date: 2020/2/22 18:42
     */
    public void remove2(int key) {
        if (root != null) {
            root = remove2(root, key);
        }
    }
    
    /**
     * 功能描述: 向以root为根的二叉搜索树中，插入节点(key, value)。
     * 返回插入新节点后的二叉搜索树的根。
     *
     * @param: [root, key, value]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 17:58
     */
    private TreeNode insert(TreeNode root, int key, int value) {
        // 插入位置
        if (root == null) {
            count++;
            return new TreeNode(key, value);
        }
        if (key == root.key) {
            root.value = value;
        } else if (key < root.key) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }
        return root;
    }
    
    /**
     * 功能描述: 查看以root为根的二叉搜索树中是否包含键值为key的节点。
     *
     * @param: [root, key]
     * @return: boolean
     * @auther: wjy
     * @date: 2020/2/22 17:58
     */
    private boolean contain(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.key) {
            return true;
        } else if (key < root.key) {
            return contain(root.left, key);
        } else {
            return contain(root.right, key);
        }
    }
    
    /**
     * 功能描述: 在以root为根的二叉搜索树中查找key所对应的value。
     * 假设key一定存在
     *
     * @param: [root, key]
     * @return: int
     * @auther: wjy
     * @date: 2020/2/22 17:57
     */
    private int search(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (key == root.key) {
            return root.value;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
    
    /**
     * 功能描述: 在以root为根的二叉搜索树中，返回最小的键值。
     *
     * @param: [root]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 18:27
     */
    private TreeNode minKey(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return minKey(root.left);
    }
    
    /**
     * 功能描述: 在以root为根的二叉搜索树中，返回最大的键值。
     *
     * @param: [root]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 18:27
     */
    private TreeNode maxKey(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return maxKey(root.right);
    }
    
    /**
     * 功能描述: 删除以root为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param: [root]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 17:57
     */
    private TreeNode removeMin(TreeNode root) {
        if (root.left == null) {
            count--;
            return root;
        }
        root.left = removeMin(root.left);
        return root;
    }
    
    /**
     * 功能描述: 删除以root为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param: [root]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 17:57
     */
    private TreeNode removeMax(TreeNode root) {
        if (root.right == null) {
            count--;
            return root;
        }
        root.right = removeMax(root.right);
        return root;
    }
    
    /**
     * 功能描述: 删除掉以root为根的二分搜索树中键值为key的节点
     * 返回删除节点后新的二分搜索树的根。
     * 将其后继节点作为代替节点。
     *
     * @param: [root, key]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 18:17
     */
    private TreeNode remove1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = remove1(root.left, key);
            return root;
        } else if (key > root.key) {
            root.right = remove1(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 此时root是被删除的节点
                // minNode(node)是被删除节点的后继节点
                TreeNode minNode = minKey(root.right);
                // 将被删除节点的后继节点放在被删除节点的位置
                TreeNode node = new TreeNode(minNode.key, minNode.value);
                node.left = root.left;
                // 删除原来的后继节点
                node.right = removeMin(root.right);
                // 节点总数+1
                count++;
                return node;
            }
        }
    }
    
    /**
     * 功能描述: 删除掉以root为根的二分搜索树中键值为key的节点
     * 返回删除节点后新的二分搜索树的根。
     * 将其前驱节点作为代替节点。
     *
     * @param: [root, key]
     * @return: search.binarysearchtree.TreeNode
     * @auther: wjy
     * @date: 2020/2/22 18:43
     */
    private TreeNode remove2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = remove2(root.left, key);
            return root;
        } else if (key > root.key) {
            root.right = remove2(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 此时root是被删除的节点
                // maxNode(node)是被删除节点的前驱节点
                TreeNode maxNode = maxKey(root.left);
                // 将被删除节点的前驱节点放在被删除节点的位置
                TreeNode node = new TreeNode(maxNode.key, maxNode.value);// 节点总数+1
                // 删除原来的前驱节点
                node.left = removeMax(root.left);
                node.right = root.right;
                // 节点数+1
                count++;
                return node;
            }
        }
    }
}
