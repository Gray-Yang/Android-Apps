class Controller(var model: Model) {

    fun start() {
        model.start()
    }

    fun addentry(){
        model.addenty()
        println("add new entry for the current view")
    }

    fun deleteentry(abc: Int){
        model.deleteenty(abc)
        println("delete the entry for the current view")
    }

    fun switch(def:Int){
        model.switchgraph(def)
        println("delete the entry for the current view")
    }

    fun changeGraph(graphName: String){
        model.changeGraph(graphName)
    }

    fun addgraph(graphName: String) {
        model.addgraph(graphName)
        println("delete the entry for the current view")
    }

    fun add(new: Double, index:Int){
        model.update(index, new)
    }
}
