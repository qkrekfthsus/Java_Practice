public class ProducerConsumer{
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Producer p = new Producer("생산자", b);
		Consumer c = new Consumer("소비자", b);
		p.start();
		c.start();
	}
}