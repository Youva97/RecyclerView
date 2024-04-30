package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MonAdapter monAdapter;
    private RecyclerView recyclerView;
    private List<Items> mesItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.monRecyclerView);
        mesItems = new ArrayList<>();

        mesItems.add(new Items(R.drawable.dbzdev, "Dbzdev", "Le saiyan de la programmation"));
        mesItems.add(new Items(R.drawable.uchiha, "Uchiha", "Le clan des Uchiha"));
        mesItems.add(new Items(R.drawable.dragonballs, "DragonBalls", "Les 7 boules de crital !"));
        mesItems.add(new Items(R.drawable.om, "OM", "L'olympique de marseille"));
        mesItems.add(new Items(R.drawable.easports, "Easports", "Le monde du foot dans toute sa splender"));
        mesItems.add(new Items(R.drawable.google, "Google", "Le moteur de recherche le plus utilisé!"));
        mesItems.add(new Items(R.drawable.netflix, "Netflix", "Le site de streaming le plus visionné!"));
        mesItems.add(new Items(R.drawable.dbzdev, "Dbzdev", "Le saiyan de la programmation"));
        mesItems.add(new Items(R.drawable.uchiha, "Uchiha", "Le clan des Uchiha"));
        mesItems.add(new Items(R.drawable.dragonballs, "DragonBalls", "Les 7 boules de crital !"));
        mesItems.add(new Items(R.drawable.om, "OM", "L'olympique de marseille"));
        mesItems.add(new Items(R.drawable.easports, "Easports", "Le monde du foot dans toute sa splender"));
        mesItems.add(new Items(R.drawable.google, "Google", "Le moteur de recherche le plus utilisé!"));
        mesItems.add(new Items(R.drawable.netflix, "Netflix", "Le site de streaming le plus visionné!"));
        mesItems.add(new Items(R.drawable.dbzdev, "Dbzdev", "Le saiyan de la programmation"));
        mesItems.add(new Items(R.drawable.uchiha, "Uchiha", "Le clan des Uchiha"));
        mesItems.add(new Items(R.drawable.dragonballs, "DragonBalls", "Les 7 boules de crital !"));
        mesItems.add(new Items(R.drawable.om, "OM", "L'olympique de marseille"));
        mesItems.add(new Items(R.drawable.easports, "Easports", "Le monde du foot dans toute sa splender"));
        mesItems.add(new Items(R.drawable.google, "Google", "Le moteur de recherche le plus utilisé!"));
        mesItems.add(new Items(R.drawable.netflix, "Netflix", "Le site de streaming le plus visionné!"));

        Log.d("Items", "onCreate:" + mesItems);
        monAdapter = new MonAdapter(mesItems, this);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        int orientation = getResources().getConfiguration().orientation;

        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        } else
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(monAdapter);

        effetSwipe effetSwipe = new effetSwipe(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, getApplicationContext(), mesItems, monAdapter);

        new ItemTouchHelper(effetSwipe).attachToRecyclerView(recyclerView);

    }

    ;
}