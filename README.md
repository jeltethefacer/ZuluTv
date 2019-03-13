#Prototype version of zulutv

you can compile and run the server in the java folder
```
javac Server.java Entity.java  TvConnectionHandler.java
java Server
```

this will start the server

before you run 
to run the client open the python folder and run the following command
use of a virtual enviroment recommended
Before you compile the python you should change the ip address on line 25 of simple_connect.py to the ip adress given by the java server

```
pip install PySide2
python simple_connect.py
```

When you see the window enter the code given by the server and you should see the contents appear

##todo
*make the ip-adress a command line option
*tidy up the folder system

