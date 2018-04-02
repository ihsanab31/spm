package com.sumroch.spotme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.bottlerocketstudios.barcode.generation.ui.BarcodeView;
/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class BarcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        final EditText etText = (EditText) findViewById(R.id.et_text);
        final BarcodeView bvGenerated = (BarcodeView) findViewById(R.id.bv_generated);

        findViewById(R.id.btn_generate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etText.getText().toString().isEmpty())
                    etText.setError("Fild must filled");
                else {
                    etText.setError(null);
                    bvGenerated.setBarcodeText(etText.getText().toString());
                }
            }
        });

    }
}
