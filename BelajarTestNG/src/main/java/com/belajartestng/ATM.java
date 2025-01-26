package com.belajartestng;

public class ATM {
    private double saldoAwal;

    ATM(double saldoAwal){
        this.saldoAwal = saldoAwal;
    }

    public double cekSaldo(){
        return saldoAwal;
    }

    public void setorUang (double jumlah){
        if (jumlah > 0){
            saldoAwal += jumlah;
        }
        else{
            System.out.println("Jumlah Uang Yang disetor Harus Lebih Dari Rp. 0 !!");
        }
    }

    public void tarikUang(double jumlah){
        if (jumlah > 0 && saldoAwal > jumlah){
            saldoAwal -= jumlah;
        }
        else if (saldoAwal < jumlah){
            System.out.println("Saldo Anda Tidak Mencukupi");
        }
        else{
            System.out.println("Jumlah Uang Yang ditarik Harus Lebih Dari Rp. 0 !!");
        }
    }
}
