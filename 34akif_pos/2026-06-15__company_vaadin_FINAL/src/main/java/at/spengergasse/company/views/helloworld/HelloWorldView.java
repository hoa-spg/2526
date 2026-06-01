package at.spengergasse.company.views.helloworld;

import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.Key;
// import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Hello Spengergasse")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {


    private TextField name;
    private Button sayHello;

    public HelloWorldView() {
        name = new TextField("Your name");
        //<theme-editor-local-classname>
        name.addClassName("hello-world-view-text-field-1");
        sayHello = new Button("Say hello");

        ComboBox<String> classes = new ComboBox<>("Classes");
        //<theme-editor-local-classname>
        classes.setOverlayClassName("hello-world-view-combo-box-1");
        //<theme-editor-local-classname>
        classes.addClassName("hello-world-view-combo-box-1");
        List<String> classStrings = new ArrayList<>();
        classStrings.add("4AKIF");
        classStrings.add("4BKIF");
        classStrings.add("6ABIF");
        classes.setItems(classStrings);

        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue() + ", " + classes.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);


        add(name, classes, sayHello);
    }

}
