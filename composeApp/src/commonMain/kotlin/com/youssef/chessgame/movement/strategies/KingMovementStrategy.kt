package com.youssef.chessgame.movement.strategies

import androidx.compose.ui.geometry.Offset
import com.youssef.chessgame.movement.MovementStrategy
import com.youssef.chessgame.movement.MovementStyleBuilder
import com.youssef.chessgame.piece.Piece

class KingMovementStrategy(val steps: Int = 1) : MovementStrategy {
    override fun getPossibleMoves(piece: Piece): Set<Offset> {
        return MovementStyleBuilder()
            .moveForward()
            .moveBackward()
            .moveLeft()
            .moveRight()
            .moveDiagonal()
            .build()
            .flatMap { it.possibleMoves(piece.position, steps) }.toSet()
    }
}
