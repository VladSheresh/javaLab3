package javacources.main;
import javacources.entitiy.Guest;
import javacources.entitiy.GuestAndRoom;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@ComponentScan("javacources")
public class TestClass {

   static String[] HEADERS = { "author", "title","new"};
   static Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>() {
        {
            put("dfgf", "Hyperion");
            put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
        }
    };
   static List<String> str = new ArrayList<>();
    static Map<String, String> BOOK = new HashMap<>();


    public static void main(String[] args) throws IOException {

        Comparator<GuestAndRoom> nameComparator = (o1, o2) -> (o1.getGuest().getName().compareTo(o2.getGuest().getName()));
        List<GuestAndRoom> str = new ArrayList<>();
        Guest guest = new Guest();
        guest.setName("Брп");
        GuestAndRoom guestAndRoom = new GuestAndRoom();
        guestAndRoom.setGuest(guest);
        str.add(guestAndRoom);
        Guest guest1 = new Guest();
        guest1.setName("Амывм");
        GuestAndRoom guestAndRoom1 = new GuestAndRoom();
        guestAndRoom1.setGuest(guest1);
        str.add(guestAndRoom1);
        Guest guest2 = new Guest();
        guest2.setName("Ввладлы");
        GuestAndRoom guestAndRoom2 = new GuestAndRoom();
        guestAndRoom2.setGuest(guest2);
        str.add(guestAndRoom2);
        str = str.stream().sorted(nameComparator).collect(Collectors.toList());
        createCSVFile();
        givenCSVFile_whenRead_thenContentsAsExpected();
        int x =1+1;

    }

    public static void createCSVFile() throws IOException {
        FileWriter out = new FileWriter("book_new.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(HEADERS)
                )) {
            AUTHOR_BOOK_MAP.forEach((author, title) -> {
                try {
                    printer.printRecord(author, title, "1");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            printer.printRecord("", "", "1");
            //printer.printRecord("",LocalDate.now());
        }
    }

    public static void givenCSVFile_whenRead_thenContentsAsExpected() throws IOException {
        Reader in = new FileReader("book_new.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            String author = record.get("author");
            String title = record.get("title");
            String newNew = record.get("new");
            AUTHOR_BOOK_MAP.get(author);
            BOOK.put(author,title);
            str.add(newNew);
        }
    }

    private static void testAddRoomAction() {
        //new AddRoomAction().execute();
        //new ChangeRoomPriceActoin().execute();
        //System.out.println(room.getId() + "  " + room.getPrice() + " " + room.getStatus());
        //String date = "1,1,1";
        //var a = date.split(",");
        //System.out.println(a[0]);
        //LocalDate date1 = LocalDate.of(2021, 10, 12);
    }




}
