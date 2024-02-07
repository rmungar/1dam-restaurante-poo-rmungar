package src

class Plato(nombre:String, precio:Double, tiempoPreparacion: Int, val ingredientes: MutableList<String>) {
    init {
        require(nombre.isNotEmpty()) {"El nombre del plato no puede estar vacío"}
        require(precio > 0) {"El precio del plato no puede ser menor o igual a 0"}
        require(tiempoPreparacion > 1) {"El tiempo de preparacion no puede ser menor o igual a 1"}
        require(ingredientes.isNotEmpty()) {"Ingredientes no puede estar vacío"}
    }
    var nombre:String = nombre.replaceFirstChar { it -> it.uppercase() }
        set(value) {
            require(value.isNotEmpty()) {"El nombre del plato no puede estar vacío"}
            field = value
        }
    var precio = precio
        set(value) {
            require(value > 0) {"El precio del plato no puede ser menor o igual a 0"}
            field = value
        }
    var tiempoPreparacion = tiempoPreparacion
        set(value) {
            require(value > 1) {"El tiempo de preparacion no puede ser menor o igual a 1"}
            field = value
        }

    fun agregarIngrediente(ingrediente:String){
        if (ingrediente.isNotBlank()) ingredientes.add(ingrediente.lowercase())
        else {
            println("No se añadió el cliente")
        }
    }

    override fun toString(): String {

        return "$nombre ($tiempoPreparacion) -> ${precio}€ (${
            if (ingredientes.size > 1) {
                ingredientes.dropLast(1).joinToString { ", " } + " y " + ingredientes.last()
            } else {
                ingredientes.joinToString(", ")
            }
        })"
    }
}

