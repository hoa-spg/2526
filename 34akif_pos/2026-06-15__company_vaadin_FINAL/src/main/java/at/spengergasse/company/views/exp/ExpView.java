package at.spengergasse.company.views.exp;

import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * This is a demo for javascript interaction.
 * See also  frontend/exp-script.js
 */

@PageTitle("ExpView")
@Route(value = "expview", layout = MainLayout.class)
@JsModule("exp-script.js")
public class ExpView extends VerticalLayout {

    private final Button btn1 = new Button("Button 1");
    private final Button btn2 = new Button("Button 2");
    public ExpView() {
        initUI();
    }

    public void initUI() {
        btn1.addClickListener(e -> onClickBtn1());
        add(btn1, btn2);

        UI.getCurrent().getPage().executeJs("return ns.init($0, $1)", btn2, this);
    }

    private void onClickBtn1() {
        UI.getCurrent().getPage().executeJs("ns.toggle()");
    }

    @ClientCallable
    public String add(int a, int b) {
        return "Ergebnis: " + (a+b) + " ;-)";
    }
}
