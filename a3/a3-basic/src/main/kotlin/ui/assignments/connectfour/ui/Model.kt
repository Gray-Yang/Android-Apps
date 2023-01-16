package ui.assignments.connectfour.ui
import ui.assignments.connectfour.model.Array2D
import ui.assignments.connectfour.model.Grid
import ui.assignments.connectfour.model.Model
import java.util.*


class Modelc {

    //region View Management

    // all views of this model
    private val views: ArrayList<IView> = ArrayList()

    // method that the views can use to register themselves with the Model
    // once added, they are told to update and get state from the Model
    fun addView(view: IView) {
        views.add(view)
        //view.updateView()
    }

    fun removeView(view: IView?) {
        // remove view here
    }

    // the model uses this method to notify all of the Views that the data has changed
    // the expectation is that the Views will refresh themselves to display new data when appropriate
    private fun notifyObservers() {
        for (view in views) {
            //println("Model: notify View")
            view.updateView()
        }
    }

    private fun notifystart() {
        views[0].updateView()
        views[1].updateView()
    }
    //endregion

    // simple accessor method to fetch the current state
    // of the data in the model, just a counter

    var modelo = Model

    fun start(){
        notifystart()
    }

    fun next(){
        notifyObservers()
        //notifystart()
    }

    // method that the Controller uses to tell the Model to change state
    // in a larger application there would probably be multiple entry points like this

}