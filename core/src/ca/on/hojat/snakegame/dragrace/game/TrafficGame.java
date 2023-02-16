package ca.on.hojat.snakegame.dragrace.game;

import ca.on.hojat.snakegame.dragrace.Assets;
import ca.on.hojat.snakegame.dragrace.objects.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import ca.on.hojat.snakegame.dragrace.screens.Screens;

import java.util.Iterator;

public class TrafficGame extends Table {
    public static final int STATE_RUNNING = 0;
    public static final int STATE_GAMEOVER = 1;
    public int state;

    final float WIDTH = Screens.WORLD_WIDTH;
    final float HEIGHT = Screens.WORLD_HEIGHT;

    public final static int NUM_COINS_FOR_SUPERSPEED = 10;
    public int numCoinsForSuperSpeed;
    boolean canSuperSpeed;

    final float TIME_TO_SPAWN_CAR = 2;
    float timeToSpawnCar;

    final float TIME_TO_SPAWN_COIN = 1f;
    float timeToSpawnCoin;

    final float DURATION_SUPER_SPEED = 5;
    float durationSuperSpeed = 0;
    boolean isSuperSpeed;
    float velocidadActual = 5;

    float score;
    int coins;

    private final InfiniteScrollBg backgroundRoad;
    public PlayerCar oCar;
    private final Array<EnemyCar> arrEnemyCars;
    private final Array<Moneda> arrCoins;

    public final float lane2 = 390;
    public final float lane1 = 240;
    public final float lane0 = 90;

    public TrafficGame() {
        setBounds(0, 0, WIDTH, HEIGHT);
        setClip(true);
        backgroundRoad = new InfiniteScrollBg(getWidth(), getHeight());
        addActor(backgroundRoad);

        oCar = new PlayerCar(this);
        addActor(oCar);
        arrEnemyCars = new Array<>();
        arrCoins = new Array<>();

        state = STATE_RUNNING;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        durationSuperSpeed += delta;
        if (durationSuperSpeed >= DURATION_SUPER_SPEED) {
            stopSuperSpeed();
        }

        if (numCoinsForSuperSpeed >= NUM_COINS_FOR_SUPERSPEED) {
            canSuperSpeed = true;
        }


        updateEnemyCar(delta);
        updateMonedas(delta);
        score += delta * velocidadActual;

        if (oCar.state == PlayerCar.STATE_DEAD) {
            state = STATE_GAMEOVER;
        }

    }


    private void updateEnemyCar(float delta) {
        // Primero creo un carro si es necesario

        timeToSpawnCar += delta;
        if (timeToSpawnCar >= TIME_TO_SPAWN_CAR) {
            timeToSpawnCar -= TIME_TO_SPAWN_CAR;
            spawnCar();

        }

        Iterator<EnemyCar> iter = arrEnemyCars.iterator();
        while (iter.hasNext()) {
            EnemyCar enemyCar = iter.next();
            if (enemyCar.getBounds().y + enemyCar.getHeight() <= 0) {
                iter.remove();
                removeActor(enemyCar);
                continue;
            }

            if (isSuperSpeed)
                enemyCar.setSpeed();
        }

        // Despues checo las colisiones con el jugador
        iter = arrEnemyCars.iterator();
        while (iter.hasNext()) {
            EnemyCar enemyCar = iter.next();
            if (enemyCar.getBounds().overlaps(oCar.getBounds())) {
                iter.remove();

                if (enemyCar.getX() > oCar.getX()) {
                    enemyCar.crash(true, enemyCar.getY() > oCar.getY());
                    if (!isSuperSpeed)
                        oCar.crash(false, true);
                } else {
                    enemyCar.crash(false, enemyCar.getY() > oCar.getY());
                    if (!isSuperSpeed)
                        oCar.crash(true, true);
                }
                Assets.soundCrash.stop();
                Assets.playSound(Assets.soundCrash);

            }
        }

    }

    private void updateMonedas(float delta) {

        timeToSpawnCoin += delta;

        // if (isSuperSpeed)
        // timeToSpawnCoin += delta * 5;

        if (timeToSpawnCoin >= TIME_TO_SPAWN_COIN) {
            timeToSpawnCoin -= TIME_TO_SPAWN_COIN;
            spwanCoin();
        }

        Iterator<Moneda> iter = arrCoins.iterator();
        while (iter.hasNext()) {
            Moneda obj = iter.next();
            if (obj.getBounds().y + obj.getHeight() <= 0) {
                iter.remove();
                removeActor(obj);
                continue;
            }
            // Veo si estan tocando mi carro
            if (oCar.getBounds().overlaps(obj.getBounds())) {
                iter.remove();
                removeActor(obj);
                coins++;
                numCoinsForSuperSpeed++;
                continue;
            }

            // Veo si esta tocando a un enemigo
            for (EnemyCar objEnemy : arrEnemyCars) {
                if (obj.getBounds().overlaps(objEnemy.getBounds())) {
                    iter.remove();
                    removeActor(obj);
                    break;
                }
            }

            if (isSuperSpeed)
                obj.setSpeed();

        }

    }

    public void setSuperSpeed() {
        canSuperSpeed = false;
        durationSuperSpeed = 0;
        isSuperSpeed = true;
        velocidadActual = 30;
        numCoinsForSuperSpeed = 0;
        backgroundRoad.setSpeed();

    }

    public void stopSuperSpeed() {
        isSuperSpeed = false;
        velocidadActual = 5;
        backgroundRoad.stopSpeed();
    }

    private void spawnCar() {
        int lane = MathUtils.random(0, 2);
        float x = 0;
        if (lane == 0)
            x = lane0;
        if (lane == 1)
            x = lane1;
        if (lane == 2)
            x = lane2;
        EnemyCar enemyCar = new EnemyCar(x, getHeight());
        arrEnemyCars.add(enemyCar);
        addActor(enemyCar);
    }

    private void spwanCoin() {
        int lane = MathUtils.random(0, 2);
        float x = 0;
        if (lane == 0)
            x = lane0;
        if (lane == 1)
            x = lane1;
        if (lane == 2)
            x = lane2;
        Moneda obj = new Moneda(x, getHeight());
        arrCoins.add(obj);
        addActor(obj);
    }

}
