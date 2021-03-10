package com.example.mynicestar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    TextView textVOK;
    Button buttonok;
    ImageView imagyo;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
        imagyo = findViewById(R.id.imageViewimagyo);
        registerForContextMenu(imagyo);


// *** EXPANDABLE CARD ***
        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                        "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(this)
                .load(R.drawable.imagyo)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent2)))
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imagyo);


        buttonok = (Button) findViewById(R.id.buttonok);
        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
//        cast a la vista a la que aplicamos un MENU CONTEXTUAL y la registramos
                ImageView mycontext = findViewById(R.id.imageViewimagyo);


            }
        });
    }


    //    inflamos el menu contextual con los items del menu xml correspondiente
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    // *** DIALOGO MODAL ***

    public void showAlertDialogButtonClicked(MainActivity view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
    //    builder.setTitle("Achtung!");
  //      builder.setMessage("Where do you go?");
//        builder.setIcon(R.drawable.ic_action_name_dark);


        // un XML a medida para el diálogo
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view , null));

        // add the buttons
        builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                // Intent intent = new Intent(MainActivity.this, MyWebView.class);
                //  startActivity(intent);

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Intent intent = new Intent(MainActivity.this, ConstraintSet.Motion.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.item:
           Toast toast = Toast.makeText(this, "going CONTEXT CAMERA", Toast.LENGTH_LONG);
                toast.show();
                showAlertDialogButtonClicked(MainActivity.this);

                break;
            case R.id.action_settings:

                Toast toast2 = Toast.makeText(this, "going CONTEXT SETTINGS", Toast.LENGTH_LONG);
                toast2.show();

                break;
        }
        return super.onContextItemSelected(item);
    }

    // *** SWIPEREFRESH con SNACKBAR ***

    //    construimos el Swipe y aplicamos un Listener que lanza un SnackBar y desactiva a continuación del Swipe la animación

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();


            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
            //           final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };


}
