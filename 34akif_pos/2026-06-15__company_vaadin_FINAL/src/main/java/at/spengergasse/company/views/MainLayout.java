package at.spengergasse.company.views;

import at.spengergasse.company.views.about.AboutView;
import at.spengergasse.company.views.calculator.Calculator;
import at.spengergasse.company.views.company.CompanyView;
import at.spengergasse.company.views.company.EmployeeView;
import at.spengergasse.company.views.company.EmployeesListView;
import at.spengergasse.company.views.exp.ExpView;
import at.spengergasse.company.views.helloworld.HelloWorldView;
import at.spengergasse.company.views.ticketautomat.TicketAutomatView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;


/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Company");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private Component createNavigation() {
        VerticalLayout nav = new VerticalLayout();
        nav.setSpacing(true);
        nav.add(
                createNavItem("Hello 4AKIF", HelloWorldView.class, VaadinIcon.GLOBE),
                createNavItem("About", AboutView.class, VaadinIcon.FILE),
                createNavItem("Ticket-Automat", TicketAutomatView.class, VaadinIcon.TICKET),
                createNavItem("Calculator", Calculator.class, VaadinIcon.CALC),

                createNavItem("CompanyView", CompanyView.class, VaadinIcon.BUILDING_O),
                createNavItem("EmployeesList", EmployeesListView.class, VaadinIcon.TABLE),
                createNavItem("Employee", EmployeeView.class, VaadinIcon.USER),

                createNavItem("Javascript", ExpView.class, VaadinIcon.SCREWDRIVER)

                );

        return nav;
    }

    private RouterLink createNavItem(String label, Class<? extends Component> view,
                                     VaadinIcon icon) {
        RouterLink link = new RouterLink(view);
        link.addClassName("nav-item");
        link.setHighlightCondition(HighlightConditions.locationPrefix());
        link.add(new Icon(icon), new Text(" " + label));
        return link;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
