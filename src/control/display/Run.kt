package control

import control.display.Display
import interfaces.Crud
import utilities.Menu

object Run : Crud{
    // RUNNER FUNCTION
    fun runner(){
        var isExit = false
        do {
            Display.printDividen()
            Display.printTitle(title = "Selamat Datang di Program Crud")
            Display.printDividen()
            Display.printMainMenu(Menu.mainMenu)
            Display.printDividen()
            val option = getOption()
            if (validationOption(option, Menu.mainMenu)){
                val optionNumber = option.toInt()
                when(optionNumber){
                    1 -> tambahData()
                    2 -> tampilData()
                    3 -> editData()
                    4 -> deleteData()
                    0 -> isExit = true
                }
            }
        } while (!isExit)
    }

    // MENDAPATKAN INPUTAN USER
    fun getOption(): String {
        print("> Masukan pilihan : ")
        val option = readlnOrNull()
        return when {
            option != null -> option
            else -> ""
        }
    }

    // VALIDASI INPUTAN USER
    fun validationOption(option : String, menu : Array<String>) : Boolean{
        val check = option.toIntOrNull()
        return when {
            check != null -> {
                if (check >= 0 && check <= menu.size){
                    true
                } else {
                    println("> Pilihan tidak ditemukan di menu\n> silahkan ulangi!")
                    false
                }
            }
            else -> {
                println("> Pilihan tidak ditemukan, silahkan ulangi!")
                false
            }
        }
    }

    override fun tambahData() {
        Display.printDividen()
        Display.printTitle(title = "Tambah Data")
        Display.printDividen()
    }

    override fun tampilData() {
        Display.printDividen()
        Display.printTitle(title = "Tampil Data")
        Display.printDividen()
    }

    override fun editData() {
        Display.printDividen()
        Display.printTitle(title = "Edit Data")
        Display.printDividen()
    }

    override fun deleteData() {
        Display.printDividen()
        Display.printTitle(title = "Delete Data")
        Display.printDividen()
    }
}
