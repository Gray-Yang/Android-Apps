import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

// MVC1 Separate View and Controller (not typically done, but example of "pure" MVC)
// A simple MVC example inspired by Joseph Mack, http://www.austintek.com/mvc/
// This version uses MVC: two views coordinated with the observer pattern and a separate controller.
class Main : Application() {
    override fun start(stage: Stage) {
        // window name
        stage.title = this.javaClass.name

        // create and initialize the Model to hold our counter
        val model = Model()

        // create the Controller, and tell it about Model
        // the controller will handle input and pass requests to the model
        val controller = Controller(model)

        // create each view, and tell them about model and controller
        // the views will register themselves with these components
        // and handle displaying the data from the model
        //val view1 = View1(model, controller)

        val toolbarview = toolbarView(model, controller)
        val datasetview = datasetView(model, controller)
        val graph = graphsView(model, controller)

        val summary = BorderPane()

        datasetview.scrollPane.minHeightProperty().bind(
            stage.heightProperty()
        )
/*
        val vbox = VBox()
        vbox.children.add(toolbarview)

        val vbox2 = VBox()
            //vbox2.children.add(view1)
        vbox2.children.add(line)

        val hbox = HBox()
        hbox.children.add(datasetview)
        hbox.children.add(vbox2)

        vbox.children.add(hbox)*/
        summary.top = toolbarview
        summary.center = datasetview
        summary.right = graph

        //vbox.children.add(view1) // top-view
        //vbox.children.add(view2) // bottom-view

        // Add grid to a scene (and the scene to the stage)
        stage.title = "CS349 - A2 Graphs - h338yang"
        stage.scene = Scene(summary, 640.0, 480.0)
        stage.minWidth = 800.0
        stage.minHeight = 600.0
        stage.show()
    }
}
