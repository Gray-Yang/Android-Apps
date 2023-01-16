import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import java.util.*


class datasetView(val model: Model, controller: Controller) : VBox(), IView {

    var dataset: ObservableList<TableViewController> = FXCollections.observableArrayList<TableViewController>()
    var listV = VBox()
    var controllercopy = controller
    var addentry = Button("Add Entry").apply { prefWidth = 350.0}
    var dataset_name = Label("Dataset name: quadratic").apply { prefWidth = 200.0 }
    var bool = true;
    var scrollPane = setScoll(listV)

    override fun updateView() {
        println("datasetView: updateView")
        dataset.remove(0,dataset.size)
        listV.children.clear()
        for(i in 1..model.dataSets[model.current].data.size){
            //var temp = String.format("%lf",model.dataSets[0].data[i-1])
            var temp = StringBuilder().append(model.dataSets[model.current].data[i-1]).toString()
            var tmp = TextField(temp);
            dataset.add(TableViewController(model, controllercopy,model.dataSets[model.current].name,i-1, tmp))
        }
        listV.children.setAll(dataset)
        var name = "Dataset name: "+model.dataSets[model.current].name;
        var dataset_name = Label(name)
        listV.children.add(0,dataset_name)
        listV.children.add(addentry)
    }


    init {
        // setup the view (i.e. group+widget)
        if(bool){
            controller.start()
            bool = false;
        }

        model.dataSets[0].data.add(1.0)
        model.dataSets[0].data.add(2.0)
        model.dataSets[0].data.add(3.0)
        model.dataSets[0].data.add(4.0)
        model.dataSets[0].name = "quadratic"

        for(i in 1..model.dataSets[0].data.size){
            var temp = StringBuilder().append(model.dataSets[0].data[i-1]).toString()
            var tmp = TextField(temp);
            dataset.add(TableViewController(model, controllercopy,"quadratic",i-1, tmp))
        }
        listV.children.setAll(dataset)
        listV.children.add(0,dataset_name)
        listV.children.add(addentry)
        //listV.alignment = Pos.CENTER
        var scrollPane = setScoll(listV)

        addentry.addEventHandler(MouseEvent.MOUSE_CLICKED) {
            controller.addentry()
        }
        // add button widget to the pane
        children.add(scrollPane)
        // register with the model when we're ready to start receiving data
        model.addView(this)
    }

    fun setScoll(listV: VBox): ScrollPane{
        var temp = ScrollPane(listV).apply {
            hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
            vbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED
        }
        return temp
    }
}

class TableViewController internal constructor(model: Model, controller: Controller, namep:String, entrynum: Int, txt: TextField): HBox() {
    var entry = "Entry #$entrynum"
    var name = ""
    var text = TextField();
    var cancel = Button("X")
    var en = Label(entry)

    init {
        text.minWidth = 200.0
        text.minHeight = 10.0
        text = txt
        name = namep;
        var hbox = HBox(en, text,cancel).apply{
            alignment = Pos.CENTER
            isFillHeight = true
            spacing = 10.0
        }
        text.textProperty().addListener{ _, _, newValue ->

            if(!newValue.matches(Regex("(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$"))){

            }

            else{
                controller.add(newValue.toDouble(),entrynum)
            }
        }

        children.addAll(hbox)
        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED) {
            if(model.dataSets[model.current].data.size > 1) {
                controller.deleteentry(entrynum)
            }
        }
        padding = Insets(5.0)
        spacing = 10.0
    }
}