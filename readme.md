Es handelt sich hierbei um ein Notentool, das durch Schulen, Lehrer und Schüler benutzt werden kann. Diese Noten können für verschiede Kurse aufgeteilt auf mehreren Semestern hinterlegt werden. Dazu werden die wesentlichsten Informationen der Schüler und Lehrer ebenfalls gespeichert.

Es wird eine Lokale PostgreSQL Datenbank gebraucht. Im File "src/main/resources/application.properties" wird die Datenbankverbindung konfiguriert

Mit dem File "src/main/resources/gradetool-ddl.sql" kann die Datenbank aufgesetzt werden.

Die SQL Befehle im File "src/main/resources/test-sql.sql" können benutzt werden um direkt auf der Datenbank einige Datensätze anzulegen etc.
