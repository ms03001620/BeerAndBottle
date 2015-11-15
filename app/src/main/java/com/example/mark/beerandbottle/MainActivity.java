package com.example.mark.beerandbottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editRmb = (EditText) findViewById(R.id.edit_rmb);
        final EditText editPrice = (EditText) findViewById(R.id.edit_price);
        final EditText editBottle = (EditText) findViewById(R.id.edit_bottle);
        final EditText editLid = (EditText) findViewById(R.id.edit_lid);
        final TextView textLog = (TextView) findViewById(R.id.text_log);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String rmb = editRmb.getText().toString();
                    String price = editPrice.getText().toString();
                    String bottle = editBottle.getText().toString();
                    String lid = editLid.getText().toString();

                    int r = Integer.parseInt(rmb);
                    int p = Integer.parseInt(price);
                    int b = Integer.parseInt(bottle);
                    int l = Integer.parseInt(lid);

                    if(r==0 || p==0 || b==0 || l==0){
                        Toast.makeText(MainActivity.this, "不要设置0", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Saler saler = new Saler(b, l, p);

                    Person persion = new Person(r);

                    persion.buy(saler);
                    persion.play(saler, textLog);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
