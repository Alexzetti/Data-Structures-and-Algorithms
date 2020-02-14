
 import java.lang.*;

public class GameEntry implements Comparable<GameEntry> {
  private String name;        // name of the person earning this score
  private int score;          // the score value
  /** Constructs a game entry with given parameters.. */
  public GameEntry(String n, int s) {
    name = n;
    score = s;
  }
  public int compareTo(GameEntry e) throws NullPointerException, ClassCastException {
		return (score - e.getScore());
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
