package com.example.doctor_labtest_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLTD);
        tvTotalCost = findViewById(R.id.textViewLTDTotalCost);
        edDetails = findViewById(R.id.editTextLTDTextMultiline);
        btnAddToCart = findViewById(R.id.buttonLTDCheckout);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText(intent.getStringExtra("Total Cost : "+intent.getStringExtra("text3")+"/-"));

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"Doctor_Labtest_Booking_App", null, 1);

                if (db.checkCart(username, product)==1) {
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Record inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}