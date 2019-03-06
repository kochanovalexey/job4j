package ru.job4j.calculate;

/**
 * Class Класс выводящий строку "Hello world"
 * @author akochanov
 * @since 06.03.2019
 * @version 1
*/
public class Calculate {
	/**
	* Main
	* Конструктор, выводящий строку в консоль.
	* @param args - arg.
	*/
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	
	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	 public String echo(String name) {
		return "Echo, echo, echo : " + name;
	 }
}