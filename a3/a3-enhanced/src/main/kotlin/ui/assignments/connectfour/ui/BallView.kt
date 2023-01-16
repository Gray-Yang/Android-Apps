package ui.assignments.connectfour.ui

import javafx.animation.AnimationTimer
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.layout.HBox
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.layout.Region
import javafx.geometry.Insets
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.text.Font
import ui.assignments.connectfour.model.Player
import kotlin.math.abs


class BallView(val model: Modelc, controller: Controller) : VBox(), IView {
    var controllercopy = controller
    var red = ImageView(javaClass.getResource("/ui/assignments/connectfour/piece_red.png").toString()).apply {
        fitHeight = 75.0
        fitWidth = 75.0
    }
    var yellow = ImageView(javaClass.getResource("/ui/assignments/connectfour/piece_yellow.png").toString()).apply {
        fitHeight = 75.0
        fitWidth = 75.0
    }

    var begin = Button("Click here to start game!").apply {
        padding = Insets(10.0)
        background = Background(
            BackgroundFill(Color.LIGHTGREEN,
            CornerRadii(10.0),
            Insets(5.0))
        )
        textFill = Color.BLACK
        textAlignment = TextAlignment.CENTER
        isWrapText = true
        prefHeight = 100.0
        prefWidth = 300.0

    }
    var h = HBox()
    data class DragInfo(var target : ImageView? = null,
                        var anchorX: Double = 0.0,
                        var anchorY: Double = 0.0,
                        var initialX: Double = 0.0,
                        var initialY: Double = 0.0)
    var dragInfo = DragInfo()
    var spacer = Region().apply {
        prefWidth = 370.0
    }
    var spacer2 = Region().apply {
        prefWidth = 900.0
    }
    var bool = true;
    var first = false
    var acc = 0.0

    override fun updateView() {
        if(bool){
            h = HBox(red,spacer).apply {
                alignment = Pos.CENTER
                isFillHeight = true
                prefHeight = 100.0
                padding = Insets(0.0, 10.0, 0.0, 10.0)
            }
            children.remove(0,1)
            children.add(0,h)

            if(first){
                var b = ImageView(javaClass.getResource("/ui/assignments/connectfour/piece_yellow.png").toString())
                var temp = model.modelo.onPieceDropped
                var row = temp.value?.x //row
                var column = temp.value?.y //column
                var xl = row?.times(100.0)
                var yl = column?.times(100.0)
                b.scaleX = 10.0
                b.scaleY = 10.0
                println(xl)
                println(yl)
                b.translateX = 200.0 + xl!! - 52.0
                b.translateY = 70.0-acc + yl!!
                acc = acc+8.0
                b.fitHeight = 8.0
                b.fitWidth = 8.0
                children.add(b)
            }
            if(model.modelo.onGameDraw.value){
                var draw = Label("DRAW")
                draw.setFont(Font("Arial", 24.0))
                val x = HBox(spacer,draw).apply{
                    alignment = Pos.CENTER
                    isFillHeight = true
                }
                children.clear()
                children.add(0,x)
            }

            if(model.modelo.onGameWin.value != Player.NONE){
                var tempWin = model.modelo.onGameWin.value
                var win = Label("Player #"+tempWin.toString()+" WIN")
                win.setFont(Font("Arial", 24.0))
                val x = HBox(spacer,win).apply{
                    alignment = Pos.CENTER
                    isFillHeight = true
                }
                children.clear()
                children.add(0,x)
            }
        }else {
            h = HBox(spacer2,yellow).apply {
                alignment = Pos.CENTER
                isFillHeight = true
                prefHeight = 100.0
                padding = Insets(0.0, 10.0, 0.0, 10.0)
            }
            children.remove(0,1)
            children.add(0,h)

            var a = ImageView(javaClass.getResource("/ui/assignments/connectfour/piece_red.png").toString())
            var temp = model.modelo.onPieceDropped
            var row = temp.value?.x //row
            var column = temp.value?.y //column
            var xp = row?.times(100.0)
            var yp = column?.times(100.0)
            a.scaleX = 10.0
            a.scaleY = 10.0
            println(xp)
            println(yp)
            a.translateX = 200.0 + xp!! - 52.0
            a.translateY = 70.0-acc + yp!!

            acc = acc+8.0
            a.fitHeight = 8.0
            a.fitWidth = 8.0
            children.add(a)
            first = true

            if(model.modelo.onGameDraw.value){
                var draw = Label("DRAW")
                draw.setFont(Font("Arial", 24.0))
                val x = HBox(spacer,draw).apply{
                    alignment = Pos.CENTER
                    isFillHeight = true
                }
                children.clear()
                children.add(0,x)
            }

            if(model.modelo.onGameWin.value != Player.NONE) {
                children.clear()
                var tempWin = model.modelo.onGameWin.value
                var win = Label("Player #" + tempWin.toString() + " WIN")
                win.setFont(Font("Arial", 24.0))

                val x = HBox(spacer, win).apply {
                    alignment = Pos.CENTER
                    isFillHeight = true
                }
                children.add(0, x)

            }
        }
        bool = !bool
    }

