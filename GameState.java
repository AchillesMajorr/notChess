package edu.siena.csis225.notChess;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * This class deals with anything to do with the games state.
 * @author Shaswar Mohammed
 */
public class GameState {

  public notChess[][] board; // 2D array to store the state of the board
  public boolean isWhiteTurn; // true if it's currently white's turn, false otherwise
  public int turnCountWhite; // number of turns taken so far by White
  public int turnCountBlack; //Black's turns so far.
  public boolean GameOngoing;
  public ChessPiece piece[][];
  public notChess pieceObject;
  public int totalTurns;

  public GameState() {
    isWhiteTurn = true;
    turnCountWhite = 1;
    turnCountBlack = 0;
    //true for active, false for the game is over.
    GameOngoing = true;
    totalTurns = 0;
  }

  public notChess[][] getBoard() {
    return board;
  }

  public boolean isGameOngoing() {
    return GameOngoing;
  }

  public void setGameOngoing(boolean GameOngoing) {
    this.GameOngoing = GameOngoing;
  }

  public void gameOver() {
    setGameOngoing(false);
    if (!GameOngoing) {
      System.exit(0);
    }
  }

  //Total turns taken
  public int getTotalTurns() {
    return turnCountBlack + turnCountWhite;
  }

  //if the turn is odd it is white's turn
  //if it is even it is black's turn.
  public boolean isWhiteTurn() {
    //Checks if even , if so returns false
    if (getTotalTurns() % 2 == 0) {
      return false;
    } else return true;
  }

  //Get WHITE'S turn count.
  public int getTurnCountWhite() {
    return turnCountWhite;
  }

  //Increments WHITE'S turn count.
  public void incrementTurnCountWhite() {
    turnCountWhite++;
  }

  //get BLACK'S turn count.
  public int getTurnCountBlack() {
    return turnCountBlack;
  }

  //Increments BLACK'S turn count.
  public void incrementTurnCountBlack() {
    turnCountBlack++;
  }

  public void switchTurn() {
    isWhiteTurn = !isWhiteTurn;
  }

  //This needs to tell you if a capture is avaible. if so, you cannot make a move unless you capture first.
  public boolean captureAvailable() {
    return true;
  }

  //Keeps track of win condtions, and whether they have been met.
  public boolean winConditions() {
    if (turnCountWhite >= 50 && turnCountBlack >= 50) {
      // Once this happens you should end the game and whichever player has the fewest pieces left will win.
      int blackPieces = pieceObject.countBlackPieces();
      int whitePieces = pieceObject.countWhitePieces();
      if (blackPieces < whitePieces) {
        GameOngoing = false;
        return true;
      } else if (whitePieces < blackPieces) {
        GameOngoing = false;
        return false;
      }
    }
    return false;
  }

  //Should call isValidMove from ChessPiece first then, make the move and update the board.
  //Once a move is made, then the switchTurn method should be called and the board updated, along with the
  //incrementTurnCount method. You Should call this method "makeMove" when a piece is selected in actionPerfomed in notChess.
  //Then check if the game is over. Win conditions should be
  public void makeMove(ChessPiece piece, int moveToRow, int moveToCol) {
    boolean validMove = piece.isValidMove(moveToRow, moveToCol);
    if (validMove) {
      // Move the piece to the new location
      int currentX = piece.getX();
      int currentY = piece.getY();
      board[currentX][currentY] = null;
      piece.setX(moveToRow);
      piece.setY(moveToCol);
      //board = board[moveToRow][moveToCol];

      // Update turn count and switch turns
      if (isWhiteTurn) {
        incrementTurnCountWhite();
      } else {
        incrementTurnCountBlack();
      }
      totalTurns++;
      switchTurn();

      // Check if game is over
      if (winConditions()) {
        gameOver();
      }
    }
  }
}
