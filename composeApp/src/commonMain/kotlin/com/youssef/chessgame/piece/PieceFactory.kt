package com.youssef.chessgame.piece

import androidx.compose.ui.geometry.Offset
import com.youssef.chessgame.movement.strategies.BishopMovementStrategy
import com.youssef.chessgame.movement.strategies.KingMovementStrategy
import com.youssef.chessgame.movement.strategies.KnightMovementStrategy
import com.youssef.chessgame.movement.strategies.PawnMovementStrategy
import com.youssef.chessgame.movement.strategies.QueenMovementStrategy
import com.youssef.chessgame.movement.strategies.RookMovementStrategy
import com.youssef.chessgame.movement.strategies.CustomMovementStrategy

object PieceFactory {
    fun createPiece(type: ChessType, team: Team, steps: Int, position: Offset): Piece {
        val movementStrategy = when (type) {
            ChessType.King -> KingMovementStrategy()
            ChessType.Queen -> QueenMovementStrategy()
            ChessType.Bishop -> BishopMovementStrategy()
            ChessType.Knight -> KnightMovementStrategy()
            ChessType.Rook -> RookMovementStrategy()
            ChessType.Pawn -> PawnMovementStrategy()
            ChessType.Lion, ChessType.Tiger -> CustomMovementStrategy()
            else -> throw IllegalArgumentException("Invalid piece type")
        }
        return ChessPiece(type, team, steps, position, movementStrategy)
    }
}
