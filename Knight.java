package edu.siena.csis225.notChess;

/**
 * This class is the Knight, it extends its base class ChessPiece.
 * @author Shaswar
 */
public class Knight extends ChessPiece {

  public Knight(String type, int x, int y, boolean isWhite) {
    super("KN", x, y, isWhite);
  }

  @Override
  protected boolean pieceLogic(int newX, int newY) {
    int deltaX = Math.abs(newX - getX());
    int deltaY = Math.abs(newY - getY());
    return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
  }
}
