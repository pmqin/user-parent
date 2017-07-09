/**
 * 
 */
package pmqin.com.Collection;

/** 
* @author : pmqin
* @date   : 2016年7月30日 下午5:57:48 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Student {
	private int stuNum;
	private String name;

	 public Student(int stuNum,String name){
	        this.stuNum = stuNum;
	        this.name = name;
	    }
	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stuNum;
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
		Student other = (Student) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
		if (stuNum != other.stuNum)
			return false;
		return true;
	}
}
