package cn.edu.gdmec.s07150804.work1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2;
    private int iNum1,iNum2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText("onCreate方法中赋的值");
        tv2.setText("onCreate方法中赋的值");
        iNum1 = 0;
        iNum2 = 0;
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        tv1.setText("触发onRestart，显示view1");
        tv2.setText("触发onRestart，显示view2");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        iNum1++;
        iNum2++;
        outState.putString("tv1","onSaveInstanceState保存的数值为"+iNum1);
        outState.putString("tv2",String.valueOf(iNum2));
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText("onSaveInstanceState保存的数值为"+savedInstanceState.getString("tv2"));
        iNum2 = Integer.parseInt(savedInstanceState.getString("tv2"));
    }}