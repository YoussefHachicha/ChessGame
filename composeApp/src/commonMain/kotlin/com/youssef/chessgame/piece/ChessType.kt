package com.youssef.chessgame.piece

import androidx.compose.ui.geometry.Offset

enum class ChessType(val offset: Offset) {
    King(Offset.Zero),
    Queen(Offset.Zero),
    Bishop(Offset.Zero),
    Knight(Offset.Zero),
    Rook(Offset.Zero),
    Pawn(Offset.Zero),
    Lion(Offset.Zero),
    Tiger(Offset.Zero)
}