import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Controller {


    @FXML
    private TextField nomeAdd;
    @FXML
    private DatePicker data;
    @FXML
    private TextField hora;
    @FXML
    private TextField minuto;
    @FXML
    private TextField horaD;
    @FXML
    private TextField minutoD;
    @FXML
    private TextField frasePassado;
    @FXML
    private TextField frasePresente;
    @FXML
    private TextField fraseFuturo;
    @FXML
    private TextField nomeRemover;

    @FXML
    void adicionarEvento() {

        Evento evento = new Evento(
                nomeAdd.getText(),
                LocalDateTime.of(data.getValue(),
                        LocalTime.of(Integer.parseInt(hora.getText()), Integer.parseInt(minuto.getText()))),
                Duration.parse("PT" + horaD.getText() + "H" + minutoD.getText() + "M"),
                frasePassado.getText(),
                frasePresente.getText(),
                fraseFuturo.getText()
        );

        try {
            Admin.getInstance().getEventosDAO().add(evento);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void removerEvento() {
        try {
            Admin.getInstance().getEventosDAO().remove(nomeRemover.getText());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
