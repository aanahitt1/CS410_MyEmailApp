package com.example.myemailapp;

import android.view.View;
import android.widget.TextView;

import com.example.myemailapp.R;

import static android.support.v7.widget.RecyclerView.ViewHolder;


class EmailViewHolder extends ViewHolder {

        TextView icon;
        TextView emailSender;
        TextView emailSubject;
        TextView emailDate;

        EmailViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            emailSender = itemView.findViewById(R.id.emailSender);
            emailSubject = itemView.findViewById(R.id.emailSubject);
            emailDate = itemView.findViewById(R.id.emailDate);
        }
}
