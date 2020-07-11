package org.techtown.edc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class collection extends Activity implements View.OnClickListener {
    private Princess player;
    private Button b[] = new Button[29];
    private int item[] = new int[29];
    Button  choice;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_collection);

        //Intent intent = getIntent();
        //player = (Princess) intent.getSerializableExtra("player");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                this.finish();
                break;
        }
    }
}
