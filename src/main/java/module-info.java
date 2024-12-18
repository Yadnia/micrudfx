module org.YadMary {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires java.desktop;
    requires com.google.errorprone.annotations;
    requires org.checkerframework.checker.qual;
    requires jasperreports;

    opens org.YadMary to javafx.fxml;
    opens org.YadMary.controller to javafx.fxml;
    opens org.YadMary.entity to org.hibernate.orm.core, javafx.base;
    exports org.YadMary;

}
