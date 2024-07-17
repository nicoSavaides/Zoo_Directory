package edu.csueb.android.zoodirectory2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import edu.csueb.android.zoodirectory2.R;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private Context context;
    private List<Animal> animalList;

    public AnimalAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item, parent, false);
        return new AnimalViewHolder(view);
    }






    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);

        holder.nameTextView.setText(animal.getName());
        holder.thumbnailImageView.setImageResource(animal.getThumbnailImage());

        holder.itemView.setOnClickListener(v -> {
            if (position == animalList.size() - 1) {
                new AlertDialog.Builder(context)
                        .setTitle("Warning")
                        .setMessage("This animal is very scary. Do you want to proceed?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            Intent intent = new Intent(context, AnimalDetailActivity.class);
                            intent.putExtra("animal", animal); // Pass the Animal object
                            context.startActivity(intent); // Start the activity
                        })
                        .setNegativeButton("No", null)
                        .show();
            } else {
                Intent intent = new Intent(context, AnimalDetailActivity.class);
                intent.putExtra("animal", animal);
                context.startActivity(intent);
            }
        });
    }








    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailImageView;
        public TextView nameTextView;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }
}
