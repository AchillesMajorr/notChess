package edu.siena.csis225.notChess;

/**
 * This class is the King, it extends its base class ChessPiece.
 * @author
 */
public class King extends ChessPiece {

  public King(String type, int x, int y, boolean isWhite) {
    super("K", x, y, isWhite);
  }

  @Override
  protected boolean pieceLogic(int newX, int newY) {
    int deltaX = Math.abs(newX - getX());
    int deltaY = Math.abs(newY - getY());
    // A King can move one square in any direction (horizontal, vertical, or diagonal)
    return deltaX <= 1 && deltaY <= 1;
  }
}
