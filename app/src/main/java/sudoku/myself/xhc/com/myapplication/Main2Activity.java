package sudoku.myself.xhc.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void button1(View view){
        startActivity(new Intent(Main2Activity.this , MainActivity.class));
    }
    public void button2(View view){
        startActivity(new Intent(Main2Activity.this , Main3Activity.class));
    }
}
