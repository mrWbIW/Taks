import net.sourceforge.jFuzzyLogic.FIS;


/*

 * Тестовый парсер FCL-файла
 * компилируем командой chdir C:\Users\Admin\Desktop\Нейронки\6 
javac -cp ./jFuzzyLogic_v2.1a.jar MusicGenerator.java
 * далее кладем файл MusicGenerator.class в каталог MusicGenerator
 * и запускаем командой "java -cp ./jFuzzyLogic_v2.1a.jar;MusicGenerator MusicGenerator"

 */


// Входные переменные:
// Время суток: TimeHours
// Скорость движения: MovementSpeed
// Показатель_Настроения: MoodLevel
// Время года: Month

// Выходные переменные:
// Количество ударов в минуту (bpm): BPM
// Громкость: Volume


public class MusicGenerator {

	public static void main(String[] args) throws Exception {

		FIS fis = FIS.load("MusicGenerator.fcl", true);

		if (fis == null) {
			System.err.println("Error loading file with name 'MusicGenerator.fcl'");
			return;
		}

		// Показываем.
		fis.chart();

		// Задаем значения входных переменных.
		fis.setVariable("TimeHours", 6);
		fis.setVariable("Month", 11);
		fis.setVariable("MovementSpeed", 65);
		fis.setVariable("MoodLevel", 66);

		// Вычисляем.
		fis.evaluate();

		// Печатаем информацию о выходной перменной.
		System.out.println(fis.getVariable("BPM").toString());
		System.out.println(fis.getVariable("Volume").toString());

		// Печатаем вещественное значение последней дефаззификации выходной переменной.
		System.out.println(fis.getVariable("BPM").getValue());
		System.out.println(fis.getVariable("Volume").getValue());

		// Показываем график выходной переменной.
		fis.getVariable("BPM").chartDefuzzifier(true);
		fis.getVariable("Volume").chartDefuzzifier(true);

	}

}