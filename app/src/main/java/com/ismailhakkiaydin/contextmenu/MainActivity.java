package com.ismailhakkiaydin.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit1, edit2;

    private void init() {

        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);

        this.registerForContextMenu(edit1);
        this.registerForContextMenu(edit2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.editText:
                this.getMenuInflater().inflate(R.menu.color_menu, menu);
                break;
            case R.id.editText2:
                this.getMenuInflater().inflate(R.menu.font_menu,menu);
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnuBlue:
                edit1.setTextColor(Color.BLUE);
                break;
            case R.id.mnuGreen:
                edit1.setTextColor(Color.GREEN);
                break;
            case R.id.mnuRed:
                edit1.setTextColor(Color.RED);
                break;

            case  R.id.mnuBig:
                edit2.setTextSize(60);
                break;
            case R.id.mnuMedium:
                edit2.setTextSize(40);
                break;
            case R.id.mnuSmall:
                edit2.setTextSize(20);
                break;
        }

        return super.onContextItemSelected(item);

    }
}
