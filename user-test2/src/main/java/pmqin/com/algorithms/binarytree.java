package pmqin.com.algorithms;

//extends Comparable<K,V>
public class binarytree<K, V>   {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private  Node<K, V> root;
	public binarytree(Node<K, V> root) {
		this.root=root;
	}
	
	public V get(K key) {
		return get(root,key);
	}
	
	private V get(Node<K, V> root, K key) {
		// TODO Auto-generated method stub
		return null;
	}
	private void put( K key,V value) {
		put(root,key,value);
	}
	private Node<K, V>  put(Node<K, V> root, K key,V value) {
		if (root==null) {
			return new Node<K, V> (key,value);
		}
	
		return null;
	}
	
	static class Node<K, V>
	{
		
		public  Node(K key,V value) {
			super();
			this.key=key;
			this.value=value;
		}
		
		private Node<K, V> left;
		private Node<K, V> right;
		private K key;
		private V value;
		public Node<K, V> getLeft() {
			return left;
		}
		public void setLeft(Node<K, V> left) {
			this.left = left;
		}
		public Node<K, V> getRight() {
			return right;
		}
		public void setRight(Node<K, V> right) {
			this.right = right;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", key=" + key + ", value=" + value + "]";
		}
		
	}

}
