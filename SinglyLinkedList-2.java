/*************************************************************
public class SinglyLinkedList<E>{

   
   //---------Nested Node class-----------
   private static class Node<E>{
      private E element;        // content, this could be set to final
      private Node<E> next;     // next node in the list
   
      public Node(E e, Node<E> n){// constructor
         element = e;
         next = n;
      }
      // Necessary set and get methods
      public E getElement(){ 
         return element;
      }
      public Node<E> getNext() {
         return next;
      }
      public void setNext(Node<E> n){
         next = n;
      }
   }
   //------end of Nested Node class------
      
   private Node<E> head = null;
   private Node<E> tail = null;
   private int size = 0;
   public SinglyLinkedList() {}     //Default Constructor
   
   public int size() {return size; } // Accessor methods
   
   public boolean isEmpty() { return size == 0;}
   
   
   public E first() {                        // Get the value of the element in the Head
      if (isEmpty()) 
         return null;
      return head.getElement();
   }
   public E last() {                         // Get the value of the element in the Tail
      if (isEmpty()) 
         return null;
      return tail.getElement();
   }        
   public void addFirst(E e){                // Create new node and added to the head
      head = new Node<>(e, head);
      if (size == 0)
         tail = head;
      size++ ;
   }
   public void addLast(E e) {                // Create new node and added to the tail
      Node<E> newest = new Node<>(e, null);
      if (isEmpty())
         head = newest;
      else
         tail.setNext(newest);
      tail = newest;
      size++;
   }
   
   public void addAfter(Node<E> previous, E e) {// Creat new node and add after node previous
      if (previous == null)
         throw new NullPointerException("Node previous cannot be null");
         
      Node<E> newest =  new Node<>(e, previous.getNext());
      previous.setNext(newest); 
      if (tail == previous)
           tail = newest;
      size++;       
   }
   
   public E removeFirst() {                 // Remove the head node, set new head
      if (isEmpty()) 
         return null;
      E answer = head.getElement();
      head = head.getNext();
      size--;
      if (size == 0)
         tail = null;
      return answer;
   }
   
   public E removeAfter(Node<E> previous) {// Creat new node and add after node previous
      if (previous == null )
         throw new NullPointerException("Node previous cannot be null");
      
      if (previous.getNext() == null)
         return null;
         
      E e = previous.getNext().getElement();
      if (previous.getNext() == tail)
         tail = previous;
          
      previous.setNext( previous.getNext().getNext() ); 
      size--; 
      
      return e;      
   }
   
   // You may need to create more methods
}
   
   
   


