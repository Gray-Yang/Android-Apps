import javafx.collections.FXCollections.fill
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority.min
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.ArcType
import javafx.scene.shape.Polyline
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


class graphsView(private val model: Model, controller: Controller) : VBox(), IView {

    val canvas = Canvas(640.0*0.7,480.0)

    // When notified by the model that things have changed,
    // update to display the new value
    var abbb = canvas.width
    var controllercopy = controller
    var length = model.dataSets[model.current].data.size
    var eachWidth = abbb/(length)


    fun line(){
        var i = 0
        abbb = canvas.width
        if(model.dataSets[model.current].data.size == 1){
            canvas.graphicsContext2D.apply {
                fill = Color.WHITE
                fillRect(0.0,0.0,canvas.width,canvas.height)
                fill = Color.RED
                fillOval(canvas.width/2, canvas.height-5.0,3.0,3.0)
            }
            return
        }
        length = model.dataSets[model.current].data.size
        eachWidth = abbb/(length)

        canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)

        canvas.graphicsContext2D.apply {
            fill = Color.WHITE
            fillRect(0.0,0.0,canvas.width,canvas.height)
            fill = Color.RED
            fillOval(6.0, (-1*model.dataSets[model.current].data[0]+canvas.height/2),3.0,3.0)
        }

