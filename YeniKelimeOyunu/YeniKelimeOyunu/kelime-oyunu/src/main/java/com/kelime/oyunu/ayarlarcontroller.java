package com.kelime.oyunu;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ayarlarcontroller {

    @FXML
    private Button ayarlargeri;

    @FXML
    private Button kolay;

    @FXML
    private Button orta;

    @FXML
    private Button zor;

    @FXML
    private Button mavi;

    @FXML
    private Button pembe;

    @FXML
    private Button turuncu;

    @FXML
    private Button yesil;

    OyunEkranController oec = new OyunEkranController();
    OyunEkranControllerBlue ob = new OyunEkranControllerBlue();
    OyunEkranControllerGreen oy = new OyunEkranControllerGreen();
    OyunEkranControllerPink op = new OyunEkranControllerPink();
    OyunEkranControllerOrange ot = new OyunEkranControllerOrange();

    @FXML
    void ayarlargerionaction(ActionEvent event) throws IOException {
        KelimeOyunu.changePage("GirisEkran.fxml");
        oec.initialize();
        ob.initialize();
        ot.initialize();
        op.initialize();
        oy.initialize();
    }

    @FXML
    void kolayonaction(ActionEvent event) {

        OyunEkranController.remainingMinutes = 4;
        OyunEkranController.remainingSeconds = 0;
        OyunEkranControllerBlue.remainingMinutes = 4;
        OyunEkranControllerBlue.remainingSeconds = 0;
        OyunEkranControllerGreen.remainingMinutes = 4;
        OyunEkranControllerGreen.remainingSeconds = 0;
        OyunEkranControllerPink.remainingMinutes = 4;
        OyunEkranControllerPink.remainingSeconds = 0;
        OyunEkranControllerOrange.remainingMinutes = 4;
        OyunEkranControllerOrange.remainingSeconds = 0;

        oec.initialize();
        ob.initialize();
        ot.initialize();
        op.initialize();
        oy.initialize();

    }

    @FXML
    void ortaonaction(ActionEvent event) {
        OyunEkranController.remainingMinutes = 3;
        OyunEkranController.remainingSeconds = 0;
        OyunEkranControllerBlue.remainingMinutes = 3;
        OyunEkranControllerBlue.remainingSeconds = 0;
        OyunEkranControllerGreen.remainingMinutes = 3;
        OyunEkranControllerGreen.remainingSeconds = 0;
        OyunEkranControllerPink.remainingMinutes = 3;
        OyunEkranControllerPink.remainingSeconds = 0;
        OyunEkranControllerOrange.remainingMinutes = 3;
        OyunEkranControllerOrange.remainingSeconds = 0;

        oec.initialize();
        ob.initialize();
        ot.initialize();
        op.initialize();
        oy.initialize();

    }

    @FXML
    void zoronaction(ActionEvent event) {

        OyunEkranController.remainingMinutes = 2;
        OyunEkranController.remainingSeconds = 0;
        OyunEkranControllerBlue.remainingMinutes = 2;
        OyunEkranControllerBlue.remainingSeconds = 0;
        OyunEkranControllerGreen.remainingMinutes = 2;
        OyunEkranControllerGreen.remainingSeconds = 0;
        OyunEkranControllerPink.remainingMinutes = 2;
        OyunEkranControllerPink.remainingSeconds = 0;
        OyunEkranControllerOrange.remainingMinutes = 2;
        OyunEkranControllerOrange.remainingSeconds = 0;

        oec.initialize();
        ob.initialize();
        ot.initialize();
        op.initialize();
        oy.initialize();

    }

    @FXML
    void mavionaction(ActionEvent event) throws IOException {
        KelimeOyunu.changePage("OyunEkranBlue.fxml");
        

    }

    @FXML
    void pembeonaction(ActionEvent event) throws IOException {
        KelimeOyunu.changePage("OyunEkranPink.fxml");

    }

    @FXML
    void turuncuonaction(ActionEvent event) throws IOException {
        KelimeOyunu.changePage("OyunEkranOrange.fxml");

    }

    @FXML
    void yesilonaction(ActionEvent event) throws IOException {
        KelimeOyunu.changePage("OyunEkranGreen.fxml");

    }

}