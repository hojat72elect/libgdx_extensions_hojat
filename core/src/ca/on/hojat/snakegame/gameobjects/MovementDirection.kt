package ca.on.hojat.snakegame.gameobjects

/**
 * All the various directions that a character (in this case, a snake)
 * can move in our game world.
 */
sealed class MovementDirection {
    object RIGHT : MovementDirection()
    object LEFT : MovementDirection()
    object UP : MovementDirection()
    object DOWN : MovementDirection()
}
