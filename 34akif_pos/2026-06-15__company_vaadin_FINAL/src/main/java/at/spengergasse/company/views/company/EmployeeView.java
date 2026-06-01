package at.spengergasse.company.views.company;

import at.spengergasse.company.model.Company;
import at.spengergasse.company.model.CompanyException;
import at.spengergasse.company.model.Employee;
import at.spengergasse.company.util.UIFactory;
import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.*;


@PageTitle("EmployeeView")
@Route(value = "employee", layout = MainLayout.class)
public class EmployeeView extends VerticalLayout implements HasUrlParameter<Long> {

    private final TextField firstName = new TextField("First name");
    private final TextField lastName = new TextField("Last name");
    private final EmailField email = new EmailField("Email address");
    private final TextField phone = new TextField("Phone number"); // TODO introduce custom field
    private final DatePicker dateOfBirth = new DatePicker("Birthday");
    private final ComboBox<Employee.Role> role = new ComboBox<>("Role");
    // private final TextField salary = new TextField("Salary");
    private final IntegerField salary = new IntegerField("Salary");
    private final Checkbox subcontractor = new Checkbox("Subcontractor");


    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Save");

    private Employee employee;

    private Binder<Employee> binder = new Binder<>(Employee.class);

    public EmployeeView() {
        initUI();
        initHandlers();
        binder.bindInstanceFields(this);
    }

    private void initUI() {
        FormLayout form = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        role.setItems(Employee.Role.values());
        form.add(firstName, lastName, dateOfBirth, phone,
                email, role, salary, subcontractor);
        add(form);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setJustifyContentMode(JustifyContentMode.END);
        buttonLayout.setWidthFull();

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);

        add(buttonLayout);
    }

    private void initHandlers() {
        save.addClickListener(e -> saveEmployee());
        cancel.addClickListener(e -> cancelEmployee());
    }

    private void cancelEmployee() {
        System.out.println("CANCEL " + employee);
        if (employee.getId() != null) {
            UIFactory.showConfirm("Discard changes?",
                    "Are you really sure you want to discard potential changes?",
                    e -> getUI().ifPresent(ui -> ui.navigate(EmployeesListView.class)));
        } else {
            UIFactory.showNotification("Discarding changes");
            this.employee = new Employee();
            binder.readBean(this.employee);
        }
    }

    private void saveEmployee() {
        if (this.employee.getId() != null) { // employee is already working in the company
            try {
                binder.writeBean(this.employee);
                UIFactory.showNotification("Employee saved successfully!");
                getUI().ifPresent(ui -> ui.navigate(EmployeesListView.class));
            } catch (Exception e) {
                UIFactory.error("Error on saving employee.", e);
            }
        } else { // new employee to be hired
            try {
                binder.writeBean(this.employee);
                Company.getInstance().hire(this.employee);
                UIFactory.showNotification("Employee created and hired successfully!");
                getUI().ifPresent(ui -> ui.navigate(EmployeesListView.class));
            } catch (Exception e) {
                UIFactory.error("Error on hiring employee.", e);
            }
        }
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Long eId) {
        if (eId != null) { // show employee with provided id (if exists)
            System.out.println("Employee ID (URL Parameter): " + eId);
            try {
                this.employee = Company.getInstance().getEmployee(eId);
                binder.readBean(this.employee);
                save.setText("Save");
            } catch (CompanyException e) {
                UIFactory.error("No employee found with provided id", e);
            }
        } else { // empty form to create new employee
            System.out.println("No URL Parameter provided");
            this.employee = new Employee();
            binder.readBean(this.employee);
            save.setText("Create");
        }
    }

}
