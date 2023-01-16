
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
import javafx.scene.text.*
import javafx.stage.Stage
import java.util.*

class Main : Application() {
    override fun start(stage: Stage) {

        var totalNotes = 4
        var activeNotes = 4
        var TopCheckBox = CheckBox()
        var listV = VBox()
        var listT =  Vector<Text>()
        var listC =  Vector<CheckBox>();

        val text1 = Text("assemble, build, buildDependents, buildKotlinToolingMetadata, buildNeeded, classes, clean, jar, testClasses")
        val text2 = Text("I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349!")
        val text3 = Text(" qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm ")
        val text4 = Text("When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin ")

        listT.addAll(listOf(text1, text2, text3, text4))

        for(i in 1..listT.size){
            listT[i-1].wrappingWidthProperty().bind(stage.widthProperty().subtract(130.0))
            listC.add(CheckBox())
        }

        var TableView: ObservableList<TableViewController> = FXCollections.observableArrayList<TableViewController>()

        for(i in 1..listT.size){
            TableView.add(TableViewController(listT[i-1],listC[i-1]))
        }

        var statusBar = oneNote(totalNotes, activeNotes)
        val summary = BorderPane()
        for(item in TableView) {
            item.checkBox.selectedProperty().addListener() { _, _, newValue ->
                if (newValue == false) {
                    activeNotes = activeNotes + 1
                    statusBar = oneNote(totalNotes, activeNotes)
                    summary.bottom = statusBar
                    item.background = Background(
                        BackgroundFill(Color.LIGHTYELLOW, CornerRadii(10.0), Insets(5.0,10.0,5.0,10.0))
                    )
                } else {
                    activeNotes = activeNotes - 1
                    statusBar = oneNote(totalNotes, activeNotes)
                    item.background = Background(
                        BackgroundFill(Color.LIGHTGRAY, CornerRadii(10.0), Insets(5.0,10.0,5.0,10.0))
                    )
                    if (!TopCheckBox.isSelected) {
                        listV.children.remove(item)
                    }
                    summary.bottom = statusBar
                }
            }
        }
        TableView[2].checkBox.isSelected = true

        listV.children.setAll(TableView)
        listV.children.remove(TableView[2])

        val textInput = TextArea()
        HBox.setMargin(textInput, Insets(10.0,0.0,10.0,10.0))
        textInput.prefWidthProperty().bind(stage.widthProperty().subtract(115.0))
        textInput.prefHeight = 62.0
        val create = Button("Create")
        HBox.setMargin(create, Insets(20.0,10.0,10.0,10.0))
        create.isWrapText = true
        create.alignment = Pos.CENTER
        create.prefWidth = 75.0
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
                import javafx.scene.text.*
                import javafx.stage.Stage
                import java.util.*

        class Main : Application() {
            override fun start(stage: Stage) {

                var totalNotes = 4
                var activeNotes = 4
                var TopCheckBox = CheckBox()
                var listV = VBox()
                var listT =  Vector<Text>()
                var listC =  Vector<CheckBox>();

                val text1 = Text("assemble, build, buildDependents, buildKotlinToolingMetadata, buildNeeded, classes, clean, jar, testClasses")
                val text2 = Text("I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349! I love CS349!")
                val text3 = Text(" qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm qwertyuiopasdfghjklzxcvbnm ")
                val text4 = Text("When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin When an iOS developer try to understand Kotlin ")

                listT.addAll(listOf(text1, text2, text3, text4))

                for(i in 1..listT.size){
                    listT[i-1].wrappingWidthProperty().bind(stage.widthProperty().subtract(130.0))
                    listC.add(CheckBox())
                }

                var TableView: ObservableList<TableViewController> = FXCollections.observableArrayList<TableViewController>()

                for(i in 1..listT.size){
                    TableView.add(TableViewController(listT[i-1],listC[i-1]))
                }

                var statusBar = oneNote(totalNotes, activeNotes)
                val summary = BorderPane()
                for(item in TableView) {
                    item.checkBox.selectedProperty().addListener() { _, _, newValue ->
                        if (newValue == false) {
                            activeNotes = activeNotes + 1
                            statusBar = oneNote(totalNotes, activeNotes)
                            summary.bottom = statusBar
                            item.background = Background(
                                BackgroundFill(Color.LIGHTYELLOW, CornerRadii(10.0), Insets(5.0,10.0,5.0,10.0))
                            )
                        } else {
                            activeNotes = activeNotes - 1
                            statusBar = oneNote(totalNotes, activeNotes)
                            item.background = Background(
                                BackgroundFill(Color.LIGHTGRAY, CornerRadii(10.0), Insets(5.0,10.0,5.0,10.0))
                            )
                            if (!TopCheckBox.isSelected) {
                                listV.children.remove(item)
                            }
                            summary.bottom = statusBar
                        }
                    }
                }
                TableView[2].checkBox.isSelected = true

                listV.children.setAll(TableView)
                listV.children.remove(TableView[2])

                val textInput = TextArea()
                HBox.setMargin(textInput, Insets(10.0,0.0,10.0,10.0))
                textInput.prefWidthProperty().bind(stage.widthProperty().subtract(115.0))
                textInput.prefHeight = 62.0
                val create = Button("Create")
                HBox.setMargin(create, Insets(20.0,10.0,10.0,10.0))
                create.isWrapText = true
                create.alignment = Pos.CENTER
                create.prefWidth = 75.0
                create.prefHeight = 42.0
                val inputa = HBox(textInput,create).apply(){
                    background = Background(BackgroundFill(Color.LIGHTSALMON, CornerRadii(10.0),Insets(5.0)))
                    isFillHeight = true
                }
                //HBox.setHgrow(textInput, Priority.ALWAYS)
                //HBox.setHgrow(textInput, Priority.NEVER)

                listV.children.add(0,inputa)

                val choiceBox = ChoiceBox(observableArrayList("Length(asc)", "Length(desc)"))

                val view = Label("View:")
                HBox.setMargin(view, Insets(10.0,5.0,10.0,5.0))
                val list = Button("List").apply { prefWidth = 50.0 }
                HBox.setMargin(list, Insets(10.0,0.0,10.0,0.0))
                val grid = Button("Grid").apply { prefWidth = 50.0 }
                HBox.setMargin(grid, Insets(10.0,5.0,10.0,5.0))
                val showa = Label("Show archived:")
                HBox.setMargin(showa, Insets(10.0,5.0,10.0,5.0))
                val order = Label("Order by:")
                HBox.setMargin(order, Insets(10.0,5.0,10.0,0.0))
                val rSpace = Pane()
                HBox.setHgrow(rSpace, Priority.SOMETIMES)
                val clearButton = Button("Clear").apply { prefWidth = 50.0 }
                HBox.setMargin(clearButton, Insets(10.0,10.0,10.0,5.0))

                val toolbar = ToolBar(
                    view,list,grid, Separator().apply { orientation = Orientation.VERTICAL },showa,
                    TopCheckBox.apply { padding = Insets(10.0, 5.0, 10.0, 0.0) },
                    Separator().apply { orientation = Orientation.VERTICAL },order,
                    choiceBox.apply {
                        selectionModel.select(0)
                        prefWidth = 105.0 },rSpace,clearButton
                )

                var scrollPane = setScoll(listV)

                choiceBox.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
                    if (newValue == "Length(asc)") {
                        insertionSort(TableView)
                    }
                    else if (newValue == "Length(desc)"){
                        insertionSort(TableView)
                        TableView.reverse()
                    }
                    else {
                        println("catch exception, error in choicebox")
                    }
                    if (TopCheckBox.isSelected) {//show all
                        listV.children.setAll(TableView)
                        println("why include dskdjskdjskjdi")
                    } else {
                        listV.children.setAll(TableView.filter {//is selcted in false
                            it.checkBox.isSelected == false
                        })
                    }
                    scrollPane = setScoll(listV)
                }

                TopCheckBox.selectedProperty().addListener { _, _, newValue ->
                    if (newValue == true) {
                        listV.children.setAll(TableView)
                    } else {
                        listV.children.setAll(TableView.filter {
                            it.checkBox.isSelected == false
                        })
                    }
                }

                clearButton.setOnAction(EventHandler<ActionEvent?> {
                    if(totalNotes != 0){
                        var tmp = TableView.size
                        for(i in 1..tmp){
                            TableView.remove(TableView[tmp-i])
                        }
                        totalNotes = 0
                        activeNotes = 0
                        statusBar = oneNote(totalNotes, activeNotes)
                        listV.children.setAll(TableView)
                        summary.bottom = statusBar
                    }
                })

                scrollPane.padding = Insets(5.0,0.0,5.0,0.0)
                summary.top = toolbar
                summary.center = scrollPane
                summary.bottom = statusBar

                stage.title = "CS349 - A1 Notes - h338yang"
                stage.scene = Scene(summary, 800.0, 600.0)
                stage.minWidth = 640.0
                stage.minHeight = 480.0
                stage.show()
            }

            //}
            // -----------local helper function-----------
            fun insertionSort(TableView: ObservableList<TableViewController>){
                var len = TableView.size
                for (i in 1..len-1) {
                    var tmp = TableView[i]
                    var j = i - 1
                    while (j >= 0 && TableView[j].text.text.length > tmp.text.text.length) {
                        TableView[j + 1] = TableView[j]
                        j = j - 1
                    }
                    TableView[j + 1] = tmp
                }
            }

            fun setScoll(listV: VBox): ScrollPane{
                var temp = ScrollPane(listV).apply {
                    hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
                    vbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED
                }
                return temp
            }

            fun oneNote(totalNotes:Int, activeNotes:Int): Label {
                if(totalNotes == 1){
                    if(activeNotes == 1){
                        val statusBar1 = Label("$totalNotes notes, 1 of which is active").apply {
                            padding = Insets(10.0)
                        }
                        return statusBar1
                    }else {
                        val statusBar2 = Label(
                            "$totalNotes notes, $activeNotes of which are active"
                        ).apply {
                            padding = Insets(10.0)
                        }
                        return statusBar2
                    }
                }else {
                    if(activeNotes == 1){
                        val statusBar3 = Label("$totalNotes notes, 1 of which is active").apply {
                            padding = Insets(10.0)
                        }
                        return statusBar3
                    }else {
                        val statusBar4 = Label(
                            "$totalNotes notes, $activeNotes of which are active"
                        ).apply {
                            padding = Insets(10.0)
                        }
                        return statusBar4
                    }
                }
            }

        }


