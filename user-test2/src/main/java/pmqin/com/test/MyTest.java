/**
 * 
 */
package pmqin.com.test;

public class MyTest {

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	
	
	//@Deprecated //建议不要使用，已经被新特新所取代，类似于C#的特新
	public void setName(String name) {
		Name = name;
	}
	private Integer Id;
	private String Name;
	
	/*
	 * @author pmqin
	 * @return 返回字符串
	 * @version v1.0
	 */
	public static String GetMyName()
	{
		return "秦鹏明";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyTest other = (MyTest) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MyTest [Id=" + Id + ", Name=" + Name + "]";
	}
}
