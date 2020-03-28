package lambdasinaction.chap2;

public class MeaningOfThis
{
	public final int value = 4;
	public void doIt()
	{
		int value = 6;
		Runnable r = new Runnable(){
			public final int value = 5;
			public void run(){
				int value = 10;
				System.out.println("this.value is: >>>>>>>>>> " + this.value);
				System.out.println("value is: ########### " + value);

			}
		};

		r.run();

		System.out.println("value is: $$$$$  " + value);

		System.out.println("this.value is: (At this case, it's outside of Runnable class: " + this.value);

	}
	public static void main(String...args)
	{       
		MeaningOfThis m = new MeaningOfThis();
		m.doIt(); // ???   
	}
}
