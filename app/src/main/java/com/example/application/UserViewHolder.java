package com.example.application;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView profilePicture;
    TextView userName;
    TextView userEmail;
    TextView currentDegree;
    TextView completedDegrees;
    LinearLayout degreeLayout; // New Linear Layout for completed degrees

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        profilePicture = itemView.findViewById(R.id.imageDefaultIcon);
        userName = itemView.findViewById(R.id.txtUserName);
        userEmail = itemView.findViewById(R.id.txtUserEmail);
        currentDegree = itemView.findViewById(R.id.txtUserDegree);
        completedDegrees = itemView.findViewById(R.id.txtCompletedDegrees);
        degreeLayout = itemView.findViewById(R.id.linearLayout);
    }
}
