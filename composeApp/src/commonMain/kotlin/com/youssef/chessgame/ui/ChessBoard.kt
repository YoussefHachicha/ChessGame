package com.youssef.chessgame.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.youssef.chessgame.board.ChessBoard
import com.youssef.chessgame.ui.utils.bounceClick
import com.youssef.chessgame.ui.utils.clickableNoIndication

@Composable
fun ChessBoard(board: ChessBoard) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickableNoIndication {
                board.selectedPiece = null
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .aspectRatio(1f)
                .align(Alignment.Center)
        ) {
            for (row in 0 until 8) {
                Row(modifier = Modifier.weight(1f)) {
                    for (col in 0 until 8) {
                        ChessSquare(
                            color = if ((row + col) % 2 == 0) Color(0xffEBECD0) else Color(0xff779556),
                            modifier = Modifier.weight(1f)
                        ) {
                            board.pieces.filter {
                                it.position == Offset(
                                    col.toFloat(),
                                    row.toFloat()
                                )
                            }.fastForEach { chessPiece ->

                                ChessPiece(
                                    chessPiece = chessPiece,
                                    onSelect = {
                                        board.selectedPiece = chessPiece
                                    }
                                )
                            }
                            board.selectedPiece?.let { selectedPiece ->
                                selectedPiece.getPossibleMoves()
                                    .filter {
                                        it == Offset(col.toFloat(), row.toFloat())
                                    }
                                    .fastForEach { position ->
                                        if (board.pieces.any { it.position == position }) {
                                            ChessSquare(
                                                color = Color.Red.copy(alpha = 0.5f),
                                                modifier = Modifier
                                                    .padding(8.dp)
                                                    .bounceClick {
                                                        board.movePiece(
                                                            selectedPiece,
                                                            position.x.toInt(),
                                                            position.y.toInt()
                                                        )
                                                        board.removePiece(board.pieces.first { it.position == position && it != selectedPiece })
                                                        board.selectedPiece = null
                                                    }
                                                    .clip(CircleShape)


                                            )
                                        } else {
                                            ChessSquare(
                                                color = Color.Blue.copy(alpha = 0.5f),
                                                modifier = Modifier
                                                    .padding(8.dp)
                                                    .bounceClick {
                                                        board.movePiece(
                                                            selectedPiece,
                                                            position.x.toInt(),
                                                            position.y.toInt()
                                                        )
                                                        board.selectedPiece = null
                                                    }
                                                    .clip(CircleShape)

                                            )
                                        }
                                    }
                            }
                        }
                    }
                }
            }
        }

    }
}
