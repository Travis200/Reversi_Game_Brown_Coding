/**
 * @author Kostiantyn Potomkin
 * @version 0.9
 * @since 05-03-2020
 */
package uk.ac.ncl.game;

import uk.ac.ncl.entity.CellStatus;
import uk.ac.ncl.entity.DirectedMove;
import uk.ac.ncl.entity.Cell;

import java.util.ArrayList;
import java.util.Arrays;

import static uk.ac.ncl.Constants.*;
import static uk.ac.ncl.entity.CellStatus.*;

/**
 *
 * Main logic of the game.
 *
 */
public class MoveChecker {

    private Cell[][] cells;


    public MoveChecker(Cell[][] cells) {
        this.cells = cells;
    }

    /**
     * Generates a move of the opponent
     *
     * @param cellStatus - colour of the opponent
     * @return a piece to make a move
     */
    public Cell generateOpponent(CellStatus cellStatus) {
        ArrayList<Cell> potentialMoves = null;
        if (cellStatus == DARK) {
            potentialMoves = findPotentialMoves(CellStatus.DARK);
        }
        else if (cellStatus == LIGHT) {
            potentialMoves = findPotentialMoves(CellStatus.LIGHT);
        }
        int max_score = 0  ;
        Cell opponentsMove = null;
        for (int i = 0; i < potentialMoves.size(); i++){
            if (potentialMoves.get(i).getMove().getScore() > max_score){
                opponentsMove = potentialMoves.get(i);
            }
        }
        return opponentsMove;
    }

    /**
     * Flips pieces between selected piece in directions of valid moves.
     *
     * @param cell - piece we have just put on the board
     * @param colour - colour of the current player
     */
    public void flipPieces(Cell cell, CellStatus colour) {
        pause(300);
        CellStatus oppColour = null;
        if (colour == DARK) {
            oppColour = LIGHT;
        }
        else if (colour == LIGHT){
            oppColour = DARK;
        }
        cell.colourTemp(colour == OPPONENTS_CELL_STATUS ? OPPONENTS_COLOUR : PLAYERS_COLOUR, false);
        for (DirectedMove move : cell.getMove().getMoves()) {
            int[] direction = move.getDirection();
            int d_row = cell.getRow();
            int d_col = cell.getColumn();
            cells[d_row][d_col].setValue(colour);
                ArrayList<Cell> piecesToFlip = new ArrayList<Cell>();
                d_row = cell.getRow();
                d_col = cell.getColumn();
                boolean sameDirection = true;
                boolean flipCheckersBool = false;
                while (sameDirection == true) {
                        d_row += direction[0];
                        d_col += direction[1];
                    if ((-1 < d_row && d_row < 8) && (-1 < d_col && d_col < 8)) {
                            if (cells[d_row][d_col].getValue() == oppColour) {
                                piecesToFlip.add(cells[d_row][d_col]);
                            }
                            else if (cells[d_row][d_col].getValue() == colour) {
                                if (piecesToFlip.size() > 0) {
                                    flipCheckersBool = true;
                                }
                                sameDirection = false;
                            }
                            else {
                                sameDirection = false;
                            }

                    if (flipCheckersBool == true) {
                        for (Cell piece : piecesToFlip) {
                            int d_row1 = piece.getRow();
                            int d_col1 = piece.getColumn();
                            cells[d_row1][d_col1].setValue(colour);
                        }
                        }
                    }
                    else {
                        sameDirection = false;
                    }
                }
            }
        }

    /**
     * Returns potential moves on the board for the specified colour
     *
     * @param colour - colour of the current player
     * @return pieces for which there exist valid moves
     */
        public ArrayList<Cell> findPotentialMoves(CellStatus colour) {
            ArrayList<Cell> potentialMoves = new ArrayList<Cell>();
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (this.cells[i][j].getValue() == CellStatus.EMPTY){
                        if (this.cells[i][j].isLegal(colour, cells)){
                            potentialMoves.add(this.cells[i][j]);
                        }
                    }
                }
            }
        return potentialMoves;
    }

    /**
     * Updates information about pieces
     *
     * @param cells - pieces to update
     * @param colour - new colour
     */
    public void colourPieces(ArrayList<Cell> cells, CellStatus colour) {
        for (Cell cell : cells){
            cell.setValue(colour);
        }
    }

    /**
     * Sums up results of the game
     *
     * @return string with the results of the game
     */
    public String getFinalScore() {
        int lights = 0;
        int darks = 0;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (this.cells[row][column].getValue() == LIGHT) {
                    lights ++;
                } else if (this.cells[row][column].getValue() == DARK) {
                    darks ++;
                }
            }
        }
        if (darks == lights) {
            return "The game is over. It is a draw. Each player has " + darks + " pieces";
        }
        else {
            String winner = lights > darks ? "Light" : "Dark";
            return "The game is over. "
                    + winner + " has won with the result: Dark - " + darks + " Light - " + lights;
        }
    }

    /**
     * Cleans up potential moves from the board cells
     *
     * @param grayCells - pieces with valid moves
     */
    public void removeMoves(ArrayList<Cell> grayCells){
        if (grayCells != null){
            for (int i = 0; i < grayCells.size(); i++){
                grayCells.get(i).setMove(null);
            }
        }
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
