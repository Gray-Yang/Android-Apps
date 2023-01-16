package ui.assignments.connectfour

import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import ui.assignments.connectfour.ui.*

class ConnectFourApp : Application() {
    override fun start(stage: Stage) {
        stage.title = this.javaClass.name

        // create and initialize the Model to hold our counter
        val model = Modelc()

        // create the ui.assignments.connectfour.ui.Controller, and tell it about Model
        // the controller will handle input and pass requests to the model
        val controller = Controller(model)

        // create each view, and tell them about model and controller
        // the views will register themselves with these components
        // and handle displaying the data from the model
        //val view1 = View1(model, controller)

        val player = PlayerView(model, controller)
        val ball = BallView(model, controller)
        val grid = GridView(model, controller)



//        val summary = BorderPane()

  //      val v = VBox(player,ball)
    //    grid.alignment = Pos.CENTER
      //  summary.top = v
        //summary.bottom = grid
        val summary = AnchorPane(player.apply{
            AnchorPane.setTopAnchor(this, 0.0)
            AnchorPane.setLeftAnchor(this, 0.0)
        },ball.apply {
            AnchorPane.setTopAnchor(this, 50.0)
            AnchorPane.setLeftAnchor(this, 0.0)
        },grid.apply{
            AnchorPane.setTopAnchor(this, 175.0)
            AnchorPane.setLeftAnchor(this, 100.0)
        })


        stage.title = "CS349 - A3 Connect Four - h338yang"
        stage.scene = Scene(summary, 1000.0, 880.0)
        stage.isResizable = false
        stage.show()
    }
}