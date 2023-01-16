import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.text.Text

class CreateController internal constructor(txt:Text): HBox() {
    var text = Text("");
    var create = Button("Create")

    init {
        text = txt;
        children.addAll(text, create)
        padding = Insets(20.0)
        spacing = 10.0
        background = Background(
            BackgroundFill(Color.LIGHTYELLOW, CornerRadii(10.0), Insets(5.0,10.0,5.0,10.0))
        )
    }

}