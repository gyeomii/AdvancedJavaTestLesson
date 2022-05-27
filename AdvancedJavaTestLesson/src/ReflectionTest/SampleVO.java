package ReflectionTest;

public class SampleVO implements Comparable<SampleVO> {
	public String id;
	protected String name;
	private int age;
	
	public SampleVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public SampleVO() {
	}

	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(SampleVO o) {
		return name.compareTo(o.name);
	}
	
}
