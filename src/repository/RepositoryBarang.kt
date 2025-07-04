package repository

import objek.Barang

// MENGGUNAKAN OBJEK
object RepositoryBarang {
    // VARIABEL UNTUK MENAMPUNG LIST BARANG MENGGUNAKAN MUTABLE LIST AGAR DINAMIS
    private val listBarang = mutableListOf<Barang>()

    // VARIABEL UNTUK ID BARANG YANG AKAN BERTAMBAH KETIKA MENAMBAHKAN BARANG
    private var idBarang = 0

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

    // FUNCTION UNTUK MENCARI BARANG BERDASARKAN NAMANYA
    fun cariBarangByNama(nama : String) : Barang? {
        return listBarang.find { it.namaBarang.contains(nama, ignoreCase = true) }
    }

    // FUNCTION UNTUK UPDATE BARANG
    fun editBarang(oldNamaBarang : String?, newNamaBarang: String?, newStokBarang: Int?): Boolean {
        val barangToUpdate = oldNamaBarang?.let { cariBarangByNama(it) }
        return if (barangToUpdate != null) {
            // MENGGUNAKAN 'let' UNTUK BEKERJA DENGAN OBJEK YANG NON-NULL
            barangToUpdate.let {
                if (newNamaBarang != null) {
                    it.namaBarang = newNamaBarang
                }
                if (newStokBarang != null) {
                    it.stokBarang = newStokBarang
                }
            }
            println("> Barang dengan nama $oldNamaBarang berhasil diupdate.")
            println("> Nama barang menjadi $newNamaBarang")
            true
        } else {
            println("> Barang dengan nama $oldNamaBarang gagal diupdate.")
            println("> Silahkan ulangi!")
            false
        }
    }

    // FUNCTION UNTUK HAPUS BARANG
    fun hapusBarang(nama : String?): Boolean {
        val barangDihapus = listBarang.removeIf { it.namaBarang == nama } // removeIf MENGEMBALIKAN BOOLEAN
        return if (barangDihapus) {
            println("> Barang dengan nama $nama ditemukan")
            true
        } else {
            println("> Barang dengan nama $nama tidak ditemukan")
            false
        }
    }


}