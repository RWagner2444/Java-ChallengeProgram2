import java.util.ArrayList;
/**
 * Test our skills of Sequential and Binary Searches
 * 3-23-2021
 * Ryan Wagner
 */
public class ContactTester
{
    public static void main(String[] args){
        Contact[] contacts = new Contact[10];
        contacts[0] = new Contact("Bob", "Dad", "Jan 01", "920-555-1234", "bob@email.com");
        contacts[1] = new Contact("Erica", "Mom", "Dec 12", "920-555-9876", "erica@thisemail.com");
        contacts[2] = new Contact("Jeff", "Brother", "Sep 31", "920-555-4567", "jeff@heymail.com");
        contacts[3] = new Contact("Sam", "Sister", "May 03", "920-555-3878", "sam@gmail.com");
        contacts[4] = new Contact("Guy", "Grandpa", "Jan 27", "920-555-6019", "guy@tmail.com");
        contacts[5] = new Contact("Mary", "Grandma", "Oct 10", "920-555-6019", "marypmail.com");
        contacts[6] = new Contact("Alex", "Friend", "Jan 17", "920-555-1627", "alex@heymail.com");
        contacts[7] = new Contact("Josh", "Uncle", "Oct 24", "920-555-5441", "josh@icloud.com");
        contacts[8] = new Contact("Sharon", "Aunt", "Feb 4", "920-555-1796", "sharon@hmail.com");
        contacts[9] = new Contact("Scott", "Friend", "July 6", "920-555-7788", "scott@heymail.com");

        //sortNames(contacts);
        //sortRelations(contacts);
        printContacts(contacts);

        //sortNames(contacts);
        //findName(contacts, "Jeff");
        //findName(contacts, "Ryan");

        //sortRelations(contacts);
        //findRelation(contacts, "Friend");
        //findRelation(contacts, "Bestie");
        
        //findBirthdayMonth(contacts, "Jan");
        //findBirthdayMonth(contacts, "Jun");
        
        //findPhoneNumber(contacts, "920-555-6019");
        //findPhoneNumber(contacts, "920-555-2947");
        
        //findEmail(contacts, "jeff@heymail.com");
        //findEmail(contacts, "jeff@gmail.com");
    }
    
    public static void printContacts(Contact[] contacts){
        System.out.printf("%-10s %-10s %-10s %-15s %s\n\n", "Name", "Relation", "Birthday", "PhoneNumber", "Email");
        for(Contact c: contacts){
            System.out.println(c);
        }
    }

    public static void findName(Contact[] contacts, String toFind){
        int high = contacts.length, low = -1, probe;
        while(high - low > 1){
            probe = (high + low) / 2;
            if(contacts[probe].getName().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
            }
        }
        System.out.println("\nSearching for " + toFind + "...\n");
        if((low >= 0) && (contacts[low].getName().compareTo(toFind) == 0)){
            System.out.println(contacts[low]);
        }
        else{
            System.out.println("Did not find " + toFind);
        }
    }

    public static void sortNames(Contact[] contacts){
        int index = 0;
        Contact contact = new Contact("", "", "", "", "");
        for(int i = contacts.length - 1; i > 0; i--){
            index = 0;
            for(int c = 1; c <= i; c++){
                if(contacts[c].getName().compareTo(contacts[index].getName()) > 0){
                    index = c;
                }
                contact = contacts[i];
                contacts[i] = contacts[index];
                contacts[index] = contact;
            }
        }
    }

    public static void findRelation(Contact[] contacts, String toFind){
        int high = contacts.length, low = -1, probe;
        while(high - low > 1){
            probe = (high + low) / 2;
            if(contacts[probe].getRelation().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
                if(contacts[probe].getRelation() == toFind){
                    break;
                }
            }
        }
        System.out.println("\nSearching for " + toFind + "...\n");
        if((low >= 0) && contacts[low].getRelation() == toFind){
            multRelations(contacts, low, toFind);
        }
        else{
            System.out.println("Not Found: " + toFind);
        }
    }   

    public static void multRelations(Contact[] contacts, int low, String toFind){
        int i, start = low, end = low;
        i = low - 1;
        while((i >= 0) && (contacts[i].getRelation() == toFind)){
            start = i;
            i--;
        }
        i = low + 1;
        while((i < contacts.length) && contacts[i].getRelation() == toFind){
            end = i;
            i++;
        }
        for(i = start; i <= end; i++){
            System.out.println(contacts[i]);
        }
    }

    public static void sortRelations(Contact[] contacts){
        int index = 0;
        Contact contact = new Contact("", "", "", "", "");
        for(int i = contacts.length - 1; i > 0; i--){
            index = 0;
            for(int c = 1; c <= i; c++){
                if(contacts[c].getRelation().compareTo(contacts[index].getRelation()) > 0){
                    index = c;
                }
                contact = contacts[i];
                contacts[i] = contacts[index];
                contacts[index] = contact;
            }
        }
    }

    public static void findBirthdayMonth(Contact[] contacts, String toFind){
        System.out.println("\nSearching for " + toFind + "...\n");
        ArrayList<Integer> index = new ArrayList<Integer>();
        int i = 0;
        boolean found = false;
        while(!found && i < contacts.length){
            if(contacts[i].getBirthday().substring(0,3).compareTo(toFind) == 0){
                index.add(i);
            }
            i++;
            if(i == contacts.length - 1 && index.size() == 0){
                System.out.println("\n" + toFind + " was not found.\n");
            }
        }
        for(Integer I: index){
            System.out.println(contacts[I]);
        }
    }
    
    public static void findPhoneNumber(Contact[] contacts, String toFind){
        System.out.println("\nSearching for " + toFind + "...\n");
        ArrayList<Integer> index = new ArrayList<Integer>();
        int i = 0;
        boolean found = false;
        while(!found && i < contacts.length){
            if(contacts[i].getPhoneNumber().compareTo(toFind) == 0){
                index.add(i);
            }
            i++;
            if(i == contacts.length - 1 && index.size() == 0){
                System.out.println(toFind + " was not found.\n");
            }
        }
        for(Integer I: index){
            System.out.println(contacts[I]);
        }
    }
    
    public static void findEmail(Contact[] contacts, String toFind){
        System.out.println("\nSearching for " + toFind + "...\n");
        ArrayList<Integer> index = new ArrayList<Integer>();
        int i = 0, first = 0;
        boolean found = false;
        while(!found && i < contacts.length){
            if(contacts[i].getEmail().compareTo(toFind) == 0){
                index.add(i);
            }
            i++;
            if(i == contacts.length - 1 && index.size() == 0){
                System.out.println(toFind + " was not found.\n");
            }
        }
        for(Integer I: index){
            System.out.println(contacts[I]);
        }
    }
}
