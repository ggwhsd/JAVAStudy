package SingletonStudy;

public final class Singleton05 {

		private byte[] data = new byte[1024];

		private Singleton05()
		{
			
		}
		private static class Holder
		{
			private static Singleton05 instance = new Singleton05();
		}
		public static Singleton05 getInstance()
		{
			
			return Holder.instance;
		}
		public void print()
		{
			System.out.println(this.getClass().getName());
		}
		public static void main(String[] args) {
			Singleton05.getInstance().print();

		}

}
