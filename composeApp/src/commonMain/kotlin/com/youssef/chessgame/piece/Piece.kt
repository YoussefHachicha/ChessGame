package com.youssef.chessgame.piece

import androidx.compose.ui.geometry.Offset

interface Piece {
    val position: Offset
    val type: ChessType
    val team: Team
    val steps: Int
    fun move(x: Int, y: Int)
    fun getPossibleMoves(): Set<Offset>
    fun canMoveTo(x: Int, y: Int): Boolean
}