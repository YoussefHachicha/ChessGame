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
        PieceFactory.createWhiteKing(Offset(4f, 3f)),
        PieceFactory.createBlackKing(Offset(4f, 7f)),
        PieceFactory.createBlackPiece(ChessType.Lion, 2, Offset(4f, 4f)),
        PieceFactory.createBlackPiece(ChessType.Bishop, 7, Offset(0f, 0f)),
        PieceFactory.createBlackPiece(ChessType.Queen, 7, Offset(1f, 1f)),
        PieceFactory.createBlackPiece(ChessType.Knight, 7, Offset(0f, 3f)),
        PieceFactory.createBlackPiece(ChessType.Pawn, 1, Offset(6f, 6f)),
        PieceFactory.createBlackPiece(ChessType.Tiger, 1, Offset(2f, 5f))
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