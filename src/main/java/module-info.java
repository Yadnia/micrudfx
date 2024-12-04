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

    opens org.YadMary to javafx.fxml;
    opens org.YadMary.controller to javafx.fxml;
    opens org.YadMary.entity to org.hibernate.orm.core;
    exports org.YadMary;

}
