package com.example.aldair.tpdm_u4_practica1_arriola_sanchez;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Thread hilo;
    Circulo [] cir = new Circulo[6];


    public Lienzo(Context context){
        super(context);
        cir[0] = new Circulo(this,100,100);
        cir[1] = new Circulo(this,200,200);
        cir[2] = new Circulo(this,300,300);
        cir[3] = new Circulo(this,400,400);
        cir[4] = new Circulo(this,500,500);
        cir[5] = new Circulo(this,600,600);
        hilo = new Thread() {

            public void run() {
                while (true) {
                    for(int i = 0; i < cir.length;i++){
                        cir[i].desplazarX();
                        cir[i].desplazarY();
                    }

                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postInvalidate();
                }
            }
        };
        hilo.start();
    }

    public void bordes(Circulo ci , Canvas ca){
        if((ci.x + ci.tam) >= ca.getWidth()){
            ci.movX = ci.movX*-1;
        }
        if((ci.x - ci.tam) < 1){
            ci.movX = ci.movX*-1;
        }
        if((ci.y + ci.tam) >= ca.getHeight()){
            ci.movY = ci.movY*-1;
        }
        if((ci.y - ci.tam) < 1){
            ci.movY = ci.movY*-1;
        }
    }

    protected void onDraw (Canvas c){
        Paint p = new Paint();
        for(int i = 0; i< cir.length;i++){
            cir[i].pintar(c,p);
            bordes(cir[i],c);
        }
    }

    public boolean onTouchEvent(MotionEvent e){
        return true;
    }

}
