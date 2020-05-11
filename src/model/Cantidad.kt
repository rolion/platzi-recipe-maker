package model

import utils.iPrint

class Cantidad(val valor:Float, val unidad:String):iPrint {
    override fun print() {
        print(" $valor $unidad")
    }
}