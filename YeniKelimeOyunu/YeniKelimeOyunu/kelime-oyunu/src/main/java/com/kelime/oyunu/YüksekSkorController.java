package com.kelime.oyunu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class YüksekSkorController {

    private String maxpuan;
    private String ikincipuan;
    private String ucuncupuan;

    OyunEkranController oec = new OyunEkranController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text ys1, ys2, ys3;


    public void puanyansit() {
        try {
            Connection con = DB.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT toplam_puan FROM oyun_puanlari ORDER BY toplam_puan DESC LIMIT 0,3");
    
            int count = 0;
            while (rs.next() && count < 3) {
                if (count == 0) {
                    maxpuan = rs.getString("toplam_puan");
                } else if (count == 1) {
                    ikincipuan = rs.getString("toplam_puan");
                } else if (count == 2) {
                    ucuncupuan = rs.getString("toplam_puan");
                }
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    void GeriDonusButton(ActionEvent event) throws IOException {
        KelimeOyunu.changePage("GirisEkran.fxml");
    }

    @FXML
    void initialize() {
        puanyansit();
        ys1.setText(maxpuan);
        ys2.setText(ikincipuan);
        ys3.setText(ucuncupuan);
    }

}
