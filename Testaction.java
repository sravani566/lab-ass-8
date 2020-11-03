import java.util.*;
import java.util.stream.Collectors;

public class Testaction {
	public static void main(String[] args) {
	
	List<Transaction> transaction = getAllTransactions();	
	

		// Find all transactions in the year 2011 and sort them by value (small to high)
		
		System.out.println("* Find all transactions in the year 2011 and sort them by value (small to high) *");
		List<Transaction> AllTrInYear2011 = transaction.stream().
				filter(year -> year.getYear() == 2011)
				.sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))
				.collect(Collectors.toList());
		AllTrInYear2011.forEach(list -> System.out.println(list));
		
		
		// What are all the unique cities where the traders work?
		
		System.out.println("* What are all the unique cities where the traders work? *");
		List<Trader> trade = transaction.stream()
				.map(tr -> tr.getTrader())
				.distinct()
				.collect(Collectors.toList());
		System.out.println(trade);
		
		

		// Find all traders from delhi and sort them by name.
		
		System.out.println("* Find all traders from delhi and sort them by name *");
		List<Trader> tradersFromDelhi = trade.stream()
				.filter(city->city.getCity().equals("delhi"))
				.sorted((o1, o2) -> o1.getName()
                .compareTo(o2.getName()))
				.collect(Collectors.toList());
		tradersFromDelhi.forEach(list -> System.out.println(list));

		// Return a string of all traders names sorted alphabetically.
		
		System.out.println("*  Return a string of all traders names sorted alphabetically *");
		List<Trader> sortedNamesofTraders = trade.stream()
				.sorted((o1, o2) -> o1.getName()
		         .compareTo(o2.getName()))
				.collect(Collectors.toList());
		System.out.println(sortedNamesofTraders);

		
		// Are any traders based in Jaipur?
		
		System.out.println("*  Are any traders based in Jaipur? *");
		boolean jaipurTraders = trade.stream()
				.anyMatch(city -> city.getCity().equals("jaipur"));
		if (jaipurTraders)
			System.out.println("Traders are there from Jaipur are there");
		else
			System.out.println("No jaipur Traders");
		

		// Print all transactions values from the traders living in delhi
		
		System.out.println("* Print all transactions values from the traders living in delhi  *");
		List<Integer> TraderValuesLivingindelhi = transaction.stream()
				.filter(city -> city.getTrader().getCity().equals("delhi"))
				.map(value -> value.getValue())
				.collect(Collectors.toList());
		System.out.println(TraderValuesLivingindelhi);
		

		// Whats the highest value of all the transactions?
		
		System.out.println("* Whats the highest value of all the transactions?  *");
		OptionalInt maximumValFromTransactions = transaction.stream()
				.mapToInt(value -> value.getValue()).max();
		System.out.println(maximumValFromTransactions);
		

		// Find the transaction with the smallest value
		
		System.out.println("* Find the transaction with the smallest value *");
		OptionalInt minimumValFromTransactions = transaction.stream()
				.mapToInt(value -> value.getValue()).min();
		System.out.println(minimumValFromTransactions);
		
	
	}
	
	private static List<Transaction> getAllTransactions() 
	{
		Trader ram = new Trader("ram", "delhi");
		Trader kapil = new Trader("kapil", "noida");
		Trader raj = new Trader("raj", "banglore");
		Trader ekta = new Trader("ekta", "banglore");
		List<Transaction> transactions = Arrays.asList
				(new Transaction(ram, 2011, 300), 
				new Transaction(ram, 2012, 1000),
				new Transaction(kapil, 2011, 400), 
				new Transaction(raj, 2012, 710), 
				new Transaction(ekta, 2012, 700),
				new Transaction(ekta, 2012, 950));
		return transactions;

	}

}

