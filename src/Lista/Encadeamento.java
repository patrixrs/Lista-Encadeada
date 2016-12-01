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

		
		@SuppressWarnings("unused")
		public void remove(Node dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			previous.setNext(dado.getNext());
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}// ---
	}// fim da classe ListaIterator

	private class Node {
		public String dado;
		private Node next;
		private Node prev;

		public Node(String dado) {
			this.dado = dado;
			this.next = null;
		}
		
		public Node() {
			//construtor vazio
		}
		
		public void setDado(String dado) {// define valor ao nó
			this.dado = dado;
		}

		public String getDado() {// retorna valor do nó
			return dado;
		}

		public void setNext(Node next) {// define proximo nó
			this.next = next;
		}

		public Node getNext() {// retorna proximo nó
			return next;
		}

		public void setPrev(Node prev) {// define nó anterior
			this.prev = prev;
		}

		public Node getPrev() {// retorna nó anterior
			return prev;
		}
	}// fim da classe Node

	private Node head = null;
	private Node tail = null;
	private Node anterior = null;
	private boolean teste = false;

	public Node getHead() {// retorna primeir nó
		return head;
	}

	public void setHead(Node head) {// define primeiro nó
		this.head = head;
	}

	public Node getTail() {// retorna ultimo nó
		return tail;
	}

	public void setTail(Node tail) {// define ultimo nó
		this.tail = tail;
	}

	public void append(String dado) {// insere depois			
		Node node = new Node();
		node.setDado(dado);
		if (head == null) {
			head  = node;
		} else {
			if(!teste){
				head.setNext(node);
				node.setPrev(head);
				anterior = node;
			}else{
				node.setPrev(anterior);
				anterior = node;
			}
			tail.setNext(node);
			teste = true;
		}
		tail = node;		
	}// ---

	public void pushFront(String dado) {// insere antes
		Node node = new Node(dado);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
		//System.out.println(dado);
	}// ---

	public void print() {// printa a lista
		Node aux = head;
		int i = 1;
		while (aux != null) {
			System.out.println("[" + i + "] " + aux.dado);
			aux = aux.getNext();
			i++;// gera index só p exibição
		}
	}// ---
	
	public boolean search(String valor) {// busca na lista
		Node aux = getHead();
		while (aux != null) {
			if (valor.equals(aux.dado)) {// compara o valor digitado com o nome da lista
				return true;
			}
			aux = aux.getNext();
		}		
		return false;// retorna a string false se não tem na lista
	}// ---	

	@Override
	public Iterador iterator() {
		return new ListaIterator();
	}// ---
	
	/*
	public void remover(String rem) {
		Node node = new Node(dado);
		if(search(rem)){
			node = 
			node.setPrev();
			anterior = node;
		}
	}
	*/
	
	private void If(boolean search) {
		// TODO Auto-generated method stub
		
	}

}// fim da classe Encadeamento