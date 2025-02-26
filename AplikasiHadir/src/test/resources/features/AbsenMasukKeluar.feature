Feature: Absen Masuk dan Keluar

  @AbsenMasuk @User1
  Scenario: User1 melakukan absen masuk WFO tanpa note
    Given user1 memulai proses absen masuk
    And user1 menekan tombol kamera
    And user1 memilih tipe absen "Work From Home"
    When user1 menekan absen masuk
    And user1 melakukan scroll halaman ke bawah
    Then user1 berhasil absen dengan pesan "Rabu, 26 February 2025"

  @AbsenMasuk @User2
  Scenario: User2 melakukan absen masuk WFH tanpa note
    Given user2 memulai proses absen masuk
    And user2 mengambil foto sebagai bukti kehadiran
    And user2 memilih opsi absen "Work From Office"
    When user2 menekan tombol absen masuk
    And user2 melakukan scroll halaman ke bawah
    Then user2 berhasil absen dengan pesan "Rabu, 26 February 2025"

  @AbsenKeluar @User1
  Scenario: User1 melakukan absen keluar tanpa note
    Given user1 menekan tombol keluar pada history absensi
    When user1 menekan tombol absen keluar
    And user1 melakukan scroll halaman ke bawah
    Then user1 berhasil melakukan absen keluar

  @AbsenMasuk @User3
  Scenario: User3 melakukan absen masuk WFO dengan note
    Given user3 memulai proses absen masuk
    And user3 menekan tombol kamera
    And user3 memilih tipe absen "Work From Home"
    And user3 mengisi "Saya Hadir" pada bagian notes
    When user3 menekan absen masuk
    And user3 melakukan scroll halaman ke bawah
    Then user3 berhasil absen dengan pesan "Rabu, 26 February 2025"

  @AbsenMasuk @User4
  Scenario: User4 melakukan absen masuk WFH dengan note
    Given user4 memulai proses absen masuk
    And user4 mengambil foto sebagai bukti kehadiran
    And user4 memilih opsi absen "Work From Office"
    And user4 mengisi "Saya Hadir" pada bagian notes
    When user4 menekan tombol absen masuk
    And user4 melakukan scroll halaman ke bawah
    Then user4 berhasil absen dengan pesan "Rabu, 26 February 2025"

  @AbsenKeluar @User3
  Scenario: User3 melakukan absen keluar dengan note
    Given user3 menekan tombol keluar pada history absensi
    And user3 mengisi "Saya Pulang" pada bagian notes pulang
    When user3 menekan tombol absen keluar
    And user3 melakukan scroll halaman ke bawah
    Then user3 berhasil melakukan absen keluar