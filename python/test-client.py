import socket

HOST = '192.168.1.24'  # The server's hostname or IP address
PORT = 6121       # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    s.sendall(b'146641\n')
    data = s.recv(1024)

print('Received',  data)
