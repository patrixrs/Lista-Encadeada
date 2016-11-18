
public class Encadeamento implements Iterable<String> {

	private class ListaIterator implements Iterador {

		private Node current = null;
		private Node previous = null;
		
		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}

		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				previous = current;
				current = current.getNext();
			}
			return current.dado;
		}

		@Override
		public void insert(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			Node node = new Node(dado);
			node.setNext(current);
			if (previous == null) {
				head = node;
			} else {
				previous.setNext(node);
			}
		}
		
		@Override
		public void append(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			Node node = new Node(dado);
			Node proximo = current.getNext();
			node.setNext(proximo);
			current.setNext(node);
			if (proximo == null) {
				tail = node;
			}
		}
		
		@Override
		public void remove() {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			previous.setNext(current.getNext());
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}		
	}
	
	private class Node {
		public final String dado;
		private Node next;
		
		public Node(String dado) {
			this.dado = dado;
			this.next = null;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getNext() {
			return next;
		}
	}
	
	private Node head = null;
	private Node tail = null;

	public void append(String dado) {
		Node node = new Node(dado);
		if (tail == null) {
			head  = node;
		} else {
			tail.setNext(node);
		}
		tail  = node;
	}

	public void pushFront(String dado) {
		Node node = new Node(dado);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
	}

	public void print() {
		Node iter = head;
		while (iter != null) {
			System.out.println(iter.dado);
			iter = iter.getNext();
		}
	}

	@Override
	public Iterador iterator() {
		return new ListaIterator() ;
	}
}