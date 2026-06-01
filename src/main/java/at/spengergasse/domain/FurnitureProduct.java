package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode (of = "furnitureId", callSuper = false)
@Entity
public class FurnitureProduct {
    @Id
    private Long furnitureId;
    private LocalDate productionDate;
    private String    productName;
    private String    material;
    private Double    price;
    private Integer   quantity;
    private Boolean   assemblyService;

    private static final AtomicLong sequence = new AtomicLong(1000);
    private static final String[] materialTypes = {"Plastic", "Wood", "Metal", "Customized"};


    public FurnitureProduct() {
        setFurnitureId();
        setProductionDate(LocalDate.now());
        setProductName("Unkn");
        setMaterial("normal");
        setPrice(10.0);
        setQuantity(5);
        setAssemblyService(false);
    }

    public FurnitureProduct(LocalDate productionDate, String productName, String material, Double price, Integer quantity, Boolean assemblyService) {
        setFurnitureId();
        setProductionDate(productionDate);
        setProductName(productName);
        setMaterial(material);
        setPrice(price);
        setQuantity(quantity);
        setAssemblyService(assemblyService);
    }

    public FurnitureProduct(Long furnitureId, LocalDate productionDate, String productName, String material, Double price, Integer quantity, Boolean assemblyService) {
        setFurnitureId(furnitureId);
        setProductionDate(productionDate);
        setProductName(productName);
        setMaterial(material);
        setPrice(price);
        setQuantity(quantity);
        setAssemblyService(assemblyService);
    }

    public void setFurnitureId() {
        this.furnitureId = sequence.getAndIncrement();
    }

    public void setPrice(Double price) {
        if (price < 7)
            throw new FurnitureProductException("Price is too low!");
        if (price > 140)
            throw new FurnitureProductException("Price is too high!");
        this.price=price;
    }

    public void setFurnitureTypes(String materialType) {
        if (! Arrays.asList(materialTypes).contains(materialType))
            throw new FurnitureProductException("Unknown furniture Type!");
        this.material = materialType;
    }

    @Override
    public FurnitureProduct clone() {
        return new FurnitureProduct(furnitureId, productionDate, productName, material, price, quantity, assemblyService);
    }

}
