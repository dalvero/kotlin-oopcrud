package control.display

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
}

