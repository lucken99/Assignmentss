package learn;

import org.springframework.beans.factory.annotation.Value;

public class ResourceTest {
	@Value("${resource.books}")
	private static String resource;
	
	@Value("${resource.books}/{bookCode}")
	private String idResource;
	public static void main(String[] args) {
		System.out.print(resource);
	}
}
