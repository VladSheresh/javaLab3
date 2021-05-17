package javacources.MemoDataStorage;

import javacources.entitiy.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//сделать обстрактный класс и наследовать от него
public class DataStorage {

    private static List<Room> allRooms = new ArrayList<>();
    private static List<Services> allServices = new ArrayList<>();
    private static List<Guest> allGuests = new ArrayList<>();
    private static List<Booking> allBooking = new ArrayList<>();

    public static void createRoom(Room room) {
        allRooms.add(room);
    }

    public static void createService(Services service) {
        allServices.add(service);
    }

    public static void createGuest(Guest guest) {
        allGuests.add(guest);
    }

    public static void createBooking(Booking booking) {
        allBooking.add(booking);
    }

    public static List<Room> getAllRooms() {
        return allRooms;
    }

    public static List<Services> getAllServices() {
        return allServices;
    }

    public static List<Guest> getAllGuests() {
        return allGuests;
    }

    public static List<Booking> getAllBooking() {
        return allBooking;
    }

    public static void Save() throws IOException {
        convertRoomsToCSV();
        convertServicesToCSV();
        convertGuestsToCSV();
        convertBookingsToCSV();
    }

    public static void Restore() throws IOException {
        convertCSVToRooms();
        convertCSVToServices();
        convertCSVToGuests();
        convertCSVToBookings();
    }

    public static void convertRoomsToCSV() throws IOException {
        String[] heders = {"id", "price", "status", "capacity", "countStars"};
        FileWriter out = new FileWriter("rooms.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(heders))) {
            allRooms.forEach((room) -> {
                try {
                    printer.printRecord(room.getId(), room.getPrice(), room.getStatus(), room.getCapacity(), room.getCountStars());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void convertServicesToCSV() throws IOException {
        String[] heders = {"id", "price"};
        FileWriter out = new FileWriter("services.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(heders))) {
            allServices.forEach((service) -> {
                try {
                    printer.printRecord(service.getId(), service.getPrice());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void convertGuestsToCSV() throws IOException {
        String[] heders = {"id", "name"};
        FileWriter out = new FileWriter("guests.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(heders))) {
            allGuests.forEach((guest) -> {
                try {
                    printer.printRecord(guest.getId(), guest.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void convertBookingsToCSV() throws IOException {
        String[] heders = {"idBooking", "idRoom", "dateCheckIn", "dateCheckOut", "idGuest", "idService"};
        FileWriter out = new FileWriter("bookings.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(heders))) {
            allBooking.forEach((booking) -> {
                try {
                    printer.printRecord(booking.getId(), booking.getRoom().getId(), booking.getDateCheckIn(), booking.getDateCheckOut());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                booking.getServiceGuest().forEach((guest, Services) -> {
                    try {
                        printer.printRecord("-", "-", "-", "-", guest.getId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Services.forEach(service -> {
                        try {
                            printer.printRecord("-", "-", "-", "-", "-", service.getId());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    try {
                        printer.printRecord("-", "-", "-", "-", "-", "-");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                try {
                    printer.printRecord();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void convertCSVToBookings() throws IOException {
        Reader in = new FileReader("bookings.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            Booking booking = new Booking();
            List<Guest> guests = new ArrayList<>();
            List<Services> services = new ArrayList<>();
            Map<Guest, List<Services>> guestServices = new HashMap<>();
            if (!record.get("idBooking").equals("-") && !record.get("idRoom").equals("-") && !record.get("dateCheckIn").equals("-") && !record.get("dateCheckOut").equals("-")) {
                booking.setId(Integer.parseInt(record.get("idBooking")));
                booking.setRoom(getRoom(Integer.parseInt(record.get("idRoom"))));
                booking.setDateCheckIn(getDate(record.get("setDateCheckIn")));
                booking.setDateCheckOut(getDate(record.get("setDateCheckOut")));
            } else if (!record.get("idGuest").equals("-")) {
                guests.add(getGuest(Integer.parseInt(record.get("idGuest"))));
            } else if (!record.get("idService").equals("-")) {
                services.add(getService(Integer.parseInt(record.get("idService"))));
            } else if (record.get("idService").equals("-")) {
                guestServices.put(guests.get(guests.size() - 1), services);
                services.clear();
            } else {
                booking.setGuests(guests);
                booking.setServiceGuest(guestServices);
                allBooking.add(booking);
                guests.clear();
                guestServices.clear();
            }
        }
    }

    private static Services getService(int serviceId) {
        return allServices.stream().filter(service -> service.getId() == serviceId).findFirst().orElse(null);
    }

    private static Room getRoom(int serviceId) {
        return allRooms.stream().filter(room -> room.getId() == serviceId).findFirst().orElse(null);
    }

    private static Guest getGuest(int serviceId) {
        return allGuests.stream().filter(guest -> guest.getId() == serviceId).findFirst().orElse(null);
    }

    private static LocalDate getDate(String s) {
        String[] date = s.split("-");
        return LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
    }

    public static void convertCSVToRooms() throws IOException {
        Reader in = new FileReader("rooms.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            Room room = new Room();
            room.setId(Integer.parseInt(record.get("id")));
            room.setPrice(Integer.parseInt(record.get("price")));
            if (record.get("status").equals("FREE")) {
                room.setStatus(Status.FREE);
            } else if (record.get("status").equals("BUSY")) {
                room.setStatus(Status.BUSY);
            } else if (record.get("status").equals("REPAIRS")) {
                room.setStatus(Status.REPAIRS);
            } else {
                room.setStatus(Status.SERVED);
            }
            room.setCapacity(Integer.parseInt(record.get("capacity")));
            room.setCountStars(Integer.parseInt(record.get("countStars")));
            allRooms.add(room);
        }
    }

    public static void convertCSVToServices() throws IOException {
        Reader in = new FileReader("services.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            Services service = new Services();
            service.setId(Integer.parseInt(record.get("id")));
            service.setPrice(Integer.parseInt(record.get("price")));
            allServices.add(service);
        }
    }

    public static void convertCSVToGuests() throws IOException {
        Reader in = new FileReader("guests.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            Guest guest = new Guest();
            guest.setId(Integer.parseInt(record.get("id")));
            guest.setName(record.get("name"));
            allGuests.add(guest);
        }
    }

}
