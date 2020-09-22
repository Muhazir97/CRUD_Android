package smartech.co.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InputActivity extends AppCompatActivity {
    private EditText et_nama, et_fakultas, et_jurusan, et_semester;

    private FloatingActionButton fab_done;
    private SQLiteHelper helper;
    private String pilih = "Tambah";
    private String id, nama, fakultas, jurusan, semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_nama = findViewById(R.id.et_nama);
        et_fakultas = findViewById(R.id.et_fakultas);
        et_jurusan = findViewById(R.id.et_jurusan);
        et_semester = findViewById(R.id.et_semester);
        fab_done = findViewById(R.id.fab_done);

        helper = new SQLiteHelper(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getSupportActionBar().setTitle("Ubah Data");

            id = bundle.getString("ID");
            nama = bundle.getString("NAMA");
            fakultas = bundle.getString("FAKULTAS");
            jurusan = bundle.getString("JURUSAN");
            semester = bundle.getString("SEMESTER");
            pilih = bundle.getString("TANDA");

            et_nama.setText(nama);
            et_fakultas.setText(fakultas);
            et_jurusan.setText(jurusan);
            et_semester.setText(semester);
        }else{
            getSupportActionBar().setTitle("Tambah Data");
        }

        fab_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = et_nama.getText().toString();
                String fakultas = et_fakultas.getText().toString();
                String jurusan = et_jurusan.getText().toString();
                String semester = et_semester.getText().toString();

                if(TextUtils.isEmpty(nama)){
                    et_nama.setError("Data Tidak Boleh Kosong");
                    et_nama.requestFocus();
                }else if(TextUtils.isEmpty(fakultas)){
                    et_fakultas.setError("Data Tidak Boleh Kosong");
                    et_fakultas.requestFocus();
                }else if(TextUtils.isEmpty(jurusan)){
                    et_jurusan.setError("Data Tidak Boleh Kosong");
                    et_jurusan.requestFocus();
                }else if(TextUtils.isEmpty(semester)){
                    et_semester.setError("Data Tidak Boleh Kosong");
                    et_semester.requestFocus();
                }else{
                    if(pilih.equals("Tambah")){
                        boolean isInsert = helper.insertData(nama,
                                fakultas,
                                jurusan,
                                semester);
                        if(isInsert){
                            Toast.makeText(InputActivity.this,"Data berhasil di simpan",Toast.LENGTH_SHORT).show();
                            kosong();
                            startActivity(new Intent(InputActivity.this,MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(InputActivity.this,"Data gagal di simpan",Toast.LENGTH_SHORT).show();
                            kosong();
                            startActivity(new Intent(InputActivity.this,MainActivity.class));
                            finish();
                        }
                    }else{
                        boolean isUpdate = helper.updateData(
                                id,
                                nama,
                                fakultas,
                                jurusan,
                                semester);
                        if(isUpdate){
                            Toast.makeText(InputActivity.this,"Data berhasil di update",Toast.LENGTH_SHORT).show();
                            kosong();
                            startActivity(new Intent(InputActivity.this,MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(InputActivity.this,"Data gagal di update",Toast.LENGTH_SHORT).show();
                            kosong();
                            startActivity(new Intent(InputActivity.this,MainActivity.class));
                            finish();
                        }
                    }
                }
            }
        });

    }

    private void kosong(){
        et_nama.setText(null);
        et_fakultas.setText(null);
        et_jurusan.setText(null);
        et_semester.setText(null);
    }
}
