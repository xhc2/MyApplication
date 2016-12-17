package sudoku.myself.xhc.com.myapplication;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个模块一个list
 * 
 * @author pc 每个模块的第一个都是大块的 占两行,其他的都只占一行
 */
public class ClassifyView extends LinearLayout{


	private List<List<ClassifyBean>> lists = new ArrayList<List<ClassifyBean>>();
	private List<List<Button>> listBt = new ArrayList<List<Button>>();
	private int width, height;
	private int gridWidth;
	private ClassifyClickInter clickInter;
	
	public ClassifyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public ClassifyView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ClassifyView(Context context) {
		this(context, null);
	}

	private void init(Context context) {
		this.setOrientation(LinearLayout.VERTICAL);
	}
	
	public void setClassifyClickInter(ClassifyClickInter clickInter){
		this.clickInter = clickInter;
	}
	public void setList(List<List<ClassifyBean>> lists){
		if(lists != null){
			this.lists = lists;
			requestLayout();
		}
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		width = getMeasuredWidth();
		height = getMeasuredHeight();
		gridWidth = width / 4;
		Log.e("xhc", "onMeasure width "+width+" height "+height+" gridWidth "+gridWidth);
		// 用来控制控件放哪里
		Log.e("xhc" ,"lists.size()"+lists.size() );
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		for (int i = 0; i < lists.size(); ++i) {
			List<Button> tempListBt = new ArrayList<Button>();
			RelativeLayout rl = new RelativeLayout(getContext());
			LayoutParams rlParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			rlParams.topMargin = 9;
			//控制控件放在哪里
			int leftMarin = 0;
			int topMargin = 0;

			for (int j = 0; j < lists.get(i).size(); ++j) {

				Button bt = new Button(getContext());
				bt.setBackgroundResource(R.drawable.click_border_selector);
				bt.setId(View.generateViewId());
				bt.setTextColor(getColor(R.color.white));
				final ClassifyBean cb =  lists.get(i).get(j);
				String text = cb.getName();
				bt.setText(text);
				tempListBt.add(bt);
				bt.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						if(clickInter != null){
							clickInter.clickClassify(cb);
						}
					}
				});
				if(j == 0){
					//第一个，大块的
					RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(
							gridWidth, gridWidth);
					btParams.leftMargin = leftMarin;
					btParams.topMargin = topMargin;
					bt.setLayoutParams(btParams);
					leftMarin += gridWidth;

				}
				else if(leftMarin  >= width){
					//换行
					topMargin += gridWidth / 2 ;
					if (j == 4) {
						// 第二行
						leftMarin = gridWidth;
					} else {
						// 超过第二行了
						leftMarin = 0;
					}
					RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(
							gridWidth, gridWidth / 2);
					btParams.leftMargin = leftMarin;
					btParams.topMargin = topMargin;
					bt.setLayoutParams(btParams);
					leftMarin += gridWidth;
				}
				else{
					RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(
							gridWidth, gridWidth / 2);
					btParams.leftMargin = leftMarin;
					btParams.topMargin = topMargin;
					bt.setLayoutParams(btParams);
					leftMarin += gridWidth;
				}
				rl.addView(bt);
			}
			listBt.add(tempListBt);
			this.addView(rl, rlParams);
		}

	}

	private ColorStateList getColor(int colorId) {
		return getContext().getResources().getColorStateList(colorId);
	}

}
