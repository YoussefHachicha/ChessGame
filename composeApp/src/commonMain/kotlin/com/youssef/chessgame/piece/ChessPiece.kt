package com.youssef.chessgame.piece

import androidx.compose.ui.geometry.Offset
import com.youssef.chessgame.movement.MovementStrategy

class ChessPiece(
    override val type: ChessType,
    override val team: Team,
    override val steps: Int,
    initialPosition: Offset,
    private val movementStrategy: MovementStrategy
) : Piece {
    private var _position: Offset = initialPosition

    override val position: Offset
        get() = _position

    override fun move(x: Int, y: Int) {
        //here we are giving the user full access to be moved to any position then each time we are checking if the position is valid
        //this is not the best way to do it, we should filter out the possibleMoves based on the position of the other pieces on the board
//        if (canMoveTo(x, y)) {
            _position = Offset(x.toFloat(), y.toFloat())
//        }
    }

    override fun getPossibleMoves(): Set<Offset> {
        return movementStrategy.getPossibleMoves(this)
    }

    override fun canMoveTo(x: Int, y: Int): Boolean {
        return getPossibleMoves().contains(Offset(x.toFloat(), y.toFloat()))
    }

    //we need to have a list of the position of all the pieces on the board
    // and if one of the chess piece possibleMoves contains the position of another piece
    //then we can attack it
//    override fun attack() {
//        TODO("Not yet implemented")
//    }
}
