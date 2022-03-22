package com.example.donut_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DonutDetail extends AppCompatActivity {
    private Donut donut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_detail);

        donut = (Donut) getIntent().getSerializableExtra("selectedDonut");
        showDonutInfo(donut);

        setActionForPlusBtn();

        setActionForSubtractBtn();

        //Add action for Add to cart Button (to back MainActivity)
        backToMainActivity();
    }

    private void setActionForSubtractBtn(){
        ImageButton subtractBtn = findViewById(R.id.subtractBtn);
        TextView quantity = findViewById(R.id.donutQuan);

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int donutQuantity = Integer.parseInt(
                        quantity.getText().toString()
                );

                if (donutQuantity > 1){
                    quantity.setText(--donutQuantity + "");
                }

            }
        });
    }

    private void setActionForPlusBtn(){
        ImageButton plusBtn = findViewById(R.id.plusBtn);
        TextView quantity = findViewById(R.id.donutQuan);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int donutQuantity = Integer.parseInt(
                        quantity.getText().toString()
                );

                quantity.setText(++donutQuantity + "");

            }
        });
    }

    private void showDonutInfo(Donut donut){
        ImageView donutImg = findViewById(R.id.donutImg);
        donutImg.setImageResource(donut.getDonutImgId());

        TextView donutName = findViewById(R.id.donutName);
        donutName.setText(donut.getDonutName());

        TextView donutDesc = findViewById(R.id.donutDesc);
        donutDesc.setText(donut.getDonutDesc());

        TextView donutPrice = findViewById(R.id.donutPrice);
        donutPrice.setText("$ " + donut.getDonutPrice());
    }

    private void backToMainActivity(){
        Button addToCartBtn = findViewById(R.id.addToCartBtn);

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView donutQuan = findViewById(R.id.donutQuan);
                TextView donutName = findViewById(R.id.donutName);

                String message =
                        "Added " +
                                Integer.parseInt(donutQuan.getText().toString()) +
                                " " +
                                donutName.getText().toString() +
                                " to Cart";

                Toast.makeText(
                        getApplicationContext(),
                        message,
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        DonutDetail.this,
                        MainActivity.class
                );

                startActivity(intent);
            }
        });
    }
}
