import model.GrupoIngrediente
import model.Ingrediente

fun main() {
    var misRecetas= arrayOf("Sopa de maní", "Majadito", "Picante de pollo")
    val listGrupo: List<GrupoIngrediente> = createGroupIngredientes()
    val listaIngredientes : List<Ingrediente> = createIngredients(listGrupo)
        do {
            val menu = """
            seleccione una opcion:
            (1) Hacer una receta
            (2) Ver mis recetas
            (3) Salir
        """.trimIndent()
            println(menu)
            var response:String? = readLine()
            var option:Int = response?.toIntOrNull()?:0
            when(option){
                1->{
                    println("okey vamos a crear una receta");
                    makeRecipe(listGrupo,listaIngredientes)
                }
                2->{
                    println("tus recetas son:")
                    misRecetas.forEach { println("-$it") }
                }
                3->{
                    println("bye, bye!");
                }
                else -> {
                    println("debe elegir una opcion entre 1 y 3");
                }
            }
        }while (!option.equals(3))
}

fun createIngredients(listaGrupo: List<GrupoIngrediente>):List<Ingrediente>{
    var listaIngredientes:MutableList<Ingrediente> = mutableListOf()
    listaGrupo.forEach {
        when(it.id){
            1->{
                //Agregamos la lista de vegetales
                listaIngredientes.add(Ingrediente("Pimentón",1,it))
                listaIngredientes.add(Ingrediente("Cebolla",2,it))
                listaIngredientes.add(Ingrediente("Espárrago",3,it))
                listaIngredientes.add(Ingrediente("Rúcula",4,it))
            }
            2->{
                //Agregamos la lista de carnes
                listaIngredientes.add(Ingrediente("Cuadril",1,it))
                listaIngredientes.add(Ingrediente("filé mignon",2,it))
                listaIngredientes.add(Ingrediente("Culata de contra",3,it))
                listaIngredientes.add(Ingrediente("Pechuga de pollo",4,it))
            }
            3->{
                //Agregamos la lista de lacteos
                listaIngredientes.add(Ingrediente("Leche entera",1,it))
                listaIngredientes.add(Ingrediente("Leche desnatada",2,it))
                listaIngredientes.add(Ingrediente("Leche de soja",3,it))
                listaIngredientes.add(Ingrediente("Leche de almendras",4,it))
            }
            4->{
                //Agregamos la lista de fruta
                listaIngredientes.add(Ingrediente("Manzana",1,it))
                listaIngredientes.add(Ingrediente("Pera",2,it))
                listaIngredientes.add(Ingrediente("Uva",3,it))
                listaIngredientes.add(Ingrediente("Papaya",4,it))
            }
        }
    }
    return listaIngredientes
}
fun createGroupIngredientes():List<GrupoIngrediente>{
    //devuelve un array de groupos
    return listOf<GrupoIngrediente>(
                GrupoIngrediente("Vegetales",1),
                GrupoIngrediente("Carnes",2),
                GrupoIngrediente("Lacteos",3),
                GrupoIngrediente("Fruta",4)
                )
}

fun makeRecipe(grupos:List<GrupoIngrediente>, ingredientes: List<Ingrediente>){
    //makeRecipe() -> Deberá mostrar el siguiente menú de opciones: lista categorias

    do {
        println("Seleccione una categoria")
        grupos.forEach {
            println("${it.id} ${it.nombre}")
        }
        println("${grupos.size+1} volver atras")
        var response:String? = readLine()
        var option:Int = response?.toIntOrNull()?:0

        when(option){
            1->{
              seleccionarIngrediente(ingredientes.filter { it.groupo.id==1 })

            }
            2->{
                seleccionarIngrediente(ingredientes.filter { it.groupo.id==2 })
            }
            3->{
                seleccionarIngrediente(ingredientes.filter { it.groupo.id==3 })
            }
            4->{
                seleccionarIngrediente(ingredientes.filter { it.groupo.id==4 })
            }
        }
    }while(option!=grupos.size+1)
}
fun seleccionarIngrediente(ingredientes:List<Ingrediente>){
    ingrediente@do{
        println("seleccione el ingrediente")

        ingredientes.forEach { it.print() }
        println("${ingredientes.size+1} volver atras")
        var responseIngrediente:String? = readLine()
        var optionIngrediente:Int = responseIngrediente?.toIntOrNull()?:0

        if(optionIngrediente!=0){
            do{
                println("Ingrese la cantidad")
                var cantidad:String? = readLine()
                var cantidadIngrediente:Int = cantidad?.toIntOrNull()?:0
                if(cantidadIngrediente!=0){
                    ingredientes[optionIngrediente-1].print()
                    println("cantidad= $cantidadIngrediente")
                    break@ingrediente
                }
            }while(cantidadIngrediente!=0)

        }
    }while(ingredientes.size+1!=optionIngrediente)
}
fun viewRecipe(){
    // Mostrará el título de la categoría ingresada, así: Ver mis recetas
}