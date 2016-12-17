package sudoku.myself.xhc.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rcView = (RecyclerView)findViewById(R.id.rc_view);
        List<ClassifyBean> list = new ArrayList<>();
        for (int i = 0 ;i < 20 ; ++i){
            ClassifyBean cb = new ClassifyBean();
            cb.setName("xhc");
            list.add(cb);
        }

        MyRecyleAdapter adapter = new MyRecyleAdapter( list , this);
        rcView.setAdapter(adapter);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        adapter.addOnRecyleItemClick(new OnRecyleItemClick<ClassifyBean>() {
            @Override
            public void onItemClick(View v, ClassifyBean o, int position) {
                Toast.makeText(Main3Activity.this, o.getName() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
