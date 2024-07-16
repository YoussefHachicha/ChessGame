package com.youssef.chessgame.ui.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

private fun DrawScope.drawBorder(boardSize: Float) {
    drawRect(
        color = Color.Black,
        topLeft = Offset.Zero,
        size = Size(boardSize, boardSize),
        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2f)
    )
}
