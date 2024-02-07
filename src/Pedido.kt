package src

class Pedido(val platos:List<Plato>, var estado: String = "Pendiente") {
    companion object{
        var numero = 0
        fun generarNumero(): Int{
            numero++
            return numero
        }
    }
}