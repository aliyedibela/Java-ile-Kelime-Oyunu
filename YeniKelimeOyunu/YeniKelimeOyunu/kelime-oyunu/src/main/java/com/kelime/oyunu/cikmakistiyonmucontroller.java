package com.kelime.oyunu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class cikmakistiyonmucontroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    OyunEkranController o = new OyunEkranController();
    OyunEkranControllerBlue ob = new OyunEkranControllerBlue();
    OyunEkranControllerGreen oy = new OyunEkranControllerGreen();
    OyunEkranControllerPink op = new OyunEkranControllerPink();
    OyunEkranControllerOrange ot = new OyunEkranControllerOrange();

    @FXML
    private void evetbutton(ActionEvent event) throws IOException{

        o.kullaniciPuaniKaydet(o.toplampuann);
        ob.kullaniciPuaniKaydet(ob.toplampuann);
        oy.kullaniciPuaniKaydet(oy.toplampuann);
        op.kullaniciPuaniKaydet(op.toplampuann);
        ot.kullaniciPuaniKaydet(ot.toplampuann);

        KelimeOyunu.changePage("GirisEkran.fxml");
        Stage stage = (Stage) label.getScene().getWindow();
        
        stage.close();
        o.timeline.stop();
       
        ob.timeline.stop();
       
        oy.timeline.stop();
        
        op.timeline.stop();
      
        ot.timeline.stop();
       
    }

    @FXML
    private void hayirbutton(ActionEvent event) throws IOException {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.close();
        o.suredevam();
    }
}