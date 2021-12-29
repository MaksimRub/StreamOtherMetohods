package com.example.streamothermetohods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c, d;
    Button solve;
    TextView results, results1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        solve = findViewById(R.id.solve);
        results = findViewById(R.id.result);
        results1 = findViewById(R.id.result1);


        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                                try {
                                    int b1 = Integer.parseInt(b.getText().toString());
                                    int c1 = Integer.parseInt(c.getText().toString());
                                    int d1 = Integer.parseInt(d.getText().toString());

                                    int D = c1 * c1 - 4 * b1 * d1;
                                    if (D < 0) {
                                        results1.setText("stream2:" + " " + "нет решений");
                                    } else {
                                        double x1 = (-c1 + Math.sqrt(D)) / (2 * b1);
                                        double x2 = (-c1 - Math.sqrt(D)) / (2 * b1);
                                        if (x1 == x2) {
                                            String x1_str=Double.toString(x1);
                                            results1.setText("stream2:" + " "+x1_str);
                                        } else {
                                            String x1_str=Double.toString(x1);
                                            String x2_str=Double.toString(x2);
                                            results1.setText("stream2:" + " "+x1_str+";  "+x2_str);
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                }
                            }
                });
                t1.start();


                AnotherThread t = new AnotherThread();
                t.start();

            }
        });
    }


    class AnotherThread extends Thread {
        @Override
        public void run() {
                    try {
                        int a1 = Integer.parseInt(a.getText().toString());
                        int b1 = Integer.parseInt(b.getText().toString());
                        int c1 = Integer.parseInt(c.getText().toString());

                        int D = b1 * b1 - 4 * a1 * c1;

                        if (D < 0) {
                            results.setText("stream1:" + " " + "нет решений");
                        } else {
                            double x1 = (-b1 + Math.sqrt(D)) / (2 * a1);
                            double x2 = (-b1 - Math.sqrt(D)) / (2 * a1);
                            if (x1 == x2) {
                                String x1_str=Double.toString(x1);
                                results.setText("stream1:" + " "+x1_str);

                            } else {
                                String x1_str=Double.toString(x1);
                                String x2_str=Double.toString(x2);

                                results.setText("stream1:" + " "+x1_str+";  "+x2_str);

                            }

                        }
                    } catch (NumberFormatException e) {


                    }

                }
            }
        }


