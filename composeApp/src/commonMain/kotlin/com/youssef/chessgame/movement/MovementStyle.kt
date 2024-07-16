package com.youssef.chessgame.movement

import androidx.compose.ui.geometry.Offset
import kotlin.random.Random

class MovementStyle(
    //private val steps: Int,// steps are calculated based on other pieces on the board, it should be the maximum possible value and we then later need to filer out from the set
    val possibleMoves: (position: Offset, steps: Int) -> Set<Offset>
) {
    companion object {
        //Regular chess Movements

        fun moveForward() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            for (i in 1..steps) {
                set.add(Offset(position.x, position.y - i))
            }
            set
        }

        fun moveBackward() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            for (i in 1..steps) {
                set.add(Offset(position.x, position.y + i))
            }
            set
        }

        fun moveLeft() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            for (i in 1..steps) {
                set.add(Offset(position.x - i, position.y))
            }
            set
        }

        fun moveRight() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            for (i in 1..steps) {
                set.add(Offset(position.x + i, position.y))
            }
            set
        }

        fun moveDiagonal() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            for (i in 1..steps) {
                set.add(Offset(position.x + i, position.y - i))
                set.add(Offset(position.x - i, position.y + i))
                set.add(Offset(position.x + i, position.y + i))
                set.add(Offset(position.x - i, position.y - i))
            }
            set
        }

        fun moveLShape() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            set.add(Offset(position.x + 2, position.y - 1))
            set.add(Offset(position.x + 2, position.y + 1))
            set.add(Offset(position.x - 2, position.y - 1))
            set.add(Offset(position.x - 2, position.y + 1))
            set.add(Offset(position.x + 1, position.y - 2))
            set.add(Offset(position.x + 1, position.y + 2))
            set.add(Offset(position.x - 1, position.y - 2))
            set.add(Offset(position.x - 1, position.y + 2))
            set
        }

        //Add more Custom Movements here:
        fun moveCShape() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            set.add(Offset(position.x, position.y - 2))
            set.add(Offset(position.x, position.y + 2))
            set.add(Offset(position.x - 2, position.y))
            set.add(Offset(position.x + 2, position.y))
            set
        }

        fun moveRandomShape() = MovementStyle { position, steps ->
            val set = mutableSetOf<Offset>()
            repeat(4) {
                val randomX = Random.nextInt(0, 7).toFloat()
                val randomY = Random.nextInt(0, 7).toFloat()
                val randomOffset = Offset(randomX, randomY)
                if (randomOffset != position) {
                    set.add(randomOffset)
                }
            }
            set
        }

    }
}