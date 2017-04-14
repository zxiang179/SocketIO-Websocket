package zx.nio.test;

import java.nio.IntBuffer;
public class TestBuffer {
	
	public static void main(String[] args) {
		
		//1 ��������
		//����ָ�����ȵĻ�����
		/*IntBuffer buf = IntBuffer.allocate(10);
		buf.put(13);//position��λ��: 0->1
		buf.put(21);//position��λ�ã�1->2
		buf.put(35);//position��λ��: 2->3
		//��λ�ø�λΪ0 Ҳ����positionλ��3->0����Ϊÿ��put��position��λ�ö����1 
		buf.flip();
		System.out.println("ʹ��flip��λ:"+buf);
		System.out.println("����Ϊ:"+buf.capacity());//����һ����ʼ���󣬲�����ı�(wrap���������������)
		System.out.println("����Ϊ:"+buf.limit());//����ֻװ��������Ԫ�أ����Կɶ�ȡ�������Ԫ��Ϊ3��limit=3
		
		System.out.println("��ȡ�±�Ϊ1��Ԫ��:"+buf.get(1));
		System.out.println("get(index)������positionλ�ò��ı�:"+buf);
		buf.put(1,4);
		System.out.println("put(index,change)������positionλ�ò��ı䣺"+buf);
		for(int i=0;i<buf.limit();i++){
			//����get������ʹ�仺����λ��(position)������һλ
			//��ǰpositionλ��Ϊ3
			System.out.print(buf.get()+"\t");
		}
		System.out.println("buf�������֮��Ϊ:"+buf);*/
		
		//2 wrap����ʹ��
		//wrap���������һ�����飺һ�������÷������ȳ�ʼ���������ĳ��ȣ���Ϊû�����壬��󻹻ᱻwrap�����������鸲�ǵ�
		//����wrap�����޸Ļ����������ʱ�����鱾��Ҳ����ŷ����仯
		/*int[] arr = new int[]{1,2,5};
		IntBuffer buf1 = IntBuffer.wrap(arr);
		System.out.println(buf1);
		
		IntBuffer buf2 = IntBuffer.wrap(arr,0,2);
		//����ʹ�ñ�ʾ����Ϊ����arr�ĳ��ȣ����ǿɲ�����Ԫ��ֻ��ʵ�ʽ��뻺������Ԫ�س��ȡ�
		System.out.println(buf2);*/
		
		//3 ��������
		IntBuffer buf1 = IntBuffer.allocate(10);
		int[] arr = new int[]{1,2,5};
		buf1.put(arr);
		System.out.println(buf1);
		//һ�ָ��Ʒ���
		IntBuffer buf3 = buf1.duplicate();
		System.out.println(buf3);
		
		//����buf1��λ������
		buf1.position(1);
//		buf1.flip();
		System.out.println(buf1);
		
		System.out.println("�ɶ�����Ϊ:"+buf1.remaining());
		
		int[] arr2 = new int[buf1.remaining()];
		//�����������ݷ���arr2������
		buf1.get(arr2);
		for(int i:arr2){
			System.out.print(Integer.toString(i)+",");
		}
		
	}

}
