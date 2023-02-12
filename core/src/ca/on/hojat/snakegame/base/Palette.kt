package ca.on.hojat.snakegame.base

import com.badlogic.gdx.graphics.Color

object Palette {
    val WHITE = define(255f, 255f, 255f)
    val PINE = define(116f, 63f, 57f)
    val TETANUS = define(190f, 74f, 47f)
    val OAK = define(184f, 111f, 80f)
    val SHADESKIN = define(194f, 133f, 105f)
    val RUST = define(216f, 118f, 68f)
    val AMBER = define(247f, 118f, 34f)
    val SKIN = define(232f, 183f, 150f)
    val SAP = define(228f, 166f, 114f)
    val GLOW = define(254f, 174f, 52f)
    val BIRCH = define(234f, 212f, 170f)
    val LIGHT = define(254f, 231f, 97f)
    val GLADE = define(99f, 199f, 77f)
    val FLORA = define(62f, 137f, 72f)
    val MOSS = define(38f, 92f, 66f)
    val MOLD = define(25f, 60f, 62f)
    val ION = define(44f, 232f, 245f)
    val ARCHAEON = define(0f, 149f, 233f)
    val DEEP = define(18f, 78f, 137f)
    val ALUMINIUM = define(192f, 203f, 220f)
    val ZINC = define(139f, 155f, 180f)
    val IRON = define(90f, 105f, 136f)
    val STEEL = define(58f, 68f, 102f)
    val SHADE = define(38f, 43f, 68f)
    val INK = define(24f, 20f, 37f)
    val LILAC = define(104f, 56f, 108f)
    val PETAL = define(181f, 80f, 136f)
    val DARKBARK = define(63f, 40f, 50f)
    val IIEM = define(255f, 0f, 68f)
    val BLOOD = define(158f, 40f, 53f)
    val FABRIC = define(228f, 59f, 68f)
    val PEACH = define(246f, 117f, 122f)
    private fun define(r: Float, g: Float, b: Float): Color {
        return Color(r / 255f, g / 255f, b / 255f, 1f)
    }
}