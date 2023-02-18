package ca.on.hojat.snakegame.dragrace.shop

import ca.on.hojat.snakegame.dragrace.Assets
import ca.on.hojat.snakegame.dragrace.MainStreet
import ca.on.hojat.snakegame.dragrace.Settings
import ca.on.hojat.snakegame.dragrace.Settings.save
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Array

class PersonajesSubMenu(var game: MainStreet,  contenedor: Table) {

    var didBuyBanshee = false
    var didBuyTornado = false
    var didBuyTurismo = false
    var didBuyAudiS5 = false
    var didBuyBmwX6 = false
    var didBuyBullet = false
    var didBuyCrossfire = false
    var didBuyCitroenC4 = false
    var didBuyDodgeCharger = false
    var didBuyFiat500 = false
    var didBuyHondaCRV = false
    var didBuyMazda6 = false
    var didBuyMazdaRX8 = false
    var didBuySeatIbiza = false
    var didBuyVolkswagenScirocco = false
    var btBuyDiablo: TextButton? = null
    var btBuyBanshee: TextButton? = null
    var btBuyTornado: TextButton? = null
    var btBuyTurismo: TextButton? = null
    var btBuyAudiS5: TextButton? = null
    var btBuyBmwX6: TextButton? = null
    var btBuyBullet: TextButton? = null
    var btBuyCrossfire: TextButton? = null
    var btBuyCitroenC4: TextButton? = null
    var btBuyDodgeCharger: TextButton? = null
    var btBuyFiat500Lounge: TextButton? = null
    var btBuyHondaCRV: TextButton? = null
    var btBuyMazda6: TextButton? = null
    var btBuyMazdaRX8: TextButton? = null
    var btBuySeatIbiza: TextButton? = null
    var btBuyVolkswagenScirocco: TextButton? = null
    private var arrBotones: Array<TextButton>? = null

