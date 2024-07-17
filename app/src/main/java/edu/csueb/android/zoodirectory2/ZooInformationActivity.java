package edu.csueb.android.zoodirectory2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ZooInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_information);


        TextView zooNameTextView = findViewById(R.id.zooNameTextView);
        Button phoneNumberButton = findViewById(R.id.phoneNumberButton);


        zooNameTextView.setText("Nico's Zoo");
        phoneNumberButton.setText("888-8888");


        phoneNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:8888888"));
                startActivity(dialIntent);
    }
});
}
}
