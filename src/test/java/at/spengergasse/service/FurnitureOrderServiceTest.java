package at.spengergasse.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureOrderServiceTest {

    @Test
    void testToString() {
        FurnitureOrderService furnyOrdi = new FurnitureOrderService();
        furnyOrdi.fillTestData();
        System.out.println(furnyOrdi);
    }
}