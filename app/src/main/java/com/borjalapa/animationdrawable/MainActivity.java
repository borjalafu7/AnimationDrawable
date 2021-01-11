 package com.borjalapa.animationdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

 public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    AnimationDrawable animationDrawable;

    //metemos todas las imagenes como vector asset y luego hacemos un recurso con una lista de las diferentes partes de la animacion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.ivCheck);

        //iniciamos la animacion cuando clickemos pero solo puedes hacerlo 1 vez entonces hay 2 soluciones para ese problema
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sol1();

                sol2();
            }
        });

    }

    //la mejor solucion es esta
     private void sol2() {
         imageView.setBackground(null);

         //a nuestro imageview le metemos de recurso el archivo de animaciones
         imageView.setBackgroundResource(R.drawable.animacion_check);

         //luego le metemos al animationDrawable el backgruond del imageView
         animationDrawable = (AnimationDrawable)imageView.getBackground();

         animationDrawable.start();
     }

     //solucion
     private void sol1() {
         //a nuestro imageview le metemos de recurso el archivo de animaciones
         imageView.setBackgroundResource(R.drawable.animacion_check);

         //luego le metemos al animationDrawable el backgruond del imageView
         animationDrawable = (AnimationDrawable)imageView.getBackground();

         //esto hará la animacion en bucle
         animationDrawable.setOneShot(false);

         animationDrawable.start();
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 animationDrawable.stop();
             }
         }, 1000);
     }
 }