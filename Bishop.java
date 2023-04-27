package edu.siena.csis225.notChess;

/**
 * This class is the Bishop, it extends its base class ChessPiece.
 * @author
 */
public class Bishop extends ChessPiece {

  notChess board = new notChess();

  public Bishop(String type, int x, int y, boolean isWhite) {
    super("B", x, y, isWhite);
  }

  @Override
  protected boolean pieceLogic(int newX, int newY) {
    // check if the bishop is moving diagonally
    int xDiff = Math.abs(newX - getX());
    int yDiff = Math.abs(newY - getY());
    if (xDiff == yDiff) {
      // check if there are no other pieces in the bishop's path
      int xDir = (newX > getX()) ? 1 : -1; // determine direction of movement in x-axis
      int yDir = (newY > getY()) ? 1 : -1; // determine direction of movement in y-axis
      int currX = getX() + xDir;
      int currY = getY() + yDir;

      while (currX != newX && currY != newY) {
        if (board.isPieceAt(currX, currY)) {
          return false; // bishop's path is blocked
        }
        currX += xDir;
        currY += yDir;
      }
      return true; // bishop can move to destination
    }
    return false; // bishop is not moving diagonally
  }
}
