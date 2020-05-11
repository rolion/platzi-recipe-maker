package model

import utils.aCommonFields
import utils.iPrint

class Ingrediente(nombre:String, id:Int, val groupo:GrupoIngrediente): aCommonFields(nombre,id),iPrint{

    override fun print() {
        println("$id $nombre");
    }
}