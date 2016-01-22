package cloudant;


public class Main {

	public static void main(String[] args) {
		
		Connection cc = new Connection();
		
		/*Person p = new Person("Alan Xia", null, null);
		p.group = "group1";
		cc.putPerson(p);
		
		List<Trait> traits = new ArrayList<Trait>();
		traits.add(new Trait("programming", .9));
		traits.add(new Trait("being awesome", .95));
		Person p2 = new Person("Dev God", traits, null);
		p2.group = "group2";
		cc.putPerson(p2);
		
		Person testPerson = cc.getPerson("Dev God");
		System.out.println(testPerson.name);
		System.out.println(testPerson.traits);
		
		List<Person> people = cc.getAllPeople();
		System.out.println("There are " + people.size() + " people.");
		
		List<Person> g1ppl = cc.getAllPeopleInGroup("group1");
		System.out.println("There are " + g1ppl.size() + " people in group1.");
		
		List<Person> notg1ppl = cc.getAllPeopleNotInGroup("group1");
		System.out.println(notg1ppl.get(0).name + " is not in group1.");
		
		cc.deletePerson(p);
		cc.deletePerson(p2);*/
		
		cc.closeDBConnector();
	}

}
