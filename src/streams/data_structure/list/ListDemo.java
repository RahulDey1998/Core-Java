package streams.data_structure.list;

public class ListDemo {

	public static void main(String[] args) {
		
		ListFun<String> list = ListFun.list("Rahul", "Soumen", "Sourav", "Mahima");
		ListFun<Integer> listNum = ListFun.list(1,4,3,5,6,8);
		ListFun<Integer> listNum2 =	listNum.addLast(10);
		
		listNum2.forEach(System.out::println);
		System.out.println();
		ListFun<Integer> reverse = listNum2.reverse();
//		ListFun<Integer> newList = listNum2.removeByIndex(3);
//		reverse.forEach(System.out::println);
		
	}
}
