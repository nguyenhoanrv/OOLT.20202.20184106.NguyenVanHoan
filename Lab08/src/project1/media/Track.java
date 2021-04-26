package project1.media;
import project1.disc.CompactDisc;

	public class Track implements Playable{
		protected String title;
		protected int length;
		public Track(){
			
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		
		public Track(String title, int length) {
			super();
			this.title = title;
			this.length = length;
		}
		public void play() {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		
	}

