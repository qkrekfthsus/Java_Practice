
public class Main extends Player{

	public static void main(String[] args) {
		
		Main main = new Main();
		main.play("Joakim Karud - Mighty Love");
		main.pause();
		main.stop();
	}

	@Override
	void play(String songName) {
		System.out.println(songName + " 곡을 재생합니다.");
	}

	@Override
	void pause() {
		System.out.println("곡을 일시정지합니다.");
	}

	@Override
	void stop() {
		System.out.println("곡을 정지합니다.");
	}

}
