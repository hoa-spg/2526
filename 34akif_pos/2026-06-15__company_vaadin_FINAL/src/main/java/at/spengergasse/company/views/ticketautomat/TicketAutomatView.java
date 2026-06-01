package at.spengergasse.company.views.ticketautomat;

import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.List;

@PageTitle("TicketAutomat")
@Route(value = "ticket-automat", layout = MainLayout.class)
public class TicketAutomatView extends VerticalLayout {

    private static final List<String> stops = List.of("Stephansplatz", "Spengergasse", "Margaretengürtel", "Schönbrunn", "Westbahnhof");
    final private FormLayout personData = new FormLayout();
    final private HorizontalLayout tripData = new HorizontalLayout();
    final private HorizontalLayout ticketData = new HorizontalLayout();
    final private VerticalLayout ticket = new VerticalLayout();


    final private TextField firstName = new TextField();
    final private TextField lastName = new TextField();

    final private EmailField email = new EmailField();

    final private Select<String> origin = new Select();
    final private Select<String>  destination = new Select();

    final private RadioButtonGroup<String> ticketType = new RadioButtonGroup<>();

    final private IntegerField quantity = new IntegerField();

    final private Checkbox dayTicket = new Checkbox();

    final private Button buyTicket = new Button();

    final private TextArea printedTicket = new TextArea();

    public TicketAutomatView() {
        initUI();
        addEventHandlers();
    }

    private void initUI() {
        setWidth("80%");
        setPadding(true);
        setMargin(true);

        firstName.setLabel("First Name");
        firstName.setPlaceholder("First Name");

        lastName.setLabel("Last Name");
        lastName.setPlaceholder("Last Name");

        email.setLabel("Email");
        personData.add(firstName, lastName, email);
        personData.setColspan(email, 2);

        origin.setLabel("Origin");
        origin.setItems(stops);
        destination.setLabel("Destionation");
        destination.setItems(stops);
        tripData.add(origin, destination);
        tripData.setFlexGrow(1, origin);
        tripData.setFlexGrow(2, destination);

        ticketType.setLabel("Ticket-Type");
        ticketType.setItems("Standard", "Discount");
        ticketType.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);

        dayTicket.setLabel("Day Ticket");

        quantity.setLabel("Quantity");
        quantity.setMin(1);
        quantity.setMax(10);
        quantity.setStep(1);

        buyTicket.setText("Buy Ticket");
        Style style = buyTicket.getStyle();
        style.set("border", "thin solid red" );
        style.set("box-shadow", "5px 5px 5px gray");
        ticketData.add(ticketType, dayTicket, quantity);

        printedTicket.setWidth("80%");
        printedTicket.setHeight("200px");
        printedTicket.setReadOnly(true);

        printedTicket.setValue("Your ticket will be printed here!");

        add(personData, tripData, ticketData, ticket, buyTicket, printedTicket);


    }

    private void addEventHandlers() {
        buyTicket.addClickListener(event -> onBuyTicketClicked());
        dayTicket.addClickListener(event -> onDayTicketChanged());
    }

    private void onDayTicketChanged() {
        origin.setEnabled(!dayTicket.getValue());
        destination.setEnabled(!dayTicket.getValue());
    }

    private void onBuyTicketClicked() {
        boolean error = false;
        StringBuilder sb = new StringBuilder();
        if (firstName.getValue() == null || firstName.getValue().length() < 2) {
            error = true;
            sb.append("Invalid firstname; ");
        }
        if (lastName.getValue() == null || lastName.getValue().length() < 2) {
            error = true;
            sb.append("Invalid lastname; ");
        }
        if (email.getValue() == null || email.getValue().length() < 2) {
            error = true;
            sb.append("Invalid email; ");
        }
        if (!dayTicket.getValue()) {
            if (origin.getValue() == null) {
                error = true;
                sb.append("Invalid origin; ");
            }
            if (destination.getValue() == null) {
                error = true;
                sb.append("Invalid destination; ");
            }
        }
        if (ticketType.getValue() == null) {
            error = true;
            sb.append("Invalid ticket type; ");
        }
        if (quantity.getValue() == null) {
            error = true;
            sb.append("Invalid quantity; " );
        }



        if (error) {
            printedTicket.setValue("INVALID VALUES: " + sb.toString());
        } else {
            StringBuilder ticket = new StringBuilder();
            ticket.append("==================================================\n");
            if (dayTicket.getValue()) {
                ticket.append("Dayticket valid for ").append(LocalDate.now()).append("\n");
            } else {
                ticket.append("Ticket from ").append(origin.getValue()).append(" to ").append(destination.getValue()).append("\n");
            }
            ticket.append("Passenger: ").append(firstName.getValue()).append(" ").append(lastName.getValue()).append("\n");
            ticket.append("Valid for ");

            ticket.append("\n");
            ticket.append("Number of trips: ").append(quantity.getValue()).append("\n");
            if (ticketType.getValue().equals("Discount")) {
                ticket.append("Discounted Ticket\n");
            }
            ticket.append("==================================================\n");
            printedTicket.setValue(ticket.toString());
        }



//        System.out.println("Buy clicked!");
    }


}
