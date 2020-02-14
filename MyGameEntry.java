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
public class MyGameEntry {
    
      private String name;        // name of the person earning this score
  private int score;          // the score value
  /** Constructs a game entry with given parameters.. */
  public MyGameEntry(String n, int s) {
    name = n;
    score = s;
  }
  /** Returns the name field. */
  public String getName() { return name; }
  /** Returns the score field. */
  public int getScore() { return score; }
  /** Returns a string representation of this entry. */
  public String toString() {
    return "(" + name + ", " + score + ")";
  }
}
