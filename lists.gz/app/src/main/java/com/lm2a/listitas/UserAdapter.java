package com.lm2a.listitas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<Usuario> {

    private int resourceLayout;
    private Context mContext;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<Usuario> objects) {
        super(context, resource, objects);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v==null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            v = layoutInflater.inflate(resourceLayout, null);

        }

        Usuario usuario = getItem(position);
        if(usuario != null){
            TextView name = v.findViewById(R.id.tv_nombre);
            TextView email = v.findViewById(R.id.tv_email);
            if(name!=null){
                name.setText(usuario.getName());
            }
            if(email!=null){
                email.setText(usuario.getEmail());
            }
        }


        return v;
    }
}
