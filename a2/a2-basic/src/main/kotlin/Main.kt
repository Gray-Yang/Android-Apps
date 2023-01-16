
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.stage.Stage
import javafx.scene.layout.Region
import java.util.*
/*

class Main : Application() {
    override fun start(stage: Stage) {

        var listV = VBox()
        var listT = Vector<TextArea>()

        val text1 = TextArea("1.0")
        val text2 = TextArea("2.0")
        val text3 = TextArea("3.0")
        val text4 = TextArea("4.0")

        listT.addAll(listOf(text1, text2, text3, text4))

        var TableView: ObservableList<TableViewController> = FXCollections.observableArrayList<TableViewController>()

        for(i in 1..listT.size){
            TableView.add(TableViewController(listT[i-1]))
        }


        val summary = BorderPane()
        listV.children.setAll(TableView)


        val choiceBox = ChoiceBox(observableArrayList("quadratic", "negative quadratic","alternating","random","inflation 90-22"))

        choiceBox.apply {
            selectionModel.select(0)
            prefWidth = 150.0
        }
        val spacer = Region()
        HBox.setHgrow(spacer, Priority.ALWAYS)
        val first = HBox(choiceBox, spacer).apply{
            alignment = Pos.CENTER
            isFillHeight = true
        }
        first.setSpacing(10.0)
        val createButton = Button("Create").apply { prefWidth = 60.0 }
        HBox.setMargin(createButton, Insets(0.0,10.0,0.0,0.0))
        val dataN = TextArea()
        dataN.setPrefSize(150.0,1.0)
        HBox.setMargin(dataN, Insets(0.0,0.0,0.0,10.0))


        val second = HBox(dataN,createButton).apply{
            alignment = Pos.CENTER
            isFillHeight = true
        }

        val line = Button("Line").apply { prefWidth = 75.0 }
        HBox.setMargin(line, Insets(0.0,0.0,0.0,10.0))
        val bar = Button("Bar").apply { prefWidth = 75.0 }
        HBox.setMargin(bar, Insets(0.0,0.0,0.0,0.0))
        val barsem = Button("Bar (SEM)").apply { prefWidth = 75.0 }
        HBox.setMargin(barsem, Insets(0.0,0.0,0.0,0.0))
        val pie = Button("Pie").apply { prefWidth = 75.0 }
        HBox.setMargin(pie, Insets(0.0,10.0,0.0,0.0))

        val third = HBox(line,bar,barsem,pie).apply{
            alignment = Pos.CENTER
            isFillHeight = true
        }

        val toolbar = ToolBar(
            first,
            Separator().apply { orientation = Orientation.VERTICAL },
            second,
            Separator().apply { orientation = Orientation.VERTICAL },
            third
        )



        var scrollPane = setScoll(listV)



        createButton.setOnAction(EventHandler<ActionEvent?> {
        })

        scrollPane.padding = Insets(5.0,0.0,5.0,0.0)
        summary.top = toolbar
        summary.center = scrollPane

        stage.title = "CS349 - A2 Graphs - h338yang"
        stage.scene = Scene(summary, 640.0, 480.0)
        stage.minWidth = 800.0
        stage.minHeight = 600.0
        stage.show()
        }

    //}
    // -----------local helper function-----------
    fun setScoll(listV: VBox): ScrollPane{
        var temp = ScrollPane(listV).apply {
            hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
            vbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED
        }
        return temp
    }



}
*/
