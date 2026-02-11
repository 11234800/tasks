package task1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );
        //1:
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(evenNumbers);

        List<String> namesWithA =names.stream().filter(name ->name.startsWith("A")).toList();
        System.out.println(namesWithA);

        List<String> upperNames = names.stream().map(name -> name.toUpperCase()).toList();
        System.out.println(upperNames);

        List<Integer> sorted = numbers.stream().sorted().toList();
        System.out.println(sorted);

        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        System.out.println(distinctNumbers);

        //2:
        long countLongNames = names.stream().filter(name ->name.length() > 5).count();
        System.out.println(countLongNames);

        Optional<String> firstLongName = names.stream().filter(name ->name.length() > 4).findFirst();
        if (firstLongName.isPresent()) {
            System.out.println(firstLongName.get());
        }
        else {
            System.out.println("not found");
        }

        boolean numberIsDivisibleBy5 = numbers.stream().anyMatch(n -> n % 5 == 0);
        System.out.println(numberIsDivisibleBy5);

        Set<Integer> set = numbers.stream().collect(Collectors.toSet());
        System.out.println(set);

        List<Integer> skippedNumbers = numbers.stream().skip(3).toList();
        System.out.println(skippedNumbers);

        //3:
        int sum =numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        int max =numbers.stream().max(Integer::compareTo).orElse(0);
        int min =numbers.stream().min(Integer::compareTo).orElse(0);
        System.out.println(max);
        System.out.println(min);

        double averageGrade =students.stream().mapToDouble(Student::getGrade).average().orElse(0);
        System.out.println(averageGrade);

        int product =numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

        long positiveCount = numbers.stream().filter(n -> n > 0).count();
        System.out.println(positiveCount);

        //4:
        Map<String,List<Student>> studentsByDepartment =students.stream().collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println(studentsByDepartment);

        Map<Boolean,List<Integer>> evenOdd =numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenOdd);

        String joinedNames =names.stream().collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        Map<Integer,Long> employeesCountByAge = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println(employeesCountByAge);

        Map<String,Double> avgSalaryByDept =employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDept);

        //5:
        List<String> flatWords =nestedWords.stream().flatMap(List::stream).toList();
        System.out.println(flatWords);

        List<Character> uniqueChars =names.stream().flatMap(name -> name.chars().mapToObj(c -> (char) c)).distinct().toList();
        System.out.println(uniqueChars);

        List<Optional<String>> optionals =Arrays.asList(
                Optional.of("Ali"),
                Optional.empty(),
                Optional.of("Mona")
        );
        List<String> values =optionals.stream().flatMap(Optional::stream).toList();
        System.out.println(values);

        List<Integer> nameLengths =names.stream().map(name->name.length()).toList();
        System.out.println(nameLengths);

        List<String> res =names.stream().filter(s ->s.startsWith("A")).map(name->name.toUpperCase()).toList();
        System.out.println(res);

        //6:
        List<Employee> sortedEmployees =employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).toList();
        System.out.println(sortedEmployees);

        int secondMax =numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(secondMax);

        Set<Integer> duplicates =numbers.stream().filter(n -> Collections.frequency(numbers, n) > 1).collect(Collectors.toSet());
        System.out.println(duplicates);

        List<String> cleanNames =names.stream().filter(s ->!s.isEmpty()).toList();
        System.out.println(cleanNames);

        Map<Boolean,List<Student>> passFail =students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= 60));
        System.out.println(passFail);

    }
}