import java.util.Scanner

fun clearScreen(){
    print("\u001b[2J") // Clear the entire screen
    print("\u001b[0;0H") // Move the cursor to the top left corner
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val chooseArchive=Screen("Список архивов", mutableMapOf(0 to "Создать архив", 1 to "Это мой уже созданный архив"))
    val chooseNote=Screen("Список заметок", mutableMapOf(0 to "Создать заметку", 1 to "Это моя уже созданная заметка"))
    val currentLibrary=Library()
    println("Вас приветствует программа \"Заметки\"!")
    while(true){
        var a=chooseArchive.userInput()
        when (a) {
            0->currentLibrary.addArchive()
            1->{
                while (true) {
                    clearScreen()
                    var screenArchives=currentLibrary.open((currentLibrary.libraryContent))
                    var b=Screen("Перечень архивов", screenArchives).userInput()
                    var size = currentLibrary.libraryContent.keys.size
                    when (b) {
                        in 0..(size-1) -> {
                            while (true){
                                clearScreen()
                                var c=chooseNote.userInput()
                                when (c) {
                                    0->currentLibrary.libraryContent[b]?.addNote()
                                    1->{
                                        while (true){
                                            clearScreen()
                                            var screenNote: MutableMap<Int, String>?=(currentLibrary.libraryContent[b]?.open(
                                                currentLibrary.libraryContent[b]?.archiveContent!!))
                                            var d=Screen("Перечень заметок",screenNote).userInput()
                                            var size2 = currentLibrary.libraryContent[b]?.archiveContent!!.keys.size
                                            when (d) {
                                                in 0..(size2 -1) -> {
                                                    currentLibrary.libraryContent[b]!!.archiveContent[d]!!.printNote()
                                                }
                                                size2->break
                                            }
                                        }
                                    }
                                    2->break
                                }
                            }
                        }
                        size -> break
                    }
                }
            }
            2->break
        }
    }
    println("Работа программы \"Заметки\" завершена.")
    scanner.close()
}
