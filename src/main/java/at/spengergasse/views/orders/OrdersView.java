package at.spengergasse.views.orders;

import at.spengergasse.domain.FurnitureProduct;
import at.spengergasse.domain.FurnitureProductException;
import at.spengergasse.service.FurnitureOrderService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Orders")
@Route("orders")
@Menu(order = 1, icon = LineAwesomeIconUrl.FILE)
public class OrdersView extends VerticalLayout {
    private final Button buttonRemoveAllOrders = new Button("Remove all");
    private final Button buttonAdd10Orders = new Button("Add 10 orders");
    private final Button buttonAdd1Euro = new Button("Add 1 Euro");
    private final Button buttonRemoveAllAssemblyServices = new Button("Remove assembly services");
    private final Button buttonAddWrong = new Button("Add Wrong");
    private final Grid<FurnitureProduct> grid = new Grid<>(FurnitureProduct.class, true);
    private final FurnitureOrderService furnitureOrderService;

    public OrdersView(@Autowired FurnitureOrderService furnitureOrderService) {
        this.furnitureOrderService = furnitureOrderService;

        setSpacing(true);
        setSizeFull();
        grid.setSizeFull();

        buttonRemoveAllOrders.addClickListener(event -> removeAllOrders());
        buttonAdd10Orders.addClickListener( event -> add10Orders());
        buttonAdd1Euro.addClickListener(event -> add1Euro());
        buttonRemoveAllAssemblyServices.addClickListener(event -> removeAllAssemblyServices());
        buttonAddWrong.addClickListener(event -> addWrongFurnitureProduct());
        add(new HorizontalLayout(buttonRemoveAllOrders, buttonAdd10Orders, buttonAdd1Euro, buttonRemoveAllAssemblyServices, buttonAddWrong));

        add(grid);
        reload();

    }

    private void addWrongFurnitureProduct() {
        try {
            furnitureOrderService.addWrongFurnitureProduct();
            reload();
        }
        catch (FurnitureProductException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void removeAllAssemblyServices() {
     try {
         furnitureOrderService.removeAllAssemblyServices();
         reload();
     }
     catch (FurnitureProductException e) {
            Notification.show(e.getMessage());
            reload();
     }
    }

    private void add1Euro() {
        try {
            furnitureOrderService.add1Euro();
            reload();
        }
        catch (FurnitureProductException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void add10Orders() {
        try {
            furnitureOrderService.add10Orders();
            buttonRemoveAllOrders.setEnabled(true);
            buttonRemoveAllAssemblyServices.setEnabled(true);
            reload();
        }

        catch (FurnitureProductException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void removeAllOrders() {
       try {
           furnitureOrderService.removeAllOrders();
           buttonRemoveAllOrders.setEnabled(false);
           buttonRemoveAllAssemblyServices.setEnabled(false);
           reload();
       }
       catch (FurnitureProductException e) {
           Notification.show(e.getMessage());
           reload();
       }
    }

    private void reload() {
        grid.setItems(furnitureOrderService.findAll());
    }

}
