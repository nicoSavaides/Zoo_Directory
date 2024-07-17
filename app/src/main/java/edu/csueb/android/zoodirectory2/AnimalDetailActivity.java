package edu.csueb.android.zoodirectory2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        ImageView largeImageView = findViewById(R.id.detailImageView);
        TextView animalNameTextView = findViewById(R.id.animalNameTextView);
        TextView animalDescriptionTextView = findViewById(R.id.detailTextView);


        Animal animal = (Animal) getIntent().getSerializableExtra("animal");


        if (animal != null) {

            animalNameTextView.setText(animal.getName());
            largeImageView.setImageResource(animal.getLargeImage());
            animalDescriptionTextView.setText(animal.getDescription());
        }
    }
}
