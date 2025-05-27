import java.util.Scanner

open class Library {
    val libraryContent:MutableMap<Int,Archive> = HashMap()

    fun askName(type:String):String {
        val scanner2 = Scanner(System.`in`)
        var name:String=""
        while (true) {
            println("Введите имя $type:")
            name=scanner2.nextLine()
            if (name=="") {
                println("Имя $type не может быть пустым.")
            } else break
        }
        return name
    }

    fun addArchive(){
        val name:String=askName("архива")
        var freshScript=Archive(name)
        libraryContent[libraryContent.keys.size]=freshScript
    }

    fun open(content:MutableMap<Int,Archive>):MutableMap<Int, String> {
        clearScreen()
        println("Выберите номер для просмотра архива или выберите \"выход\"")
        val contentList:MutableMap<Int, String> = HashMap()
        if (content.keys.size>0) content.forEach { (key, value) -> contentList.put(key, value.archiveName) }
        else println("Здесь ещё нет архивов.")
        return contentList
    }

}