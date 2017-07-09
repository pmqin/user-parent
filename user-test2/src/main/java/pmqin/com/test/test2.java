package pmqin.com.test;

public class test2 {

	public test2() {

	}

	public test2(String name) {
		this.Name = name;
	}

	public test2(Integer id) {
		this.Id = id;
	}

	public test2(String name, Integer id) {
		this.Name = name;
		this.Id = id;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	private String GetTestName() {
		return "getDeclaredMethod*()获取的是类自身声明的所有方法，包含public、protected和private方法";
		
	}
	private Integer Id;
	
	private String Name;

	
	@Override
	public String toString() {
		return "test2 [Id=" + Id + ", Name=" + Name + "]";
	}

	public class test3 {

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		private Integer Id;
		private String Name;
	} 
	
}
