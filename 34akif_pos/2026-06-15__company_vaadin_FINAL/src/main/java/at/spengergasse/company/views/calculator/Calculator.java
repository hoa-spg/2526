package at.spengergasse.company.views.calculator;

import at.spengergasse.company.util.UIFactory;
import at.spengergasse.company.views.MainLayout;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("BaseCalculator")
@Route(value = "calculator", layout = MainLayout.class)
public class Calculator extends VerticalLayout {

    private enum Operators { ADD, SUB, MUL, DIV };
    private enum Base {
        BIN(2), DEC(10), HEX(16);
        private int numVal;

        Base(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }
    };

    private final TextField operand1 = new TextField("Operand 1");
    private final TextField operand2 = new TextField("Operand 2");

    private final Select<Operators> operation = new Select<>();

    private final Select<Base> base = new Select<>();

    private final Button calculate = new Button("Calculate");
    private final TextField result = new TextField("Result");

    private Integer op1, op2;

    public Calculator() {
        initUI();
    }

    private void initUI() {
        operation.setLabel("Operation");
        operation.setItems(Operators.values());
        operation.setValue(Operators.ADD);

        base.setLabel("Base");
        base.setItems(Base.values());
        base.setValue(Base.DEC);

        base.addValueChangeListener(e -> onBaseValueChanged(e));

        result.setReadOnly(true);
        calculate.addClickListener(e -> onCalculatePressed());
        add(operand1, operand2, operation, base, calculate, result);
    }

    private void onCalculatePressed() {
        boolean ok = validateInputs();
        if (ok) {
            UI.getCurrent().getPage().executeJs("console.log($0)", "Validation successful");
            // UIFactory.showNotification("Validation successful!");
            performCalculation();
        } else {
            UI.getCurrent().getPage().executeJs("console.log($0)", "Validation unsuccessful");
            UIFactory.showNotification("Validation unsuccessful");
        }

    }

    private boolean validateInputs() {
        if (this.operand1.getValue() == null) {
            UIFactory.showNotification("First operand is empty");
            return false;
        }
        if (this.operand2.getValue() == null) {
            UIFactory.showNotification("Second operand is empty");
            return false;
        }

        try {
            op1 = Integer.parseInt(this.operand1.getValue(), base.getValue().getNumVal());
        } catch (NumberFormatException e) {
            UIFactory.showNotification("First operand does not contain a valid number.");
            return false;
        }

        try {
            op2 = Integer.parseInt(this.operand2.getValue(), base.getValue().getNumVal());
        } catch (NumberFormatException e) {
            UIFactory.showNotification("Second operand does not contain a valid number.");
            return false;
        }
        return true;
    }

    private void performCalculation() {
        try {
            Integer result = switch (operation.getValue()) {
                case ADD -> op1 + op2;
                case SUB -> op1 - op2;
                case MUL -> op1 * op2;
                case DIV -> op1 / op2;
            };
            System.out.println("performCalculation: result: " + result);
            String resString = switch (base.getValue()) {
                case DEC -> result.toString();
                case BIN -> Integer.toBinaryString(result);
                case HEX -> result >= 0 ? Integer.toHexString(result) : "-" + Integer.toHexString(Math.abs(result));
            };


            this.result.setValue(resString);
        } catch (ArithmeticException e) {
            this.result.setValue("undefined");
        }
    }

    private void onBaseValueChanged(AbstractField.ComponentValueChangeEvent<Select<Base>, Base> e) {

         // Uebung fuer 4. Juni (Teil 1)

//        int oldBase = e.getOldValue().getNumVal();
//        int newBase = e.getValue().getNumVal();
//
//        boolean ok = validateInputs() mit parameter
//        Integer op1BaseDec = op1.intValue();
//        if (oldBase != Base.DEC.getNumVal()) {
//
//        }
    }



}
