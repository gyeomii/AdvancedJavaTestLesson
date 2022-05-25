package ThreadTest;

public class T20WaitNotifyTest {

}

class DataBox {
	private String data;

	public synchronized String getData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String returnData = data;
		System.out.println("읽어온 데이터: " + returnData);
		data = null;
		System.out.println(Thread.currentThread().getName() + " notify 호출");
		notify();

		return returnData;
	}

	public synchronized void setData(String data) {
		if (data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println("세팅한 데이터 : " + this.data);
			System.out.println(Thread.currentThread().getName() + " notify 호출");
			notify();
		}
	}

}

class ProducerThread extends Thread {
	private DataBox dataBox;

	public ProducerThread(DataBox dataBox) {
		super("ProducerThread");
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			String data = "Data-" + i;
			System.out.println("dataBox.setData(" + data + ")호출");
			dataBox.setData(data);
		}
	}
}

class ConsumerThread extends Thread {
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		super("ConsumerThread");
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			String data = dataBox.getData();
			System.out.println("dataBox.getData : " + data);
		}
	}
}