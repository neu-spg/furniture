package at.spengergasse.views.orders;

import at.spengergasse.domain.FurnitureProduct;
import at.spengergasse.service.FurnitureOrderService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
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
    private final Grid<FurnitureProduct> grid = new Grid<>(FurnitureProduct.class, true);
    private final FurnitureOrderService furnitureOrderService;

    public OrdersView(@Autowired FurnitureOrderService furnitureOrderService) {
        this.furnitureOrderService = furnitureOrderService;

        setSpacing(true);
        setSizeFull();
        grid.setSizeFull();
        add(grid);
        reload();

    }

    private void reload() {
        grid.setItems(furnitureOrderService.findAll());

    }

}