    init {

        HBox.setHgrow(spacer, Priority.ALWAYS)
        HBox.setHgrow(spacer2, Priority.ALWAYS)
        begin.setStyle("-fx-font-size:24")

        h = HBox(spacer,begin,spacer2).apply{
            alignment = Pos.CENTER
            isFillHeight = true
        }

        begin.setOnAction(EventHandler<ActionEvent?> {
            controllercopy.start()
            model.modelo.startGame()
        })
        red.apply {
            addEventFilter(MouseEvent.MOUSE_PRESSED){
                dragInfo = DragInfo(this, it.sceneX,it.sceneY,translateX,translateY)
            }
            addEventFilter(MouseEvent.MOUSE_DRAGGED){
                translateX = dragInfo.initialX + it.sceneX - dragInfo.anchorX
                translateY = dragInfo.initialY + it.sceneY - dragInfo.anchorY
                if(translateX < 0.0){
                    translateX = 0.0
                }
                if(translateX > 800.0){
                    translateX = 800.0
                }

                if(translateY < -10.0){
                    translateY = -10.0
                }
                if(translateY > 10.0){
                    translateY = 10.0
                }
                translateX = ((translateX/112.5).toInt()+1.0) * 100
            }
            fun animationDown(y:Int?){
                var velocity = 0.0
                var a = true
                var b = true
                val animation = object : AnimationTimer(){
                    override fun handle(now: Long) {
                        if(a&&b){
                            translateY += velocity
                            velocity += 1.0
                        }
                        else if(!a && b){
                            translateY -= velocity
                            velocity -= 2.0
                        }else {
                            translateY += velocity
                            velocity += 1.0
                        }
                        if (y != null) {
                            if(a&&b){
                                if(translateY > (70.0-acc + y*100)) {
                                    a = !a
                                }
                            }
                            if(!a&&b){
                                if(translateY < (70.0-acc + y*100)/2){
                                    b = false
                                }
                            }
                            if(!a && !b){
                                if(translateY > (70.0-acc + y*100)) {
                                    stop()
                                    isVisible = (model.modelo.onNextPlayer.value == Player.TWO)
                                    translateX = 0.0
                                    translateY = 0.0
                                    controllercopy.next()
                                }
                            }
                        }
                    }
                }
                animation.start()
            }
            fun animationBack(){
                var v1 = abs(translateX)/50.0
                var v2 = abs(translateY)/50.0
                val animation = object : AnimationTimer(){
                    override fun handle(now: Long) {
                        translateX -= v1
                        translateY -= v2
                        if(translateX < 13.0) {
                            stop()
                        }

                    }
                }
                animation.start()
            }
            addEventFilter(MouseEvent.MOUSE_RELEASED){
                dragInfo = DragInfo()
                var col = translateX / 112.5

                model.modelo.dropPiece(col.toInt())

                if(model.modelo.onPieceDropped.value != null){
                    val dropy = model.modelo.onPieceDropped.value?.y
                    println(dropy)
                    animationDown(dropy)
                }else {
                    animationBack()
                }

            }
        }
        yellow.apply {
            addEventFilter(MouseEvent.MOUSE_PRESSED){
                dragInfo = DragInfo(this, it.sceneX,it.sceneY,translateX,translateY)
            }
            addEventFilter(MouseEvent.MOUSE_DRAGGED){
                translateX = dragInfo.initialX + it.sceneX - dragInfo.anchorX
                translateY = dragInfo.initialY + it.sceneY - dragInfo.anchorY
                if(translateX < -800.0){
                    translateX = -800.0
                }
                if(translateX > 0.0){
                    translateX = 0.0
                }

                if(translateY < -10.0){
                    translateY = -10.0
                }
                if(translateY > 10.0){
                    translateY = 10.0
                }
                translateX = ((translateX/112.5).toInt()-1.0) * 100
            }
            fun animationDown(y:Int?){
                var velocity = 0.0
                var a = true
                var b = true
                val animation = object : AnimationTimer(){
                    override fun handle(now: Long) {
                        if(a&&b){
                            translateY += velocity
                            velocity += 1.0
                        }
                        else if(!a && b){
                            translateY -= velocity
                            velocity -= 2.0
                        }else {
                            translateY += velocity
                            velocity += 1.0
                        }
                        if (y != null) {
                            if(a&&b){
                                if(translateY > (70.0-acc + y*100)) {
                                    a = !a
                                }
                            }
                            if(!a&&b){
                                if(translateY < (70.0-acc + y*100)/2){
                                    b = false
                                }
                            }
                            if(!a && !b){
                                if(translateY > (70.0-acc + y*100)) {
                                    stop()
                                    isVisible = (model.modelo.onNextPlayer.value == Player.ONE)
                                    translateX = 0.0
                                    translateY = 0.0
                                    controllercopy.next()
                                }
                            }
                        }
                    }
                }
                animation.start()
            }
            fun animationBack(){
                var v1 = abs(translateX)/50.0
                var v2 = abs(translateY)/50.0
                val animation = object : AnimationTimer(){
                    override fun handle(now: Long) {
                        translateX += v1
                        translateY -= v2
                        if(abs(translateX) < 13.0) {
                            stop()
                        }

                    }
                }
                animation.start()
            }
            addEventFilter(MouseEvent.MOUSE_RELEASED){
                dragInfo = DragInfo()
                var col = (translateX + 900.0) / 112.5
                model.modelo.dropPiece(col.toInt())
                if(model.modelo.onPieceDropped.value != null){
                    val dropy = model.modelo.onPieceDropped.value?.y
                    println(dropy)
                    animationDown(dropy)
                }else {
                    animationBack()
                }
            }
        }

        children.add(h)
        model.addView(this)
    }
}