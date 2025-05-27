import java.util.Scanner

class Note (val noteName:String) {

    var manuScript:String = ""

    fun createNote() {
        val scanner3 = Scanner(System.`in`)
        var input:String = ""
        println("Введите текст заметки и нажмите Enter.")
        manuScript=scanner3.nextLine()
    }

    fun printNote() {
            println("Заметка \"$noteName\"")
            println(manuScript)
            println("Нажмите любую клавишу и Enter для выхода")
            val scanner4 = Scanner(System.`in`)
            var anyKey=scanner4.nextLine()
    }
}
