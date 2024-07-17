package edu.csueb.android.zoodirectory2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        animalList = createAnimalList();


        animalAdapter = new AnimalAdapter(this, animalList);
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        Log.d("MenuInflation", "Menu inflated successfully");
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_zoo_info) {

            startActivity(new Intent(MainActivity.this, ZooInformationActivity.class));
            return true;
        } else if (id == R.id.action_uninstall) {

            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    private List<Animal> createAnimalList() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Snake", R.drawable.snake_image, R.drawable.snake_image, "Snakes are elongated, legless reptiles covered in scales, found on every continent except Antarctica."));
        list.add(new Animal("Tiger", R.drawable.tiger_image, R.drawable.tiger_image, "The tiger is the largest living cat species and a member of the genus Panthera."));
        list.add(new Animal("Gorilla", R.drawable.gorilla_image, R.drawable.gorilla_image, "Sharing the largest primates with humans at 98% DNA similarity, gorillas are peaceful herbivores living in family groups led by a silverback, known for their intelligence and gentle nature."));
        list.add(new Animal("Panda", R.drawable.panda_image, R.drawable.panda_image, "Despite their classification as carnivores, adorable giant pandas are herbivores, relying almost entirely on bamboo for sustenance, and spend most of their days munching on these fibrous shoots in the bamboo forests of China."));
        list.add(new Animal("Dolphin", R.drawable.dolphin_image, R.drawable.dolphin_image, "While they are known for their playful nature, dolphins are also fierce predators, using their speed and teamwork to hunt fish and even squid in complex maneuvers."));


        return list;
    }
}

