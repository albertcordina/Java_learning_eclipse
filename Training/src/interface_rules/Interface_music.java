package interface_rules;

interface MusicPlayer {

	void play(String song);

	void pause();

	void stop();

}

class MediaPlayer implements MusicPlayer {

	private String song;
	private String playbackStatus;

	public MediaPlayer() {
		song = "";
		playbackStatus = "stopped";
	}

	public void play(String song) {
		this.song = song;
		playbackStatus = "playing";
		System.out.println("The Media Player is playing: " + song);

	}

	public void pause() {
		if (playbackStatus.equals("streaming")) {
			playbackStatus = "paused";
			System.out.println("The Media Player is paused.");
		} else {
			System.out.println("The Media Player is not streaming.");
		}
	}

	public void stop() {
		if (!playbackStatus.equals("stopped")) {
			System.out.println("The Media Player has stopped");
		} else {
			System.out.println("The Media Player is on");
		}
	}
}

class StreamingService implements MusicPlayer {

	private String song;
	private String playbackStatus;

	public StreamingService() {
		song = "";
		playbackStatus = "stopped";
	}

	public void play(String song) {
		this.song = song;
		playbackStatus = "streaming";
		System.out.println("StreamingService is streaming: " + song);

	}

	public void pause() {
		if (playbackStatus.equals("streaming")) {
			playbackStatus = "paused";
			System.out.println("StreamingService is paused.");
		} else {
			System.out.println("StreamingService is not streaming.");
		}
	}

	public void stop() {
		if (!playbackStatus.equals("stopped")) {
			playbackStatus = "stopped";
			System.out.println("StreamingService has stopped.");
			song = "";
		} else {
			System.out.println("StreamingService is already stopped.");
		}
	}
}

public class Interface_music {

	public static void main(String[] args) {

		MediaPlayer player = new MediaPlayer();
		StreamingService stream = new StreamingService();

		player.play("Song 1");
		player.pause();
		player.play("Song 2");
		player.stop();

		stream.play("Song A");
		stream.pause();
		stream.stop();
		stream.play("Song B");

	}
}