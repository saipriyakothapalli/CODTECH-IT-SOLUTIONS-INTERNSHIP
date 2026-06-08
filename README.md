#CODTECH IT SOLUTIONS-INTERNSHIP
*COMPANY*:CODTECH IT SOLUTIONS

*NAME*: K SAIPRIYA

*INTERN ID*:CTIS8416

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 8 WEEKS

*MENTOR*: VAISHALI

##TASK 1:File Handling Utility
A simple program to demonstrate basic file operations such as writing, reading, and modifying text files using Java. File handling  allows data to be stored permanently and retrieved when needed.
In this program, the user interacts with the system through the console by providing input data. The program first performs the write operation, where the user enters text that is stored in a file using the FileWriter class. If the file does not exist, it is automatically created; if it already exists, the previous content is overwritten.
Next, the program performs the read operation using FileReader and BufferedReader. These classes help in efficiently reading the contents of the file line by line and displaying them on the screen. This allows the user to verify the data stored in the file.
The program then performs the modify operation, where new data entered by the user is added to the existing file content. This is achieved by enabling append mode in FileWriter by passing true as a parameter. This ensures that the existing data is preserved while adding new information.
To ensure reliability, we use exception handling (try-catch blocks) to manage possible errors such as file not found or input/output issues. 

#TASK 2:REST API CLIENT

In modern software development, a Java program that handles HTTP requests and parses JSON responses serves as a bridge between your application and the rest of the internet. This is the fundamental mechanism used to interact with RESTful APIs, such as fetching weather data, processing payments via Stripe, or connecting to social media platforms.
Here is a detailed description of how such a program works, the technologies involved, and a functional example.
1. The Core Components
To build this in Java, you typically need two main pieces:
The HTTP Client: This sends the request (like a browser does) to a URL and waits for a response. Since Java 11, the built-in java.net.http.HttpClient is the standard choice.
The JSON Parser: API responses are usually returned as JSON (JavaScript Object Notation) strings. Java does not "understand" JSON by default, so we use a library like Jackson or Gson to convert that string into a Java Object (a process called Deserialization).
2. The Technical Workflow
A typical execution follows these four steps:
Request Construction: You define the Endpoint (URL), the Method (GET to retrieve data, POST to send data), and any required Headers (like API keys for security).
Execution: The HttpClient sends the request across the network.
Response Handling: The program receives an HttpResponse, which contains a status code (e.g., 200 for success, 404 for not found) and the Body (the JSON data).
JSON Mapping: The JSON parser takes the raw string and maps it to a POJO (Plain Old Java Object), allowing you to access the data using standard getter methods like user.getName().

#TASK-3:
#Java Chat Application
This real-time chat application is built using a Client-Server Architecture powered by Java’s low-level networking capabilities. The system allows multiple users to connect to a central hub (the Server), exchange messages, and see updates instantly, mimicking the core functionality of modern messaging platforms like Discord or WhatsApp.
The Architecture: Client-Server Model
The application relies on the Transmission Control Protocol (TCP) via Java Sockets. TCP is chosen over UDP because it provides a reliable, ordered, and error-checked delivery of a stream of data, which is essential for text communication where missing words or scrambled sentences would ruin the user experience.
1. The Central Hub: The Server
The Server’s primary responsibility is to act as a traffic controller. It utilizes the ServerSocket class to "bind" itself to a specific port and listen for incoming connection requests.
A critical challenge in chat applications is handling concurrency. If the server processed only one client at a time, the second user would be blocked until the first user disconnected. To solve this, the server employs Multithreading. Every time a new client connects, the server spawns a dedicated ClientHandler thread. This allows the server to maintain hundreds of simultaneous connections. The server also maintains a Synchronized Collection (like a HashSet) of all active threads to "broadcast" messages—taking a message from one user and pushing it out to every other connected user in real-time.
2. The User Interface: The Client
The Client serves as the bridge between the user and the server. When started, it attempts to open a Socket to the server’s IP address and port. Once the connection is established, the client faces a "Blocking I/O" problem: it must wait for the user to type a message, but it also must wait for the server to send new messages.
To solve this, the client is split into two parallel threads:
The Write Thread: This monitors the console/input field. When a user hits "Enter," it sends the text through the PrintWriter to the server.
The Read Thread: This runs in the background, constantly listening to the InputStream. Whenever a broadcast arrives from the server, this thread immediately prints it to the user’s screen.
3. Real-Time Data Flow
The communication flow follows a specific lifecycle:
Handshake: The client connects; the server asks for a username.
Notification: The server alerts all existing users that a new member has joined.
Messaging: When User A sends a message, the Server receives it and loops through its list of active ClientHandlers, sending that message to User B, C, and D.
Termination: If a user types /quit or closes the app, the server catches the exception, removes that user from the active list, and notifies others of their departure.


#Conclusion:
This application demonstrates the power of Java's Network API and Concurrency models. By combining sockets for data transfer and multithreading for simultaneous processing, the application achieves a seamless, real-time communication environment that is both robust and scalable.


#Task 4:
This Task demonstrates the implementation of a User-Based Collaborative Filtering recommendation system built with Java and the Apache Mahout machine learning library. In the modern digital landscape, recommendation engines are the backbone of personalized user experiences, powering suggestions on platforms like Netflix, Amazon, and Spotify. This specific implementation utilizes a "Taste" based architecture to analyze user behavior and predict future preferences.
The Core Architecture:

The system is built upon four primary components provided by the Mahout framework:
Data Model: The foundation of the system is the FileDataModel. It ingests raw data from a CSV file containing three critical variables: UserID, ItemID, and PreferenceValue (rating). This component is highly optimized for memory efficiency, using specialized data structures to handle millions of data points without the overhead of standard Java objects.

User Similarity: This is the mathematical "brain" of the engine. We utilized the Pearson Correlation Similarity algorithm. This algorithm calculates the statistical relationship between users by comparing their rating patterns. A score of 1.0 indicates identical tastes, while -1.0 indicates complete opposites. It allows the system to identify which users are truly "like-minded."

User Neighborhood: Once similarity is calculated, the NearestNUserNeighborhood component narrows the search field. Instead of analyzing every user in the database, it identifies the "Top N" (in our case, 2) most similar individuals to the target user. This mimics real-life word-of-mouth recommendations, where you are more likely to trust the opinions of a few close friends with similar tastes than the opinions of the entire world.

Recommender Engine: The final component is the GenericUserBasedRecommender. It synthesizes the data from the neighborhood and similarity scores to find items that the similar users liked but that the target user has not yet discovered.

Analysis of the Result:

In our execution, the system provided a recommendation for User 1: Item ID 13 with a Predicted Rating of 2.0.
By looking at the sample data, we can see why: User 1 and User 3 both gave "Item 10" a perfect 5.0 rating. This created a strong bond of similarity between them. Because User 3 also enjoyed Item 13, the engine logically concluded that User 1 might find it interesting as well. The predicted rating of 2.0 is an adjusted score based on the weighted averages of the neighborhood; in a larger dataset, this number would fluctuate as the engine gains more "confidence" through more data points.
Why Use Java and Apache Mahout?

Java remains one of the most reliable languages for building recommendation systems due to its robust type-safety and high performance in enterprise environments. By using Maven for dependency management, the project becomes easily portable and scalable. Apache Mahout, specifically, is designed to be scalable. While our implementation runs on a local machine using a CSV file, Mahout’s architecture is built to integrate with Apache Hadoop and Spark, allowing the same logic to be applied to petabytes of data across distributed clusters.
