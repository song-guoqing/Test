import java.nio.ByteBuffer;

public class Test {
	// byte[] ¸ßµÍÎ»×ª»»
	public static byte[] byteArrayReverse(byte[] bs) {
		for (int i = 0; i < bs.length / 2; i++) {
			byte temp = bs[i];
			bs[i] = bs[bs.length - 1 - i];
			bs[bs.length - 1 - i] = temp;
		}
		return bs;
	}

	public static int byteArray2int(byte[] arr) {
		ByteBuffer wrapped = ByteBuffer.wrap(arr); // big-endian by default
		int num = wrapped.getInt();
        
		return num;
	}
	
	public static void main(String[] args) {
		int javaReadInt = 347658929;
		long hexInt = 0x9E4812202L;
		byte[] bytes = ByteBuffer.allocate(4).putInt(javaReadInt).array();
		for (byte b : bytes) {
			System.out.format("0x%x ", b);
		}
		byte[] retByte = byteArrayReverse(bytes);
		System.out.println(Integer.toHexString(byteArray2int(retByte)));
	}

}
