package at.spengergasse.company.views.company;

import at.spengergasse.company.model.Company;
import at.spengergasse.company.model.CompanyException;
import at.spengergasse.company.model.Employee;
import at.spengergasse.company.util.UIFactory;
import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("EmployeesListView")
@Route(value = "employees", layout = MainLayout.class)
public class EmployeesListView extends Div {

    private static boolean AUTO_CREATE_COLUMNS = false;
    private Grid<Employee> grid;

    public EmployeesListView() {
        setSizeFull();
        grid = new Grid<>(Employee.class, AUTO_CREATE_COLUMNS);
        grid.addColumn("firstName").setAutoWidth(false);
        grid.addColumn("lastName").setAutoWidth(false);
        grid.addColumn("email").setAutoWidth(false);
        grid.addColumn("phone").setAutoWidth(false);
        grid.addColumn("dateOfBirth").setAutoWidth(false);
        grid.addColumn("role").setAutoWidth(false);
        grid.addColumn("salary").setAutoWidth(false);
        grid.addColumn("subcontractor").setAutoWidth(false);

        grid.addComponentColumn(employee -> {
            HorizontalLayout actionLayout = new HorizontalLayout();
            Button edit = new Button(new Icon(VaadinIcon.EDIT));
            edit.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_SUCCESS);
            edit.addClickListener(e -> edit(employee));
            Button delete = new Button(new Icon(VaadinIcon.TRASH));
            delete.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_ERROR);
            delete.addClickListener(e -> delete(employee));
            actionLayout.add(edit, delete);
            return actionLayout;
        }).setHeader("Action")
            .setWidth("100px")
            .setTextAlign(ColumnTextAlign.END)
            .setFrozenToEnd(true)
            .setAutoWidth(true)
            .setFlexGrow(0);

        refreshGrid();
        add(grid);
    }

    private void edit(Employee emp) {
        System.out.println("EDIT Employee: " + emp);
        if (emp != null) {
            getUI().ifPresent(ui -> ui.navigate(EmployeeView.class, emp.getId()));
        } else {
            UIFactory.showNotification("Error on editing employee!");
        }
    }

    private void delete(Employee emp) {
        if (emp != null) {
            System.out.println("DELETE Employee: " + emp);
            try {
                Company.getInstance().fire(emp.getId());
                UIFactory.showNotification("Employee " + emp.getId() + " (" + emp.getLastName() + " ) fired! Yeah!");
                refreshGrid();
            } catch (CompanyException e) {
                UIFactory.error("Could not fire employee with id " + emp.getId() + " :-(, ", e);
            }
        } else {
            UIFactory.showNotification("Error on deleting employee!");
        }
    }

    public void refreshGrid() {
        grid.setItems(Company.getInstance().getStaff());
    }
}
