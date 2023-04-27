package edu.siena.csis225.notChess;

/**
 * This class is the Rook, it extends its base class ChessPiece.
 * @author
 */
public class Rook extends ChessPiece {

  public Rook(String type, int x, int y, boolean isWhite) {
    super("R", x, y, isWhite);
  }

  @Override
  protected boolean pieceLogic(int newX, int newY) {
    // Rooks can move horizontally or vertically, but not diagonally
    if (newX == getX() || newY == getY()) {
      return true;
    } else {
      return false;
    }
  }
}
