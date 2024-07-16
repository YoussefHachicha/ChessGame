package com.youssef.chessgame.movement


class MovementStyleBuilder {
    private val rules = mutableListOf<MovementStyle>()

    fun build(): Set<MovementStyle> = rules.toSet()


    fun moveForward(): MovementStyleBuilder {
        rules.add(MovementStyle.moveForward())
        return this
    }

    fun moveBackward(): MovementStyleBuilder {
        rules.add(MovementStyle.moveBackward())
        return this
    }

    fun moveLeft(): MovementStyleBuilder {
        rules.add(MovementStyle.moveLeft())
        return this
    }

    fun moveRight(): MovementStyleBuilder {
        rules.add(MovementStyle.moveRight())
        return this
    }

    fun moveDiagonal(): MovementStyleBuilder {
        rules.add(MovementStyle.moveDiagonal())
        return this
    }

    fun moveLShape(): MovementStyleBuilder {
        rules.add(MovementStyle.moveLShape())
        return this
    }

    fun moveCShape(): MovementStyleBuilder {
        rules.add(MovementStyle.moveCShape())
        return this
    }

    fun moveRandomWay(): MovementStyleBuilder {
        rules.add(MovementStyle.moveRandomShape())
        return this
    }

}