package com.example.taotoon;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taotoon.adapter.MangaAdapter;
import com.example.taotoon.model.Manga;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewMG;
    MangaAdapter mangaAdapter;
    ArrayList<Manga> arr_Manga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        loadData();
    }

    private void loadData() {
        arr_Manga.add(new Manga(1,"Konosuba",R.drawable.h1));
        arr_Manga.add(new Manga(2,"Nhà có 5 nàng dâu",R.drawable.h3));
        arr_Manga.add(new Manga(3,"Solo Leveling",R.drawable.h4));
        arr_Manga.add(new Manga(4,"Re:zero",R.drawable.h5));
        arr_Manga.add(new Manga(5,"Overlord",R.drawable.h6));
        arr_Manga.add(new Manga(6,"Tonikaku Kawaii",R.drawable.h7));
        arr_Manga.add(new Manga(7,"Naruto",R.drawable.h8));
        arr_Manga.add(new Manga(8,"Kimetsu no Yaiba",R.drawable.h9));
        arr_Manga.add(new Manga(9,"Dr Stone",R.drawable.h10));
        arr_Manga.add(new Manga(10,"One Piece",R.drawable.h11));
        arr_Manga.add(new Manga(11,"Jojo",R.drawable.h12));
        arr_Manga.add(new Manga(12,"Jujutsu Kaisen",R.drawable.h13));
    }

    private void addControls() {
        recyclerViewMG = findViewById(R.id.recyclerManga);
        arr_Manga=new ArrayList<>();
        mangaAdapter= new MangaAdapter(this,arr_Manga);
        recyclerViewMG.setAdapter(mangaAdapter);
        //recyclerViewMG.setLayoutManager(new LinearLayoutManager(this)); //Dạng thẳng

        //Dạng lưới
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewMG.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnuCategory = getMenuInflater();
        mnuCategory.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.mnAccount){
            Intent intent = new Intent(MainActivity.this,activity_login.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.mnRegister){
            Intent intent = new Intent(MainActivity.this,activity_register.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}