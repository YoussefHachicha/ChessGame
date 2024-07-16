package com.youssef.chessgame.board

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import com.youssef.chessgame.piece.ChessType
import com.youssef.chessgame.piece.Piece
import com.youssef.chessgame.piece.PieceFactory
import com.youssef.chessgame.piece.Team

class ChessBoard {
    val pieces = mutableListOf<Piece>(
        PieceFactory.createPiece(ChessType.King, Team.White, 1, Offset(4f, 3f)),
        PieceFactory.createPiece(ChessType.King, Team.Black, 1, Offset(4f, 7f)),
        PieceFactory.createPiece(ChessType.Lion, Team.White, 2, Offset(4f, 4f)),
        PieceFactory.createPiece(ChessType.Bishop, Team.White, 7, Offset(0f, 0f)),
        PieceFactory.createPiece(ChessType.Queen, Team.Black, 7, Offset(1f, 1f)),
        PieceFactory.createPiece(ChessType.Knight, Team.Black, 7, Offset(0f, 3f)),
        PieceFactory.createPiece(ChessType.Pawn, Team.White, 1, Offset(6f, 6f)),
        PieceFactory.createPiece(ChessType.Tiger, Team.White, 1, Offset(2f, 5f))
        // Add more pieces as needed
    )
    var selectedPiece: Piece? by mutableStateOf(null)

    fun addPiece(piece: Piece) {
        pieces.add(piece)
    }

    fun removePiece(piece: Piece) {
        pieces.remove(piece)
    }

    fun movePiece(piece: Piece, x: Int, y: Int) {
        piece.move(x, y)
    }
}