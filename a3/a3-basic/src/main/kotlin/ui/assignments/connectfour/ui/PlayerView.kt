package ui.assignments.connectfour.ui
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import javafx.scene.control.Label;
import javafx.scene.text.Font

class PlayerView(val model: Modelc, controller: Controller) : VBox(), IView {
    var Player1 = Label("Player #1").apply {
        padding = Insets(10.0)
        textFill = Color.GREY
        textAlignment = TextAlignment.CENTER
        isWrapText = true
        prefWidth = 140.0
        prefHeight = 40.0
    }

    var Player2 = Label("Player #2").apply{
        padding = Insets(10.0)
        textFill = Color.GREY
        textAlignment = TextAlignment.CENTER
        isWrapText = true
        prefWidth = 125.0
        prefHeight = 40.0
    }

    var spacer = Region().apply {
        prefWidth = 730.0
    }
    var whole = HBox(Player1,spacer,Player2).apply{
        alignment = Pos.CENTER
        isFillHeight = true
    }

    var bool = true

    override fun updateView() {
        if(bool){
            Player1.textFill = Color.BLACK
            Player2.textFill = Color.GREY
        }else {
            Player1.textFill = Color.GREY
            Player2.textFill = Color.BLACK
        }
        bool = !bool
    }

    init {
        Player1.setFont(Font("Arial", 24.0))
        Player2.setFont(Font("Arial", 24.0))
        children.add(whole)
        model.addView(this)
    }
}