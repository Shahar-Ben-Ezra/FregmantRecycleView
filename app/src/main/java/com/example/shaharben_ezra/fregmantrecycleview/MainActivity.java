package com.example.shaharben_ezra.fregmantrecycleview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
TextView TvName,TvTel;
EditText EtName,EtTel;Button BtnAdd;
ListFrag listFrag;
FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TvTel=findViewById(R.id.TvTel);
        TvName=findViewById(R.id.TvName);
        EtName=findViewById(R.id.EtName);
        fragmentManager=this.getSupportFragmentManager();
        listFrag=(ListFrag)fragmentManager.findFragmentById(R.id.ListFrag);
        EtTel=findViewById(R.id.EtTel);
        BtnAdd=findViewById(R.id.BtnAdd);
        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( EtName.getText().toString().isEmpty()|| EtTel.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please enter all fileds", Toast.LENGTH_SHORT).show();
                }
                else{
                    ApplicationClass.people.add(new Person(  EtName.getText().toString().trim(),
                    EtTel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person successfully added ", Toast.LENGTH_SHORT).show();
                    EtTel.setText(null);
                    EtName.setText(null);
                    listFrag.notifyDataChanged();

                }


            }
        });
      OnItemClicked(0);
    }

    @Override
    public void OnItemClicked(int i) {
        TvName.setText(ApplicationClass.people.get(i).getName());
        TvTel.setText(ApplicationClass.people.get(i).getTelNr());

    }
}
