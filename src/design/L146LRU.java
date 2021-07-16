package design;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class L146LRU {
	/*
	 * 146. LRU 缓存机制
	 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。实现 LRUCache 类：
	 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
	 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
	 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
	 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
	 *  进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
	 */
	/*
	int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public L146LRU(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
        {
            return -1;
        }
        //将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            //修改key的值
            cache.put(key, value);
            //将key变为最近使用
            makeRecently(key);
            return;
        }

        if(cache.size() >= this.cap)
        {
            //链表头部就是最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //将新的key添加到链表尾部
        cache.put(key, value);
    }

    private void makeRecently(int key)
    {
        int val = cache.get(key);
        //删除key, 重新插入队尾
        cache.remove(key);
        cache.put(key, val);
    }
    */
	
	class Node 
	{
	    public int key, val;
	    public Node next, prev;
	    public Node(int k, int v) {
	        this.key = k;
	        this.val = v;
	    }
	}
	
	class DoubleList
	{
		//头尾虚节点
		private Node head, tail;
		//链表元素数
		private int size;
		
		public DoubleList()
		{
			//初始化双向链表数据
			head = new Node(0, 0);
			tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		//在链表尾部添加链表节点
		public void addLast(Node node)
		{
			node.prev = tail.prev;
			node.next = tail;
			tail.prev.next = node;
			tail.prev = node;
			size++;
		}
		
		//删除链表中的节点
		public void remove(Node node)
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
		}
		
		//删除链表中第一个节点
		public Node removeFirst()
		{
			if(head.next == tail)
			{
				return null;
			}
			Node first = head.next;
			remove(first);
			return first;
		}
		
		//返回链表长度
		public int size()
		{
			return size;
		}
	}
	
	class LRUCache
	{
		private HashMap<Integer, Node> map;
		private DoubleList cache;
		private int cap;
		
		public LRUCache(int capacity)
		{
			this.cap = capacity;
			map = new HashMap<>();
			cache = new DoubleList();
		}
		
		//将某个key提升为最近使用
		private void makeRecently(int key)
		{
			Node node = map.get(key);
			//先从链表中删除这个节点
			cache.remove(node);
			//重新插到队尾
			cache.addLast(node);
		}
		
		//添加最近使用的元素
		private void addRecently(int key, int val)
		{
			Node node = new Node(key, val);
			//链表尾部是最近使用的元素
			cache.addLast(node);
			//在map中添加key的映射
			map.put(key, node);
		}
		
		//删除某一个key
		private void deleteKey(int key)
		{
			Node node = map.get(key);
			//从链表中删除
			cache.remove(node);
			//从映射中删除
			map.remove(key);
		}
		
		//删除最久未使用的元素
		private void removeLeastRecently()
		{
			//链表头部就是第一个元素就是最久未使用
			Node node = cache.removeFirst();
			//从映射中删除key
			int key = node.key;
			map.remove(key);
		}
		
		public int get(int key)
		{
			if(!map.containsKey(key))
			{
				return -1;
			}
			//将数据提升为最近使用
			makeRecently(key);
			Node node = map.get(key);
			return node.val;
		}
		
		public void put(int key, int val)
		{
			if(map.containsKey(key))
			{
				//删除旧数据
				deleteKey(key);
				//新插入的数据为最近使用数据
				addRecently(key, val);
				return;
			}
			
			if(cache.size() >= cap)
			{
				//删除最久未使用
				removeLeastRecently();
			}
			//添加为最近使用
			addRecently(key, val);
		}
	}
}
