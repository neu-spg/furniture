package at.spengergasse.service;

import at.spengergasse.domain.FurnitureProduct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class FurnitureOrderService {
    private ArrayList<FurnitureProduct> furnitureProducts;

    public FurnitureOrderService() {
        furnitureProducts = new ArrayList<>(1000);
    }

    public void fillTestData() {
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,10), "Chair Basic", "Wood", 25.0, 10, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,12), "Chair Deluxe", "Wood", 45.0, 5, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,15), "Office Desk", "Metal", 120.0, 3, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,18), "Coffee Table", "Wood", 55.0, 8, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,20), "Bookshelf", "Wood", 80.0, 4, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,22), "TV Stand", "Metal", 95.0, 6, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,25), "Dining Table", "Wood", 130.0, 2, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,1,28), "Nightstand", "Wood", 35.0, 12, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,1), "Wardrobe", "Customized", 140.0, 1, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,3), "Shoe Rack", "Plastic", 20.0, 15, false));

        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,5), "Gaming Desk", "Metal", 110.0, 3, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,8), "Bar Stool", "Metal", 40.0, 10, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,10), "Kitchen Cabinet", "Wood", 135.0, 2, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,12), "Bed Frame", "Metal", 125.0, 4, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,15), "Drawer Unit", "Plastic", 30.0, 9, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,18), "Corner Shelf", "Wood", 50.0, 7, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,20), "Bench", "Wood", 60.0, 5, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,22), "Conference Table", "Metal", 138.0, 1, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,25), "Reception Desk", "Customized", 139.0, 1, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,2,28), "Filing Cabinet", "Metal", 85.0, 6, false));

        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,2), "Wall Shelf", "Wood", 22.0, 14, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,5), "Laptop Table", "Plastic", 28.0, 11, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,7), "Dining Chair", "Wood", 33.0, 20, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,10), "Garden Bench", "Metal", 75.0, 4, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,12), "Patio Table", "Plastic", 65.0, 5, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,14), "Display Cabinet", "Customized", 100.0, 2, true));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,18), "Storage Box", "Plastic", 15.0, 30, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,20), "Kids Desk", "Wood", 48.0, 8, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,22), "Rocking Chair", "Wood", 90.0, 3, false));
        furnitureProducts.add(new FurnitureProduct(LocalDate.of(2024,3,25), "Executive Desk", "Customized", 140.0, 1, true));
    }

    @Override
    public String toString() {
        String erg = "";

        for (FurnitureProduct fp : furnitureProducts) {
            erg += fp.toString() + "\n";
        }
        return erg;
    }

/*
    public String toString2() {
        return furnitureProducts.stream()
                .map(f -> f.toString())
                .collect(Collectors.joining("\n"));
    }

 */
}
