package com.owl.io;

import com.owl.util.LogPrintUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * author engwen
 * email xiachanzou@outlook.com
 * 2019/11/13.
 */
public class SocketClient {
    private String host;
    private int port;
    private SocketChannel socketChannel;
    private Selector selector;

    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
        this.connect();
    }

    private void connect() {
        try {
            this.selector = Selector.open();
            this.socketChannel = SocketChannel.open(new InetSocketAddress(this.host, this.port));
            //非阻塞
            this.socketChannel.configureBlocking(false);
            this.socketChannel.register(selector, SelectionKey.OP_CONNECT);

//        socketChannel.finishConnect();
        } catch (Exception e) {
            LogPrintUtil.error("connect error, information is  " + e);
        }
    }

    public void disconnect() {
        try {
            this.socketChannel.socket().close();
            this.socketChannel.close();
        } catch (Exception e) {
            LogPrintUtil.error("disconnect error, information is  " + e);
        }
    }

    public void emit(String event, String msg) {
        SocketModel model = new SocketModel(event, msg);
        ByteBuffer buffer = ByteBuffer.wrap(model.toString().getBytes());
        try {
            this.socketChannel.write(buffer);
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            this.socketChannel.read(allocate);
            LogPrintUtil.info("get server back  " + new String(allocate.array()).trim());
        } catch (Exception e) {
            LogPrintUtil.error("emit msg is Error :" + e);
        }
    }
}
