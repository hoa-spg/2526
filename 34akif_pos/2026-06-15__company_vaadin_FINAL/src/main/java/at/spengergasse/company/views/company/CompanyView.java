package at.spengergasse.company.views.company;

import at.spengergasse.company.model.Company;
import at.spengergasse.company.model.CompanyException;
import at.spengergasse.company.util.UIFactory;
import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.io.InputStream;

@PageTitle("CompanyView")
@Route(value = "company", layout = MainLayout.class)
public class CompanyView extends VerticalLayout {

    private final TextField companyName = new TextField("Company Name");
    private final TextField companyAddress = new TextField("Company Address");
    private final Button save = new Button("Save");
    private final Button cancel = new Button("Cancel");
    private final FormLayout formLayout = new FormLayout();

    private final Details inputOuputLayout = new Details("Input/Output");

    private final Button saveToFile = new Button("Save to File");

    private final MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
    private Upload loadFromFile;

    private Company company = Company.getInstance();

    Binder<Company> binder = new Binder<>(Company.class);

    public CompanyView() {

        loadFromFile = new Upload(buffer);

        initUI();
        initHandlers();

        System.out.println("Company: " + this.company);
        binder.bindInstanceFields(this);
        binder.readBean(this.company);
    }

    private void initUI() {
        setWidth("80%");

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setJustifyContentMode(JustifyContentMode.END);
        buttonLayout.setWidthFull();

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);

        formLayout.add(companyName, companyAddress);

        HorizontalLayout fileIoHorizontalLayout = new HorizontalLayout();
        fileIoHorizontalLayout.add(saveToFile, loadFromFile);
        inputOuputLayout.add(fileIoHorizontalLayout);

        add(formLayout, buttonLayout, inputOuputLayout);
    }

    private void initHandlers() {
        save.addClickListener(e -> onSaveClicked());
        cancel.addClickListener(e -> onCancelClicked());

        saveToFile.addClickListener(e -> saveToFile());
        loadFromFile.addSucceededListener(e -> loadFromFile(e));
    }

    private void loadFromFile(SucceededEvent e) {
        String fileName = e.getFileName();
        UIFactory.showNotification("File " + fileName + " successfully uploaded!");

        InputStream inputStream = buffer.getInputStream(fileName);
        try {
            Company.loadFromFile(inputStream);
            UIFactory.showNotification("Company successfully loaded!");
        } catch (CompanyException ex) {
            UIFactory.error("Error on processing file", ex);
        }

    }

    private void saveToFile() {
        final String filename = "company.csv";
        try {
            Company.getInstance().writeToFile(filename);
            UIFactory.showNotification("Saved to file.");
        } catch (CompanyException e) {
            UIFactory.error("Could not write to file company.csv", e);
        }
    }

    private void onSaveClicked() {
        System.out.println("save clicked");
        try {
            binder.writeBean(this.company);
        } catch (Exception e) {
            UIFactory.error("Error", e);
        }
        System.out.println(this.company);
    }

    private void onCancelClicked() {
        System.out.println("cancel clicked");
        UIFactory.showConfirm("Discard changes",
                        "Are you really, really sure, to discard all changes?",
                            e -> {
                                System.out.println("OK WE REALLY WANT TO RESET TO INITIAL VALUES");
                                binder.readBean(this.company);
                            });
        System.out.println(this.company);
    }
}
