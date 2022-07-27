package com.example.computerbbdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ComputerAdapter extends ArrayAdapter<Computer> {
    private int resourceLayout;
    private Context mContext;

    public ComputerAdapter(@NonNull Context context, int resource, @NonNull List<Computer> objects) {
        super(context, resource, objects);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            v = layoutInflater.inflate(resourceLayout, null);
        }
        Computer computer = getItem(position);
        if (computer != null) {
            TextView marca = v.findViewById(R.id.tv_marca);
            TextView cpu = v.findViewById(R.id.tv_cpu);
            TextView os = v.findViewById(R.id.tv_os);
            TextView precio = v.findViewById(R.id.tv_precio);

            if (marca != null) {
                marca.setText(computer.getMarca());
            }
            if (cpu != null) {
                cpu.setText(computer.getCpu());
            }
            if (os != null) {
                os.setText(computer.getOs());
            }
            if (precio != null) {
                precio.setText(""+computer.getPrecio());
            }
        }
        return v;

    }
}