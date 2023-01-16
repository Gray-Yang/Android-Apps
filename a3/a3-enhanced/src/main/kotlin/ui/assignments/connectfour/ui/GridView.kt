package ui.assignments.connectfour.ui

import javafx.scene.layout.VBox
import javafx.scene.image.ImageView

class GridView(val model: Modelc, controller: Controller) : VBox(), IView {

    var gridNode = ImageView(javaClass.getResource("/ui/assignments/connectfour/grid_8x7.png").toString())

    override fun updateView() {
        children.clear()
        children.add(gridNode)
    }

    init{
        children.add(gridNode)
        model.addView(this)
    }
}