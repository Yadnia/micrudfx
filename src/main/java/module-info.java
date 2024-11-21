module org.YadMary {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires java.persistence;
    requires org.checkerframework.checker.qual;
    requires java.naming;
    requires com.sun.jna.platform;

    opens org.YadMary to javafx.fxml;
    exports org.YadMary;
}
