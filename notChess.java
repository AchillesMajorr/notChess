package edu.siena.csis225.notChess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class is the board GUI
 * @author Shaswar
 */
public class notChess extends JFrame implements Runnable, ActionListener {

  // class fields and methods will be added here

  //Instance Var.

  public GameState gameState = new GameState();
  public ChessPiece[][] board;
  public JButton[][] squares;
  public static final int ROWS = 8;
  public static final int COLS = 8;
  public JFrame frame;
  public JPanel panel;

  public notChess() {
    board = new ChessPiece[ROWS][COLS];
    squares = new JButton[ROWS][COLS];
    initializeBoard();
  }

  public void run() {
    //Create the frame of GUI
    frame = new JFrame("notChess");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Create the chess board panel
    panel = new JPanel(new GridLayout(8, 8));

    // Add buttons to the panel
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        JButton button = new JButton();
        button.setActionCommand(i + "," + j); // Store coordinates as action command
        button.addActionListener(this);
        panel.add(button);
        squares[i][j] = button; // Store button reference in squares array
      }
    }

    // Initialize the board with starting pieces
    initializeBoard();

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  // This method initializes the board with starting pieces, this method should be called when you want to create he board, it is
  //called in the run() method above.
  public void initializeBoard() {
    // Initialize white pieces
    board[0][0] = new Rook("R", 0, 0, true);
    board[0][1] = new Knight("KN", 0, 1, true);
    board[0][2] = new Bishop("B", 0, 2, true);
    board[0][3] = new Queen("Q", 0, 3, true);
    board[0][4] = new King("K", 0, 4, true);
    board[0][5] = new Bishop("B", 0, 5, true);
    board[0][6] = new Knight("KN", 0, 6, true);
    board[0][7] = new Rook("R", 0, 7, true);
    //Pawn
    for (int i = 0; i < COLS; i++) {
      board[1][i] = new Pawn("P", 1, i, true);
    }

    // Initialize black pieces
    board[7][0] = new Rook("R", 7, 0, false);
    board[7][1] = new Knight("KN", 7, 1, false);
    board[7][2] = new Bishop("B", 7, 2, false);
    board[7][3] = new Queen("Q", 7, 3, false);
    board[7][4] = new King("K", 7, 4, false);
    board[7][5] = new Bishop("B", 7, 5, false);
    board[7][6] = new Knight("KN", 7, 6, false);
    board[7][7] = new Rook("R", 7, 7, false);
    for (int i = 0; i < COLS; i++) {
      board[6][i] = new Pawn("P", 6, i, false);
    }

    // Set icons for the buttons
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] != null) {
          //should set the type of the piece as the name for the square.
          squares[i][j].setName(board[i][j].getType());
        }
      }
    }
  }

  public void actionPerformed(ActionEvent e) {
    String[] coordinates = e.getActionCommand().split(",");
    int x = Integer.parseInt(coordinates[0]);
    int y = Integer.parseInt(coordinates[1]);

    // Check if there is a piece at the clicked position
    if (isPieceAt(x, y) == false) {
      ChessPiece piece = board[x][y];
      // Do something with the clicked piece
    } else {
      // No piece at the clicked position, make a move
      GameState game = new GameState();
      game.makeMove(board[x][y], x, y);
      // update the GUI
      panel.repaint();
    }
  }

  //This method should return true if there is a piece in the specified position on the board and false if the position on the board is empty.
  public boolean isPieceAt(int x, int y) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        ChessPiece piece = board[i][j];

        //if the coordinates match up.
        if (piece != null && piece.getX() == x && piece.getY() == y) {
          return true; // a piece occupies the square
        }
      }
    }
    return false; // no piece occupies the square
  }

  //Method here to count the pieces of each players on the board.
  //Should be one method here for player White and player Black
  //Counts the current number of WHITE pieces on the board.
  public int countWhitePieces() {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        ChessPiece piece = board[i][j];
        if (piece != null && piece.isWhite()) {
          count++;
        }
      }
    }
    return count;
  }

  public int countBlackPieces() {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        ChessPiece piece = board[i][j];
        if (piece != null && !piece.isWhite()) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new notChess());
  }
  //Create a method that gets a piece at a certain postion on the board, even though we have a getX() and getY() method
  //we need to be able to check if the board has a piece in a certain positon and because getX() and getY() only gives us the location
  //of a specific piece, we need this method.

}