        create.prefHeight = 42.0
        val inputa = HBox(textInput,create).apply(){
            background = Background(BackgroundFill(Color.LIGHTSALMON, CornerRadii(10.0),Insets(5.0)))
            isFillHeight = true
        }
        //HBox.setHgrow(textInput, Priority.ALWAYS)
        //HBox.setHgrow(textInput, Priority.NEVER)

        listV.children.add(0,inputa)

        val choiceBox = ChoiceBox(observableArrayList("Length(asc)", "Length(desc)"))

        val view = Label("View:")
        HBox.setMargin(view, Insets(10.0,5.0,10.0,5.0))
        val list = Button("List").apply { prefWidth = 50.0 }
        HBox.setMargin(list, Insets(10.0,0.0,10.0,0.0))
        val grid = Button("Grid").apply { prefWidth = 50.0 }
        HBox.setMargin(grid, Insets(10.0,5.0,10.0,5.0))
        val showa = Label("Show archived:")
        HBox.setMargin(showa, Insets(10.0,5.0,10.0,5.0))
        val order = Label("Order by:")
        HBox.setMargin(order, Insets(10.0,5.0,10.0,0.0))
        val rSpace = Pane()
        HBox.setHgrow(rSpace, Priority.SOMETIMES)
        val clearButton = Button("Clear").apply { prefWidth = 50.0 }
        HBox.setMargin(clearButton, Insets(10.0,10.0,10.0,5.0))

