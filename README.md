# mintos
Java developer home assignment
Your task is to develop a simple RESTful web service that would satisfy a set of functional requirements, as
well as a list of non-functional requirements. Please note, those non-functional requirements are given in
order of importance; items appearing earlier in the list are more crucial for assignment.
The implementation of this task will be considered representative of you at your best.
Functional requirements
Implement a web service that would handle GET requests to path “weather” by returning the weather data
determined by IP of the request originator.
Upon receiving a request, the service should perform a geolocation search using a non-commercial, 3rd party
IP to location provider.
Having performed the reverse geo search service should use another non-commercial, 3rd party service to
determine current weather conditions using the coordinates of the IP.
Non-functional requirements
As mentioned previously, the following list is given in order of priority, you may implement only part of the
items (more is better, however).
1. Test coverage should be not less than 80%
2. Implemented web service should be resilient to 3rd party service unavailability
3. Data from 3rd party providers should be stored in a database
4. An in-memory cache should be used as the first layer in data retrieval
5. DB schema should allow a historical analysis of both queries from a specific IP and of weather
conditions for specific coordinates
6. DB schema versioning should be implemented
Result submission
Please provide a link to a Git repository containing your implementation
