package src

class Plato(nombre:String, precio:Double, tiempoPreparacion: Int, val ingredientes: List<String>) {
    init {
        require(nombre.isNotEmpty()) {"El nombre del plato no puede estar vacío"}
        require(precio > 0) {"El precio del plato no puede ser menor o igual a 0"}
        require(tiempoPreparacion > 1) {"El tiempo de preparacion no puede ser menor o igual a 1"}
        require(ingredientes.isNotEmpty()) {"Ingredientes no puede estar vacío"}
    }
    var nombre:String = nombre.replaceFirstChar { it -> it.uppercase() }
        set(value) {
            require(nombre.isNotEmpty()) {"El nombre del plato no puede estar vacío"}
            field = value
        }
    var precio = precio
        set(value) {
            require(precio > 0) {"El precio del plato no puede ser menor o igual a 0"}
            field = value
        }
    var tiempoPreparacion = tiempoPreparacion
        set(value) {
            require(tiempoPreparacion > 1) {"El tiempo de preparacion no puede ser menor o igual a 1"}
            field = value
        }

    fun agregarIngredientes(ingrediente:String){
        if (ingrediente.isNotEmpty()) ingredientes.addLast(ingrediente.lowercase())
        else {
            println("El ingrediente no puede estar vacio")
        }
    }

    override fun toString(): String {
        return "$nombre ($tiempoPreparacion) -> ${precio}€ ($ingredientes)"
    }
}