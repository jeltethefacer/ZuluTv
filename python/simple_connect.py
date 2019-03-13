# main.py
import sys
import socket
from PySide2.QtUiTools import QUiLoader
from PySide2.QtWidgets import QApplication, QWidget, QMainWindow
from PySide2.QtCore import QFile, QObject, QTimer
from simple_connect_gui import Ui_MainWindow

class ConnectUi(QMainWindow):
    def __init__(self):
        self.connected = False
        super(ConnectUi, self).__init__()
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        
        self.ui.connectButton.clicked.connect(self.connectToServer)
        # self.timer = QTimer()
        # self.timer.timeout.connect(self.getNewData)
        # self.timer.start(5000)                


    def connectToServer(self):
        print("trying to connect")
        try: 
            HOST = '192.168.178.33'  # The server's hostname or IP address
            PORT = 6121       # The port used by the server
            code = self.ui.connectCode.text() + '\n'
            code = code.encode()
            self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            self.connected = True
            self.s.connect((HOST, PORT))
            self.s.sendall(code)
            data = self.s.recv(1024)
            data = data.decode("utf-8")
            self.ui.showInfo.setText(data)
            self.s.sendall(b"vrijheid\n")
            self.s.sendall(b"lmao\n")
            self.s.sendall(b"Jullie hebben allemaal onvoldoende!!!!!!!!!!!\n")
        except:
            print("excuse me wtf")
    
    def getNewData(self):
        if(self.connected):
            print("hallo")
            try:
                 message = self.s.recv(1024)
                 message = message.decode("utf-8")
                 print(message)
                 message = ""
                 if(message != ""):
                     self.ui.showInfo.setText(message)
            except:
                print("errors to be handled or something like that.")
           
              


if __name__ == "__main__":
    app = QApplication(sys.argv)

    file = QFile("simple_connect_gui.ui")
    file.open(QFile.ReadOnly)

    loader = QUiLoader()
    window = ConnectUi()
    window.show()
    sys.exit(app.exec_())
