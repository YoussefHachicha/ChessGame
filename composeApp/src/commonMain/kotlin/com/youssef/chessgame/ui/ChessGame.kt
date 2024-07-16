package com.youssef.chessgame.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.youssef.chessgame.board.ChessBoard

@Composable
fun ChessGame() {
    val board = remember { ChessBoard() }
    ChessBoard(board)
}