package src

class Pedido(val platos:MutableList<Plato>, var estado: String = "Pendiente") {
    companion object{
        var numero = 0
        fun generarNumero(): Int{
            numero++
            return numero
        }
    }
    var numeroPedido = generarNumero()
    fun agregarPlato(plato: Plato){
        platos.add(plato)
    }
    fun eliminarPlato(plato: Plato){
        if (platos.contains(plato)) platos.remove(plato)
        else{
            println("Ese plato ($plato) no se corresponde con este pedido ($platos)")
        }
    }
    fun calcularPrecio(): Double{
        var precio = 0.0
        for (plato in platos) precio += plato.precio
        return precio
    }
    fun calcularTiempo(): Int{
        var tiempoTotal = 0
        for (plato in platos) tiempoTotal += plato.tiempoPreparacion
        return tiempoTotal
    }

    override fun toString(): String {
        return "Pedido - $numeroPedido ; Estado : $estado"
    }
}