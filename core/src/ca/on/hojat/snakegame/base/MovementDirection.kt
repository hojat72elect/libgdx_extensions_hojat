package ca.on.hojat.snakegame.base

/**
 * All the various directions that a character (in this case, a snake)
 * can move in our game world.
 */
sealed class MovementDirection {
    object Right : MovementDirection()
    object Left : MovementDirection()
    object Top : MovementDirection()
    object Bottom : MovementDirection()
    object TopLeft : MovementDirection()
    object TopRight : MovementDirection()
    object BottomLeft : MovementDirection()
    object BottomRight : MovementDirection()
}
