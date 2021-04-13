/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;


class WrapperDVD {
    DigitalVideoDisc dvd;

    public WrapperDVD(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }
}

public class TestPassingParameter {
    
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new  DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        
        WrapperDVD wrdvd1 = new WrapperDVD(jungleDVD);
        WrapperDVD wrdvd2 = new WrapperDVD(cinderellaDVD);
        
        swapDVDbyWrap(wrdvd1, wrdvd2);
        System.out.println("jungle dvd title: " + wrdvd1.dvd.getTitle());
        System.out.println("cinderella dvd title: " + wrdvd2.dvd.getTitle());
        
        //changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    
    public static void swapDVDbyWrap(WrapperDVD wrdvd1, WrapperDVD wrdvd2) { //remember to rewrite (use wrapper or not, i don't know)
        DigitalVideoDisc tmp = wrdvd1.dvd;
        wrdvd1.dvd = wrdvd2.dvd;
        wrdvd2.dvd = tmp;
    }
    
    /*public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }*/
    
}
