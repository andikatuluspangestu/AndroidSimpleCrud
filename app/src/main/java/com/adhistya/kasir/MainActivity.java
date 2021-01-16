package com.adhistya.kasir;

import android.app.*;
import android.os.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends Activity 
{
	private EditText ETnamapelanggan, ETid,ETnamabrg, ETjumlah,ETharga, ETuangbyr;
	private Button btnProses,btnClear,btnExit;
	private TextView txtnamapelanggan, txtnamabrg,txtjml, 
	txtharga,txtuangbyr,txtbonus,txttotal,txtuangkembali,txtket;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		getSupportActionBar().setTitle("Toko Slawi");
		getSupportActionBar().setSubtitle("W A H I D I N");
		ETnamapelanggan = (EditText)findViewById(R.id.namapelanggan);
		ETnamabrg = (EditText)findViewById(R.id.namabarang);
		ETjumlah = (EditText)findViewById(R.id.jumlah);
		ETharga = (EditText)findViewById(R.id.harga);
		ETuangbyr = (EditText)findViewById(R.id.uangbayar);
		btnProses = (Button) findViewById(R.id.btnproses);
		btnClear = (Button) findViewById(R.id.btnclear);
		btnExit = (Button) findViewById(R.id.btnexit);
		txtnamapelanggan = (TextView) findViewById(R.id.tampilnama);
		txtnamabrg = (TextView) findViewById(R.id.tampilnamabrg);
		txtjml = (TextView) findViewById(R.id.tampiljumlah);
		txtharga=(TextView) findViewById(R.id.tampilharga);
		txtuangbyr=(TextView) findViewById(R.id.tampiluangbyr);
		txtbonus=(TextView) findViewById(R.id.bonus);
		txttotal=(TextView) findViewById(R.id.totalbelanja);
		txtuangkembali=(TextView) findViewById(R.id.uangkembali);
		txtket=(TextView) findViewById(R.id.keterangan);
		btnProses.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String getnamapelanggan = ETnamapelanggan.getText().toString();
					String getnamabarang = ETnamabrg.getText().toString();
					String getjumlah = ETjumlah.getText().toString();
					String getharga = ETharga.getText().toString();
					String getuangbyr = ETuangbyr.getText().toString();
					txtjml.setText("Jumlah : "+getjumlah);
					txtnamapelanggan.setText("Nama pelanggan : "+getnamapelanggan);
					txtnamabrg.setText("Nama barang : "+getnamabarang);
					txtharga.setText("Harga barang : "+getharga);
					txtuangbyr.setText("Besar Uang : "+getuangbyr);
					double jb = Double.parseDouble(getjumlah);
					double h = Double.parseDouble(getharga);
					double ub = Double.parseDouble(getuangbyr);
					double jml_byr = jb * h;
					txttotal.setText("Total : "+jml_byr);
					
					//hitung bonus
					if(jml_byr >=200000){
						txtbonus.setText("Bonus : Mie");
					}
					else if(jml_byr >=50000){
						txtbonus.setText("Bonus : Pepsodent");
					}
					else if(jml_byr >=40000){
						txtbonus.setText("Bonus : Permen");
					}
					else{ txtbonus.setText("Bonus : Tidak ada");}
					double uangkembalian = ub-jml_byr;
					if(ub < jml_byr){
						txtket.setText("Keterangan : uang bayar kurang Rp. "+(uangkembalian));
						txtuangkembali.setText("Uang kembali : Rp 0");
					}
					else{
						txtket.setText("Keterangan : Hitung uang kembalian");
						txtuangkembali.setText("Uang kembali : Rp "+(uangkembalian));
					}
				}
			});
			
		btnExit.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					moveTaskToBack(true);
				}
			});
	}
	
	public void Reset(View view) {
		ETuangbyr.getText().clear();
		ETharga.getText().clear();
		ETjumlah.getText().clear();
		ETnamabrg.getText().clear();
		ETnamapelanggan.getText().clear();
		txtjml.setText(" ");
		txtnamapelanggan.setText(" ");
		txtnamabrg.setText(" ");
		txtharga.setText(" ");
		txtuangbyr.setText(" ");
		txtuangkembali.setText("Uang Kembali: Rp. 0 ");
		txtbonus.setText("Bonus : - ");
		txtket.setText("Keterangan : - ");
		txttotal.setText("Total Belanja: Rp. 0 ");
	}
}
