package com.kelime.oyunu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GirisEkranController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button ayarlar;

    OyunEkranController o = new OyunEkranController();
    OyunEkranControllerBlue ob = new OyunEkranControllerBlue();
    OyunEkranControllerGreen oy = new OyunEkranControllerGreen();
    OyunEkranControllerPink op = new OyunEkranControllerPink();
    OyunEkranControllerOrange ot = new OyunEkranControllerOrange();


    @FXML
    void initialize() {
        DB.dbConnect();
    }

    @FXML
    void ayarlaronaction(ActionEvent event) {

        try {
            KelimeOyunu.changePage("Ayarlar.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        o.timeline.stop();
       
        ob.timeline.stop();
       
        oy.timeline.stop();
  
        op.timeline.stop();
     
        ot.timeline.stop();
  
    }

    @FXML
    private void OynaButtonClick(ActionEvent event) {

        try {
            KelimeOyunu.changePage("OyunEkran.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void YuksekSkorButtonClick(ActionEvent event) throws IOException {
        try {
            KelimeOyunu.changePage("YüksekSkor.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
