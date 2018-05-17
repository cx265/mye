package priv.cx.carl.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

public class PersonSerializeAndDeserialize {
	
	public static void main(String[] args) {
		PersonSerialize();
		Person p = PersonDeserialize();
		System.out.println(MessageFormat.format("name={0},age={1}", p.getName(),p.getAge()));
	}
	
	private static void PersonSerialize() {
		Person person = new Person();
		person.setName("cx");
		person.setAge(25);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
			oos.writeObject(person);
			System.out.println("Person对象序列化成功！");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Person PersonDeserialize() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person person = null;
		try {
			person = (Person) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Person对象反序列化成功！");
		return person;
	}

}
