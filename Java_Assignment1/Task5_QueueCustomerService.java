import java.util.LinkedList;
import java.util.Queue;

public class Task5_QueueCustomerService {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        cs.addRequest("Issue with login");
        cs.addRequest("Payment not processed");
        cs.displayRequests();
        cs.serveRequest();
        cs.displayRequests();
    }
}

class CustomerService {
    private Queue<String> requests = new LinkedList<>();

    public CustomerService() {
        System.out.println("CREATE Time Complexity: O(1)");
    }

    public void addRequest(String request) {
        requests.offer(request);
        System.out.println("INSERT Time Complexity: O(1)");
    }

    public void serveRequest() {
        String served = requests.poll();
        if (served != null) {
            System.out.println("Served: " + served);
            System.out.println("DELETE Time Complexity: O(1)");
        } else {
            System.out.println("No requests to serve.");
        }
    }

    public void displayRequests() {
        System.out.println("Pending Requests: " + requests);
        System.out.println("SEARCH Time Complexity: O(n)");
    }
}
