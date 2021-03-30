package hust.soict.hedspi.test.order;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.order.*;
public class TestOrder{
    public static void main (String[] args){
        Order anOrder = new Order();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        anOrder.addDigitalVideoDisc(dvd2,dvd3);

        // DigitalVideoDisc [] dvd = new DigitalVideoDisc [2];
        // dvd[0] = new DigitalVideoDisc("The Lion King");
        // dvd[0].setCategory("Animation");
        // dvd[0].setCost(19.95f);
        // dvd[0].setDirector("Roger Allers");
        // dvd[0].setLength(87);

        // dvd[1] = new DigitalVideoDisc("Star Wars");
        // dvd[1].setCategory("Science Fiction");
        // dvd[1].setCost(24.95f);
        // dvd[1].setDirector("George Lucas");
        // dvd[1].setLength(124);

        // anOrder.addDigitalVideoDisc(dvd);

        anOrder.print();
    }
}