https://openliberty.io/start/ (as spring initializr)
--> micro-app.zip 
load in eclipse or ...
----------------
mvn liberty:dev  --> lance le serveur liberty (http://localhost:9080)
En mode dev , avec recompilation/rechargement automatique du code
---------------
mvn liberty:start (sans mode dev)
mvn liberty:stop (ou bien Ctrl-C)
---------------
http://localhost:9080/micro-app/ (si index.html dans src/main/webapp)
http://localhost:9080/micro-app/my-api/devise