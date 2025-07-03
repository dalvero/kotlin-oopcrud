package control.display

import objek.Barang

// OBJEK CLASS DISPLAY
object Display{
    // FUNCTION PRINT GARIS
    fun printDividen(char : Char = '=', panjang : Int = 50){
        for (i in 0..< panjang) print(char)
        println()
    }

    // FUNCTION PRINT JUDUL
    fun printTitle(char : Char = '-', panjang : Int = 50, title : String){
        val titleLength = title.length

        // ALGORITMA //
        // PENGECEKAN TERLEBIH DAHULU APAKAH PANJANG JUDUL LEBIH DARI PANJANG GARIS
        if (titleLength > panjang) {
            println(title) // MENCETAK JUDUL TANPA CHAR
            return
        }

        // MENGHITUNG SISA CHAR
        val remainingChars = panjang - titleLength

        // MENGHITUNG CHAR DISISI KIRIR
        val leftPadding = remainingChars / 2

        // MENGHITUNGG CHAR DI SISI KANAN (KASUS GANJIL)
        val rightPadding = remainingChars - leftPadding

        // PRINT PADDING KIRIR
        for (i in 0..< leftPadding) {
            print(char)
        }
        // PRINT JUDUL
        print(title)

        // PRINT PADDING KANAN
        for (i in 0..< rightPadding) {
            print(char)
        }
        println()
    }

    // FUNCTION PRINT MAIN MENU
    fun printMainMenu(mainMenu : Array<String>){
        for (i in mainMenu.indices){
            println("${i + 1}. ${mainMenu[i]}")
        }
        println("0. Keluar")
    }

    // FUNCTION PRINT BARANG
    fun printListBarang(withTitle : Boolean, listBarang : List<Barang>){
        if (withTitle){
            printTitle(title = "List Barang")
        }

        // TABEL KOMPONEN
        val lebarNo = 5
        val lebarId = 8
        val lebarNamaBarang = 20
        val lebarStokBarang = 12

        // PRINT LINE HEADER
        val line = "+${"-".repeat(lebarNo)}+${"-".repeat(lebarId)}+${"-".repeat(lebarNamaBarang)}+${"-".repeat(lebarStokBarang + 1)}"
        println(line)
        println("| ${"No".padEnd(lebarNo - 2)} | ${"ID".padEnd(lebarId - 2)} | ${"Nama Barang".padEnd(lebarNamaBarang - 2)} | ${"Stok Barang".padEnd(lebarStokBarang - 2)}|")
        println(line)

        // PRINT DATA
        if (listBarang.isEmpty()){
            println("| ${"Tidak ada barang tersedia.".padEnd(lebarNo + lebarId + lebarNamaBarang + lebarStokBarang + 2)}|")
        } else {
            for ((no, barang) in listBarang.withIndex()){
                val nomor = (no + 1).toString().padEnd(lebarNo - 2)
                val idBarang = "BRG-${barang.idBarang}".padEnd(lebarId - 2)
                val namaBarang = barang.namaBarang.padEnd(lebarNamaBarang - 2)
                val stokBarang = barang.stokBarang.toString().padEnd(lebarStokBarang - 2)
                println("| $nomor | $idBarang | $namaBarang | $stokBarang |")
            }
        }

        // PRINT LINE FOOTER
        println(line)
    }

}

