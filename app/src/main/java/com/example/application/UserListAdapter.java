package com.example.application;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        List<User> userList = users;
        userList.sort(User.comparator); // Sort users here
        holder.userName.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.currentDegree.setText(users.get(position).getDegreeProgram());
        holder.userEmail.setText(users.get(position).getEmail());
        holder.profilePicture.setImageResource(users.get(position).getImage());

        // If user has no completed degrees, we simply won't set anything
        if(users.get(position).getDegrees().size() != 0) {
            holder.completedDegrees.setText("Suoritetut tutkinnot:");
            // Iterating through the degree list with for each -loop
            for (String degree : users.get(position).getDegrees()) {
                TextView textView = new TextView(this.context);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.WHITE);
                textView.setText("- " + degree);
                holder.degreeLayout.addView(textView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}