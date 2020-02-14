
*/
import java.util.Comparaor;

/** Class for storing high scores in a SinglyLinkedList in nondecreasing order. */
public class SingleLinkedScoreboard {

  private Comparator<GameEntry> comparator;
  private int capacity;                    // default capacity is 10
  private SinglyLinkedList<GameEntry> board;               // list of game entries (names & scores)
  
  /** Constructs an empty scoreboard and set capacity for storing entries. */
  public SingleLinkedScoreboard() {
    this(10, new DefaultComparator<>()); // default capacity is 10
  }
  
  public SingleLinkedScoreboard(int capacity) {
	  this(capacity, new DefaultComparator<>());
  }
  
  public SingleLinkedScoreboard(Comparator<GameEntry> comp) {
	  this(10, comp);
  }
  
  public SingleLinkedScoreboard(int capacity, Comparator<GameEntry> comp) {
	comparator = comp;
    this.capacity = (capacity > 0) ? capacity : 1; 
    board = new SinglyLinkedList<>();
  }

  /** Attempt to add a new score to the collection (if it is high enough) */
  public void add(GameEntry e) {
	int newScore = e.getScore();
    //Check if the list is empty, if yes, just addFirst
    if ( board.size() == 0){
      board.addFirst(e);
    } else if ( comparator.compare(e, board.first()) > 0 ) { //Check if it goes before the head
      board.addFirst(e); // You can clearly merge those two, but I didn't for clarity.
    } else if ( comparator.compare(e, board.last()) < 0 ) {// Check if less that smallest score           
         if ( board.size() < capacity ){ // Only add if there is space       
            board.addLast(e);       
         }  
    } else {   // we have at least 2 elements in our scoreboard and the entry should be added
               // in a spot in the middle of the list.
      SinglyLinkedList.Node<GameEntry> curNode = board.getHead();
      while( curNode.getNext() != null && curNode.getNext().getElement().getScore() > newScore ){
         // The null check is redundant but it is there for safety, in case I messed up my logic
         // the loop will stop when the first next node with a value less than the current score
         // is discovered. At this point we just need to add after the curNode.
         // we are guaranteed to find such a node, since the newScore > board.last().getScore() 
         curNode = curNode.getNext(); 
      }
      board.addAfter(curNode, e);
      // The addAfter() at the line above may cause the size to exceed capacity, same goes
      // for the addFirst in line 29
      while( board.size() > capacity ){
         remove( board.size() -1 ); // this loop should at most repeat once, so it could be an if statement
                                    // I am removing the last element
                                    // Notice, I am using the remove method from below.
      }
      
    }
    

  }

  /** Remove and return the high score at index i. */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= board.size() )
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    
    if ( i == 0 ){
      return board.removeFirst();
    }
    
    SinglyLinkedList.Node<GameEntry> curNode = board.getHead();
    for (int counter = 0; counter < i-1;  counter++ ){ // stop at previous node
      curNode = curNode.getNext(); 
    }
    
    return board.removeAfter(curNode);
    
  }

  /** Returns a string representation of the high scores list. */
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    
    SinglyLinkedList.Node<GameEntry> curNode = board.getHead();
    while ( curNode != null ) {
                        
      sb.append( curNode.getElement() );
      curNode = curNode.getNext();
      if (curNode != null)
        sb.append(", ");  // separate entries by commas
    }
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {
    // The main method
    SingleLinkedScoreboard highscores = new SingleLinkedScoreboard(5);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
    int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

    for (int i=0; i < names.length; i++) {
      GameEntry gE = new GameEntry(names[i], scores[i]);
      System.out.println("Adding " + gE);
      highscores.add(gE);
      System.out.println(" Scoreboard: " + highscores);
    }
	
    System.out.println("Removing score at index 4");
    highscores.remove(4);
    System.out.println(highscores);
    System.out.println("Removing score at index 0");
    highscores.remove(0);
    System.out.println(highscores);
    System.out.println("Removing score at index 1");
    highscores.remove(1);
    System.out.println(highscores);
    System.out.println("Removing score at index 1");
    highscores.remove(1);
    System.out.println(highscores);
  }
}
