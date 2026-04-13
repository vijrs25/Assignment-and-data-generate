package generateData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.github.javafaker.Faker;

public class EmployeeGenerator {
    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        BufferedWriter writer = new BufferedWriter(new FileWriter("employees.csv"));

        writer.write("id,name,email,phone,designation,salary,address,city,country,company,age\n");

        for (int i = 1; i <= 100000; i++) {
            writer.write(i + ",");
            writer.write(clean(faker.name().fullName()) + ",");
            writer.write(clean(faker.internet().emailAddress()) + ",");
            writer.write(clean(faker.phoneNumber().cellPhone()) + ",");
            writer.write(clean(faker.job().title()) + ",");
            writer.write(String.valueOf(faker.number().numberBetween(30000, 150000)) + ",");
            writer.write(clean(faker.address().fullAddress()) + ",");
            writer.write(clean(faker.address().city()) + ",");
            writer.write(clean(faker.address().country()) + ",");
            writer.write(clean(faker.company().name()) + ",");
            writer.write(String.valueOf(faker.number().numberBetween(21, 60)));
            writer.write("\n");
        }

        writer.flush();
        writer.close();

        System.out.println("CSV generated successfully");
    }

    private static String clean(String value) {
        if (value == null) return "";
        return value.replace(",", " ")
                    .replace("\n", " ")
                    .replace("\r", " ")
                    .trim();
    }
}