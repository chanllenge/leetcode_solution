package list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chan
 * Date: 2019/6/22 8:51
 * Description:
 */
public class LRUCache {
    private Map<Integer, Node> hashMap;
    private int capacity;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(this.capacity, 0.75F);
        this.size = 0;
    }

    /**
     * get时，如果没有Node，直接返回即可；如果存在的话，需要将该Node移动到链表末尾并
     * 删除原来的节点,get操作size不变
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    private Node getNode(int key) {
        Node node = hashMap.get(key);
        if (node == null) return node;
        // node如果已经是尾节点了，就不用删除本来的节点了
        if (tail != node) {
            if (head == node) {
                head = head.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            appendNodeToTail(node);
        }
        return node;
    }

    private void  appendNodeToTail(Node node) {
        //原来没有节点，直接将node赋值给head和tail即可
        if (size == 0) {
            head = tail = node;
        } else {
            node.pre = tail;
            tail.next = node;
            node.next = null;
            tail = node;
        }
    }

    //长度是否超出限制了？删除链表头元素
    private void reduceToSize() {
        while (size > capacity) {
            Node toDelete = head;
            head = head.next;
            head.pre = null;
            hashMap.remove(toDelete.key);
            size--;
        }
    }
    /**
     * put时也需要更新链表，LRU么，最近访问了，就需要将Node放到末尾
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = new Node(key, value);
        Node exist = getNode(key);
        if (exist == null) {
            appendNodeToTail(node);  //初始化后，node节点地址不变，所以73,74行顺序无前后关系
            hashMap.put(key, node);
            size++;
            reduceToSize();
        } else {
            exist.value = value;
        }
    }

    class Node {
        private Node pre;
        private Node next;
        private int key;
        private int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
