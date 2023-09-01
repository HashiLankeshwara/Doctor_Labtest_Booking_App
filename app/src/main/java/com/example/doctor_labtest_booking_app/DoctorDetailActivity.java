package com.example.doctor_labtest_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
//import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Dr.Ajit Kumara", "Colombo", "Exp : 5yrs", "0702244344", "600"},
                    {"Dr.Upul Sanath", "Kandy", "Exp : 15yrs", "0772244333", "900"},
                    {"Dr.Sahas Rathnayake", "Anuradhapura", "Exp : 8yrs", "0722244322", "300"},
                    {"Dr.Jagath Bandara", "Kurunegala", "Exp : 6yrs", "0752244311", "500"},
                    {"Dr.Sithum Wickrama", "Galle", "Exp : 7yrs", "0762244300", "800"}
            };

    private String[][] doctor_details2 =
            {
                    {"Dr.Ajit Kumara", "Colombo", "Exp : 5yrs", "0702244344", "600"},
                    {"Dr.Upul Sanath", "Kandy", "Exp : 15yrs", "0772244333", "900"},
                    {"Dr.Sahas Rathnayake", "Anuradhapura", "Exp : 8yrs", "0722244322", "300"},
                    {"Dr.Jagath Bandara", "Kurunegala", "Exp : 6yrs", "0752244311", "500"},
                    {"Dr.Sithum Wickrama", "Galle", "Exp : 7yrs", "0762244300", "800"}
            };

    private String[][] doctor_details3 =
            {
                    {"Dr.Ajit Kumara", "Colombo", "Exp : 5yrs", "0702244344", "600"},
                    {"Dr.Upul Sanath", "Kandy", "Exp : 15yrs", "0772244333", "900"},
                    {"Dr.Sahas Rathnayake", "Anuradhapura", "Exp : 8yrs", "0722244322", "300"},
                    {"Dr.Jagath Bandara", "Kurunegala", "Exp : 6yrs", "0752244311", "500"},
                    {"Dr.Sithum Wickrama", "Galle", "Exp : 7yrs", "0762244300", "800"}
            };

    private String[][] doctor_details4 =
            {
                    {"Dr.Ajit Kumara", "Colombo", "Exp : 5yrs", "0702244344", "600"},
                    {"Dr.Upul Sanath", "Kandy", "Exp : 15yrs", "0772244333", "900"},
                    {"Dr.Sahas Rathnayake", "Anuradhapura", "Exp : 8yrs", "0722244322", "300"},
                    {"Dr.Jagath Bandara", "Kurunegala", "Exp : 6yrs", "0752244311", "500"},
                    {"Dr.Sithum Wickrama", "Galle", "Exp : 7yrs", "0762244300", "800"}
            };

    private String[][] doctor_details5 =
            {
                    {"Dr.Ajit Kumara", "Colombo", "Exp : 5yrs", "Mobile No : 0702244344", "600"},
                    {"Dr.Upul Sanath", "Kandy", "Exp : 15yrs", "Mobile No : 0772244333", "900"},
                    {"Dr.Sahas Rathnayake", "Anuradhapura", "Exp : 8yrs", "Mobile No : 0722244322", "300"},
                    {"Dr.Jagath Bandara", "Kurunegala", "Exp : 6yrs", "Mobile No : 0752244311", "500"},
                    {"Dr.Sithum Wickrama", "Galle", "Exp : 7yrs", "Mobile No : 0762244300", "800"}
            };

    private String[][] doctor_details6 =
            {
                    {"Dr.Ajit Kumara", "Colombo", "Exp : 5yrs", "0702244344", "600"},
                    {"Dr.Upul Sanath", "Kandy", "Exp : 15yrs", "0772244333", "900"},
                    {"Dr.Sahas Rathnayake", "Anuradhapura", "Exp : 8yrs", "0722244322", "300"},
                    {"Dr.Jagath Bandara", "Kurunegala", "Exp : 6yrs", "0752244311", "500"},
                    {"Dr.Sithum Wickrama", "Galle", "Exp : 7yrs", "0762244300", "800"}
            };


    TextView tv;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewDDTitle);

        Intent it = getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
            if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
            else
                if (title.compareTo("Dentist")==0)
                    doctor_details = doctor_details3;
                else
                    if (title.compareTo("Surgeon")==0)
                        doctor_details = doctor_details4;
                    else
                        if (title.compareTo("Cardiologists")==0)
                            doctor_details = doctor_details5;
                        else
                            doctor_details = doctor_details6;


        list = new ArrayList();
        for (int i=0; i<doctor_details.length; i++) {
            item =new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees :"+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new  String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}