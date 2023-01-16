import javafx.geometry.Insets
import javafx.scene.control.CheckBox
import javafx.scene.control.Label
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.text.Text

class TableViewController internal constructor(txt:Text, checkbox:CheckBox): HBox() {
    var text = Text("");
    var checkBox = CheckBox()

    init {
        text = txt;
        checkBox = checkbox;
        children.addAll(text, Label("Archived"), checkBox)
        padding = Insets(20.0)
        spacing = 10.0
        background = Background(
            BackgroundFill(Color.LIGHTYELLOW, CornerRadii(10.0), Insets(5.0,10.0,5.0,10.0))
        )
    }

}