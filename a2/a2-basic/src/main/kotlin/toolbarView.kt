import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.FXCollections.observableFloatArray
import javafx.geometry.Orientation
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.layout.Region
import java.util.*
import javafx.geometry.Insets
import javafx.event.ActionEvent
import javafx.event.EventHandler


class toolbarView(val model: Model, controller: Controller) : VBox(), IView {
    // When notified by the model that things have changed,
    // update to display the new value
    var list = observableArrayList("quadratic")
    var choiceBox = ChoiceBox(list).apply{
        selectionModel.select(0)
        minWidth = 110.0
    }
    var controllercopy = controller
    var spacer = Region()
    var first = HBox(choiceBox, spacer).apply{
        alignment = Pos.CENTER
        isFillHeight = true
    }
    var dataN = TextField().apply{promptText = "Data set name"}
    var createButton = Button("Create").apply { prefWidth = 60.0 }

    var second = HBox(dataN,createButton).apply{
        alignment = Pos.CENTER
        isFillHeight = true
    }

    var line = Button("Line").apply { prefWidth = 75.0 }
    var bar = Button("Bar").apply { prefWidth = 75.0 }
    var barsem = Button("Bar (SEM)").apply { prefWidth = 75.0 }
    var pie = Button("Pie").apply { prefWidth = 75.0 }

    var third = HBox(line,bar,barsem,pie).apply{
        alignment = Pos.CENTER
        isFillHeight = true
    }

    var bool = false;
    var newName = ""
    override fun updateView() {
        println("View: updateView")
    }

    init {
        // setup the view (i.e. group+widget)
        HBox.setHgrow(spacer, Priority.ALWAYS)

        first.setSpacing(10.0)
        HBox.setMargin(createButton, Insets(0.0,10.0,0.0,0.0))
        HBox.setMargin(dataN, Insets(0.0,0.0,0.0,10.0))
        val second = HBox(dataN,createButton).apply{
            alignment = Pos.CENTER
            isFillHeight = true
        }
        HBox.setMargin(line, Insets(0.0,0.0,0.0,10.0))
        HBox.setMargin(bar, Insets(0.0,0.0,0.0,0.0))
        HBox.setMargin(barsem, Insets(0.0,0.0,0.0,0.0))
        HBox.setMargin(pie, Insets(0.0, 10.0, 0.0, 0.0))

        dataN.textProperty().addListener{ _, _, newValue ->
            bool = true;
            newName = newValue
            println(newValue)
        }

        var toolbar = ToolBar(
            first,
            Separator().apply { orientation = Orientation.VERTICAL },
            second,
            Separator().apply { orientation = Orientation.VERTICAL },
            third
        )
        choiceBox.selectionModel.selectedIndexProperty().addListener { _, _, newValue ->
           controller.switch(newValue as Int)
        }

        createButton.setOnAction(EventHandler<ActionEvent?> {
            controllercopy.addgraph(newName)
            list.add(newName)
            bool = true;
            newName = ""
            dataN.text = ""
            choiceBox.selectionModel.select(model.all)
            println(newName)
        })
        line.setOnAction(EventHandler<ActionEvent?> {
            controllercopy.changeGraph("line")
        })
        bar.setOnAction(EventHandler<ActionEvent?> {
            controllercopy.changeGraph("bar")
        })
        barsem.setOnAction(EventHandler<ActionEvent?> {
            controllercopy.changeGraph("barsem")
        })
        pie.setOnAction(EventHandler<ActionEvent?> {
            controllercopy.changeGraph("pie")
        })
        // add button widget to the pane
        children.add(toolbar)
        // register with the model when we're ready to start receiving data
        model.addView(this)
    }




    fun switch(){
        choiceBox.selectionModel.selectedIndexProperty().addListener { _, _, newValue ->
        var index = 0
            var a = newValue.toInt()
            controllercopy.switch(a)
        }
    }
}