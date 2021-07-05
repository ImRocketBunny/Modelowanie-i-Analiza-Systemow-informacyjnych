import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws Exception {
       //testFilter("iloscWatkow",4);
       //serializableTest();
        //testInternalExtent();
        //testOptionalAttribute();
        testMethod();
    }
    private static void testInternalExtent() throws Exception {
        var cpu1 = new Procesor("Intel","BX80677I77700K","Core i7-7700K",1458.98,LocalDate.parse("2016-11-11"),4.2,4,8, "HD530", "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));
        var cpu2 = new Procesor("Intel","BX80677I77700K","Core i7-7700",1258.98,LocalDate.parse("2016-11-11"),4.2,4,8,  "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));

        Procesor.showExtent();
    }
    private static void testOptionalAttribute() {
        var cpu2 = new Procesor("Intel","BX80677I77700K","Core i7-7700",1258.98,LocalDate.parse("2016-11-11"),4.2,4,8,  "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));
        System.out.println(cpu2);
        cpu2.setiGpu("HD530");
        System.out.println(cpu2);

    }
    private static void testMethod() throws Exception {
        var cpu1 = new Procesor("Intel","BX80677I77700K","Core i7-7700K",1458.98,LocalDate.parse("2016-11-11"),4.2,4,8, "HD530", "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));
        var cpu2 = new Procesor("Intel","BX80677I77700K","Core i7-7700",1258.98,LocalDate.parse("2016-11-11"),4.2,4,8,  "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));
        Procesor.showExtent();
        System.out.println();
        System.out.println(Procesor.najtanszy());
        System.out.println();
        System.out.println("CPU 1 posiada podias HT: "+cpu1.czymMaHT());
    }

    public static void serializableTest() throws Exception {
        testInternalExtent();
        final String extentFile = "extentFile.txt";

        try {

            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            Procesor.writeExtent(out);
            out.close();

            System.out.println("++++++");
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            Procesor.readExtent(in);
            Procesor.showExtent();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void testFilter(String name, Object value) throws Exception {
        var cpu1 = new Procesor("Intel","BX80677I77700K","Core i7-7700K",1458.98,LocalDate.parse("2016-11-11"),4.2,4,8, "HD530", "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));
        var cpu2 = new Procesor("Intel","BX80677I77700K","Core i5-7600",1258.98,LocalDate.parse("2016-11-11"),4.2,4,4,  "Dual-channel", 8,new ArrayList<String>(Arrays.asList("AVX2","SSE4.1","SSE4.2")));
        Procesor.showExtent(name,value);
    }
}
