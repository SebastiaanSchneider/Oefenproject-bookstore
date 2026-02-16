package org.bookstore.config;

import lombok.RequiredArgsConstructor;
import org.bookstore.daos.*;
import org.bookstore.entities.*;
import org.bookstore.enums.BookFormat;
import org.bookstore.enums.Genre;
import org.bookstore.enums.OrderStatus;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Profile("dev")
@Component
@RequiredArgsConstructor
@Transactional
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final InventoryRepository inventoryRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderElementRepository orderElementRepository;

    private final Random random = new Random();

    @Override
    public void run(String @NonNull... args) {

        if (authorRepository.count() > 0) return;

        // 1️⃣ Create 100 Authors
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Author author = new Author();
            author.setFirstName(randomFirstName());
            author.setMiddleName(random.nextBoolean() ? randomFirstName() : null);
            author.setLastName(randomLastName());
            author.setBirthDate(randomDate(1940, 2000));
            authors.add(authorRepository.save(author));
        }

        // 2️⃣ Create 500 Books (random author)
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Book book = new Book();
            book.setIsbn(randomIsbn());
            book.setTitle("Book Title " + (i + 1));
            book.setAuthor(authors.get(random.nextInt(authors.size())));
            book.setGenre(randomEnum(Genre.class));
            book.setLanguage("EN");
            book.setPublisher("Publisher " + (random.nextInt(20) + 1));
            book.setPublicationDate(randomDate(1980, 2024));
            book.setDescription("Sample description for book " + (i + 1));
            book.setPageCount(100 + random.nextInt(900));
            book.setFormat(randomEnum(BookFormat.class));
            books.add(bookRepository.save(book));
        }

        // 3️⃣ Create 500 InventoryItems (1 per book)
        List<InventoryItem> inventoryItems = new ArrayList<>();
        for (Book book : books) {
            InventoryItem item = new InventoryItem();
            item.setBook(book);
            item.setPrice(5 + random.nextFloat() * 95); // 5–100
            item.setStoreStock(random.nextInt(50));
            item.setWarehouseStock(50 + random.nextInt(200));
            inventoryItems.add(inventoryRepository.save(item));
        }

        // 4️⃣ Create 50 Customers
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Customer customer = new Customer();
            customer.setFirstName(randomFirstName());
            customer.setMiddleName(random.nextBoolean() ? randomFirstName() : null);
            customer.setLastName(randomLastName());
            customer.setBirthDate(randomDate(1950, 2005));
            customer.setEmail("customer" + i + "@mail.com");
            customer.setAddress("Street " + (i + 1));
            customers.add(customerRepository.save(customer));
        }

        // 5️⃣ Create 150 Orders (random customer)
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            Order order = new Order();
            order.setCustomer(customers.get(random.nextInt(customers.size())));
            order.setStatus(randomEnum(OrderStatus.class));
            order.setCreatedAt(LocalDateTime.now().minusDays(random.nextInt(365)));
            orders.add(orderRepository.save(order));
        }

        // 6️⃣ For each order create 1–5 OrderElements
        for (Order order : orders) {

            int elementsCount = 1 + random.nextInt(5);
            Set<InventoryItem> usedItems = new HashSet<>();

            for (int i = 0; i < elementsCount; i++) {

                InventoryItem item;
                do {
                    item = inventoryItems.get(random.nextInt(inventoryItems.size()));
                } while (usedItems.contains(item));

                usedItems.add(item);

                OrderElement element = new OrderElement();
                element.setOrder(order);
                element.setInventoryItem(item);
                element.setQuantity(1 + random.nextInt(5));
                element.setPrice(item.getPrice()); // snapshot price

                orderElementRepository.save(element);
            }
        }
    }

    // -----------------------
    // Random helper methods
    // -----------------------

    private String randomFirstName() {
        String[] names = {"John","Jane","Emma","Liam","Olivia","Noah","Ava","Lucas","Mia","Ethan"};
        return names[random.nextInt(names.length)];
    }

    private String randomLastName() {
        String[] names = {"Smith","Johnson","Williams","Brown","Jones","Garcia","Miller","Davis"};
        return names[random.nextInt(names.length)];
    }

    private String randomIsbn() {
        return "978" + (100000000 + random.nextInt(900000000));
    }

    private LocalDate randomDate(int startYear, int endYear) {
        int year = startYear + random.nextInt(endYear - startYear);
        int day = 1 + random.nextInt(365);
        return LocalDate.ofYearDay(year, Math.min(day, 365));
    }

    private <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        T[] values = clazz.getEnumConstants();
        return values[random.nextInt(values.length)];
    }
}
