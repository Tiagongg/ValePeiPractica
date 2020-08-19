package com.example.valepei.View;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.valepei.BuildConfig;
import com.example.valepei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    Button buttonGithub;
    Button buttonDeveloperName;
    Button buttonAppVersion;

    Context context;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        buttonAppVersion = view.findViewById(R.id.buttonVersionApp);
        buttonDeveloperName = view.findViewById(R.id.buttonDeveloperName);
        buttonGithub = view.findViewById(R.id.buttonGitHub);


        buttonAppVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Version de la APP");
                builder.setMessage(BuildConfig.VERSION_NAME);
                builder.setPositiveButton("Aceptar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        buttonDeveloperName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Nombre del Developer");
                builder.setMessage("Tiago Gonzalez");
                builder.setPositiveButton("Aceptar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        buttonGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Repositorio del Github");
                builder.setMessage("https://github.com/Tiagongg/ValePeiPractica");

                builder.setPositiveButton("Aceptar", null);
                builder.setNegativeButton("Ir al link", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://github.com/Tiagongg/ValePeiPractica";

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }

}
