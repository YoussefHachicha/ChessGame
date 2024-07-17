package com.youssef.chessgame.movement.strategies

import androidx.compose.ui.geometry.Offset
import com.youssef.chessgame.piece.Piece
import com.youssef.chessgame.movement.MovementStrategy
import com.youssef.chessgame.movement.MovementStyleBuilder

class PawnMovementStrategy(val steps: Int = 1): MovementStrategy {
    //TODO pawn logic
    override fun getPossibleMoves(piece: Piece): Set<Offset> {
        return MovementStyleBuilder()
            .moveForward()
            .build()
            .flatMap { it.possibleMoves(piece.position, steps) }.toSet()
    }
}