        val toolbar = ToolBar(
            view,list,grid, Separator().apply { orientation = Orientation.VERTICAL },showa,
            TopCheckBox.apply { padding = Insets(10.0, 5.0, 10.0, 0.0) },
            Separator().apply { orientation = Orientation.VERTICAL },order,
            choiceBox.apply {
                selectionModel.select(0)
                prefWidth = 105.0 },rSpace,clearButton
        )

        var scrollPane = setScoll(listV)

        choiceBox.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            if (newValue == "Length(asc)") {
                insertionSort(TableView)
            }
            else if (newValue == "Length(desc)"){
                insertionSort(TableView)
                TableView.reverse()
            }
            else {
                println("catch exception, error in choicebox")
            }
            if (TopCheckBox.isSelected) {//show all
                listV.children.setAll(TableView)
                println("why include dskdjskdjskjdi")
            } else {
                listV.children.setAll(TableView.filter {//is selcted in false
                    it.checkBox.isSelected == false
                })
            }
            scrollPane = setScoll(listV)
        }

        TopCheckBox.selectedProperty().addListener { _, _, newValue ->
            if (newValue == true) {
                listV.children.setAll(TableView)
            } else {
                listV.children.setAll(TableView.filter {
                    it.checkBox.isSelected == false
                })
            }
        }

        clearButton.setOnAction(EventHandler<ActionEvent?> {
            if(totalNotes != 0){
                var tmp = TableView.size
                for(i in 1..tmp){
                    TableView.remove(TableView[tmp-i])
                }
                totalNotes = 0
                activeNotes = 0
                statusBar = oneNote(totalNotes, activeNotes)
                listV.children.setAll(TableView)
                summary.bottom = statusBar
            }
        })

        scrollPane.padding = Insets(5.0,0.0,5.0,0.0)
        summary.top = toolbar
        summary.center = scrollPane
        summary.bottom = statusBar

        stage.title = "CS349 - A1 Notes - h338yang"
        stage.scene = Scene(summary, 800.0, 600.0)
        stage.minWidth = 640.0
        stage.minHeight = 480.0
        stage.show()
        }

    //}
    // -----------local helper function-----------
    fun insertionSort(TableView: ObservableList<TableViewController>){
        var len = TableView.size
        for (i in 1..len-1) {
            var tmp = TableView[i]
            var j = i - 1
            while (j >= 0 && TableView[j].text.text.length > tmp.text.text.length) {
                TableView[j + 1] = TableView[j]
                j = j - 1
            }
            TableView[j + 1] = tmp
        }
    }

    fun setScoll(listV: VBox): ScrollPane{
        var temp = ScrollPane(listV).apply {
            hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
            vbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED
        }
        return temp
    }

    fun oneNote(totalNotes:Int, activeNotes:Int): Label {
        if(totalNotes == 1){
            if(activeNotes == 1){
                val statusBar1 = Label("$totalNotes notes, 1 of which is active").apply {
                    padding = Insets(10.0)
                }
                return statusBar1
            }else {
                val statusBar2 = Label(
                    "$totalNotes notes, $activeNotes of which are active"
                ).apply {
                    padding = Insets(10.0)
                }
                return statusBar2
            }
        }else {
            if(activeNotes == 1){
                val statusBar3 = Label("$totalNotes notes, 1 of which is active").apply {
                    padding = Insets(10.0)
                }
                return statusBar3
            }else {
                val statusBar4 = Label(
                    "$totalNotes notes, $activeNotes of which are active"
                ).apply {
                    padding = Insets(10.0)
                }
                return statusBar4
            }
        }
    }

}

