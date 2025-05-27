import java.util.Scanner

class Archive (val archiveName:String) {

    private var keyNumber:Int=0
    val archiveContent:MutableMap<Int,Note> = HashMap()

    fun askName(type:String):String {
        val scanner1 = Scanner(System.`in`)
        var name=""
        while (true) {
            println("Введите имя $type:")
            name=scanner1.nextLine()
            if (name=="") {
                println("Имя $type не может быть пустым.")
            } else break
        }
        return name
    }

    fun addNote(){
        val name:String=askName("заметки")
        val freshScript=Note(name)
        while (true) {
            freshScript.createNote()
            if (freshScript.manuScript.length > 0) {
                archiveContent[archiveContent.keys.size] = freshScript
                break
            } else println("В заметку надо бы что-нибудь записать!")
        }
    }

    fun open(content: MutableMap<Int, Note>):MutableMap<Int, String> {
        clearScreen()
        println("Архив: $archiveName")
        println("Введите номер для просмотра содержимого или выберите \"выход\"")
        val archiveScreen:MutableMap<Int, String> = HashMap()
        if (content.keys.size !=0) content.forEach { (key, value) -> archiveScreen.put(key, value.noteName) }
        else println("В архиве ещё нет ни одной заметки")
        return archiveScreen
    }
}