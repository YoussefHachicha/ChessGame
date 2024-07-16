package com.youssef.chessgame.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssef.chessgame.piece.ChessType
import com.youssef.chessgame.piece.Piece
import com.youssef.chessgame.piece.Team

@Composable
fun ChessPiece(
    chessPiece: Piece,
    onSelect: () -> Unit
) {
    val symbol = when (chessPiece.type) {
        ChessType.King -> if (chessPiece.team == Team.White) "♔" else "♚"
        ChessType.Queen -> if (chessPiece.team == Team.White) "♕" else "♛"
        ChessType.Rook -> if (chessPiece.team == Team.White) "♖" else "♜"
        ChessType.Bishop -> if (chessPiece.team == Team.White) "♗" else "♝"
        ChessType.Knight -> if (chessPiece.team == Team.White) "♘" else "♞"
        ChessType.Pawn -> if (chessPiece.team == Team.White) "♙" else "♟"
        ChessType.Lion -> "🦁"
        ChessType.Tiger -> "🐯"
    }

    Text(
        text = symbol,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onSelect()
            }
            .padding(horizontal = 4.dp)
    )
}
