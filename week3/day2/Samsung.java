package week3.day2;

public class Samsung extends AndroidTV{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Samsung sam = new Samsung();
		sam.openApp();
		sam.playVideo();
		sam.screen();
        sam.rechargePlan();
	}

	public void playVideo() {
		// TODO Auto-generated method stub
		System.out.println("playVideo option implemented from interface");
		
	}

	@Override
	public void screen() {
		// TODO Auto-generated method stub
		System.out.println("screen size is 36 inch from Abstract class");
		
		
	}

}
