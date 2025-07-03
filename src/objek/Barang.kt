package objek

class Barang(var idBarang: Int, var namaBarang : String, var stokBarang : Int) {
    fun getDataBarang(){
        println("ID\t\t\t: ${this.idBarang}")
        println("Nama Barang\t: ${this.namaBarang}")
        println("Stok Barang\t: ${this.stokBarang}")
    }
}