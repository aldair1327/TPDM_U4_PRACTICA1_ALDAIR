package com.example.aldair.tpdm_u4_practica1_arriola_sanchez;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo {
    int x,y,tam,movX,movY,color;

    public Circulo(Lienzo este, int posx, int posy){
        this.tam = (int)(Math.random()*250);
        x = posx;
        y = posy;

        if(Math.random()*10<5){
            movX = 50;
        }else{
            movX = -50;
        }

        if(Math.random()<5){
            movY = 50;
        }else{
            movY = -50;
        }

        int c = (int)(Math.random()*10);
        switch(c){
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.YELLOW;
                break;
            case 3:
                color = Color.GRAY;
                break;
            case 4:
                color = Color.BLACK;
                break;
            case 5:
                color = Color.MAGENTA;
                break;
            case 6:
                color = Color.CYAN;
                break;
            case 7:
                color = Color.rgb(153,51,255);
                break;
            case 8:
                color = Color.rgb(255,204,229);
                break;
            case 9:
                color = Color.rgb(102,51,0);
                break;
            case 10:
                color = Color.rgb(102,178,255);
                break;
            default:
                color = Color.rgb(0,102,51);
                break;
        }

    }

    public void desplazarX(){
        x += movX;
    }

    public void desplazarY(){
        y += movY;
    }

    public void pintar(Canvas c, Paint p){
        p.setColor(color);
        c.drawCircle(x,y,tam,p);
    }

}
