package id.ac.poliban.mi.latihan07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/*
    How to Create menu
    and change background of activity
    with AlertDialog.Builder()

*/

public class MainActivity extends AppCompatActivity {
    private boolean isColoring = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.miChangeColor:
                if(isColoring) {
                    View v = this.getWindow().getDecorView();
                    v.setBackgroundColor(Color.parseColor("#21511A"));
                }
                else{
                    View v = this.getWindow().getDecorView();
                    v.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                isColoring = !isColoring;
                break;

            case R.id.miExit:
                new AlertDialog.Builder(this)
                        .setTitle("Close Confirmation")
                        .setMessage("Close this App?")
                        .setIcon(android.R.drawable.btn_star)
                        .setCancelable(true)
                        .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                        .setNegativeButton("No", null).show();
                break;
        }
        return true;
    }
}
