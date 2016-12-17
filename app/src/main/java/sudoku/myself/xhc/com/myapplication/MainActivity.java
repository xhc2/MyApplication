package sudoku.myself.xhc.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClassifyView classifyView = (ClassifyView) findViewById(R.id.classify_view);
        List<List<ClassifyBean>> lists = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            List<ClassifyBean> list = new ArrayList<>();
            for (int j = 0; j <11; ++j) {
                ClassifyBean cb = new ClassifyBean();
                cb.setName("梓桐");
                list.add(cb);
            }
            lists.add(list);
        }
        classifyView.setList(lists);
        classifyView.setClassifyClickInter(new ClassifyClickInter() {
            @Override
            public void clickClassify(ClassifyBean cb) {
                Toast.makeText(MainActivity.this, cb.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
