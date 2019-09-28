package com.ethvi.datastructures.linked;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/7/29 22:28
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkdedList list = new SingleLinkdedList();
        list.addByOrder(list.new Node(2,"yizh", "rcrt"));
        list.addByOrder(list.new Node(1,"yizhiwei", "rcrt"));
        list.addByOrder(list.new Node(3,"wei", "rcrt"));
//        System.out.println("============add==============");
        list.list();
        list.overlist();
//        System.out.println("============oversal==============");
//        list.oversalList();
//        list.list();
//        System.out.println("============update==============");
//        list.update(list.new Node(2, "weizhiyi", "bd"));
//        list.list();
//        System.out.println("============delete==============");
//        list.delete(2);
//        list.list();

    }
}
