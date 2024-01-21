package com.kelime.oyunu;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;



public class OyunEkranControllerGreen {

    @FXML
    private Text sorupuan, toplampuan;

    @FXML
    private Button harfal;

    @FXML
    private Button onaylabutton;

    @FXML
    private TextArea cevaptear;

    private String cevap;

    @FXML
    private Button duraklat;
    

    @FXML
    private Button hayirbutton, evetbutton;

    @FXML
    private Text dakikaText;

    @FXML
    private ImageView petek0, petek1, petek2, petek3, petek4, petek5, petek6, petek7, petek8, petek9;

    @FXML
    private Text petekText0, petekText1, petekText2, petekText3, petekText4, petekText5, petekText6, petekText7,
            petekText8, petekText9;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Text saniyeText;
    private static int toplam_harf_sayisi = 10;
    private static int mevcut_harf_sayisi = 4;

    @FXML
    private Text soru;

    public static int remainingMinutes = 4;
    public static int remainingSeconds = 0;
    public static Timeline timeline;
    Random rand = new Random();

    private Text[] harfTextleri = new Text[toplam_harf_sayisi];
    private String dbSoru = new String(), dbCevap;
    private int puan = mevcut_harf_sayisi * 100;
    public static int toplampuann = 0;
    private int puantiklamasayisi = 0;
    private int puann;
    private int soruSayisi = 1;

    private int tiklamasayisi = 0;
    @FXML
    void initialize() {
        petekayarla();
        startCounter();
        sorucek(mevcut_harf_sayisi);
        puangoster();
        soru.setText(dbSoru);
    }

   
    @FXML
    void exitbuttonhandle(ActionEvent event) throws IOException {
        AnchorPane page = FXMLLoader.load(OyunEkranController.class.getResource("cikmakistiyonmu.fxml"));
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(((Button) event.getSource()).getScene().getWindow());
        dialogStage.setTitle("Kelime Oyunu");
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(page));
        dialogStage.showAndWait();
    }

    @FXML
    void harfalbutton(ActionEvent event) {
        puantiklamasayisi++;
        puan = mevcut_harf_sayisi * 100 - 100 * puantiklamasayisi;
        puangoster();
        if (tiklamasayisi < mevcut_harf_sayisi) {
            harfAl();
            tiklamasayisi++;
            if (tiklamasayisi == mevcut_harf_sayisi) {
                tiklamasayisi = 0;
                return;
            }
        }
    }

    public void harfAl() {
        int random;
        Text harf;
        do {
            random = rand.nextInt(mevcut_harf_sayisi);
        } while (harfTextleri[random] != null);
        harf = (Text) rootPane.lookup("#petekText" + random);
        harfTextleri[random] = harf;
        harfTextleri[random].setText(String.valueOf(dbCevap.charAt(random)));
    }

    @FXML
    void duraklat(ActionEvent event) {

        tiklamasayisi++;

        if (tiklamasayisi % 2 == 0) {
            timeline.play();
        } else {
            timeline.stop();
        }

    }

    private void temizleHarfleri() {
        for (int i = 0; i < harfTextleri.length; i++) {
            if (harfTextleri[i] != null) {
                harfTextleri[i].setText("");
                harfTextleri[i] = null;
            }
        }
        cevaptear.clear();
    }

    private void petekayarla() {
        ImageView[] petekler = new ImageView[toplam_harf_sayisi];

        for (int i = 0; i < petekler.length; i++) {
            ImageView petek = (ImageView) rootPane.lookup("#petek" + i);
            petekler[i] = petek;

            if (i < mevcut_harf_sayisi) {
                petek.setVisible(true);
            } else {
                petek.setVisible(false);
            }
        }
    }

    public void sorucek(int mevcut_harf_sayisi) {
        try {
            Statement st = DB.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM kelime_oyunu_tablosu WHERE harf_sayisi = " + mevcut_harf_sayisi + " ORDER BY RAND() LIMIT 1");
            if (rs.next()) {
                String tempSoru = dbSoru;
                do {
                    dbSoru = rs.getString("soru");
                    dbCevap = rs.getString("cevap").toUpperCase();
                } while (tempSoru.equals(dbSoru));
            }
            puantiklamasayisi = 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getdbCevap() {
        return dbCevap;
    }

    public void startCounter() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    updateCounter();
                    if (remainingMinutes == 0 && remainingSeconds == 0) {
                        timeline.stop();

                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void updateCounter() {
        if (remainingSeconds == 0) {
            remainingMinutes--;
            remainingSeconds = 59;
        } else {
            remainingSeconds--;
        }
        dakikaText.setText(String.format("%02d", remainingMinutes));
        saniyeText.setText(String.format("%02d", remainingSeconds));

        if (remainingMinutes == 0 && remainingSeconds == 0) {

            oyunbiter();

        }
    }

    public void puanla() {
        toplampuann = puan + toplampuann - mevcut_harf_sayisi * 100;
        puan = mevcut_harf_sayisi * 100 + tiklamasayisi * -100;
        puangoster();
    }

    public void toplampuan() {

        toplampuann = toplampuann + puan;
        puangoster();

    }

    public void sorupuani() {

        puan = mevcut_harf_sayisi * 100;
        puangoster();

    }

    public void puangoster() {
        sorupuan.setText(String.format("%04d", puan));
        toplampuan.setText(String.format("%04d", toplampuann));
    }

    @FXML
    void onaylabutton(ActionEvent event) {

        String cevap = cevaptear.getText().toUpperCase();
        if (soruSayisi % 2 == 0)
            mevcut_harf_sayisi++;
        soruSayisi++;

        if (cevap.equals(dbCevap)) {
            sorucek(mevcut_harf_sayisi);
            toplampuan();
            temizleHarfleri();
            timeline.play();
            petekayarla();
            puangoster();
            sorupuani();
            soru.setText(dbSoru);
        } else {
            sorucek(mevcut_harf_sayisi);
            sorupuani();
            temizleHarfleri();
            timeline.play();
            petekayarla();
            puangoster();
            soru.setText(dbSoru);
        }

        if (soruSayisi > 14) {
            oyunbiter();
        }
    }

    public void kullaniciPuaniKaydet(int toplampuann) {
        try {
            Connection con = DB.getCon();
            Statement st = con.createStatement();
            
            st.executeUpdate("INSERT INTO oyun_puanlari (toplam_puan) VALUES (" + toplampuann + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void tamamenSonlandir() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();

    }

    public void oyunbiter() {
        kullaniciPuaniKaydet(toplampuann);
        tamamenSonlandir();
    }
    public void suredevam() {
         timeline.play();
    }
}