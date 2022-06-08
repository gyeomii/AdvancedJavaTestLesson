package A07JavaIOTEST;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02FileTest {
	public static void main(String[] args) {

		File f1 = new File("d:/Others/sample.txt");
		File f2 = new File("d:/Others/test.txt");

		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
		} else {
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");
			try {
				if (f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + "파일 생성");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (f2.exists()) {
			System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
		} else {
			System.out.println(f2.getAbsolutePath() + "은 없는 파일입니다.");
		}
		System.out.println("======================================");

		File f3 = new File("d:/Others");
		File[] files = f3.listFiles();
		for (File file : files) {
			System.out.println(file.getName() + " -> ");
			if (file.isFile()) {
				System.out.println("파일");
			} else if (file.isDirectory()) {
				System.out.println("디렉토리(폴더");
			}
		}
		System.out.println("=====================================");
		String[] strFiles = f3.list();
		for (String str : strFiles) {
			System.out.println(str);
		}
		System.out.println("=====================================");
		
		//출력할 디렉토리 정보를 갖는 File객체 작성
		File f4 = new File("D:/Others");
		
		displayFileList(f4);
	}
	/*
	 	지정된 디렉토리(폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메소드
	 	@param dir 디렉토리 정보를 보고자 하는 파일객체
	 */
	private static void displayFileList(File dir) {
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
		
		//디렉토리의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		//하위 디렉토리 정보를 저장할 ArrayList 생성(File배열의 인덱스 값 저장)
		List<Integer> subDirList = new ArrayList<Integer>();
		
		//날짜 정보 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a hh:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr= ""; // 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = ""; // 파일 용량
			
			if(files[i].isDirectory()) {
			attr = "<DIR>";
				subDirList.add(i);
			}else {
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R " : " ";
				attr += files[i].canWrite() ? "W " : " ";
				attr += files[i].isHidden() ? "H " : " ";
			}
			System.out.printf("%s %5s %8s %s\n", sdf.format(new Date(files[i].lastModified())), attr, size, files[i].getName());
		}
		
		int dirCount = subDirList.size();
		int fileCount = files.length - dirCount;
		
		System.out.println(fileCount + "개의 파일, " + dirCount + "개의 디렉토리");
		
		System.out.println();
		
		for (Integer idx : subDirList) {
			displayFileList(files[idx]);
		}
	}
}