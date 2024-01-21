module com.kelime.oyunu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;
  
    

    opens com.kelime.oyunu to javafx.fxml;
    exports com.kelime.oyunu;
}
