# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'C:\Users\jelte_laptop\Desktop\repos\zulu\python\simple_connect_gui.ui',
# licensing of 'C:\Users\jelte_laptop\Desktop\repos\zulu\python\simple_connect_gui.ui' applies.
#
# Created: Sun Feb 24 20:23:24 2019
#      by: pyside2-uic  running on PySide2 5.12.1
#
# WARNING! All changes made in this file will be lost!

from PySide2 import QtCore, QtGui, QtWidgets

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(800, 600)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.verticalLayoutWidget = QtWidgets.QWidget(self.centralwidget)
        self.verticalLayoutWidget.setGeometry(QtCore.QRect(-1, -1, 801, 551))
        self.verticalLayoutWidget.setObjectName("verticalLayoutWidget")
        self.verticalLayout = QtWidgets.QVBoxLayout(self.verticalLayoutWidget)
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.verticalLayout.setObjectName("verticalLayout")
        self.showInfo = QtWidgets.QLabel(self.verticalLayoutWidget)
        self.showInfo.setObjectName("showInfo")
        self.verticalLayout.addWidget(self.showInfo)
        self.connectCode = QtWidgets.QLineEdit(self.verticalLayoutWidget)
        self.connectCode.setObjectName("connectCode")
        self.verticalLayout.addWidget(self.connectCode)
        self.connectButton = QtWidgets.QPushButton(self.verticalLayoutWidget)
        self.connectButton.setObjectName("connectButton")
        self.verticalLayout.addWidget(self.connectButton)
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 800, 26))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QtWidgets.QApplication.translate("MainWindow", "MainWindow", None, -1))
        self.showInfo.setText(QtWidgets.QApplication.translate("MainWindow", "show shit", None, -1))
        self.connectButton.setText(QtWidgets.QApplication.translate("MainWindow", "Connect", None, -1))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_MainWindow()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

