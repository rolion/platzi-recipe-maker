package model

import utils.iPrint

class RecetaIngrediente(val receta: Receta, val ingrediente: Ingrediente, val cantidad:Cantidad):iPrint {
    override fun print() {
        print("${ingrediente.nombre} ${cantidad.print()}")
    }

}