    init {
        loadPurchases()
        contenedor.clear()
        var lblPrecioBanshee: Label? = null
        var lblPrecioTornado: Label? = null
        var lblPrecioTurismo: Label? = null
        var lblPrecioAudiS5: Label? = null
        var lblPrecioBmwX6: Label? = null
        var lblPrecioCamaro: Label? = null
        var lblPrecioCrossfire: Label? = null
        var lblPrecioCitroenC4: Label? = null
        var lblPrecioDodgeCharger: Label? = null
        var lblPrecioFiat500Lounge: Label? = null
        var lblPrecioHondeCRV: Label? = null
        var lblPrecioMazda6: Label? = null
        var lblPrecioMazdaRX8: Label? = null
        var lblPrecioSeatIbiza: Label? = null
        var lblPrecioVOlkswagenScirocco: Label? = null
        if (!didBuyBanshee) lblPrecioBanshee = Label(
            PRECIO_BANSHEE.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyTornado) lblPrecioTornado = Label(
            PRECIO_TORNADO.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyTurismo) lblPrecioTurismo = Label(
            PRECIO_TURISMO.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyAudiS5) lblPrecioAudiS5 = Label(
            PRECIO_CARRO_AUDI_S5.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyBmwX6) lblPrecioBmwX6 = Label(
            PRECIO_CARRO_BMW_X6.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyBullet) lblPrecioCamaro = Label(
            PRECIO_BULLET.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyCrossfire) lblPrecioCrossfire = Label(
            PRECIO_CARRO_CHEVRLOTE_CROSSFIRE
                .toString() + "", Assets.labelStyleChico
        )
        if (!didBuyCitroenC4) lblPrecioCitroenC4 = Label(
            PRECIO_CARRO_CITROEN_C4.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyDodgeCharger) lblPrecioDodgeCharger = Label(
            PRECIO_CARRO_DODGE_CHARGER.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyFiat500) lblPrecioFiat500Lounge = Label(
            PRECIO_CARRO_FIAT_500_LOUNGE
                .toString() + "", Assets.labelStyleChico
        )
        if (!didBuyHondaCRV) lblPrecioHondeCRV = Label(
            PRECIO_CARRO_HONDA_CRV.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyMazda6) lblPrecioMazda6 = Label(
            PRECIO_CARRO_MAZDA_6.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyMazdaRX8) lblPrecioMazdaRX8 = Label(
            PRECIO_CARRO_MAZDA_RX8.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuySeatIbiza) lblPrecioSeatIbiza = Label(
            PRECIO_CARRO_SEAT_IBIZA.toString() + "",
            Assets.labelStyleChico
        )
        if (!didBuyVolkswagenScirocco) lblPrecioVOlkswagenScirocco = Label(
            PRECIO_CARRO_VOLKSWAGEN_SCIROCCO.toString() + "",
            Assets.labelStyleChico
        )
        inicializarBotones()
        contenedor.add(Image(Assets.separadorHorizontal)).expandX().fill()
            .height(5f)
        contenedor.row()

        // Usar Default
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Diablo",
                    null,
                    Assets.carroDiablo,
                    "Good car. It's not the fastest, but it's got great handling although maybe a little too twitchy for some.",
                    btBuyDiablo
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_BANSHEE
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Banshee",
                    lblPrecioBanshee,
                    Assets.carroBanshee,
                    "Looks great and drives even better. Awesome acceleration and slight oversteer make this a thrilling ride.",
                    btBuyBanshee
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_TORNADO
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Tornado",
                    lblPrecioTornado,
                    Assets.carroTornado,
                    "Pretty speedy. Nothing too hot about this car, it looks ok and is ok to drive.",
                    btBuyTornado
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_TURISMO
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Turismo",
                    lblPrecioTurismo,
                    Assets.carroTurismo,
                    "If you can get this rare sport car, you'll be rewarded with a superbly fast drive. If you get it, take care of it.",
                    btBuyTurismo
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_AUDI_S5
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Ventura", lblPrecioAudiS5,
                    Assets.audiS5, "No description", btBuyAudiS5
                )
            )
            .expandX().fill()
        contenedor.row()

        // SKIN_CARRO_BMW_X6
        contenedor
            .add(
                agregarPersonajeTabla(
                    "XMW", lblPrecioBmwX6, Assets.bmwX6,
                    "No description", btBuyBmwX6
                )
            ).expandX().fill()
        contenedor.row()

        // PRECIO_BULLET
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Bullet",
                    lblPrecioCamaro,
                    Assets.carroBullet,
                    "Probably the best sporty hatchback. It's quick and sticks to road really well. Acceleration is great too.",
                    btBuyBullet
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_CHEVRLOTE_CROSSFIRE
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Crosstown", lblPrecioCrossfire,
                    Assets.chevroletCrossfire, "No description",
                    btBuyCrossfire
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_CITROEN_C4
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Omega X", lblPrecioCitroenC4,
                    Assets.citroenC4, "No description", btBuyCitroenC4
                )
            )
            .expandX().fill()
        contenedor.row()

        // SKIN_CARRO_DODGE_CHARGER
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Vulcano", lblPrecioDodgeCharger,
                    Assets.dodgeCharger, "No description",
                    btBuyDodgeCharger
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_FIAT_500_LOUNGE
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Fiesta", lblPrecioFiat500Lounge,
                    Assets.fiat500Lounge, "No description",
                    btBuyFiat500Lounge
                )
            ).expandX().fill()
        contenedor.row()

        // SKIN_CARRO_HONDA_CRV
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Comander", lblPrecioHondeCRV,
                    Assets.hondaCRV, "No description", btBuyHondaCRV
                )
            )
            .expandX().fill()
        contenedor.row()

        // SKIN_CARRO_MAZDA_6
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Orion", lblPrecioMazda6,
                    Assets.mazda6, "No description", btBuyMazda6
                )
            )
            .expandX().fill()
        contenedor.row()

        // SKIN_CARRO_MAZDA_RX8
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Colorado", lblPrecioMazdaRX8,
                    Assets.mazdaRX8, "No description", btBuyMazdaRX8
                )
            )
            .expandX().fill()
        contenedor.row()

        // SKIN_CARRO_SEAT_IBIZA
        contenedor
            .add(
                agregarPersonajeTabla(
                    "Formosa", lblPrecioSeatIbiza,
                    Assets.seatIbiza, "No description", btBuySeatIbiza
                )
            )
            .expandX().fill()
        contenedor.row()

        // SKIN_CARRO_VOLKSWAGEN_SCIROCCO
        contenedor
            .add(
                agregarPersonajeTabla(
                    "SHU", lblPrecioVOlkswagenScirocco,
                    Assets.volkswagenScirocco, "No description",
                    btBuyVolkswagenScirocco
                )
            ).expandX().fill()
        contenedor.row()
    }

    private fun agregarPersonajeTabla(
        titulo: String, lblPrecio: Label?,
        imagen: AtlasRegion, descripcion: String, boton: TextButton?
    ): Table {
        val moneda = Image(Assets.coinFrente)
        val imgPersonaje = Image(imagen)
        if (lblPrecio == null) moneda.isVisible = false
        val tbBarraTitulo = Table()
        tbBarraTitulo.add(Label(titulo, Assets.labelStyleChico)).expandX()
            .left()
        tbBarraTitulo.add(moneda).right()
        tbBarraTitulo.add(lblPrecio).right().padRight(10f)
        val tbContent = Table()
        // tbContent.debug();
        tbContent.add(tbBarraTitulo).expandX().fill().colspan(2).padTop(8f)
        tbContent.row()
        tbContent.add(imgPersonaje).left().pad(10f).size(40f, 90f)
        val lblDescripcion = Label(descripcion, Assets.labelStyleChico)
        lblDescripcion.wrap = true
        lblDescripcion.setFontScale(.85f)
        tbContent.add(lblDescripcion).expand().fill().padLeft(5f)
        tbContent.row().colspan(2)
        tbContent.add(boton).expandX().right().padRight(10f).size(120f, 45f)
        tbContent.row().colspan(2)
        tbContent.add(Image(Assets.separadorHorizontal)).expandX().fill()
            .height(5f).padTop(15f)
        return tbContent
    }

    private fun inicializarBotones() {
        arrBotones = Array()

        // DEFAULT
        btBuyDiablo = TextButton("Select", Assets.styleTextButtonPurchased)
        if (Settings.skinSeleccionada == SKIN_CARRO_DIABLO) btBuyDiablo!!.isVisible = false
        addEfectoPress(btBuyDiablo!!)
        btBuyDiablo!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                Settings.skinSeleccionada = SKIN_CARRO_DIABLO
                setSelected(btBuyDiablo!!)
            }
        })

        // SKIN_CARRO_BANSHEE
        btBuyBanshee = if (didBuyBanshee) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_BANSHEE) btBuyBanshee!!.isVisible = false
        addEfectoPress(btBuyBanshee!!)
        btBuyBanshee!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyBanshee) {
                    Settings.skinSeleccionada = SKIN_CARRO_BANSHEE
                    setSelected(btBuyBanshee!!)
                } else if (Settings.coinsTotal >= PRECIO_BANSHEE) {
                    Settings.coinsTotal -= PRECIO_BANSHEE
                    setButtonStylePurchased(btBuyBanshee!!)
                    didBuyBanshee = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_TORNADO
        btBuyTornado = if (didBuyTornado) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_TORNADO) btBuyTornado!!.isVisible = false
        addEfectoPress(btBuyTornado!!)
        btBuyTornado!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyTornado) {
                    Settings.skinSeleccionada = SKIN_CARRO_TORNADO
                    setSelected(btBuyTornado!!)
                } else if (Settings.coinsTotal >= PRECIO_TORNADO) {
                    Settings.coinsTotal -= PRECIO_TORNADO
                    setButtonStylePurchased(btBuyTornado!!)
                    didBuyTornado = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_TURISMO
        btBuyTurismo = if (didBuyTurismo) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_TURISMO) btBuyTurismo!!.isVisible = false
        addEfectoPress(btBuyTurismo!!)
        btBuyTurismo!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyTurismo) {
                    Settings.skinSeleccionada = SKIN_CARRO_TURISMO
                    setSelected(btBuyTurismo!!)
                } else if (Settings.coinsTotal >= PRECIO_TURISMO) {
                    Settings.coinsTotal -= PRECIO_TURISMO
                    setButtonStylePurchased(btBuyTurismo!!)
                    didBuyTurismo = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_AUDI_S5
        btBuyAudiS5 = if (didBuyAudiS5) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_AUDI_S5) btBuyAudiS5!!.isVisible = false
        addEfectoPress(btBuyAudiS5!!)
        btBuyAudiS5!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyAudiS5) {
                    Settings.skinSeleccionada = SKIN_CARRO_AUDI_S5
                    setSelected(btBuyAudiS5!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_AUDI_S5) {
                    Settings.coinsTotal -= PRECIO_CARRO_AUDI_S5
                    setButtonStylePurchased(btBuyAudiS5!!)
                    didBuyAudiS5 = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_BMW_X6
        btBuyBmwX6 = if (didBuyBmwX6) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_BMW_X6) btBuyBmwX6!!.isVisible = false
        addEfectoPress(btBuyBmwX6!!)
        btBuyBmwX6!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyBmwX6) {
                    Settings.skinSeleccionada = SKIN_CARRO_BMW_X6
                    setSelected(btBuyBmwX6!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_BMW_X6) {
                    Settings.coinsTotal -= PRECIO_CARRO_BMW_X6
                    setButtonStylePurchased(btBuyBmwX6!!)
                    didBuyBmwX6 = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_BULLET
        btBuyBullet = if (didBuyBullet) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_BULLET) btBuyBullet!!.isVisible = false
        addEfectoPress(btBuyBullet!!)
        btBuyBullet!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyBullet) {
                    Settings.skinSeleccionada = SKIN_CARRO_BULLET
                    setSelected(btBuyBullet!!)
                } else if (Settings.coinsTotal >= PRECIO_BULLET) {
                    Settings.coinsTotal -= PRECIO_BULLET
                    setButtonStylePurchased(btBuyBullet!!)
                    didBuyBullet = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_CHEVRLOTE_CROSSFIRE
        btBuyCrossfire = if (didBuyCrossfire) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_CHEVRLOTE_CROSSFIRE) btBuyCrossfire!!.isVisible = false
        addEfectoPress(btBuyCrossfire!!)
        btBuyCrossfire!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyCrossfire) {
                    Settings.skinSeleccionada = SKIN_CARRO_CHEVRLOTE_CROSSFIRE
                    setSelected(btBuyCrossfire!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_CHEVRLOTE_CROSSFIRE) {
                    Settings.coinsTotal -= PRECIO_CARRO_CHEVRLOTE_CROSSFIRE
                    setButtonStylePurchased(btBuyCrossfire!!)
                    didBuyCrossfire = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_CITROEN_C4
        btBuyCitroenC4 = if (didBuyCitroenC4) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_CITROEN_C4) btBuyCitroenC4!!.isVisible = false
        addEfectoPress(btBuyCitroenC4!!)
        btBuyCitroenC4!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyCitroenC4) {
                    Settings.skinSeleccionada = SKIN_CARRO_CITROEN_C4
                    setSelected(btBuyCitroenC4!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_CITROEN_C4) {
                    Settings.coinsTotal -= PRECIO_CARRO_CITROEN_C4
                    setButtonStylePurchased(btBuyCitroenC4!!)
                    didBuyCitroenC4 = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_DODGE_CHARGER
        btBuyDodgeCharger = if (didBuyDodgeCharger) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_DODGE_CHARGER) btBuyDodgeCharger!!.isVisible = false
        addEfectoPress(btBuyDodgeCharger!!)
        btBuyDodgeCharger!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyDodgeCharger) {
                    Settings.skinSeleccionada = SKIN_CARRO_DODGE_CHARGER
                    setSelected(btBuyDodgeCharger!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_DODGE_CHARGER) {
                    Settings.coinsTotal -= PRECIO_CARRO_DODGE_CHARGER
                    setButtonStylePurchased(btBuyDodgeCharger!!)
                    didBuyDodgeCharger = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_FIAT_500_LOUNGE
        btBuyFiat500Lounge = if (didBuyFiat500) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton(
            "Buy",
            Assets.styleTextButtonBuy
        )
        if (Settings.skinSeleccionada == SKIN_CARRO_FIAT_500_LOUNGE) btBuyFiat500Lounge!!.isVisible = false
        addEfectoPress(btBuyFiat500Lounge!!)
        btBuyFiat500Lounge!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyFiat500) {
                    Settings.skinSeleccionada = SKIN_CARRO_FIAT_500_LOUNGE
                    setSelected(btBuyFiat500Lounge!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_FIAT_500_LOUNGE) {
                    Settings.coinsTotal -= PRECIO_CARRO_FIAT_500_LOUNGE
                    setButtonStylePurchased(btBuyFiat500Lounge!!)
                    didBuyFiat500 = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_HONDA_CRV
        btBuyHondaCRV = if (didBuyHondaCRV) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_HONDA_CRV) btBuyHondaCRV!!.isVisible = false
        addEfectoPress(btBuyHondaCRV!!)
        btBuyHondaCRV!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyHondaCRV) {
                    Settings.skinSeleccionada = SKIN_CARRO_HONDA_CRV
                    setSelected(btBuyHondaCRV!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_HONDA_CRV) {
                    Settings.coinsTotal -= PRECIO_CARRO_HONDA_CRV
                    setButtonStylePurchased(btBuyHondaCRV!!)
                    didBuyHondaCRV = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_MAZDA_6
        btBuyMazda6 = if (didBuyMazda6) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_MAZDA_6) btBuyMazda6!!.isVisible = false
        addEfectoPress(btBuyMazda6!!)
        btBuyMazda6!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyMazda6) {
                    Settings.skinSeleccionada = SKIN_CARRO_MAZDA_6
                    setSelected(btBuyMazda6!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_MAZDA_6) {
                    Settings.coinsTotal -= PRECIO_CARRO_MAZDA_6
                    setButtonStylePurchased(btBuyMazda6!!)
                    didBuyMazda6 = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_MAZDA_RX8
        btBuyMazdaRX8 = if (didBuyMazdaRX8) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_MAZDA_RX8) btBuyMazdaRX8!!.isVisible = false
        addEfectoPress(btBuyMazdaRX8!!)
        btBuyMazdaRX8!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyMazdaRX8) {
                    Settings.skinSeleccionada = SKIN_CARRO_MAZDA_RX8
                    setSelected(btBuyMazdaRX8!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_MAZDA_RX8) {
                    Settings.coinsTotal -= PRECIO_CARRO_MAZDA_RX8
                    setButtonStylePurchased(btBuyMazdaRX8!!)
                    didBuyMazdaRX8 = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_SEAT_IBIZA
        btBuySeatIbiza = if (didBuySeatIbiza) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton("Buy", Assets.styleTextButtonBuy)
        if (Settings.skinSeleccionada == SKIN_CARRO_SEAT_IBIZA) btBuySeatIbiza!!.isVisible = false
        addEfectoPress(btBuySeatIbiza!!)
        btBuySeatIbiza!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuySeatIbiza) {
                    Settings.skinSeleccionada = SKIN_CARRO_SEAT_IBIZA
                    setSelected(btBuySeatIbiza!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_SEAT_IBIZA) {
                    Settings.coinsTotal -= PRECIO_CARRO_SEAT_IBIZA
                    setButtonStylePurchased(btBuySeatIbiza!!)
                    didBuySeatIbiza = true
                }
                savePurchases()
            }
        })

        // SKIN_CARRO_VOLKSWAGEN_SCIROCCO
        btBuyVolkswagenScirocco = if (didBuyVolkswagenScirocco) TextButton(
            "Select",
            Assets.styleTextButtonPurchased
        ) else TextButton(
            "Buy",
            Assets.styleTextButtonBuy
        )
        if (Settings.skinSeleccionada == SKIN_CARRO_VOLKSWAGEN_SCIROCCO) btBuyVolkswagenScirocco!!.isVisible = false
        addEfectoPress(btBuyVolkswagenScirocco!!)
        btBuyVolkswagenScirocco!!.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                if (didBuyVolkswagenScirocco) {
                    Settings.skinSeleccionada = SKIN_CARRO_VOLKSWAGEN_SCIROCCO
                    setSelected(btBuyVolkswagenScirocco!!)
                } else if (Settings.coinsTotal >= PRECIO_CARRO_VOLKSWAGEN_SCIROCCO) {
                    Settings.coinsTotal -= PRECIO_CARRO_VOLKSWAGEN_SCIROCCO
                    setButtonStylePurchased(btBuyVolkswagenScirocco!!)
                    didBuyVolkswagenScirocco = true
                }
                savePurchases()
            }
        })
        arrBotones!!.add(btBuyDiablo)
        arrBotones!!.add(btBuyBanshee)
        arrBotones!!.add(btBuyTornado)
        arrBotones!!.add(btBuyTurismo)
        arrBotones!!.add(btBuyAudiS5)
        arrBotones!!.add(btBuyBmwX6)
        arrBotones!!.add(btBuyBullet)
        arrBotones!!.add(btBuyCrossfire)
        arrBotones!!.add(btBuyCitroenC4)
        arrBotones!!.add(btBuyDodgeCharger)
        arrBotones!!.add(btBuyFiat500Lounge)
        arrBotones!!.add(btBuyHondaCRV)
        arrBotones!!.add(btBuyMazda6)
        arrBotones!!.add(btBuyMazdaRX8)
        arrBotones!!.add(btBuySeatIbiza)
        arrBotones!!.add(btBuyVolkswagenScirocco)
    }

    private fun loadPurchases() {
        didBuyBanshee = pref.getBoolean("didBuyBanshee", false)
        didBuyTornado = pref.getBoolean("didBuyTornado", false)
        didBuyTurismo = pref.getBoolean("didBuyTurismo", false)
        didBuyAudiS5 = pref.getBoolean("didBuyAudiS5", false)
        didBuyBmwX6 = pref.getBoolean("didBuyBmwX6", false)
        didBuyBullet = pref.getBoolean("didBuyBullet", false)
        didBuyCrossfire = pref.getBoolean("didBuyCrossfire", false)
        didBuyCitroenC4 = pref.getBoolean("didBuyCitroenC4", false)
        didBuyDodgeCharger = pref.getBoolean("didBuyDodgeCharger", false)
        didBuyFiat500 = pref.getBoolean("didBuyFiat500", false)
        didBuyHondaCRV = pref.getBoolean("didBuyHondaCRV", false)
        didBuyMazda6 = pref.getBoolean("didBuyMazda6", false)
        didBuyMazdaRX8 = pref.getBoolean("didBuyMazdaRX8", false)
        didBuySeatIbiza = pref.getBoolean("didBuySeatIbiza", false)
        didBuyVolkswagenScirocco = pref.getBoolean(
            "didBuyVolkswagenScirocco",
            false
        )
    }

    private fun savePurchases() {
        pref.putBoolean("didBuyBanshee", didBuyBanshee)
        pref.putBoolean("didBuyTornado", didBuyTornado)
        pref.putBoolean("didBuyTurismo", didBuyTurismo)
        pref.putBoolean("didBuyAudiS5", didBuyAudiS5)
        pref.putBoolean("didBuyBmwX6", didBuyBmwX6)
        pref.putBoolean("didBuyBullet", didBuyBullet)
        pref.putBoolean("didBuyCrossfire", didBuyCrossfire)
        pref.putBoolean("didBuyCitroenC4", didBuyCitroenC4)
        pref.putBoolean("didBuyDodgeCharger", didBuyDodgeCharger)
        pref.putBoolean("didBuyFiat500", didBuyFiat500)
        pref.putBoolean("didBuyHondaCRV", didBuyHondaCRV)
        pref.putBoolean("didBuyMazda6", didBuyMazda6)
        pref.putBoolean("didBuyMazdaRX8", didBuyMazdaRX8)
        pref.putBoolean("didBuySeatIbiza", didBuySeatIbiza)
        pref.putBoolean("didBuyVolkswagenScirocco", didBuyVolkswagenScirocco)
        pref.flush()
        save()
    }

    private fun setButtonStylePurchased(boton: TextButton) {
        boton.style = Assets.styleTextButtonPurchased
        boton.setText("Select")
    }

    private fun setSelected(boton: TextButton) {
        // Pongo todos visibles y al final el boton seleccionado en invisible
        for (arrBotone in arrBotones!!) {
            arrBotone.isVisible = true
        }
        boton.isVisible = false
    }

    private fun addEfectoPress(actor: Actor) {
        actor.addListener(object : InputListener() {
            override fun touchDown(
                event: InputEvent, x: Float, y: Float,
                pointer: Int, button: Int
            ): Boolean {
                actor.setPosition(actor.x, actor.y - 3)
                event.stop()
                return true
            }

            override fun touchUp(
                event: InputEvent, x: Float, y: Float,
                pointer: Int, button: Int
            ) {
                actor.setPosition(actor.x, actor.y + 3)
            }
        })
    }

    companion object {
        const val PRECIO_BANSHEE = 50
        const val PRECIO_BULLET = 175
        const val PRECIO_TURISMO = 100
        const val PRECIO_TORNADO = 75
        const val PRECIO_CARRO_AUDI_S5 = 125
        const val PRECIO_CARRO_BMW_X6 = 150
        const val PRECIO_CARRO_CHEVRLOTE_CROSSFIRE = 200
        const val PRECIO_CARRO_CITROEN_C4 = 225
        const val PRECIO_CARRO_DODGE_CHARGER = 250
        const val PRECIO_CARRO_FIAT_500_LOUNGE = 275
        const val PRECIO_CARRO_HONDA_CRV = 300
        const val PRECIO_CARRO_MAZDA_6 = 325
        const val PRECIO_CARRO_MAZDA_RX8 = 350
        const val PRECIO_CARRO_SEAT_IBIZA = 375
        const val PRECIO_CARRO_VOLKSWAGEN_SCIROCCO = 400
        const val SKIN_CARRO_DIABLO = 0
        const val SKIN_CARRO_BANSHEE = 1
        const val SKIN_CARRO_TURISMO = 3
        const val SKIN_CARRO_BULLET = 6
        const val SKIN_CARRO_TORNADO = 2
        const val SKIN_CARRO_AUDI_S5 = 4
        const val SKIN_CARRO_BMW_X6 = 5
        const val SKIN_CARRO_CHEVRLOTE_CROSSFIRE = 7
        const val SKIN_CARRO_CITROEN_C4 = 8
        const val SKIN_CARRO_DODGE_CHARGER = 9
        const val SKIN_CARRO_FIAT_500_LOUNGE = 10
        const val SKIN_CARRO_HONDA_CRV = 11
        const val SKIN_CARRO_MAZDA_6 = 12
        const val SKIN_CARRO_MAZDA_RX8 = 13
        const val SKIN_CARRO_SEAT_IBIZA = 14
        const val SKIN_CARRO_VOLKSWAGEN_SCIROCCO = 15
        private val pref = Gdx.app
            .getPreferences("com.tiar.dragrace.shop")
    }
}