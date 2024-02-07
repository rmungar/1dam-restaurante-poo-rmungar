package src

class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        val mesa = mesas.find { it.numero == numeroMesa }
        mesa?.let {
            if (it.estado == "Ocupada"){
                it.agregarPedido(pedido)
            }
        }
    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        val mesa = mesas.find { it.numero == numeroMesa }
        mesa?.let {
            val pedido: Pedido?
            if (numeroPedido == null){
                pedido = it.pedidos.lastOrNull()
            }else{
                pedido = it.pedidos.find { p -> p.numeroPedido == numeroPedido }
            }
            pedido?.estado = "Servido"
        }
    }

    fun cerrarMesa(numeroMesa: Int) {
        val mesa = mesas.find { it.numero == numeroMesa }
        mesa?.let{
            if (it.pedidos.all { p -> p.estado == "Servido" }){
                mesa.liberarMesa()
            }
        }
    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}