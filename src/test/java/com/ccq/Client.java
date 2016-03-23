/**
 * wesoft.com Inc.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.ccq;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author <a href="mailto:chencq@hzwesoft.com">chencq</a>
 * @version $Id: Client.java, 2016/3/23 16:23 $
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.setSendBufferSize(1024);
        SocketAddress socketAddress = new InetSocketAddress("localhost", 8011);
        socket.connect(socketAddress);
        String str = "一个偶然的机会使得朋友需要我帮忙编写一个企业应用。这个工作是免费的，因此进度方面并不紧张，于是我也就有了借编写这个应用实践一下企业开发方面新技术的机会，且写且学。\n"
                     + "\n"
                     + "因为这是一个小应用，而且所有工作都是我一人来做，所有必须选择简单、易用、快速的技术，好在如今这样的技术可选择的非常多。最终我选择了 Spring Boot、AngularJS 和 Bootstrap 这三个技术。";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());
        os.flush();
    }

}
