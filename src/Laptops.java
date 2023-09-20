
import java.util.*;

class Ноутбук {
    private String бренд;
    private String модель;
    private int год;

    public Ноутбук(String бренд, String модель, int год) {
        this.бренд = бренд;
        this.модель = модель;
        this.год = год;
    }

    public String getБренд() {
        return бренд;
    }

    public String getМодель() {
        return модель;
    }

    public int getГодВыпуска() {
        return год;
    }

    @Override
    public String toString() {
        return "Ноутбук{" +
                "бренд='" + бренд + '\'' +
                ", модель='" + модель + '\'' +
                ", год выпуска=" + год +
                '}';
    }
}

public class Laptops {
    public static void main(String[] args) {
        Set<Ноутбук> ноутбуки = new HashSet<>();

        // Добавляем ноутбуки в Set
        ноутбуки.add(new Ноутбук("Acer", "Aspire", 2021));
        ноутбуки.add(new Ноутбук("HP", "Pavilion", 2020));
        ноутбуки.add(new Ноутбук("Dell", "Inspiron", 2022));

        // Создаем критерии фильтрации в Map
        Map<String, String> критерии = new HashMap<>();
        критерии.put("бренд", "Acer");
        критерии.put("год", "2021");

        // Вызываем метод для фильтрации и выводим результат
        filtrAndOut(ноутбуки, критерии);
    }

    public static void filtrAndOut(Set<Ноутбук> ноутбуки, Map<String, String> критерии) {
        for (Ноутбук ноутбук : ноутбуки) {
            boolean asFilter = true;
            for (Map.Entry<String, String> entry : критерии.entrySet()) {
                String ключ = entry.getKey();
                String значение = entry.getValue();

                // Применр фильтра по каждому критерию
                if (ключ.equals("бренд") && !ноутбук.getБренд().equals(значение)) {
                    asFilter = false;
                    break;
                } else if (ключ.equals("год") && ноутбук.getГодВыпуска() != Integer.parseInt(значение)) {
                    asFilter = false;
                    break;
                }
            }

            // Выводим ноутбук, если он соответствует всем критериям
            if (asFilter) {
                System.out.println(ноутбук);
            }
        }
    }
}