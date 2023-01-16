import java.util.*


class Model {

    //region View Management

    // all views of this model
    private val views: ArrayList<IView> = ArrayList()

    // method that the views can use to register themselves with the Model
    // once added, they are told to update and get state from the Model
    fun addView(view: IView) {
        views.add(view)
        view.updateView()
    }

    fun removeView(view: IView?) {
        // remove view here
    }

    // the model uses this method to notify all of the Views that the data has changed
    // the expectation is that the Views will refresh themselves to display new data when appropriate
    private fun notifyObservers() {
        for (view in views) {
            println("Model: notify View")
            view.updateView()
        }
    }

    private fun notifyObservergraph() {
        views[2].updateView()
        //
    }

    //endregion

    // simple accessor method to fetch the current state
    // of the data in the model, just a counter
    var current = 0
    var all= 0
    var currentName = "quadratic"
    var currentgraph = "line"
    var dataSets = ArrayList<Sets>()

    fun start(){
        var numb = ArrayList(Arrays.asList(0.0))
        var tenp = (Sets("quadratic",numb))
        dataSets.add(tenp)
        notifyObservers()
    }

    // method that the Controller uses to tell the Model to change state
    // in a larger application there would probably be multiple entry points like this

    fun switchgraph(c: Int){
        current = c
        currentName = dataSets[c].name
        notifyObservers()
    }

    fun changeGraph(graphName: String){
        currentgraph = graphName
        notifyObservergraph()
    }

    fun addgraph(graphName: String) {
        var numb = ArrayList(Arrays.asList(0.0))
        var dataset = Sets(graphName,numb)
        dataSets.add(dataset)
        all++
        current = all
        currentName = graphName
        notifyObservers()//current dataset update
    }

    fun addenty() {
        dataSets[current].data.add(0.0)
        notifyObservers()
    }

    fun deleteenty(abc: Int) {
        dataSets[current].data.removeAt(abc)
        notifyObservers()
    }

    fun update(index:Int, new: Double){
        dataSets[current].data[index] = new
        notifyObservergraph()
    }
}

class Sets(graphName : String, datasets: ArrayList<Double>){
    var name = graphName;
    var data = datasets;
}