package com.youssef.chessgame.ui.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope


private fun DrawScope.drawSquare(row: Int, col: Int, size: Float, color: Color) {
    drawRect(
        color = color,
        topLeft = Offset(col * size, row * size),
        size = Size(size, size)
    )
}