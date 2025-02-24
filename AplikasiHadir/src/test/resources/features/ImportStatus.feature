Feature: Pengujian Fitur Aplikasi Hadir

Scenario: Login Ke Website Hadir
    Given Pengguna membuka halaman login Hadir
    When Pengguna memasukkan email "admin@hadir.com" dan password "admin@hadir"
    And Pengguna menekan tombol login
    Then Pengguna berhasil masuk ke halaman utama

Scenario: Menguji Upload File dalam Import Status
    Given Pengguna menekan tombol menu Import di bagian kiri menu
    And Pengguna menekan tombol submenu Import Status Aktif
    When Pengguna menekan tombol choose file dan memilih file excel yang diinginkan
    And Pengguna menekan tombol import
    Then Muncul notifikasi "Berhasil import excel"

Scenario: Menguji Upload File dalam Import Status (Selain Excel)
    Given Pengguna menekan tombol choose file dan memilih file bukan excel
    And Pengguna menekan tombol import lagi
    Then Muncul notifikasi error "*File harus berupa file Excel (.xls atau .xlsx)"