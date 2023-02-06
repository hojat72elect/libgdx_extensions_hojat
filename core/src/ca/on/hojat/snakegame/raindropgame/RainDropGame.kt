package ca.on.hojat.snakegame.raindropgame

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.TimeUtils

class RainDropGame : ApplicationAdapter() {

    private val rainDrops = Array<Rectangle>()

    // last time we spawned a rain drop
    private var lastDropTime = 0L

    private val dropGameObject = BaseGameObject(
        rectangle = Rectangle(),
        textureAddress = *arrayOf("droplet.png")
    )

    private lateinit var dropSound: Sound
    private lateinit var rainMusic: Music
    private lateinit var camera: OrthographicCamera
    private lateinit var batch: SpriteBatch

    private val bucket = BaseGameObject(
        rectangle = Rectangle(),
        textureAddress = *arrayOf("bucket.png")
    )

    private fun spawnRaindrop() {
        val newRainDropInstance = Rectangle().apply {
            x = MathUtils.random(0f, 800f - 64)
            y = 480f
            width = 64f
            height = 64f
        }


        rainDrops.add(newRainDropInstance)
        lastDropTime = TimeUtils.nanoTime()
    }

    /**
     * warmup code
     */
    override fun create() {

        spawnRaindrop()
        // create the camera
        camera = OrthographicCamera()
        camera.setToOrtho(false, 800f, 480f)
        // create the sprite batch
        batch = SpriteBatch()
        // Load all the textures
        dropGameObject.loadTexture()
        bucket.loadTexture()

        // position the bucket in our world
        with(bucket.rectangle) {
            x = 800f / 2 - 64 / 2
            y = 20f
            width = 64f
            height = 64f
        }
        // load sounds and musics
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"))
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"))
        // start the music
        rainMusic.isLooping = true
        rainMusic.play()
    }

    override fun render() {
        ScreenUtils.clear(0f, 0f, 0.2f, 1f)
        camera.update()
        // render the bucket
        batch.projectionMatrix = camera.combined
        batch.begin()
        batch.draw(bucket.textureGraphic.first(), bucket.rectangle.x, bucket.rectangle.y)
        for (rainDrop in rainDrops) {
            batch.draw(dropGameObject.textureGraphic.first(), rainDrop.x, rainDrop.y)
        }
        batch.end()
        if (TimeUtils.nanoTime() - lastDropTime > 1_000_000_000) spawnRaindrop()
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.rectangle.x -= 200 * Gdx.graphics.deltaTime
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.rectangle.x += 200 * Gdx.graphics.deltaTime
        if (bucket.rectangle.x < 0) bucket.rectangle.x = 0f
        if (bucket.rectangle.x > 800 - 64) bucket.rectangle.x = 800f - 64
        rainDrops.iterator().forEach { rainDrop ->
            rainDrop.y -= 200 * Gdx.graphics.deltaTime
            if (rainDrop.y + 64 < 0) rainDrops.removeValue(rainDrop, true)
            if (rainDrop.overlaps(bucket.rectangle)) {
                dropSound.play()
                rainDrops.removeValue(rainDrop, true)
            }
        }
    }

    override fun dispose() {
        dropGameObject.dispose()
        bucket.dispose()
        dropSound.dispose()
        rainMusic.dispose()
        batch.dispose()
    }
}