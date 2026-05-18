package at.spengergasse.company.util;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class UIFactory {

    private UIFactory() {

    }

    public static void showNotification(String msg) {
        Notification.show(msg);
    }

    public static void showError(Throwable throwable) {
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setHeader("Error!");
        dialog.setText(throwable.getMessage());
        dialog.setCancelable(false);
        dialog.setConfirmText("OK");
        dialog.open();
    }

    public static void showConfirm(String header, String text,
                                   ComponentEventListener<ConfirmDialog.ConfirmEvent> listener)
    {
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setHeader(header);
        dialog.setText(text);
        dialog.setCancelable(true);
        dialog.setConfirmText("Confirm");
        dialog.setConfirmButtonTheme("error primary");
        dialog.addConfirmListener(listener);
        dialog.open();
    }

    public static void error(String header, Throwable e) {
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        e.printStackTrace();

        Div text = new Div(
                new Text(header),
                new Paragraph(readCause(e))
        );

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants( ButtonVariant.LUMO_TERTIARY_INLINE );
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> notification.close());
        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        notification.add(layout);
        notification.open();
    }

    private static String readCause(Throwable e) {
        Throwable rootCause = e.getCause();
        if (rootCause == null) {
            return e.getMessage();
        }

        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }

        return rootCause != null ? rootCause.getMessage()
                                 : "Unknown Error! " + e.getMessage();
    }
}
