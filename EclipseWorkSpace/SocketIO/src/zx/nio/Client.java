package zx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	
	public static void main(String[] args) {
		//�������ӵĵ�ַ
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",8765);
		//��������ͨ��
		SocketChannel sc = null;
		//����������
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		try {
			//��ͨ��
			sc = SocketChannel.open();
			//��������
			sc.connect(address);
			while(true){
				//����һ���ֽ����飬Ȼ��ʹ��ϵͳ ¼�빦��
				byte[] bytes = new byte[1024];
				//������¼������ݷ���byte��
				System.in.read(bytes);
				//�����ݷŵ�������
				buf.put(bytes);
				//�Ի��������и�λ
				buf.flip();
				//д������
				sc.write(buf);
				//��ջ���������
				buf.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sc!=null){
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
