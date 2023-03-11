package com.cookandroid.project7_2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2, button3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201807558 김도훈");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);

        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);

        button3 = (Button) findViewById(R.id.button3);
        registerForContextMenu(button3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if (v == button2) {
            mInflater.inflate(R.menu.menu2, menu);
        }
        if (v == button3) {
            mInflater.inflate(R.menu.menu3, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate45:
                button2.setRotation(45);
                return true;
            case R.id.subSize2:
                button2.setScaleX(2);
                return true;
            case R.id.subRotate90:
                button3.setRotation(90);
                return true;
            case R.id.subSize4:
                button3.setScaleX(4);
                return true;
        }
        return false;
    }
}