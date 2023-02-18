package ca.on.hojat.snakegame.dragrace.shop;

import ca.on.hojat.snakegame.dragrace.Assets;
import ca.on.hojat.snakegame.dragrace.MainStreet;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import ca.on.hojat.snakegame.dragrace.Settings;
import org.jetbrains.annotations.NotNull;

public class NoAdsSubMenu {

    int priceNoAds = 20000;

    TextButton btNoAds;
    Label lblNoAds;

    Table contenedor;
    MainStreet game;

    public NoAdsSubMenu(@NotNull final MainStreet game, @NotNull Table contenedor) {
        this.game = game;
        this.contenedor = contenedor;
        contenedor.clear();

        if (!Settings.didBuyNoAds)
            lblNoAds = new Label(priceNoAds + "", Assets.labelStyleChico);

        btNoAds = new TextButton("Buy", Assets.styleTextButtonBuy);
        if (Settings.didBuyNoAds)
            btNoAds.setVisible(false);
        addEfectoPress(btNoAds);
        btNoAds.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Settings.coinsTotal >= priceNoAds) {
                    Settings.coinsTotal -= priceNoAds;
                    Settings.didBuyNoAds = true;
                    lblNoAds.setVisible(false);
                    btNoAds.setVisible(false);
                    game.reqHandler.removeAds();
                }
            }
        });

        // Upgrade BoostTime
        contenedor.add(new Image(Assets.separadorHorizontal)).expandX().fill()
                .height(5);
        contenedor.row();
        contenedor
                .add(agregarPersonajeTabla(lblNoAds,
                        Assets.btNoAds,
                        btNoAds))
                .expandX().fill();
        contenedor.row();

    }


    private Table agregarPersonajeTabla(Label lblPrecio,
                                        TextureRegionDrawable imagen, TextButton boton) {

        Image moneda = new Image(Assets.coinFrente);
        Image imgPersonaje = new Image(imagen);

        if (lblPrecio == null)
            moneda.setVisible(false);

        Table tbBarraTitulo = new Table();
        tbBarraTitulo.add(new Label("No more ads", Assets.labelStyleChico)).expandX()
                .left().padLeft(5);
        tbBarraTitulo.add(moneda).right();
        tbBarraTitulo.add(lblPrecio).right().padRight(10);

        Table tbDescrip = new Table();
        tbDescrip.add(imgPersonaje).left().pad(10).size(55, 45);
        Label lblDescripcion = new Label("Buy it and no more ads will apper in the app", Assets.labelStyleChico);
        lblDescripcion.setWrap(true);
        lblDescripcion.setFontScale(.85f);
        tbDescrip.add(lblDescripcion).expand().fill().padLeft(5);

        Table tbContent = new Table();
        tbContent.add(tbBarraTitulo).expandX().fill().colspan(2).padTop(8);
        tbContent.row().colspan(2);
        tbContent.add(tbDescrip).expandX().fill();
        tbContent.row().colspan(2);

        tbContent.add(boton).right().padRight(10).size(120, 45);

        tbContent.row().colspan(2);
        tbContent.add(new Image(Assets.separadorHorizontal)).expandX().fill()
                .height(5).padTop(15);

        return tbContent;

    }

    protected void addEfectoPress(final Actor actor) {
        actor.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                actor.setPosition(actor.getX(), actor.getY() - 3);
                event.stop();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y,
                                int pointer, int button) {
                actor.setPosition(actor.getX(), actor.getY() + 3);
            }
        });
    }
}
