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
    fun createWhitePiece(type: ChessType, steps: Int, position: Offset): Piece {
        return createPiece(type, Team.White, steps, position)
    }
    fun createBlackPiece(type: ChessType, steps: Int, position: Offset): Piece {
        return createPiece(type, Team.Black, steps, position)
    }

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

    fun createWhiteKing(position: Offset) = createWhitePiece(ChessType.King, 1, position)

    fun createBlackKing(position: Offset) = createBlackPiece(ChessType.King, 1, position)

    fun createWhiteQueen(position: Offset) = createWhitePiece(ChessType.Queen, 7, position)

    fun createBlackQueen(position: Offset) = createBlackPiece(ChessType.Queen, 7, position)
}
