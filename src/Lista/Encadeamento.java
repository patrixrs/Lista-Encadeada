package Lista;

public class Encadeamento implements Iterable<String> {

	private class ListaIterator implements Iterador {

		private Node current = null;
		private Node previous = null;

		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}// ---

		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				previous = current;
				current = current.getNext();
			}
			return current.dado;
		}// ---

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
		}// ---

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
		}// ---

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
		}// ---
	}// fim da classe ListaIterator

	private class Node {
		public final String dado;
		private Node next;
		private Node prev;

		public Node(String dado) {
			this.dado = dado;
			this.next = null;
		}

		public String getDado() {
			return dado;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getPrev() {
			return prev;
		}
	}// fim da classe Node

	private Node head = null;
	private Node tail = null;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void append(String dado) {
		Node node = new Node(dado);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
	}// ---

	public void pushFront(String dado) {
		Node node = new Node(dado);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
	}// ---

	public void print() {
		Node iter = head;
		while (iter != null) {
			System.out.println(iter.dado);
			iter = iter.getNext();
		}
	}// ---
	
	public String search(String valor) {
		Node aux = getHead();
		while (aux != null) {
			String[] textoSeparado = aux.getDado().split(" ");			
			String dado = textoSeparado[1];
			if (valor.equals(dado)) {
				return aux.getDado();
			}
			aux = aux.getNext();
		}		
		return "false";
	}

	@Override
	public Iterador iterator() {
		return new ListaIterator();
	}// ---

}// fim da classe Encadeamento