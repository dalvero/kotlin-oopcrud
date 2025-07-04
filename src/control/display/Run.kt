package control.display

import interfaces.Crud
import objek.Barang
import repository.RepositoryBarang
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
    private fun getOption(): String {
        print("> Masukan pilihan : ")
        val option = readlnOrNull()
        return when {
            option != null -> option
            else -> ""
        }
    }

    // VALIDASI INPUTAN USER
    private fun validationOption(option : String, menu : Array<String>) : Boolean{
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

    // OVERRIDE FUNCTION TAMBAH DATA
    override fun tambahData() {
        Display.printDividen()
        Display.printTitle(title = "Tambah Data")
        Display.printDividen()
        print("> Masukan nama barang\t\t\t: ")
        val namaBarang = readlnOrNull()
        print("> Masukan jumlah stok barang\t: ")
        val stokBarang = readlnOrNull()
        if (namaBarang != null && stokBarang != null){
            val fixedNamaBarang = namaBarang.toIntOrNull()
            val fixedStock = stokBarang.toIntOrNull()
            if (fixedStock != null && fixedNamaBarang == null){
                RepositoryBarang.tambahBarang(namaBarang, fixedStock)
                Display.printListBarang(false, RepositoryBarang.tampilBarang())
            } else {
                println("> Barang gagal ditambahkan")
                println("> Barang atau Stok Barang tidak valid\n> Silahkan ulangi!")
            }
        } else {
            println("> Barang gagal ditambahkan")
            println("> Barang atau Stok Barang tidak valid\n> Silahkan ulangi!")
        }
    }

    // OVERRIDE FUNCTION TAMPIL DATA
    override fun tampilData() {
        Display.printDividen()
        Display.printTitle(title = "Tampil Data")
        Display.printDividen()
        Display.printListBarang(false, RepositoryBarang.tampilBarang())
    }

    // OVERRIDE FUNCTION EDIT DATA
    override fun editData() {
        Display.printDividen()
        Display.printTitle(title = "Edit Data")
        Display.printDividen()
        print("> Masukan nama barang\t\t\t: ")
        val namaBarang = readlnOrNull()
        if (namaBarang != null){
            val barang : Barang? = RepositoryBarang.cariBarangByNama(namaBarang)
            if (barang != null){
                println("> Barang yang anda cari ${barang.namaBarang} ditemukan")
            } else {
                println("> Barang yang anda cari $namaBarang tidak ditemukan")
                println("> Silahkan ulangi!")
                return
            }
        }

        Display.printTitle(title = "Masukan Data Barang Terbaru")
        print("> Masukan nama barang\t\t\t: ")
        val newNamaBarang = readlnOrNull()
        print("> Masukan jumlah stok barang\t: ")
        val newStokBarang = readlnOrNull()
        if (newNamaBarang != null && newStokBarang != null && namaBarang != null){
            val fixedNamaBarang = newNamaBarang.toIntOrNull()
            val fixedStock = newStokBarang.toIntOrNull()
            if (fixedStock != null && fixedNamaBarang == null){
                RepositoryBarang.editBarang(namaBarang, newNamaBarang, fixedStock)
                Display.printListBarang(false, RepositoryBarang.tampilBarang())
            } else {
                println("> Barang atau Stok Barang tidak valid\n> Silahkan ulangi!")
            }
        } else {
            println("> Barang gagal diupdate")
            println("> Barang atau Stok Barang tidak valid\n> Silahkan ulangi!")
        }
    }

    // OVERRIDE FUNCTION DELETE DATA
    override fun deleteData() {
        Display.printDividen()
        Display.printTitle(title = "Delete Data")
        Display.printDividen()
        print("> Masukan nama barang\t\t\t: ")
        val namaBarang = readlnOrNull()
        if (namaBarang != null){
            if (RepositoryBarang.hapusBarang(namaBarang)){
                println("> Barang dengan nama $namaBarang berhasil dihapus")
            } else {
                println("> Barang dengan nama $namaBarang gagal dihapus")
            }
        }
    }
}
