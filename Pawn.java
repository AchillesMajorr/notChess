package edu.siena.csis225.notChess;

/**
 * This class is the Pawn, it extends its base class ChessPiece.
 * @author Shaswar
 */
public class Pawn extends ChessPiece {

  //White pieces on bottom black pieces on top.

  public Pawn(String type, int x, int y, boolean isWhite) {
    super("P", x, y, isWhite);
  }

  @Override
  protected boolean pieceLogic(int newX, int newY) {
    int dx = newX - getX();
    int dy = newY - getY();
    int direction = isWhite() ? 1 : -1;

    // Pawn can move forward one or two spaces on first move, and one space otherwise
    if (dx == direction && dy == 0) {
      return true;
    } else if (
      dx == 2 * direction && dy == 0 && getX() == (isWhite() ? 1 : 6)
    ) {
      return true;
    }

    // Pawn can capture diagonally one space ahead
    if (dx == direction && Math.abs(dy) == 1) {
      return true;
    }

    // Otherwise, the move is invalid
    return false;
  }
}
