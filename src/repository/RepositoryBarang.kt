package repository

import objek.Barang

// MENGGUNAKAN OBJEK
object RepositoryBarang {
    // VARIABEL UNTUK MENAMPUNG LIST BARANG MENGGUNAKAN MUTABLE LIST AGAR DINAMIS
    private val listBarang = mutableListOf<Barang>()

    // VARIABEL UNTUK ID BARANG YANG AKAN BERTAMBAH KETIKA MENAMBAHKAN BARANG
    private var idBarang = 0;

    // FUNCTION UNTUK MENAMBAH BARANG
    fun tambahBarang(namaBarang : String, stokBarang : Int){
        idBarang++
        val newBarang = Barang(idBarang, namaBarang, stokBarang)
        listBarang.add(newBarang)
        println("> $namaBarang dengan stok $stokBarang berhasil ditambahkan.")
    }

    // FUNCTION UNTUK MENAMPILKAN SELURUH BARANG
    fun tampilBarang() : List<Barang>{
        return listBarang.toList()
    }

}