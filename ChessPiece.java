package edu.siena.csis225.notChess;

/**
 * This is a base class for all the chess pieces.
 * @author Shaswar MOhammed
 */
public abstract class ChessPiece {

  //Type of piece, pawn, king, rook etc
  private String type;
  //coordinates of each piece
  private int x;
  private int y;
  private boolean isWhite;

  public ChessPiece(String type, int x, int y, boolean isWhite) {
    this.type = type;
    this.x = x;
    this.y = y;
    this.isWhite = isWhite;
  }

  public boolean isValidMove(int newX, int newY) {
    if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
      return false; // invalid move if destination is out of bounds
    }
    if (newX == x && newY == y) {
      return false; // invalid move if destination is the same as current position
    }
    return pieceLogic(newX, newY); // validate move based on piece-specific logic
  }

  //Piece logic as it is specific to each piece.
  protected abstract boolean pieceLogic(int newX, int newY);

  // Getter and setter methods for type, x, y, and isWhite variables
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }
}
