package at.spengergasse.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureProductTest {

    @Test
    public void testToString() {
        FurnitureProduct f = null;
        try {
            f = new FurnitureProduct(LocalDate.now(), "Table", "Wood", 200.0, 1, false);
        }
        catch (FurnitureProductException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(f);
        System.out.println(f.getProductionDate());
        System.out.println(f.getProductName());
        f.setProductName("Desk");
        System.out.println(f.getProductName());
    }

    @Test
    public void testWrongPrice() {
        FurnitureProduct f = null;
        try {
            f = new FurnitureProduct(LocalDate.now(), "Table", "Wood", 200.0, 1, false);
            System.out.println(f);
            assertEquals(1,0);
        }
        catch (FurnitureProductException e) {
            System.out.println(e.getMessage());
            assertEquals(1,1);
        }

    }


}