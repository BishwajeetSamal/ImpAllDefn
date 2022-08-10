												WEBSOCKET
												=========
1.This chapter describes the Java API for WebSocket (JSR 356), which provides support for creating WebSocket
 applications.
2. WebSocket is an application protocol that provides full-duplex communications between two peers over 
 the TCP protocol.
 3. Previously it was happened that the client initate the request and then give the response from the server
 that is the server cannot send any data without the client requesting it first. But by the help of the 
 websocket both side full duplex communications is possible.

4.In a WebSocket application, the server publishes a WebSocket endpoint and the client uses the endpoint's
 URI to connect to the server.
5.The WebSocket protocol is symmetrical after the connection has been established.
6.the client and the server can send messages to each other at any time while the connection is open, and
 they can close the connection at any time. Clients usually connect only to one server, and servers accept
 connections from multiple clients.
7.The WebSocket protocol has two parts: handshake and data transfer.
8.The client initiates the handshake by sending a request to a WebSocket.
9.The handshake is compatible with existing HTTP-based infrastructure: web servers interpret it as an HTTP
 connection.
 10.The server applies a known operation to the value of the Sec-WebSocket-Key header to generate the value
  of the Sec-WebSocket-Accept header. 
 11.The client applies the same operation to the value of the Sec-WebSocket-Key header, and the connection
  is established successfully if the result matches the value received from the server.
 12.The client and the server can send messages to each other after a successful handshake.

13.WebSocket supports text messages (encoded as UTF-8) and binary messages.
14.The ws scheme represents an unencrypted WebSocket connection, and the wss scheme represents an
 encrypted connection.
 15.Modern web browsers implement the WebSocket protocol and provide a JavaScript API to connect to 
 endpoints, send messages, and assign callback methods for WebSocket events (such as opened connections, 
 	received messages, and closed connections).
 16.