package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode (of = "furnitureId", callSuper = false)
@Entity
public class Furniture {
    @Id
    private Long furnitureId;
    private LocalDate productionDate;
    private String    productName;
    private String    material;
    private Double    price;
    private Integer   quantity;
    private Boolean   assemblyService;

    private static final AtomicLong sequence = new AtomicLong(1000);

    public void setFurnitureId() {
        this.furnitureId = sequence.getAndIncrement();
    }

    public Furniture(Long furnitureId) {
        setFurnitureId();
        setProductionDate(LocalDate.now());
        setProductName("Uknk");
        setMaterial("normal");
        setPrice(10.0);
        setQuantity(5);
        setAssemblyService(false);
    }

    public Furniture(LocalDate productionDate, String productName, String material, Double price, Integer quantity, Boolean assemblyService) {
        setFurnitureId();
        setProductionDate(productionDate);
        setProductName(productName);
        setMaterial(material);
        setPrice(price);
        setQuantity(quantity);
        setAssemblyService(assemblyService);
    }
}
