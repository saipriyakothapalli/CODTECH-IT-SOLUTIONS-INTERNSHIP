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



TASK-3:
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
Conclusion:
This application demonstrates the power of Java's Network API and Concurrency models. By combining sockets for data transfer and multithreading for simultaneous processing, the application achieves a seamless, real-time communication environment that is both robust and scalable.
