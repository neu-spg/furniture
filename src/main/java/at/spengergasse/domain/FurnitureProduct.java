package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "Furniture production date is required!")
    @PastOrPresent(message = "Furniture production only in the past or present!")
    private LocalDate productionDate;
    @NotBlank(message = "Product name is required!")
    @Size(min=3, max=100, message = "Wrong name")
    private String    productName;
    @NotNull(message = "Material is required!")
    @Pattern(
            regexp = "Plastic|Wood|Metal|Customized",
            message = "Material must be Plastic, Wood, Metal or Customized"
    )
    private String    material;
    @NotNull(message = "Price is required!")
    @DecimalMin(value = "500.0", message = "Minimum 500 EUR")
    @DecimalMax(value = "10000.0", message = "Maximal 10.000 EUR")
    private Double    price;
    @NotNull(message = "Quantity is required!")
    @Min(value = 1, message = "Minimum 1 piece!")
    @Max(value = 1000, message = "Maximum 1000 pieces!")
    private Integer   quantity;
    @NotNull(message = "Assembly information is required!")
    private Boolean   assemblyService;

    private static final AtomicLong sequence = new AtomicLong(1000);

    public FurnitureProduct() {
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
        this.material = materialType;
    }

    @Override
    public FurnitureProduct clone() {
        return new FurnitureProduct(furnitureId, productionDate, productName, material, price, quantity, assemblyService);
    }

}
