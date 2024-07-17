package com.youssef.chessgame.piece

import androidx.compose.ui.geometry.Offset
import kotlin.random.Random

enum class ChessType(
    val offset: Offset
) {
    King(Offset.Zero),
    Queen(Offset.Zero),
    Bishop(Offset.Zero),
    Knight(Offset.Zero),
    Rook(Offset.Zero),
    Pawn(Offset.Zero),
    Lion(Offset.Zero),
    Tiger(Offset.Zero);

    fun createRandomly() = PieceFactory.createPiece(
        type = this,
        team = if (Random.nextBoolean()) Team.White else Team.Black,
        steps = Random.nextInt(1, 8),
        Offset(Random.nextInt(1, 8).toFloat(), Random.nextInt(1, 8).toFloat())
    );
}