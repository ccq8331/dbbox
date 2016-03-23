/**
 * wesoft.com Inc.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.ccq;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author <a href="mailto:chencq@hzwesoft.com">chencq</a>
 * @version $Id: Server.java, 2016/3/23 16:23 $
 */
public class Server extends Thread {

    public static void main(String[] args) throws Exception {
        new Rec().start();
    }

}

class Rec extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8011);
            serverSocket.setReceiveBufferSize(1024);
            Socket socket = serverSocket.accept();
            byte[] buffer = new byte[5 * 1024];
            InputStream is = socket.getInputStream();
            is.read(buffer);

            System.out.println(new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}