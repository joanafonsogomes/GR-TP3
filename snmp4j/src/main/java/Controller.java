import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Controller {


    @FXML
    private TextField ipAgente;
    @FXML
    private TextField portAgente;
    @FXML
    private Button startAgent;
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
    private CheckBox checkTimer;
    @FXML
    private TextField timerD;
    @FXML
    private TextField timerH;
    @FXML
    private TextField timerM;


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
        if (checkTimer.isSelected()){
            evento.setTimer(Duration.parse("P"+
                    timerD.getText()+"DT" +
                    timerH.getText() + "H" +
                    timerM.getText() + "M"));
        }
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

    @FXML
    void startAgent() {
        new Thread(()->
                Agent.main(new String[]{
                        "-c", "Agent.cfg",
                        "-bc", "Agent.bc",
                        "udp:"+ ipAgente.getText()+'/'+portAgente.getText()})
        ).start();
    startAgent.setDisable(true);
    }


}
