package me.liuchu.test.comm.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

    private Selector selector = Selector.open();

    public NIOServer() throws IOException {
    }

    private void startServer() throws IOException {

        Init();

        while (true) {
            if (selector.select(1000) == 0) {
                System.out.println("Selector中没有key");
                continue;
            }

            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                //等待连接
                if (key.isAcceptable()) {
                    handleAccept(key);
                }

                //等待读
                if (key.isReadable()) {
                    handleRead(key);
                }

                //等待写
                if (key.isWritable()) {
                    handleWrite(key);
                }

                iter.remove();
            }

        }
    }

    private void handleWrite(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }

        buffer.compact();

        channel.close();
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        //将channel中的读入数据写到buffer
        buffer.clear();

        long byteLength = channel.read(buffer);

        while (byteLength > 0) {
            buffer.flip();

            StringBuilder str = new StringBuilder();
            while (buffer.hasRemaining()) {
                str.append((char) buffer.get());
            }

            System.out.println("Channel读操作，内容:" + str);
            RequestHandler.handle(str.toString(), key);
            buffer.clear();
            byteLength = channel.read(buffer);
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();

        SocketChannel client = server.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(16));
    }

    private void Init() throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(9999));
        server.configureBlocking(false);

        //注册该总server channel
        server.register(selector, SelectionKey.OP_ACCEPT);
    }

    public static void main(String[] args) throws IOException {
        new NIOServer().startServer();
    }
}
