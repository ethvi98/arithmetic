package com.ethvi.datastructures.tree.printTree;

import java.util.*;

/**
 * @Author ethvi
 * @Description:  分层打印二叉树
 * @Date: 2019/8/26 23:38
 */
public class Main {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //用一个map来存每一层的节点值
        Map<Integer, List<Integer>> map = getMap(root);
        ArrayList<Integer> result = new ArrayList();
        for(int i = 1; i <= map.size(); i++) {
            List<Integer> f = map.get(i);
            f.forEach(result::add);
        }
        return result;
    }

    private Map<Integer, List<Integer>> getMap(TreeNode root) {
        Map<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
        //递归每一层，使用先序遍历
        getNode(root, res, 0);
        return res;
    }

    private void getNode(TreeNode root, Map<Integer, List<Integer>> res, int floor) {
        floor++;
        if(null != root) {
            List<Integer> t = new ArrayList<>();
            if(null == res.get(floor)) {
                t.add(root.val);
                res.put(floor, t);
            } else {
                res.get(floor).add(root.val);
            }
        }
        if(null != root.left)
            getNode(root.left, res, floor);
        if(null != root.right)
            getNode(root.right, res, floor);
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

