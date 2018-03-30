package cn.tentact.taims.test;

public class asas {
	public static void main(String[] args) {
		int[] arr = {5,6,7,23,2};
		for (int i = 0; i < arr.length-1; i++) {//次数
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for (int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
		
//		"s".equals("s")
	}
}
