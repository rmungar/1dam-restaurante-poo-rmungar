package src

class Mesa(var numero: Int, var capacidad:Int)  {
    var estado:String = "Libre"
    var pedidos= mutableListOf<Pedido>()

    init {
        require(numero > 0) {"El número de mesa no puede estar vacío"}
        require(capacidad in 1..6) {"La capacidad de la mesa no está dentro del límite"}
    }

    fun ocuparMesa(){
        if (estado == "Libre") estado = "Ocupada"
        else{
            println("La mesa no se pudo ocupar")
        }
    }
    fun ocuparReserva(){
        if (estado == "Reservado") estado = "Ocupada"
        else{
            println("La mesa no se pudo ocupar")
        }
    }
    fun liberarMesa(){
        estado = "Libre"
    }

    fun agregarPedido(pedido: Pedido){
        pedidos.add(pedido)
    }

    override fun toString(): String {
        return "Mesa $numero: $estado\n" + pedidos.joinToString(", ")
    }
}