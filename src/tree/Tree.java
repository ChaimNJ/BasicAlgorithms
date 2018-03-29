package tree;

import java.time.temporal.Temporal;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    private TreeNode root = null;

    public static void main(String[] args) {
        Tree t = new Tree();

        int[] tree = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        t.root = t.create(t.root,0,tree);

        t.inOrderTraverse(t.root);
        t.inOrderByStack(t.root);
        t.preOrderByStack(t.root);
        t.postOrderByStack(t.root);
        t.cenci(t.root);

    }
    private class TreeNode<T extends Comparable> implements Comparable{
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;


        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public TreeNode() {
            super();
        }

        @Override
        public int compareTo(Object o) {
            return this.data.compareTo(((TreeNode)o).data);
        }
    }
    private <T extends Comparable> TreeNode create(TreeNode node, int i,int[] arr){
       if(i>=arr.length){
           return null;
       }
       node = new TreeNode(arr[i]);
       node.left = create(node.left,2*i+1,arr);
       node.right = create(node.right,2*i+2,arr);
       return node;
    }

    /**
     * 插入
     *
     * @param a
     * @param <T>
     */
    public <T extends Comparable> void insert(T a) {
        TreeNode node = new TreeNode(a);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                if (current.data.compareTo(node.data) > 1) {
                    parent = current;
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        break;
                    }
                } else if (current.data.compareTo(node.data) < 1) {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        break;
                    }
                } else {
                    System.out.println("have same value!");
                }
            }
        }
    }

    /**
     * @param node 访问节点
     */
    private void visit(TreeNode node) {
        System.out.print(node.data + " ");
    }


    /**
     * @param node 中序遍历递归
     */
    private void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        visit(node);
        inOrderTraverse(node.right);
    }

    /**
     * @param node 中序非递归
     *             当前节点不为空，则进栈，左节点置为当前节点，
     *             若左子树为空，出栈，访问节点
     *             将节点右节点置为当前节点
     *             重复
     */
    private void inOrderByStack(TreeNode node) {
        System.out.println("中序非递归");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                visit(current);
                current = current.right;
            }
        }
        System.out.println();
    }


    /**
     * @param node 前序非递归
     */
    private void preOrderByStack(TreeNode node) {
        System.out.println("前序非递归");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                visit(current);
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
        System.out.println();
    }

    /**
     * @param node 后序序非递归
     */
    private void postOrderByStack(TreeNode node) {
        System.out.println("后序非递归");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        TreeNode pre = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.peek().right;
                if (current == null || current == pre) {
                    current = stack.pop();
                    visit(current);
                    pre = current;
                    current = null;
                }
            }
        }
        System.out.println();
    }


    /**
     * @param node 层次遍历
     */
    private void cenci(TreeNode node) {
        System.out.println("层次遍历");
        Queue<TreeNode> queue = new PriorityQueue();
        queue.add(node);
        TreeNode current = null;
        while (!queue.isEmpty()) {
            current = queue.remove();
            visit(current);
            if(current.left!=null)
            queue.add(current.left);
            if(current.right!=null)
            queue.add(current.right);
        }
        System.out.println();
    }


}
