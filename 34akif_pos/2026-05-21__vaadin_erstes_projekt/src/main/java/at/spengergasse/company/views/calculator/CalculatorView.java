package at.spengergasse.company.views.calculator;

import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Calculator")
@Route(value = "calc", layout = MainLayout.class)
public class CalculatorView extends VerticalLayout {

    private final TextField operand1;
    private final TextField operand2;
    private final Button calculateBtn;
    private final TextField result;

    public CalculatorView() {
        operand1 = new TextField("Operand 1", "0");
        operand2 = new TextField("Operand 2", "0");
        calculateBtn = new Button("Berechnen");
        result = new TextField("Ergebnis", "0");
        add(operand1, operand2, calculateBtn, result);

        calculateBtn.addClickListener((event) -> {
            int i1 = Integer.parseInt(operand1.getValue());
            int i2 = Integer.parseInt(operand2.getValue());
            result.setValue("" + (i1+i2));
        });
    }

}
