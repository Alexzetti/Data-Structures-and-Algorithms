/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

/**
 *
 * @author paulcloutier
 */
public class MyScoreboard {

    private int numEntries = 0;

    private MyGameEntry[] board;

    public MyScoreboard(int capacity) {
        board = new MyGameEntry[capacity];

    }

    public void add(MyGameEntry e) {
        int newScore = e.getScore();

        if (numEntries < board.length) {

            numEntries++;
            int j = numEntries - 1;
            board[j] = e;
        } else { // if the board is full
            int index = 0;
            int lowestScore = board[0].getScore();

            for (int i = 0; i < numEntries; i++) {           //find the lowest score
                if (lowestScore > board[i].getScore()) {
                    index = i;
                    lowestScore = board[i].getScore();
                }

            }
            if (e.getScore() > board[index].getScore()) { //add that if it is actually the lower score
                board[index] = e;

            }

        }

    }

    /**
     * Remove and return the high score at index i.
     */
    public void remove(int i) {
           if (i < 0 || i >= numEntries){
               try{ throw new IndexOutOfBoundsException("Invalid index: " + i);}
               catch (Exception e)
{
    System.out.println("Invalid index: " + i);
}
           }
           
          else{
          int last = numEntries-1;

            
            board[i] = board[last];
            board[last] = null;

            numEntries--;
            }
            
            
            
            
//            if (i < 0 || i >= numEntries) {
//            System.out.println("Invalid index: " + i); 
//           }
//            else{
//          int last = numEntries-1;
//
//            
//            board[i] = board[last];
//            board[last] = null;
//
//            numEntries--;
//            }
         
      }
     
    
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int j = 0; j < numEntries; j++) {
            if (j > 0) {
                sb.append(", ");                   // separate entries by commas
            }
            sb.append(board[j]);
        }
        sb.append("]");
        return sb.toString();
    }

}
