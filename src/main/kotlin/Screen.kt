import java.util.Scanner

class Screen(private val screenName:String, private val screenMenu: MutableMap<Int, String>?) {
    var newScreen=screenMenu

    fun isStringInt(str: String): Boolean {
        return try {
            str.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun userInput():Int {
        val scanner = Scanner(System.`in`)
        var input:String = ""
        var choice:Int=-1
        while(true) {
            if (newScreen?.get((newScreen!!.keys.size-1))!="Выход"){
                screenMenu?.keys?.let { newScreen!!.put(it.size, "Выход") }
            }
            showMenu(newScreen)
            println("Выберите номер операции:")
            input = scanner.nextLine()
            if (isStringInt(input)) {
                choice=input.toInt()
                if (newScreen?.containsKey(choice) == true) break
                else println("Такого пункта нет. Попробуйте ввести номер пункта ещё раз.")
                } else println("Введеный символ не является числом. Попробуйте ввести номер пункта ещё раз.")
            }
        return choice
    }

    private fun showMenu(screen: MutableMap<Int, String>?) {
            println("$screenName:")
            screen?.forEach { (key, value) -> println("$key. $value") }
    }
}
