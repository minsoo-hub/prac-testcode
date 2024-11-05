package sample.practestcode.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import sample.practestcode.unit.beverage.Americano;
import sample.practestcode.unit.beverage.Latte;

class CafeKioskTest {

    @Test
    public void add_manual_test() {

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료: " + cafeKiosk.getBeverages().get(0).getName());

    }
    
    @Test
    public void add() {
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        //when
        cafeKiosk.add(new Americano());
        //then
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    public void remove() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);
        assertThat(cafeKiosk.getBeverages()).hasSize(1); // hasSize

        cafeKiosk.remove(americano);
        assertThat(cafeKiosk.getBeverages()).isEmpty(); // isEmpty
    }

    @Test
    public void clear() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);
        assertThat(cafeKiosk.getBeverages()).hasSize(2);

        cafeKiosk.clear();
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

}