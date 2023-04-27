package edu.siena.csis225.notChess;

/**
 * This class is the Queen, it extends its base class ChessPiece.
 * @author Shaswar
 */
public class Queen extends ChessPiece {

  notChess board = new notChess();

  public Queen(String type, int x, int y, boolean isWhite) {
    super("Q", x, y, isWhite);
  }

  @Override
  protected boolean pieceLogic(int newX, int newY) {
    int deltaX = Math.abs(newX - getX());
    int deltaY = Math.abs(newY - getY());

    // Check if the move is diagonal
    if (deltaX == deltaY) {
      int xDir = Integer.signum(newX - getX());
      int yDir = Integer.signum(newY - getY());
      int currX = getX() + xDir;
      int currY = getY() + yDir;

      // Check if the path is clear
      while (currX != newX && currY != newY) {
        if (board.isPieceAt(currX, currY)) {
          return false; // queen's path is blocked
        }
        currX += xDir;
        currY += yDir;
      }
      return true; // queen can move to destination
    }
    // Check if the move is horizontal or vertical
    else if (deltaX == 0 || deltaY == 0) {
      int xDir = Integer.signum(newX - getX());
      int yDir = Integer.signum(newY - getY());
      int currX = getX() + xDir;
      int currY = getY() + yDir;

      // Check if the path is clear
      while (currX != newX || currY != newY) {
        if (board.isPieceAt(currX, currY)) {
          return false; // queen's path is blocked
        }
        currX += xDir;
        currY += yDir;
      }
      return true; // queen can move to destination
    }
    return false; // queen cannot move to destination
  }
}
