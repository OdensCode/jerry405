module com.example.jerrypaddy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.jerrypaddy to javafx.fxml;

    exports com.example.jerrypaddy.Database;
    opens com.example.jerrypaddy.Database to javafx.fxml;
    exports com.example.jerrypaddy.inventorycategories;
    opens com.example.jerrypaddy.inventorycategories to javafx.fxml;
    exports com.example.jerrypaddy;
    exports com.example.jerrypaddy.others;
    opens com.example.jerrypaddy.others to javafx.fxml;


}