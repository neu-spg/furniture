package at.spengergasse.views.pricelist;

import at.spengergasse.views.home.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Price List")
@Route("prices")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILE)
public class PriceListView extends VerticalLayout {

    public PriceListView() {
        setSpacing(false);

        VerticalLayout header = HomeView.getHeader();

        H2 priceList = new H2("Price List");
        priceList.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        FlexLayout products = new FlexLayout();
        VerticalLayout product1 = getCard("Sofas", "Zeitlose Designs für maximalen Komfort.", 899);
        VerticalLayout product2 = getCard("Esstische","Massivholz und moderne Eleganz kombiniert.", 649);
        VerticalLayout product3 = getCard("Stühle","Ergonomisch, stilvoll und langlebig.", 149);
        VerticalLayout product4 = getCard("Business Interior","Professionelle Einrichtung für Unternehmen.",2499);
        VerticalLayout product5 = getCard("Maßanfertigung","Möbel nach Ihren persönlichen Wünschen.",4999);
        products.setWidthFull();
        products.setJustifyContentMode(JustifyContentMode.CENTER);
        products.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        products.add(product1, product2, product3, product4, product5);

        Paragraph info = new Paragraph("Inklusive Steuer.");

        add(header, priceList,
                products, info);
    }

    public VerticalLayout getCard(String productName, String info, int price) {

        VerticalLayout product = new VerticalLayout();
        H2 productNameH2 = new H2(productName);
        Paragraph infoP = new Paragraph(info);
        Paragraph priceP = new Paragraph("Ab "+price+"€");

        product.setWidth("350px");
        product.setPadding(true);
        product.setSpacing(false);

        product.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px");

        product.add(productNameH2, infoP, priceP);

        return product;
    }

}
