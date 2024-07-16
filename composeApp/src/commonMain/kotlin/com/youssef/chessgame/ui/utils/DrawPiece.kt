package com.youssef.chessgame.ui.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.youssef.chessgame.piece.ChessType
import com.youssef.chessgame.piece.Piece
import com.youssef.chessgame.piece.Team

private fun DrawScope.drawPiece(piece: Piece, squareSize: Float, textMeasurer: TextMeasurer) {
    val x = piece.position.x.toInt()
    val y = piece.position.y.toInt()
    val pieceSymbol = when (piece.type) {
        ChessType.King -> if (piece.team == Team.White) "♔" else "♚"
        ChessType.Queen -> if (piece.team == Team.White) "♕" else "♛"
        ChessType.Rook -> if (piece.team == Team.White) "♖" else "♜"
        ChessType.Bishop -> if (piece.team == Team.White) "♗" else "♝"
        ChessType.Knight -> if (piece.team == Team.White) "♘" else "♞"
        ChessType.Pawn -> if (piece.team == Team.White) "♙" else "♟"
        ChessType.Lion -> "🦁"
        ChessType.Tiger -> "🐯"
    }
    val textSize = textMeasurer.measure(
        text = pieceSymbol,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    ).size.height * 0.25f

    drawText(
        textMeasurer = textMeasurer,
        text = pieceSymbol,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        ),
        topLeft = Offset(
            x * squareSize + squareSize / 4,
            y * squareSize + squareSize / 4 - textSize
        ),
    )
}
