package com.youssef.chessgame.movement

import androidx.compose.ui.geometry.Offset
import com.youssef.chessgame.piece.Piece

interface MovementStrategy {
    //we need to have a list of the position of all the pieces on the board
    //if a piece is in the way of the king, then we need to filter it out from the possibleMoves
    //TODO pass ChesBoard here
    fun getPossibleMoves(piece: Piece): Set<Offset>
}