        var prex = 6.0
        var prey = model.dataSets[model.current].data[0]
        for( i in 1..length-1){
            canvas.graphicsContext2D.apply {
                fill = Color.BLACK
                strokeLine(prex,-1*prey+canvas.height/2,prex+eachWidth, -1*model.dataSets[model.current].data[i]+canvas.height/2)

                fill = Color.RED
                fillOval(prex+eachWidth, -1*model.dataSets[model.current].data[i]+canvas.height/2,3.0,3.0)
                prex = prex+eachWidth
                prey = model.dataSets[model.current].data[i]
            }
        }
    }

    fun bar(){
        abbb = canvas.width
        var h = canvas.height

        var minc = model.dataSets[model.current].data[0]
        var maxc = model.dataSets[model.current].data[0]
        for(i in 1..model.dataSets[model.current].data.size-1){
            minc = min(minc,model.dataSets[model.current].data[i])
            maxc = max(maxc,model.dataSets[model.current].data[i])
        }

        var range = maxc - minc
        canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)

        var currentcolor = 0.0;
        var startx = 10.0
        var scale = 0.0
        if(maxc != minc){
            scale = (h -10.0)/range
        }

        var starty = canvas.height/2 + (  (maxc+minc)*scale)/2
        var xrange = (canvas.width-20.0)/((model.dataSets[model.current].data.size-1)*2+1)

        canvas.graphicsContext2D.apply {
            strokeLine(10.0, starty,canvas.width-10.0,starty)
        }

        var eachcolor = 360.0/ model.dataSets[model.current].data.size

        for (i in model.dataSets[model.current].data) {

            canvas.graphicsContext2D.apply {
                fill = Color.hsb(currentcolor, 1.0, 1.0,1.0)
                fillRect(startx, if(i>=0.0)(starty - i*scale) else starty, xrange, abs(i*scale))
            }
            currentcolor += eachcolor
            startx = startx + 2 * xrange
        }
    }

    fun barsem(){
        abbb = canvas.width
        var h = canvas.height

        var minc = model.dataSets[model.current].data[0]
        var maxc = model.dataSets[model.current].data[0]
        for(i in 1..model.dataSets[model.current].data.size-1){
            minc = min(minc,model.dataSets[model.current].data[i])
            maxc = max(maxc,model.dataSets[model.current].data[i])
        }

        var range = maxc - minc
        canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)

        var currentcolor = 0.0;
        var startx = 10.0
        var scale = 0.0
        if(maxc != minc){
            scale = (h -10.0)/range
        }

        var starty = canvas.height
        var xrange = (canvas.width-20.0)/((model.dataSets[model.current].data.size-1)*2+1)

        canvas.graphicsContext2D.apply {//x-axis
            strokeLine(10.0, starty,canvas.width-10.0,starty)
        }

        var sumValue = 0.0
        for(i in 1..model.dataSets[model.current].data.size){
            sumValue += model.dataSets[model.current].data[i-1]
        }
        var mean = sumValue/model.dataSets[model.current].data.size
        var mean1 = canvas.height-mean*scale
        canvas.graphicsContext2D.apply {//mean
            strokeLine(10.0, mean1,canvas.width-10.0,mean1)
            save()
        }
        var temp = 0.0
        for(i in 1..model.dataSets[model.current].data.size){
            temp += (model.dataSets[model.current].data[i-1]-mean)*(model.dataSets[model.current].data[i-1]-mean)
        }

        temp = sqrt(temp/(model.dataSets[model.current].data.size))
        var sem = temp/sqrt(model.dataSets[model.current].data.size.toDouble())
        canvas.graphicsContext2D.apply {//top left text
            strokeText("mean: ${mean}",10.0,20.0,200.0)
            strokeText("sem: ${sem}",10.0,40.0,200.0)
            save()

        }
        canvas.graphicsContext2D.apply {//top left text
            setLineDashes(5.0)
            strokeLine(10.0, canvas.height-(mean+sem)*scale,canvas.width-10.0,canvas.height-(mean+sem)*scale)
            strokeLine(10.0, canvas.height-(mean-sem)*scale,canvas.width-10.0,canvas.height-(mean-sem)*scale)
            restore()
        }

        var eachcolor = 360.0/ model.dataSets[model.current].data.size

        for (i in model.dataSets[model.current].data) {

            canvas.graphicsContext2D.apply {
                fill = Color.hsb(currentcolor, 1.0, 1.0,1.0)
                fillRect(startx, if(i>=0.0)(starty - i*scale) else starty, xrange, abs(i*scale))
            }
            currentcolor += eachcolor
            startx = startx + 2 * xrange
        }

    }

    fun pie(){
        var i = 0
        var wid = canvas.width
        var hei = canvas.height
        canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)
        var Start = 0.0;
        var x = 15.0
        var y = 15.0


        var currentcolor = 0.0;

        var sumVal = 0.0
        for (i in model.dataSets[model.current].data) {
            sumVal += i
        }

        var eachcolor = 360.0/ model.dataSets[model.current].data.size
        var scale = 360.0 / sumVal

        for (i in model.dataSets[model.current].data) {
            canvas.graphicsContext2D.apply {
                fill = Color.hsb(currentcolor, 1.0, 1.0,1.0)
                fillArc(x, y, 400.0, 400.0, Start, i*scale, ArcType.ROUND)
            }
            currentcolor += eachcolor
            Start += (scale * i)
        }
        var neg = false
        for(i in 1..model.dataSets[model.current].data.size){
            if(model.dataSets[model.current].data[i-1] < 0.0){
                neg = true
                break
            }
        }
        if(neg) {
            canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)
        }

    }

    override fun updateView() {
        var currentGraph = model.currentgraph;
        var neg = false
        for(i in 1..model.dataSets[model.current].data.size){
            if(model.dataSets[model.current].data[i-1] < 0.0){
                neg = true
                break
            }
        }

        if(currentGraph == "line"){
            line()
        } else if(currentGraph == "bar"){
            bar()
        } else if(currentGraph == "barsem"){
            if(!neg) {
                barsem()
            }else {
                canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)
            }
        }  else if(currentGraph == "pie"){
            if(!neg) {
                pie()
            }else {
                canvas.graphicsContext2D.clearRect(0.0,0.0,canvas.width,canvas.height)
            }
        }
    }

    init {


        children.add(canvas)

        // register with the model when we're ready to start receiving data
        model.addView(this)
    }
}