package at.spengergasse.views.home;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.GLOBE_SOLID)
public class HomeView extends VerticalLayout {

    private TextField name;
    private Button sayHello;

    public HomeView() {

        setSpacing(false);
        setAlignItems(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayout header = getHeader();

        HorizontalLayout logoText = new HorizontalLayout();
        Image logo = new Image("images/furniture-logo.png", "Furniture Logo");
        logo.setWidth("400px");
        Paragraph line1 = new Paragraph("Furniture steht für zeitloses Design, hochwertige Materialien und echte Handwerkskunst. Unser Möbelunternehmen verbindet moderne Ästhetik mit Funktionalität und schafft Einrichtungslösungen, die Wohn- und Arbeitsräume stilvoll aufwerten. Jedes Möbelstück wird mit Liebe zum Detail entworfen, um Komfort, Qualität und Langlebigkeit perfekt miteinander zu vereinen.");
        line1.setWidth("500px");
        line1.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        logoText.add(logo, line1);

        Paragraph line2 = new Paragraph("Bei Furniture legen wir großen Wert auf individuelle Gestaltung und persönliche Beratung. Ob elegante Wohnzimmermöbel, moderne Essbereiche oder maßgeschneiderte Lösungen für Unternehmen – wir entwickeln Konzepte, die genau zu den Bedürfnissen und dem Stil unserer Kundinnen und Kunden passen. Dabei stehen Nachhaltigkeit, hochwertige Verarbeitung und ein harmonisches Raumgefühl stets im Mittelpunkt.");
        line1.setWidth("500px");
        line2.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        Paragraph line3 = new Paragraph("Unser Ziel ist es, Räume zu schaffen, in denen Menschen sich wohlfühlen und inspirieren lassen. Mit einem Gespür für Trends, klaren Linien und langlebigen Materialien bietet Furniture Möbel, die Design und Alltag perfekt verbinden. Wir glauben daran, dass gute Einrichtung nicht nur schön aussieht, sondern das Leben jeden Tag ein Stück angenehmer macht.");
        line3.setWidth("500px");
        line3.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        HorizontalLayout address = new HorizontalLayout();
        H3 name = new H3("Furniture GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");
        address.add(name, street, city);

        add(header, logoText, line2, line3, address);

    }

    public static VerticalLayout getHeader() {

        VerticalLayout header;

        header = new VerticalLayout();
        H1 company = new H1("Furniture");
        company.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subName = new H2("... there's no other ...");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        header.add(company, subName);
        return header;
    }

}
