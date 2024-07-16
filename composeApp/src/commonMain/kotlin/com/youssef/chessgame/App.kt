package com.youssef.chessgame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.youssef.chessgame.theme.AppTheme
import com.youssef.chessgame.ui.ChessGame

@Composable
internal fun App() = MaterialTheme {
   ChessGame()
}

internal expect fun openUrl(url: String?)