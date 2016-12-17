package sudoku.myself.xhc.com.myapplication;

import android.view.View;

/**
 * Created by xhc on 2016/12/17.
 */

public interface OnRecyleItemClick<T> {
    void onItemClick(View v , T t , int position);
}
